+++
pre = '<b>0. </b>'
title = 'Fondements de l’ingénierie logicielle'
weight = 1
+++

À travers ce module, nous poserons les **fondations de l’ingénierie logicielle** : un vocabulaire commun pour passer du besoin à une solution construisible. Il y sera présenté la **conception d’applications** (le *comment détaillé*), l’**architecture** (la *charpente d’ensemble* et ses décisions structurantes) et la **chronologie type** d’un projet (de la planification à l’exploitation). 
Il s’agit d’un **aperçu** de l’ingénierie logicielle : nous ne couvrirons pas toutes les technologies mentionnées, mais l’objectif est de vous y **situer** et de vous donner des **repères** solides pour la suite de vos apprentissages.

---

## 1) Notion de **conception d’applications**
**Le but** : transformer les besoins en une **solution détaillée** prête à construire.

- Organisation **interne** des modules/composants, **contrats d’API**, gestion des **erreurs**, **modèle de données** et règles métier, **flux UI/UX**.
- Choix de **patrons** (Observer, Strategy, Adapter…), de **tactiques** (cache, pagination, idempotence) et de **contraintes** (validation, sécurité, performance).

### La portée (vs architecture)
- **Architecture** = charpente globale (frontières, styles d’intégration, décisions coûteuses à changer).
- **Conception** = comment réaliser une **capacité** dans ce cadre (algorithmes, signatures, schémas, tests).

### Artefacts typiques
- **UML** (classes, séquence, états), **schémas de données**, **contrats API** (OpenAPI/GraphQL), maquettes UI, **règles de validation**, **tests d’acceptation**.
  
---

## 2) Notion d’**architecture** logicielle
**Le but** : définir la **structure d’ensemble**, les **relations** et les **principes** qui guident la conception et l’évolution.

Un peu comme pour le bâtiment où l’on fixe d’abord fondations et ossature, l’architecture logicielle regroupe les **décisions précoces** (frontières, styles, interactions) qui orientent durablement le système ; et ce même si le développement moderne privilégie l’**adaptabilité** plutôt qu’une planification rigide, ces choix initiaux restent parfois coûteux à modifier.

{{% tabs %}}

{{% tab title="ISO/IEC/IEEE 42010" %}}
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
{{% /tab %}}

{{% tab title="PMI.org" %}}
### Une définition qui provient du PMI.org
> *L’architecture logicielle d’un programme ou système, ce sont la ou les **structures** du système, comprenant des **éléments logiciels**, leurs **propriétés visibles** et les **relations** entre eux.*

<!-- #### Ce que cela implique
- Un système peut combiner **plusieurs structures** (par ex. déploiement, composants, données).
- De grandes équipes peuvent être responsables de **structures différentes** qui, ensemble, forment l’architecture globale. -->
Un système logiciel contient des structures, et cette définition note qu'un système logiciel est composé d'une ou plusieurs d'entre elles. C'est la combinaison de ceux-ci qui forme l'architecture logicielle globale. Un grand projet logiciel peut avoir plusieurs équipes qui y travaillent, chacune responsable d'une structure particulière.
{{% /tab %}}

{{% /tabs %}}

<!-- === Styles locaux pour les titres et accordéons === -->
<style>
  /* Titres de section — style léger */
  .section-title{
    background:#f8f9fb;            /* gris doux */
    border:1px solid #e5e7eb;
    border-radius:8px;
    padding:8px 12px;
    margin:22px 0 12px;
  }
  .section-title h3{ margin:0; font-weight:700; }

  .details-menu summary {
    list-style: none;              /* cache la flèche par défaut (Firefox) */
    cursor: pointer;
    padding: .25rem 0;
    font-weight: 700;
  }
  .details-menu summary::-webkit-details-marker { display: none; } /* Chrome/Safari */
  .details-menu summary::before {
    content: "▶";
    font-size: .9em;
    margin-right: .5rem;
    transition: transform .2s ease;
  }
  .details-menu[open] summary::before {
    content: "▼";
  }
  .details-menu ul { margin: .3rem 0 .8rem 1.4rem; }
</style>


<div class="section-title"><h3>L’architecture est une abstraction</h3></div>

- Elle **décrit** les **structures**, leurs **éléments** et les **relations** entre éléments.
- Elle se concentre sur les **aspects publics** (interfaces, contrats, protocoles) et la **façon d’interagir** — pas sur chaque détail d’implémentation interne.
- Elle capture surtout les **décisions importantes** qui façonnent la **qualité**, la **longévité** et l’**utilité** du système.

<!-- > L'architecture doit anticiper, dans le développement de logiciels modernes, le changement et être conçue de manière à maximiser le potentiel d'adaptation et d'évolution à ce changement.  -->

