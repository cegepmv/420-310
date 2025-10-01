
+++
pre = '<b>1.3 </b>'
title = "Les méthodologies de développement"
weight = 3
draft = false
+++

À travers cette section, nous introduisons trois méthodologies de développement logiciel importantes. Elles représentent une évolution historique des pratiques et permettent de comparer des approches plus **planifiées** avec des approches plus **flexibles**.

Le cycle de vie logiciel représente l’ensemble des étapes par lesquelles passe un logiciel, depuis l’expression des besoins jusqu’à sa mise hors service. Il existe plusieurs modèles de cycle de vie, comme le modèle **en spirale**, **en V**, **en cascade** ou encore **itératif et incrémental**, qui structurent et organisent ces étapes.  
Ces modèles servent de cadre pour planifier, développer, tester, déployer et maintenir une application.  

---

## 1. Cascade (Waterfall)
Le modèle en cascade est une **approche séquentielle et linéaire** du développement logiciel.  
Chaque étape du projet doit être **entièrement complétée** avant de passer à la suivante.  
L’idée est qu’une fois une phase terminée (par exemple, l’analyse des besoins), elle ne sera plus revisitée.  
C’est une approche très documentée et planifiée à l’avance, qui reflète une vision de l’ingénierie traditionnelle appliquée au logiciel.  

Cette méthodologie est surtout utilisée dans des projets où :  
- les besoins sont clairs et stables dès le départ,  
- les changements sont rares ou coûteux,  
- la documentation complète est exigée (ex. projets gouvernementaux, contrats formels).  

Bien qu’elle soit simple à comprendre, son principal inconvénient est sa **rigidité** : si une erreur est détectée tard dans le cycle, il est difficile (et coûteux) de revenir en arrière.  

