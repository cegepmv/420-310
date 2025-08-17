+++
title = 'Fondements de l’ingénierie logicielle'
type = "home"
+++
<!-- Nouveau chapitre
hugo new --kind chapter content/01-modelisation/_index.md -->

Le cours d’architecture logicielle a pour objectifs de former l’étudiant ou l’étudiante à concevoir et planifier des projets logiciels de manière à en assurer la réussite à long terme. Au fil des séances, il ou elle apprendra à comparer diverses architectures, à en mesurer les forces, faiblesses et coûts techniques, puis à justifier ses choix de façon argumentée. Le cours développe également un vocabulaire commun de conception logicielle, indispensable pour dialoguer efficacement avec ses pairs. 

Enfin, la démarche adoptée met l’accent sur la nuance : il n’existe jamais une unique solution idéale, et la capacité à sélectionner l’approche la plus appropriée à un contexte donné constitue une compétence centrale qui sera cultivée tout au long de la formation.

<!-- Ce site regroupe toutes les ressources (notes, exemples de code, exercices) pour la session. -->

## Objectifs du cours

- Comprendre les fondements de l’ingénierie logicielle : **analyse** des besoins et **modélisation**.
- Maîtriser les principaux styles architecturaux, en particulier **MVC**, et plusieurs **patrons de conception**.
- Savoir assurer la **qualité** d’un logiciel : tests unitaires, intégration continue, TDD, CI/CD.

<!-- ## 3 blocs d’apprentissage

| <span style="font-variant: small-caps; font-size: 1em;">#</span> | <span style="font-variant: small-caps; font-size: 1.25em;">bloc</span> | <span style="font-variant: small-caps; font-size: 1.25em;">contenu principal</span> |
|---|------|------------------|
| **1** | Analyse et modélisation | Exigences, UML (cas d’utilisation, classes), méthodes de travail (Agile, Cascade, Kanban) |
| **2** | Architecture et conception | MVC & variantes, patrons (Repository, Service, Factory…), séparation des couches |
| **3** | Tests et qualité | TDD, JUnit, tests d’intégration, CI/CD | -->

---

<!-- ## Les principales **méthodes de conception**

| Méthode | Quand l’utiliser ? | Points clés |
|---------|-------------------|-------------|
| **Cascade / V-Model** | Projets aux exigences stables, gros livrable unique | Phases séquentielles, documentation exhaustive |
| **Agile (Scrum / Kanban)** | Évolution fréquente du périmètre, itérations courtes | Sprints, backlog, revues régulières |
| **Spiral** | Projets à haut risque technique | Cycles incrémentaux + gestion de risque |
| **Extreme Programming (XP)** | Équipes réduites, forte culture de test | TDD, pair-programming, refactoring permanent |

> Nous approfondirons chaque approche à travers des études de cas et des exercices pratiques.
> -->

## 1) Notion de **conception d’applications**
**Le but** : transformer les besoins en une **solution détaillée** prête à construire.

<!-- ### Ce que c’est
- Organisation **interne** des modules/composants, **contrats d’API**, gestion des **erreurs**, **modèle de données** et règles métier, **flux UI/UX**.
- Choix de **patrons** (Strategy, Factory, Repository, Adapter…), de **tactiques** (cache, pagination, idempotence) et de **contraintes** (validation, sécurité, performance).

### La portée (vs architecture)
- **Architecture** = charpente globale (frontières, styles d’intégration, décisions coûteuses à changer).
- **Conception** = comment réaliser une **capacité** dans ce cadre (algorithmes, signatures, schémas, tests).

### Artefacts typiques
- **UML** (classes, séquence, états), **schémas de données**, **contrats API** (OpenAPI/GraphQL), maquettes UI, **règles de validation**, **tests d’acceptation** (Gherkin).

### Bonnes pratiques
- SOLID, DRY, KISS, YAGNI • gestion d’erreurs cohérente • invariants/pré-postconditions • budgets de perf (p95/p99) • sécurité dès la conception (authZ/authN, menaces). -->