<div class="section-title"><h3>En quoi l’architecture est importante ?</h3></div>

<!-- Pourquoi devrions-nous nous soucier de l'architecture logicielle? 
Parfois, un développeur veut juste se lancer et commencer à coder. -->
La tentation est de coder tout de suite ; pourtant, l’architecture pose les fondations : elle concentre des décisions précoces qui orientent tout le reste et conditionnent les qualités du système. Et comme tout logiciel a une architecture (explicite ou non), plus le système est vaste ou complexe, plus une architecture pensée augmente les chances de succès.

<details class="details-menu">
  <summary>Aligner la solution sur les besoins</summary>
  <div>Elle permet de répondre aux exigences <b>fonctionnelles</b> et <b>non fonctionnelles</b> (sécurité, performance, etc.) en collaboration avec les parties prenantes.</div>
</details>

<details class="details-menu">
  <summary>Activer / inhiber les qualités</summary>
  <div>Les <b>attributs de qualité</b> dépendent fortement des choix architecturaux. Ce sont des propriétés <b>mesurables et testables</b> (ex. : maintenabilité, sécurité, performances).</div>
</details>

<details class="details-menu">
  <summary>La prédiction des qualités du système</summary>
  <div>On anticipe la capacité du système à atteindre ses <b>exigences non fonctionnelles</b> (évite des retouches tardives coûteuses).</div>
</details>

<details class="details-menu">
  <summary>Faciliter la communication entre les parties prenantes</summary>
  <div>Les vues et documents fournissent un <b>langage commun</b> aux équipes (métier, dev, QA, ops, sécu).</div>
</details>

<details class="details-menu">
  <summary>Gérer le changement</summary>
  <div>
    Les modifications sont inévitables (marché, nouvelles exigences, modifications des processus métier, avancées technologiques, correctifs). Une bonne architecture <b>localise l’impact</b> :
    <ul>
      <li>Changement <b>local</b> (1 élément)</li>
      <li>Changement <b>multi-éléments</b> (sans toucher l’architecture)</li>
      <li>Changement <b>architectural</b> (frontières, styles…)</li>
    </ul>
  </div>
</details>

<details class="details-menu">
  <summary>Fournir un modèle réutilisable</summary>
  <div>On réemploie non seulement du <b>code</b>, mais aussi des <b>décisions</b> (patrons, principes, contraintes) déjà éprouvées, ce qui économise des ressources, telles que du temps et de l'argent.</div>
</details>

<details class="details-menu">
  <summary><b>Imposer des contraintes de mise en œuvre</b></summary>
  <div>L’architecture introduit des <b>contraintes</b> d’implémentation et restreint les choix de conception. Cela réduit la complexité du système logiciel et empêche les développeurs de prendre des décisions incorrectes.</div>
</details>

<details class="details-menu">
  <summary>Améliorer les estimations</summary>
  <div>
    Une architecture claire aide à <b>découper</b> le travail, mieux <b>estimer</b> coûts/délais/efforts et <b>piloter</b> le projet.
    Les deux principales approches de l'estimation de la gestion de projet sont les suivantes :
    <ul>
      <li><b>Approche descendante (top-down approach)</b> : partir des livrables finaux et des objectifs, puis les décompose en plus petits lots de travaux</li>
      <li><b>Approche ascendante (bottom-up approach)</b> : partir des tâches spécifiques, puis regrouper en lots de travail</li>
    </ul>
  </div>
</details>

<details class="details-menu">
  <summary>Former & embarquer</summary>
  <div>Les vues et décisions servent de <b>support d’onboarding</b> pour les nouveaux membres et pour la maintenance (l'une des phases les plus longues et coûteuses d'un projet logiciel) : compréhension des structures/éléments et de leurs interactions, utile sur la durée.</div>
</details>

<div class="section-title"><h3>Qui consomme l’architecture ?</h3></div>

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

<div class="section-title"><h3>Quel est le rôle de l’<b>architecte logiciel</b></h3></div>

Alors, maintenant que nous savons ce qu'est l'architecture logicielle, son importance et ses avantages, et que nous comprenons qu'il existe une variété de parties prenantes qui en sont affectées, examinons le rôle de l'architecte logiciel. 

L’architecte logiciel est la personne qui porte les **décisions structurantes** du système, **aligne** les parties prenantes sur les **qualités visées** et **documente les compromis** pour guider l’évolution. 

Il arrive qu’un projet se fasse sans architecte désigné : le succès ou l’échec peut alors tenir à d’autres facteurs. Lorsque personne ne reçoit spécifiquement le titre d'architecte logiciel, un membre de l’équipe endosse souvent de fait les décisions d’architecture (on parle d’**architecte accidentel**) ou alors ces décisions émergent **collectivement** entre développeurs. Enfin, sur des projets plus vastes ou complexes, mieux vaut **désigner explicitement** ce rôle pour assurer cohérence et gestion des risques.