<!-- ![Modèle en cascade](/420-310//images/cascade.png) -->
<img src="/420-310/images/cascade.png" alt="Modèle en cascade" width="500">

- **Avantages :**
  - Simple à comprendre et à gérer.
  - Convient aux projets où les exigences sont bien définies et stables.
  - Documentation claire (UML est souvent utilisé ici).  
- **Inconvénients :**
  - Très rigide : difficile de revenir en arrière.
  - Risque élevé si les besoins changent en cours de route.
  - Le produit final n’apparaît qu’à la fin.

---

## 2. En V (V-Model)
Le modèle en V est une **variante du modèle en cascade** qui met l’accent sur la **validation et la vérification** à chaque étape du cycle de vie. Son principe repose sur une symétrie : à chaque phase de **conception** correspond une phase de **test**.  
Ainsi, les tests ne sont pas seulement effectués à la fin du projet, mais sont planifiés dès le début, en parallèle avec les activités de développement.  

Le déroulement se lit de gauche à droite, formant la lettre **V** :  
- La branche descendante correspond aux activités d’**analyse et de conception**.  
- La branche montante correspond aux activités de **test et validation**.  

<img src="/420-310/images/vmodel.png" alt="Modèle en V" width="600">

<!-- - **Phases typiques :**  
  - Analyse des besoins ↔ Tests d’acceptation  
  - Spécifications fonctionnelles ↔ Tests système  
  - Conception technique ↔ Tests d’intégration  
  - Implémentation ↔ Tests unitaires  
   -->
- **Avantages :**  
  - Forte traçabilité entre exigences et tests.  
  - Améliore la qualité et la fiabilité.  
  - Particulièrement adapté aux projets critiques (ex. santé, aéronautique, défense) où la validation est essentielle.  

- **Inconvénients :**  
  - Reste rigide et coûteux si les exigences changent en cours de route.  
  - Peu adapté aux environnements dynamiques ou incertains.  
  - Comme pour la cascade, les premiers retours clients arrivent tard.  
  
---

## 3. Itératif / Incrémental
Le modèle itératif et incrémental combine deux idées complémentaires :  
1. **Itératif** : le développement se fait en **cycles répétés**. À chaque cycle, l’équipe revient sur les mêmes étapes (mini-séquence complète de développement : **analyse → conception → implémentation → test**) pour améliorer ou ajuster le produit.  
2. **Incrémental** : à chaque cycle, le produit est **enrichi d’un nouvel incrément**, c’est-à-dire une partie fonctionnelle du logiciel utilisable.  

Ainsi, le logiciel évolue progressivement plutôt que d’être livré uniquement à la fin (comme dans la cascade). Les incréments successifs finissent par constituer le système complet.  
Les grands **objectifs du projet**, les **coûts** et l’**échéancier global** sont **définis dès le départ**, ce qui distingue ce modèle d’une approche entièrement agile.

- **Avantages :**  
  - Produit fonctionnel livré plus tôt.  
  - Permet de corriger et d’améliorer au fur et à mesure. 
  - Possibilité de corriger les erreurs rapidement.  
  - Flexibilité pour intégrer les retours des utilisateurs. 
  - Réduction des risques comparé au modèle en cascade.  

- **Inconvénients :**  
  - Nécessite une bonne gestion pour coordonner les incréments.
  - Peut entraîner une architecture instable si la planification initiale est insuffisante.  
  <!-- - Risque de dérive si les itérations ne sont pas bien contrôlées.   -->


## 4. Agile (exemple : scrum)
Le terme « Agile » désigne un **ensemble de méthodes de gestion** de projet et de développement, initialement pour les logiciels, qui valorise la **flexibilité**, la **collaboration**, l'**adaptation au changement** et la **livraison continue** de produits fonctionnels. Inspirée par le **Manifeste Agile**, cette approche **itérative** repose sur des cycles courts (comme les sprints), une forte **implication du client** et une **amélioration progressive**, permettant aux équipes de répondre rapidement aux **besoins évolutifs**. 

La méthodologie repose principalement sur deux principes fondamentaux : **la souplesse** et **la flexibilité**, qui permettent à l’équipe de s’ajuster rapidement aux changements et de maximiser la valeur livrée. 

<img src="/420-310/images/agile.jpeg" alt="Modèle agile" width="800">

### Le fonctionnent des méthodes Agile 
Le principe des méthodes Agile est de remplacer la planification lourde et rigide par une organisation **courte, flexible et centrée sur le client**. Le projet est découpé en **objectifs à court terme**, réalisés de manière progressive et ajustés au fil des retours des utilisateurs. Une équipe agile livre des petits morceaux de travail mais **utilisables**.

1. **Création du *backlog***  
   Le projet débute par la constitution d’un ***backlog***, c’est-à-dire une liste priorisée de fonctionnalités et d’objectifs.  
   Chaque élément du *backlog* représente une valeur à livrer au client. Le backlog est souvent alimenté par des **user stories**, de courtes descriptions exprimées du point de vue de l’utilisateur final.   
   Ces *user stories* permettent de garder le focus sur les besoins réels et servent de base à la planification des *sprints*.

2. **Planification des *sprints***  
   Le travail est ensuite découpé en ***sprints*** (périodes courtes de 1 à 4 semaines).  
   Au début de chaque *sprint*, l’équipe sélectionne dans le *backlog* les éléments à réaliser.  
   L’objectif est de livrer, à la fin du *sprint*, un incrément utilisable du produit.

3. **Suivi du travail avec des tableaux Kanban**  
   Pour visualiser l’avancement, les équipes utilisent souvent des **tableaux Kanban** (ex.: physiques avec des post-its ou numériques).  
   Les colonnes typiques sont : *À faire* → *En cours* → *En revue* → *Terminé*.  
   Ces tableaux permettent de gérer le flux de travail et de limiter le nombre de tâches en cours (*WIP*).

4. **Revue et rétrospective**  
   À la fin du *sprint*, l’équipe effectue une **revue** pour présenter les fonctionnalités terminées.  
   Les clients ou utilisateurs testent directement l’incrément et donnent leur *feedback*.  
   Une **rétrospective** interne permet à l’équipe de discuter de ce qui a bien fonctionné et de ce qui peut être amélioré pour le *sprint* suivant.

5. **Amélioration continue**  
   Les étapes se répètent (sélection dans le *backlog*, *sprint*, revue, ajustement), jusqu’à obtenir un produit complet.  
   En pratique, un produit agile n’est jamais considéré comme totalement “fini” : il reste toujours **améliorable et perfectible**.


### La méthode agile la plus répandue : scrum
La méthode **scrum** est l’un des cadres les plus connus de la culture Agile.  
Elle s’appuie sur une organisation claire des rôles :

- ***Product Owner*** : définit et priorise le *backlog*, porte la vision du produit et assure la relation avec les clients.  
- ***Scrum Master*** : garantit que la méthode *scrum* est respectée et aide l’équipe à lever les obstacles.  
- **Équipe de développement** : construit le produit et livre les incréments à chaque sprint.   

Scrum est aujourd’hui très répandu car il est simple à mettre en place et soutenu par de nombreux **outils numériques** (Jira, Trello, Asana, Azure DevOps, etc.) qui facilitent la gestion du *backlog*, des *sprints* et des tableaux Kanban.

**Avantages de la méthodologie agile**
- **Rapidité et flexibilité** : s’adapte rapidement aux changements, réduit le délai de mise en marché.  
- **Motivation des équipes** : plus d’autonomie, transparence, responsabilité.  
- **Meilleure prise de décision** : se concentre sur les décisions critiques plutôt que sur la bureaucratie.  
- **Applicabilité universelle** : même si née dans le logiciel, Agile est aujourd’hui adoptée par des entreprises de nombreux secteurs.

---

## 5. DevOps
DevOps est une approche moderne du développement logiciel qui vise à rapprocher les équipes de développement (Dev) et d’exploitation (Ops). Elle repose sur l’automatisation, la collaboration et l’intégration continue des processus de *build*, de test, de déploiement et de surveillance. L’objectif est de livrer des logiciels plus rapidement, avec une meilleure qualité et une fiabilité accrue, tout en favorisant une amélioration continue. DevOps ne se limite pas à des outils, mais incarne aussi une culture qui valorise la communication, la transparence et la réactivité face aux changements.

<img src="/420-310/images/devops.jpeg" alt="DevOps" width="800">
<!-- LOG410 cours 2 - méthdoes de dev et exigences  -->

<!-- 
rencontre 04
modèles de développement


Les modèles, en bref
1) Cascade (Waterfall)