## 2) Notion d’**architecture** logicielle
**Le but** : définir la **structure d’ensemble**, les **relations** et les **principes** qui guident la conception et l’évolution.

Un peu comme pour le bâtiment où l’on fixe d’abord fondations et ossature, l’architecture logicielle regroupe les **décisions précoces** (frontières, styles, interactions) qui orientent durablement le système ; et ce même si le développement moderne privilégie l’**adaptabilité** plutôt qu’une planification rigide, ces choix initiaux restent parfois coûteux à modifier.

### Une définition selon **ISO/IEC/IEEE 42010**
Il existe une définition standard de l'architecture logicielle, qui résulte d'un effort conjoint entre l'Organisation internationale de normalisation (International Organization for Standardization - ISO) et l'Institute of Electrical and Electronics Engineers (IEEE). 

La description de l'architecture des systèmes et de l'ingénierie logicielle ISO/IEC/IEEE 42010 est une norme internationale qui définit l'architecture logicielle comme :
> **EN** — *Fundamental concepts or properties of a system in its environment embodied in its elements, relationships, and in the principles of its design and evolution.*

> **FR** — *Concepts ou propriétés fondamentaux d’un système dans son environnement, incarnés par ses éléments, leurs relations, et par les principes de sa conception et de son évolution.*

##### Les points clés de la norme (en bref)
- L’architecture est **fondamentale** au système.
- Un système logiciel est situé dans un **environnement** (contraintes, systèmes voisins) dont l’architecture **tient compte**.
- Une **description d’architecture** documente l’architecture et **communique** aux **parties prenantes** comment l'architecture répond aux besoins du système.
- Les **vues d'architecture** sont produites à partir de la description de l'architecture, et chaque vue couvre une ou plusieurs préoccupations (concerns) des différentes parties prenantes;

### Une définition qui provient du PMI.org
> *L’architecture logicielle d’un programme ou système, ce sont la ou les **structures** du système, comprenant des **éléments logiciels**, leurs **propriétés visibles** et les **relations** entre eux.*

<!-- #### Ce que cela implique
- Un système peut combiner **plusieurs structures** (par ex. déploiement, composants, données).
- De grandes équipes peuvent être responsables de **structures différentes** qui, ensemble, forment l’architecture globale. -->
Un système logiciel contient des structures, et cette définition note qu'un système logiciel est composé d'une ou plusieurs d'entre elles. C'est la combinaison de ceux-ci qui forme l'architecture logicielle globale. Un grand projet logiciel peut avoir plusieurs équipes qui y travaillent, chacune responsable d'une structure particulière.

### L’architecture est une **abstraction**
- Elle **décrit** les **structures**, leurs **éléments** et les **relations** entre éléments.
- Elle se concentre sur les **aspects publics** (interfaces, contrats, protocoles) et la **façon d’interagir** — pas sur chaque détail d’implémentation interne.
- Elle capture surtout les **décisions importantes** qui façonnent la **qualité**, la **longévité** et l’**utilité** du système.

<!-- > L'architecture doit anticiper, dans le développement de logiciels modernes, le changement et être conçue de manière à maximiser le potentiel d'adaptation et d'évolution à ce changement.  -->

### En quoi l’architecture est importante ?
<!-- Pourquoi devrions-nous nous soucier de l'architecture logicielle? 
Parfois, un développeur veut juste se lancer et commencer à coder. -->
La tentation est de coder tout de suite ; pourtant, l’architecture pose les fondations : elle concentre des décisions précoces qui orientent tout le reste et conditionnent les qualités du système. Et comme tout logiciel a une architecture (explicite ou non), plus le système est vaste ou complexe, plus une architecture pensée augmente les chances de succès.

<details><summary><b>Aligner la solution sur les besoins</b></summary>
Elle permet de répondre aux exigences <b>fonctionnelles</b> et <b>non fonctionnelles</b> (sécurité, performance, etc.) en collaboration avec les parties prenantes.
</details>

<details><summary><b>Activer / inhiber les qualités</b></summary>
Les <b>attributs de qualité</b> dépendent fortement des choix architecturaux. Ce sont des propriétés <b>mesurables et testables</b> (ex. : maintenabilité, sécurité, performances).
</details>

