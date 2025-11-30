+++
pre = '<b>3. </b>'
title = "Qualité, tests et déploiement"
weight = 4
draft = false
+++

Tester, c’est piloter la qualité : on **réduit les risques**, on **documente le comportement du système** et on **rend le code fiable** à long terme. Les tests servent autant à **prévenir les régressions** qu’à **guider les décisions d’architecture** (couplage, frontières, dépendances). Ils forment un filet de sécurité qui autorise le *refactoring* et accélère les livraisons.

À travers ce module, nous allons nous attarder sur les **tests unitaires** en Java et voir comment fonctionne le **TDD** : le cycle rouge → vert → refactor, l’écriture d’assertions claires, et l’usage d’outils comme JUnit et des doubles de test pour isoler les composants.


### Unit tests 
Un test unitaire correspond à une seule idée (un comportement) et porte un nom explicite ; bien conçus, les tests unitaires guident l’architecture en forçant à réduire le couplage, injecter les dépendances et isoler les effets de bord.

**Qu’est-ce qu’un test unitaire ?** <br>
- Vérifie **une unité** de code (fonction/méthode/classe) **en isolation**.
- Il doit être **rapide**, **déterministe** et **facile à lire**.
- Utile pour ocumenter l’intention : un test bien nommé explique le « contrat ».
- Nommez clairement l’intention : `calculateTotalWDiscount()`.

La structure d’un test unitaire se fait classiquement selon le schéma **AAA (Arrange–Act–Assert)**, qui rend les tests lisibles, focalisés et faciles à maintenir.

**AAA (Arrange–Act–Assert)** <br>
1. **Arrange** : préparez les données.
2. **Act** : exécutez la méthode testée.
3. **Assert** : vérifiez le résultat attendu.

Il existe plusieurs ***frameworks* de test** (famille xUnit) pour **structurer** et **automatiser** les **vérifications**.
En Java, on utilisera simplement **JUnit 5** (et, au besoin, des doublures de test) pour écrire des tests unitaires clairs et rapides.

**JUnit 5 : mini mémo**
- Annotations : `@Test`, `@DisplayName`, `@Nested`, `@BeforeEach`, `@AfterEach`
- Assertions : `assertEquals`, `assertThrows`, `assertTrue/False`, `assertAll`
- Paramétrés : `@ParameterizedTest` + `@ValueSource` / `@CsvSource`
- Désactivation : `@Disabled("raison")`
<!-- @Nested
Permet des groupes de tests imbriqués pour mieux organiser par contexte/scénario. -->
<!-- @BeforeEach
Méthode exécutée avant chaque test (setup/initialisation). -->
<!-- @AfterEach
Méthode exécutée après chaque test (teardown/nettoyage). -->

<!-- assertEquals(expected, actual) — égalité de valeurs.
assertThrows(type, executable) — vérifie qu’une exception est lancée.
assertTrue / assertFalse(condition) — vérifie une condition booléenne.
assertAll("groupe", …) — groupe plusieurs assertions pour tout voir en un run. -->

<!-- @ParameterizedTest — exécute le même test avec plusieurs jeux de données.
@ValueSource — fournit une liste de valeurs simples (int, String, etc.).
@CsvSource — fournit des lignes CSV (plusieurs colonnes). -->

<!-- @Disabled("raison") — ignore un test (temporairement). -->
  
{{< tabs >}}

{{% tab title="Énoncé (méthode à tester)" %}}

##### 1) Méthode pure : cas nominal + bords
```java
class MathUtils {
    static int clamp(int x, int min, int max) {
        if (min > max) throw new IllegalArgumentException("min>max");
        return Math.max(min, Math.min(max, x));
    }
}
```
{{% /tab %}}

{{% tab title="Test JUnit 5" %}}
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MathUtilsTest {
    @Test @DisplayName("Clamp borne inférieure")
    void clamp_returnsMin_whenBelowMin() {
        assertEquals(0, MathUtils.clamp(-5, 0, 10));
    }

    @Test @DisplayName("Clamp borne supérieure")
    void clamp_returnsMax_whenAboveMax() {
        assertEquals(10, MathUtils.clamp(99, 0, 10));
    }

    @Test @DisplayName("Clamp paramètre invalide")
    void clamp_throws_whenMinGreaterThanMax() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.clamp(1, 10, 0));
    }
}
```
{{% /tab %}}

{{< /tabs >}}

<!-- **À expliquer :**
- Notion de **fonction pure** (déterminisme, pas d’effets de bord).
- Couvrir **cas nominal** + **bords** + **erreur**.
- Convention **AAA** (Arrange-Act-Assert) dans chaque test.
- Un test = **une idée** ; noms explicites. -->

---

{{< tabs >}}

{{% tab title="Énoncé (méthode à tester)" %}}

##### 2) test paramétré : couvrir plusieurs cas sans dupliquer
```java
class StringUtils {
    // Ignore la casse et la ponctuation
    static boolean isPalindrome(String s) {
        if (s == null) return false;
        var t = s.replaceAll("\\W", "").toLowerCase();
        return new StringBuilder(t).reverse().toString().equals(t);
    }
}
```
{{% /tab %}}

{{% tab title="Test JUnit 5" %}}
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringUtilsTest {

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @CsvSource({
        "kayak, true",
        "'A man, a plan, a canal: Panama', true",
        "hello, false",
        "'', true",
        "null, false"
    })
    void isPalindrome_cases(String input, boolean expected) {
        // Petit hack : convertir la chaîne "null" en null réel pour le cas de test
        String value = "null".equals(input) ? null : input;
        assertEquals(expected, StringUtils.isPalindrome(value));
    }
}
```
{{% /tab %}}