Phases linéaires : exigences → analyse → conception → implémentation → tests → déploiement.

Prévisible, clair pour contrats fixes et conformité.

– Peu flexible : les changements coûtent cher; feedback tardif.

À privilégier si exigences très stables et contexte réglementé.

2) Itératif & Incrémental

Itératif : on refait des cycles pour raffiner la même version.

Incrémental : on ajoute des morceaux de fonctionnalités utilisables au fil du temps.

Souvent combinés; agiles s’appuient dessus.

Utile si on veut livrer tôt et apprendre à chaque cycle.

3) Agile (famille de pratiques)

Valeurs : collaboration, logiciel qui marche, adaptation au changement.

Scrum : sprints (1–4 sem.), rôles (Product Owner, Scrum Master, Équipe), rituels (Planning, Daily, Review, Retro), artefacts (Product/Sprint Backlog, Increment).

Kanban : flux continu, limites WIP, métriques (lead time), amélioration continue.

XP : TDD, intégration continue, refactoring, pair programming.

Très réactif à l’incertitude; feedback rapide.

– Demande discipline d’équipe et proximité avec le “client”.

4) Modèle en V

Variante “planifiée” où chaque phase de dev a son miroir de test (exigences ↔ tests d’acceptation, design ↔ tests système, code ↔ tests unitaires).

Solide pour traçabilité et qualité dans les domaines critiques (santé, avionique).

5) Spirale

Cycles successifs pilotés par le risque : objectifs → analyse des risques → prototypage → validation.

Pertinent pour projets complexes/risqués; plus théorique en pratique pure.

6) DevOps (culture outillée, pas un modèle)

Vise le flux de la livraison : CI/CD, infra as code, monitoring, feedback ops → dev.

Se combine avec Agile/Itératif pour livrer souvent de façon fiable.


https://idealink.tech/fr/blog/top-software-development-methodologies

Méthodologie de développement logiciel agile
Modèle de cascade
Méthodologie des prototypes
Méthodologie DevOps
Développement rapide d'applications (RAD)
Méthodologie du modèle de développement de systèmes dynamiques
Méthodologie de développement Lean -->

<!-- ## Les principales **méthodes de conception**

| Méthode | Quand l’utiliser ? | Points clés |
|---------|-------------------|-------------|
| **Cascade / V-Model** | Projets aux exigences stables, gros livrable unique | Phases séquentielles, documentation exhaustive |
| **Agile (Scrum / Kanban)** | Évolution fréquente du périmètre, itérations courtes | Sprints, backlog, revues régulières |
| **Spiral** | Projets à haut risque technique | Cycles incrémentaux + gestion de risque |
| **Extreme Programming (XP)** | Équipes réduites, forte culture de test | TDD, pair-programming, refactoring permanent |

> Nous approfondirons chaque approche à travers des études de cas et des exercices pratiques.
> -->