+++
pre = '<b>3. </b>'
title = "Qualité, tests et déploiement"
weight = 4
draft = true
+++
# Objectifs d’apprentissage

- Comprendre l’intérêt des **tests unitaires** pour la qualité logicielle.
- Appliquer le cycle **TDD (Red → Green → Refactor)** sur de petits problèmes.
- Savoir écrire des tests JUnit 5 lisibles (AAA, _Arrange/Act/Assert_).
- Exécuter les tests localement (Maven/Gradle/IDE) et en CI (GitLab CI).
- Interpréter un **rapport de couverture** et éviter les anti-patterns courants.


## Qu’est-ce qu’un test unitaire ?
- Vérifie **une unité** de code (fonction/méthode/classe) **en isolation**.
- Doit être **rapide**, **déterministe** et **facile à lire**.
- Nommez clairement l’intention : `shouldCalculateTotal_withDiscount()`.

## AAA (Arrange–Act–Assert)
1. **Arrange** : préparez les données.
2. **Act** : exécutez la méthode testée.
3. **Assert** : vérifiez le résultat attendu.

# 2) Outils & configuration

## JUnit 5 (Maven)
```xml
<!-- pom.xml -->
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.11.3</version>
    <scope>test</scope>
  </dependency>
  <!-- Optionnel pour les mocks -->
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.14.2</version>
    <scope>test</scope>
  </dependency>
</dependencies>
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.5.2</version>
    </plugin>
  </plugins>
</build>
```

**Exécuter** :
- Tous les tests : mvn test
- Une classe : mvn -Dtest=CartServiceTest test

3) Exemple de test unitaire (Java)
Code à tester

```java
// src/main/java/com/example/PriceCalculator.java
package com.example;

public class PriceCalculator {
    public double totalWithPromo(double subtotal, double promo) {
        if (subtotal < 0 || promo < 0) throw new IllegalArgumentException();
        double total = subtotal - promo;
        return Math.max(0.0, total);
    }
}
````