<details><summary><b>*La prédiction des qualités du système</b></summary>
On anticipe la capacité du système à atteindre ses <b>exigences non fonctionnelles</b> (évite des retouches tardives coûteuses).
</details>

<details><summary><b>Faciliter la communication entre les parties prenantes</b></summary>
Les vues et documents fournissent un <b>langage commun</b> aux équipes (métier, dev, QA, ops, sécu).
</details>

<details><summary><b>Gérer le changement</b></summary>
Les modifications sont inévitables (marché, nouvelles exigences, modifications des processus métier, avancées technologiques, correctifs). Une bonne architecture <b>localise l’impact</b> :
<ul>
  <li>Changement <b>local</b> (1 élément)</li>
  <li>Changement <b>multi-éléments</b> (sans toucher l’architecture)</li>
  <li>Changement <b>architectural</b> (frontières, styles…)</li>
</ul>
</details>

<details><summary><b>Fournir un modèle réutilisable</b></summary>
On réemploie non seulement du <b>code</b>, mais aussi des <b>décisions</b> (patrons, principes, contraintes) déjà éprouvées, ce qui économise des ressources, telles que du temps et de l'argent.
</details>

<details><summary><b>Imposer des contraintes de mise en œuvre</b></summary>
L’architecture introduit des <b>contraintes</b> d’implémentation et restreint les choix de conception. Cela réduit la complexité du système logiciel et empêche les développeurs de prendre des décisions incorrectes.
</details>

<details><summary><b>Améliorer les estimations</b></summary>
Une architecture claire aide à <b>découper</b> le travail, mieux <b>estimer</b> coûts/délais/efforts et <b>piloter</b> le projet.
Les deux principales approches de l'estimation de la gestion de projet sont les suivantes :
<ul>
  <li><b>Approche descendante (top-down approach)</b> : partir des livrables finaux et des objectifs, puis les décompose en plus petits lots de travaux</li>
  <li><b>Approche ascendante (bottom-up approach)</b> : partir des tâches spécifiques, puis regrouper en lots de travail</li>
</ul>
</details>

<details><summary><b>Former & embarquer</b></summary>
Les vues et décisions servent de <b>support d’onboarding</b> pour les nouveaux membres et pour la maintenance (l'une des phases les plus longues et coûteuses d'un projet logiciel) : compréhension des structures/éléments et de leurs interactions, utile sur la durée.
</details>

### Qui consomme l’architecture ?
Il existe une variété de parties prenantes dans un système logiciel, telles que : les utilisateurs finaux du système, les analystes commerciaux, les experts du domaine, le personnel d'assurance qualité, les gestionnaires, ceux qui peuvent s'intégrer au système et les membres du personnel des opérations. 

- **Les utilisateurs finaux** (indirectement, via les qualités perçues)
- **Les analystes commerciaux** (traçabilité besoins ↔ solution)
- **Les experts métier** (règles et périmètre)
- **Le personnel d'assurance qualité (développeurs & QA)** (contrats, dépendances, tests)
- **Ops  / sécurité** (déploiement, observabilité, conformité)
- **Intégrateurs / équipes voisines** (interfaces et frontières)
- **Gestionnaires (projet/produit/technique)** (priorisation, budget, risques, jalons)

Chacune de ces parties prenantes est affectée dans une certaine mesure par l'architecture logicielle. Alors que certaines parties prenantes auront accès et seront intéressées par l'examen de l'architecture logicielle et de sa documentation, d'autres non.

Certaines de ces parties prenantes sont des consommatrices indirectes de l'architecture dans la mesure où elles se soucient du logiciel, et comme l'architecture logicielle est le fondement du système, elles deviennent des consommateurs indirects de l'architecture. 

Lorsque nous discutons des consommateurs d'une architecture logicielle, nous ne pouvons pas omettre les développeurs qui travaillent sur ce logiciel. En tant qu'architecte logiciel, il est indispensable de penser à vos développeurs, dont le travail est directement affecté par l'architecture logicielle. Ce sont eux qui travailleront quotidiennement sur le logiciel.