### À retenir
L'architecture logicielle est la structure ou les structures d'un système, leurs éléments et les relations entre ces éléments. C'est une abstraction d'un système logiciel. L'architecture logicielle est importante, car tous les systèmes logiciels ont une architecture, et cette architecture est la base du système logiciel.
L'architecture logicielle offre un certain nombre d'avantages, tels que l'activation et l'inhibition des attributs de qualité, vous permettant de prédire les qualités du système logiciel, facilitant la communication avec les parties prenantes et vous permettant d'apporter plus facilement des modifications. Il fournit également un modèle réutilisable qui pourrait être utilisé dans plusieurs produits logiciels, impose des contraintes de mise en œuvre qui réduisent la complexité et minimisent les erreurs des développeurs, améliorent les estimations des coûts/efforts et servent de formation aux nouveaux membres de l'équipe.
Les architectes logiciels sont des leaders techniques qui sont ultimement responsables des décisions techniques, de l'architecture et de sa documentation. Ils exécutent un certain nombre de tâches et sont censés avoir des connaissances sur une variété de sujets, à la fois techniques et non techniques.

---

## 3) Chronologie de développement d’un système
<style>
  .chrono-tabs{margin:18px 0 12px; font-size:1rem;}

  .chrono-tabs input[type="radio"]{position:absolute; left:-9999px;}

  .chrono-tabs .tabbar{
    display:flex; flex-wrap:wrap; align-items:center;
    gap:.35rem .5rem; margin:8px 0 14px;
  }
  .chrono-tabs .tab-label{
    display:inline-flex; align-items:center; white-space:nowrap;
    cursor:pointer; user-select:none;
    padding:6px 12px; border:1px solid #e5e7eb; border-radius:999px;
    background:#f8f9fb; font-weight:600; color:#111827; line-height:1.2;
    transition:all .15s ease; text-decoration:none;
  }
  .chrono-tabs .arrow{ color:#9aa0a6; font-weight:700; }

  #tab-planif:checked ~ .tabbar label[for="tab-planif"],
  #tab-analyse:checked ~ .tabbar label[for="tab-analyse"],
  #tab-conception:checked ~ .tabbar label[for="tab-conception"],
  #tab-impl:checked ~ .tabbar label[for="tab-impl"],
  #tab-ops:checked ~ .tabbar label[for="tab-ops"]{
    background:#eef2ff; border-color:#c7d2fe; color:#1e3a8a;
  }

  .chrono-tabs .panels{border:1px solid #e5e7eb; border-radius:10px;}
  .chrono-tabs .panel{display:none; padding:14px;}

  #tab-planif:checked ~ .panels #panel-planif{display:block;}
  #tab-analyse:checked ~ .panels #panel-analyse{display:block;}
  #tab-conception:checked ~ .panels #panel-conception{display:block;}
  #tab-impl:checked ~ .panels #panel-impl{display:block;}
  #tab-ops:checked ~ .panels #panel-ops{display:block;}
</style>

<div class="chrono-tabs">
  <input type="radio" name="chrono" id="tab-planif" checked>
  <input type="radio" name="chrono" id="tab-analyse">
  <input type="radio" name="chrono" id="tab-conception">
  <input type="radio" name="chrono" id="tab-impl">
  <input type="radio" name="chrono" id="tab-ops">

  <div class="tabbar">
    <label class="tab-label" for="tab-planif">Planification</label><span class="arrow">→</span>
    <label class="tab-label" for="tab-analyse">Analyse</label><span class="arrow">→</span>
    <label class="tab-label" for="tab-conception">Conception</label><span class="arrow">→</span>
    <label class="tab-label" for="tab-impl">Mise en œuvre</label><span class="arrow">→</span>
    <label class="tab-label" for="tab-ops">Exploitation & support</label>
  </div>

  <div class="panels">
    <div id="panel-planif" class="panel">
      <h4>La planification du projet</h4>
      <p><b>Objectifs</b> : clarifier la <b>vision</b>, le <b>périmètre</b> (in/out), les <b>risques</b> et le <b>cadre</b> (équipe, budget, jalons).</p>
      <p><b>Livrables</b> : one-pager, parties prenantes/RACI, roadmap, <b>backlog initial</b>, critères de succès (KPI).</p>
      <p><b>Outils</b> : doc de vision, tableau de bord projet, gestion d’issues (GitLab/GitHub).</p>
    </div>
    <div id="panel-analyse" class="panel">
      <h4>L'analyse</h4>
      <p><b>Objectifs</b> : investiguer le problème pour comprendre le besoin et le rendre <b>testable</b> (vérifiable objectivement).</p>
      <p><b>Livrables</b> : <b>SEL</b> préliminaire, <b>user stories / use cases</b>, <b>critères d’acceptation</b>, <b>exigences</b> mesurables, glossaire, esquisses UI.</p>
      <p><b>Outils</b> : ateliers, PlantUML/draw.io, Figma (prototypage low-fi).</p>
    </div>
    <div id="panel-conception" class="panel">
      <h4>La conception</h4>
      <p><b>Objectifs</b> : définir <b>comment</b> réaliser la solution dans le cadre architectural afin de répondre aux besoins.</p>
      <p><b>Livrables</b> : vues <b>C4</b> (Contexte/Conteneurs/Composants), <b>UML</b> (classes/séquence), schéma de données, <b>contrats API</b>.</p>
      <p><b>Outils</b> : PlantUML/draw.io, OpenAPI, linters de schémas, checklists qualité.</p>
    </div>
    <div id="panel-impl" class="panel">
      <h4>La mise en œuvre</h4>
      <p><b>Objectifs</b> : construire, valider et livrer en continu.</p>
      <p><b>Livrables</b> : code + <b>tests</b> (unitaires/intégration), <b>pipeline CI/CD</b>, artefacts versionnés, doc d’utilisation.</p>
      <p><b>Outils</b> : IDE, Git (PR/MR), CI/CD, Docker (packaging), gestion de secrets, Helm/Kustomize</p>
    </div>
    <div id="panel-ops" class="panel">
      <h4>L'exploitation et support</h4>
      <p><b>Objectifs</b> : opérer de façon fiable, apprendre de la prod et itérer.</p>
      <p><b>Livrables</b> : <b>SLI/SLO</b>, monitoring/alerting, <b>logs/métriques/traces</b>, runbooks, gestion d’incidents, plan de mises à jour/sécurité, feedback vers le backlog.</p>
      <p><b>Outils</b> : Grafana/Prometheus (*monitoring*), pages de statut, post-mortems.</p>
    </div>
  </div>
</div>

---

### Analyse, modélisation et conception — repères rapides

<style>
  /* Style formel : coins carrés, grille fine, en-têtes contrastés */
  .table-compare{margin:8px 0 12px;}
  .table-compare table{width:100%; border-collapse:collapse; font-size:0.98rem;}
  .table-compare th,.table-compare td{
    padding:10px 12px; border:1px solid #d1d5db; vertical-align:top;
  }
  .table-compare thead th{
    background:#f1f5f9; color:#0f172a; font-weight:700; /* en-têtes qui se démarquent */
    border-bottom:2px solid #94a3b8; text-transform:none;
  }
  .table-compare tbody tr:nth-child(even){background:#fafafa;} /* léger zebra */
  .note-important{
    margin-top:12px; padding:10px 12px; background:#f8f9fb; border:1px solid #e5e7eb;
    border-left:4px solid #64748b; border-radius:0; /* coins carrés */
  }
</style>

<div class="table-compare">

| Aspect | Analyse | Modélisation | Conception |
|---|---|---|---|
| **But** | Éliciter, clarifier les besoins | Structurer et visualiser | Définir la solution technique |
| **Questions** | Quel problème? Pour qui?<br>Quelles règles? Quels NFR? | Comment représenter fidèlement?<br>Quelles frontières? | Quelles technologies, patterns, composants, APIs? |
| **Livrables** | SEL (exigences F/NF), user stories, critères d’acceptation, glossaire | Use cases, MDD (modèle de domaine), SSD, maquettes, C4 Contexte | Vues C4 (Conteneurs/Composants), diagrammes de classes (conception), schéma de données, contrats d’API, décisions (ADR) |
| **Niveau** | Métier / besoins | Abstrait (peut être métier **ou** technique) | Technique / implémentable |
| **Acteurs** | Client/PO, analyste, archi | Tous (métier + tech) | Archi, devs, ops/sécu |
| **Risques traités** | Malentendus, périmètre | Ambiguïtés, incohérences | Performance, sécurité, coût, maintenabilité |

</div>

<div class="note-important">
<strong>Important :</strong> la modélisation n’est pas une phase en soi — c’est une <strong>activité</strong> qui sert l’<strong>analyse</strong> (modèles métier) et la <strong>conception</strong> (modèles techniques).
</div>

<!-- Si ton thème bloque le HTML, garde seulement la table Markdown
     et remplace la note par :
> **Important :** la modélisation n’est pas une phase en soi — c’est une **activité** qui sert l’**analyse** (modèles métier) et la **conception** (modèles techniques).
-->

