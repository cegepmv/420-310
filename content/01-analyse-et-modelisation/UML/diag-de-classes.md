+++
pre = '<b>1.2.3 </b>'
title = "Le diagramme de classes"
weight = 3
draft = false
+++

Objectif du cours
L'objectif de ces notions est de vous apprendre à lire et esquisser un diagramme de classes : classes, attributs, opérations, visibilités, relations (héritage, association, agrégation, composition, dépendance, réalisation), multiplicités, navigabilité, et notions de couplage/cohésion.

##### À à quoi sert un diagramme de classes ?

- À représenter la structure statique d’un domaine (concepts, attributs, liens).
- À préparer/communiquer la conception (API, contrats, responsabilités).
- Va servir de support aux autres modèles (use cases, séquences, persistance).

> À retenir : UML **n’impose pas l’implémentation**, il **décrit**. Le code peut ensuite diverger, mais il doit rester cohérent avec les **décisions prises**.

--- 

### 1) Les classes
<style>
  .uml-row{
    display:flex;
    flex-wrap:wrap;
    gap:12px;
    align-items:flex-start;
    justify-content:center;   /* <-- centre horizontalement */
  }
  .uml-class{
    border:1px solid #cbd5e1; border-radius:4px; overflow:hidden;
    font-family: ui-monospace, SFMono-Regular, Menlo, Consolas, "Liberation Mono", monospace;
    font-size: 0.85rem; background:#fff; min-width: 240px; max-width: 340px;
    box-shadow: 0 1px 2px rgba(0,0,0,.04);
    margin: 0 auto;            /* <-- fallback si Flex est surchargé par le thème */
  }
  .uml-title{
    padding:6px 8px; text-align:center; font-weight:700;
    background:#f1f5f9; border-bottom:1px solid #cbd5e1;
  }
  .uml-section{ padding:6px 8px; border-top:1px solid #e5e7eb; white-space:pre-wrap; }
  .stereotype{ font-weight:400; color:#334155; }
  .legend{font-size:.8rem; color:#475569; margin-top:4px}
</style>

<div class="uml-row">
  <div class="uml-class">
    <div class="uml-title">NomDeClasse <span class="stereotype">«stéréotype»</span></div>
    <div class="uml-section">
- attribut : Type [= défaut] {contraintes}
# autreAttribut : Type
    </div>
    <div class="uml-section">
+ operation(param: Type) : Retour {propriétés}
~ helper()
    </div>
  </div>
</div>

**Visibilités** : 
- `+` public  
- `#` protégé 
- `~` package (interne)
- `-` privé

**Nomenclature** : 
- Nommez avec des **noms** pour les **classes**
- Nommez **noms + types** précis pour les **attributs**
- Nommez **verbes** pour les **opérations**

---

### 2) Les relations (liens) 
| Relation        | Idée                               | Diagramme rapide           | Traduction courante (Java) |
|-----------------|------------------------------------|----------------------------|----------------------------|
| Généralisation  | « est-un(e) »                      | `A ◁── B`   | `class B extends A` |
| Réalisation     | « implémente »                     | `I ◁·· B`     | `class B implements I` |
| Association     | « a-une » (référence)              | `A ─── B`                  | champ / référence |
| Agrégation   | « a des » (partageable)            | `A ◇── B`                  | collection / référence (cycle de vie indépendant) <br>ça implique que : <br>- l’objet A est **attribut** de l’objet B. |
| Composition  | « est composé de » (très fort)          | `A ◆── B`                  | champ obligatoire, cycle de vie lié <br>ça implique que : <br>- l’objet B devra se retrouver comme **attribut** d’une ou plusieurs **méthodes** de l’objet A <br>- l’objet A est **attribut** de l’objet B |
| Dépendance      | « utilise » (faible, ponctuel)     | `A - - > B`                | paramètre local, import, appel statique <br> ça implique que : <br>- l’objet A **dépendant** de l’objet B <br> - l’objet B devra se retrouver comme **attribut** d’une ou plusieurs **méthodes** de l’objet A. |

| Notation      | Signification / Exemple                    |
|---------------|--------------------------------------------|
| Multiplicités | `n`, `0..n`, `*`, `1..*`, `0..*`, `n..m`   |
| Navigabilité  | flèche du côté « connaissant » → `A ───> B`|


### 3) Notions de couplage et cohésion (qualités de conception)

- La **cohésion** (à l’intérieur d’une classe/module), mesure à quel point les **éléments d’une classe vont ensemble**.

On rechercher une **cohésion forte** : une responsabilité claire (SRP), API compactes.

- Le **couplage** (entre classes/modules), mesure à quel point des **éléments dépendent les uns des autres**.
On rechercher un **couplage faible** : interfaces, inversion de dépendance, dépendances stables.
Exemple : exposer des types internes (classes concrètes) au lieu d’interfaces → couplage fort.
 
### Exercice – la boutique en ligne (diagramme de classes UML)
On vous demande de modéliser le noyau d’une petite boutique en ligne, ayant deux types d’utilisateurs interagissent avec le système : les clients qui achètent des produits et les administrateurs qui gèrent le catalogue. Les achats se font via un panier d’achat qui se transforme en commande, expédiée selon des informations d’expédition. Chaque commande est composée de détails de commande (lignes).

Objectif : produire un diagramme de classes UML complet (attributs, opérations, associations, multiplicités et généralisations) répondant aux exigences ci-dessus.




<!-- 9) Exercice guidé (en classe)

À partir d’un court use case (“Passer une commande”), proposez 5–7 classes métier.

Ajoutez 2 héritages (si pertinents) et 1 interface.

Reliez par associations et composition là où nécessaire (avec multiplicités).

Évaluez couplage/cohésion et proposez 1 amélioration.

À discuter : frontières du domaine vs services applicatifs, où placer les règles, ce qui relève du modèle vs de l’infrastructure.

1)  Pour aller plus loin

Lien vers une exemple de diagramme complet (à insérer par toi).

Références : UML Distilled (Fowler), Head First OOAD, Clean Architecture (on y parle beaucoup couplage/cohésion).

Note pour toi : tu peux insérer ensuite ton propre diagramme d’exemple (image ou Mermaid) et lancer la discussion sur :

responsabilité de chaque classe, 2) justesse des liens, 3) impacts d’un changement (où le couplage gêne ?), 4) variantes possibles.

Vous avez atteint la longueur maximum pour cette conversation, mais vous pouvez lancer un nouveau chat pour continuer à discuter. -->

