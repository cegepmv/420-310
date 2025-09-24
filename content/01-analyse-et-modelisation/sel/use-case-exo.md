# DU USE CASE AU CODE

À travers cet exercice, nous allons faire le parallèle entre un **cas d’utilisation** et son équivalent en **code Java**. Le système étudié : une bibliothèque qui gère un seul livre.  

**Les cas d’utilisation définis :**
##### Emprunter un livre
  - Étapes principales :  
    1. Vérifier que le livre est disponible.  
    2. Associer le livre à l’utilisateur.  
    3. Confirmer l’emprunt.  
  - Scénario alternatif :  
    - Si le livre n’est pas disponible, afficher une erreur.
##### Retourner un livre 
  - Étapes principales :  
    1. Vérifier que le livre a bien été emprunté par cet utilisateur.  
    2. Libérer le livre.  
    3. Confirmer le retour.  
  - Scénario alternatif :  
    - Si le livre n’a pas été emprunté, afficher une erreur.

---
<div style="break-before: page;"></div>

## À faire 
1. Complétez la classe `Bibliotheque` ci-dessous. Chaque **méthode publique** correspond à un **use case**. Les instructions correspondent aux **étapes du scénario**. Les conditions `if/else` correspondent aux **scénarios alternatifs**.

```java
public class Bibliotheque {

    private boolean disponible = true;
    private String emprunteur = null;

    // Use case : emprunter un livre
    public void emprunter(String utilisateur) {
        // TODO : implémenter ici les étapes principales et le scénario alternatif
    }

    // Use case : retourner un livre
    public void retourner(String utilisateur) {
        // TODO : implémenter ici les étapes principales et le scénario alternatif
    }
}
```

2. Créez une classe Main avec une méthode main qui :
- Simule un scénario normal : 
  - Un utilisateur emprunte puis retourne le livre.
- Simule un scénario alternatif :
  - Un deuxième utilisateur tente d’emprunter le livre alors qu’il est déjà pris.
  - Un utilisateur tente de retourner un livre qu’il n’a pas emprunté.

3. Complétez également le tableau de description du use case (CU01) avec :
- Description
- Acteurs
- Préconditions
- Post-conditions
- Flux de base
- Flux alternatifs

<!-- ## Corrigé du tableau CU01 – *Emprunter un livre*

| **CU01 – Emprunter un livre** |   |
|-------------------------------|---|
| **Description** | L’utilisateur emprunte un livre de la bibliothèque. |
| **Acteurs** | Utilisateur |
| **Pré-conditions** | Le livre est disponible. |
| **Post-conditions** | Le livre n’est plus disponible et est associé à l’utilisateur emprunteur. |
| **Flux de base** | 1. L’utilisateur demande l’emprunt d’un livre.<br>2. Le système vérifie la disponibilité.<br>3. Le système associe le livre à l’utilisateur.<br>4. Le système confirme l’emprunt. |
| **Flux alternatifs** | 2a. Le livre n’est pas disponible :<br>2a.1. Le système affiche un message d’erreur.<br>2a.2. Le processus s’arrête. |
| **Exigences spéciales** | Aucune |
| **Points d’extensions** | Aucun |

---

👉 Veux-tu que je complète aussi le **corrigé du tableau CU02 – Retourner un livre** dans le même format, pour que tes étudiants aient les deux exemples prêts à comparer ? -->