{{< /tabs >}}

<!-- **À expliquer :**
- Pourquoi un **test paramétré** (éviter la duplication, lisibilité).
- Choix des **données** : cas simples, composés, vide, **null**.
- `@CsvSource` et formatage des **chaînes** avec virgules/apostrophes.
- Toujours garder **un comportement par assertion principale**. -->

--- 

{{< tabs >}}

{{% tab title="Énoncé (méthode à tester)" %}}

##### 3) mock d’une dépendance (ex. service + repo)
```java
record Account(String id, int balance) {}

interface AccountRepo {
    Account find(String id);
    void save(Account a);
}

class TransferService {
    private final AccountRepo repo;
    TransferService(AccountRepo repo) { this.repo = repo; }

    void transfer(String from, String to, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount<=0");
        var a = repo.find(from);
        var b = repo.find(to);
        if (a == null || b == null) throw new IllegalStateException("account missing");
        if (a.balance() < amount) throw new IllegalStateException("insufficient");
        repo.save(new Account(a.id(), a.balance() - amount));
        repo.save(new Account(b.id(), b.balance() + amount));
    }
}
```
{{% /tab %}}

{{% tab title="Test JUnit 5 (Mockito)" %}}
```java
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class TransferServiceTest {

    @Test
    void transfer_moves_funds_and_persists() {
        var repo = mock(AccountRepo.class);
        when(repo.find("A")).thenReturn(new Account("A", 100));
        when(repo.find("B")).thenReturn(new Account("B", 50));

        var svc = new TransferService(repo);
        svc.transfer("A", "B", 40);

        verify(repo).save(new Account("A", 60));
        verify(repo).save(new Account("B", 90));
        verifyNoMoreInteractions(repo);
    }

    @Test
    void transfer_fails_on_insufficient_funds() {
        var repo = mock(AccountRepo.class);
        when(repo.find("A")).thenReturn(new Account("A", 10));
        when(repo.find("B")).thenReturn(new Account("B", 0));

        var svc = new TransferService(repo);
        assertThrows(IllegalStateException.class, () -> svc.transfer("A", "B", 50));
        verify(repo, never()).save(any());
    }
}
```
{{% /tab %}}

{{< /tabs >}}

<!-- **À expliquer :**
- **Isolation** : on teste le **service** sans base de données (dépendance **mockée**).
- **Stubs** via `when(...).thenReturn(...)` ; **vérifications** via `verify(...)`.
- Cas nominal vs **erreurs métier** (fonds insuffisants, compte manquant, montant ≤ 0).
- Comment les tests poussent à **injecter** les dépendances (constructeur) → architecture plus **modulaire** et **testable**. -->


<!-- ### Exécuter des tests unitaires JUnit 5 avec Maven (IntelliJ)
1) La structure du projet
mon-projet/
 └─ src/
    ├─ main/java/...        # code de prod
    └─ test/java/...        # classes de test (mêmes packages que le code) -->

<!-- **Exécuter** :
- Tous les tests : mvn test
- Une classe : mvn -Dtest=CartServiceTest test -->

### TDD : Test-Driven Development
Le TDD, ou développement piloté par les tests (Test-Driven Development), est une approche de développement logiciel où les développeurs écrivent des tests automatisés avant d'écrire le code fonctionnel. Le processus itératif se déroule en trois étapes principales :  écrire d’abord un test qui échoue, puis le code minimal pour le faire passer, et enfin refactorer sans altérer le comportement.

Au-delà de "vérifier que ça marche", TDD structure l’architecture : modules cohésifs, dépendances explicites (inversion de dépendances), coutures (seams) pour isoler les E/S et un code naturellement testable, donc maintenable.

**Le cycle « rouge → vert → *refactor* »**
- rouge (*red*) : écrire un test précis qui échoue (comportement souhaité, pas l’implémentation).
- vert (*green*) : implémenter le strict minimum pour faire passer ce test.
- *refactor* : améliorer le design (noms, duplication, extractions) sans casser les tests.

<!-- 1) Modules cohésifs
Idée : un module fait une chose claire (responsabilité unique).
Pourquoi TDD aide : on écrit un test par comportement → on isole naturellement la responsabilité pour que le test soit simple.
Signal : si un test doit créer 12 objets ou passer par 5 étapes, le module fait trop de choses. -->

<!-- 2) Dépendances explicites (Inversion de dépendances)
Idée : une classe ne crée pas ses dépendances en dur ; elle les reçoit (constructeur ou setter).
Pourquoi TDD aide : pour tester UserService, tu veux remplacer la base par un double → tu injectes un UserRepo.
Bénéfice : remplaçable en test, remplaçable en prod (BD → mémoire, HTTP → stub, etc.). -->

<!-- 3) Coutures (seams) pour isoler les E/S
Idée : une « couture » est un point où tu peux substituer une implémentation (ex. horloge, HTTP, système de fichiers).
Pourquoi TDD aide : pour tester rapidement/déterministement, tu refuses l’horloge réelle, les fichiers, le réseau. Tu crées une interface (couture) et passes une implémentation fake/mocked en test. -->

<!-- 4) Un code naturellement testable → maintenable
Idée : un code testable est : découplé, pur quand c’est possible, avec E/S isolées et dépendances injectées.
Pourquoi TDD aide : le test impose ces propriétés ; sinon, le test devient pénible → tu refactorises pour simplifier la testabilité.
Bénéfice : quand tu refactores plus tard (renommer, extraire, optimiser), le filet de tests te protège des régressions. -->