### Quel est le rôle de l’**architecte logiciel**
Alors, maintenant que nous savons ce qu'est l'architecture logicielle, son importance et ses avantages, et que nous comprenons qu'il existe une variété de parties prenantes qui en sont affectées, examinons le rôle de l'architecte logiciel. 

L’architecte logiciel est la personne qui porte les **décisions structurantes** du système, **aligne** les parties prenantes sur les **qualités visées** et **documente les compromis** pour guider l’évolution. 

Il arrive qu’un projet se fasse sans architecte désigné : le succès ou l’échec peut alors tenir à d’autres facteurs. Lorsque personne ne reçoit spécifiquement le titre d'architecte logiciel, un membre de l’équipe endosse souvent de fait les décisions d’architecture (on parle d’**architecte accidentel**) ou alors ces décisions émergent **collectivement** entre développeurs. Enfin, sur des projets plus vastes ou complexes, mieux vaut **désigner explicitement** ce rôle pour assurer cohérence et gestion des risques.


### À retenir
L'architecture logicielle est la structure ou les structures d'un système, leurs éléments et les relations entre ces éléments. C'est une abstraction d'un système logiciel. L'architecture logicielle est importante, car tous les systèmes logiciels ont une architecture, et cette architecture est la base du système logiciel.
L'architecture logicielle offre un certain nombre d'avantages, tels que l'activation et l'inhibition des attributs de qualité, vous permettant de prédire les qualités du système logiciel, facilitant la communication avec les parties prenantes et vous permettant d'apporter plus facilement des modifications. Il fournit également un modèle réutilisable qui pourrait être utilisé dans plusieurs produits logiciels, impose des contraintes de mise en œuvre qui réduisent la complexité et minimisent les erreurs des développeurs, améliorent les estimations des coûts/efforts et servent de formation aux nouveaux membres de l'équipe.
Les architectes logiciels sont des leaders techniques qui sont ultimement responsables des décisions techniques, de l'architecture et de sa documentation. Ils exécutent un certain nombre de tâches et sont censés avoir des connaissances sur une variété de sujets, à la fois techniques et non techniques.

## 3) Chronologie de développement d’un système

### La planification du projet
**Objectifs** : clarifier la **vision**, le **périmètre** (in/out), les **risques** et le **cadre** (équipe, budget, jalons).  
**Livrables** : one-pager, parties prenantes/RACI, roadmap, **backlog initial**, critères de succès (KPI).  
**Outils** : doc de vision, tableau de bord projet, gestion d’issues (GitLab/GitHub).

### L'analyse
**Objectifs** : investiguer le problème pour comprendre le besoin et le rendre **testable** (vérifiable objectivement).  
**Livrables** : **SEL** préliminaire, **user stories / use cases**, **critères d’acceptation**, **exigences** mesurables, glossaire, esquisses UI.  
**Outils** : ateliers, PlantUML/draw.io, Figma (prototypage low-fi).

### La conception
**Objectifs** : définir **comment** réaliser la solution dans le cadre architectural afin de répondre aux besoins.  
**Livrables** : vues **C4** (Contexte/Conteneurs/Composants), **UML** (classes/séquence), schéma de données, **contrats API**, 
**Outils** : PlantUML/draw.io, OpenAPI, linters de schémas, checklists qualité.

### La mise en œuvre
**Objectifs** : construire, valider et livrer en continu.  
**Livrables** : code + **tests** (unitaires/intégration), **pipeline CI/CD**, artefacts versionnés, doc d’utilisation.   
**Outils** : IDE, Git (PR/MR), CI/CD, Docker (packaging), gestion de secrets

### L'exploitation et support 
**Objectifs** : opérer de façon fiable, apprendre de la prod et itérer.  
**Livrables** : **SLI/SLO**, monitoring/alerting, **logs/métriques/traces**, runbooks, gestion d’incidents, plan de mises à jour/sécurité, feedback vers le backlog.  
**Outils** : Grafana/Prometheus, pages de statut, post-mortems. 
