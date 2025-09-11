+++
pre = '<b>1.1 </b>'
title = "S.E.L"
weight = 1
+++

# spécifications des exigences logicielles

La **spécification des exigences logicielles** (SEL) décrit **ce que** le système doit faire et **dans quelles conditions** il doit le faire.  
Elle sert de contrat **vérifiable** entre parties prenantes (métier, dev, QA, ops), encadre la **conception** et facilite les **tests d’acceptation**.

> Objectif : transformer un besoin flou en exigences **claires, mesurables et traçables**.

![Tree swing](/420-310/images/tree_swing.jpg)

L’image classique du **“tree swing”** illustre les malentendus possibles entre client, analyste, dev et test : chacun imagine une solution différente au même besoin, d’où l’importance d’un **SEL précis**.

<!-- === Styles locaux pour les titres et accordéons === -->
<style>
  /* titres de section — style léger */
  .section-title{
    background:#f8f9fb;            
    border:1px solid #e5e7eb;
    border-radius:8px;
    padding:8px 12px;
    margin:22px 0 12px;
  }
  .section-title h3{ margin:0; font-weight:700; }
</style>

## Étapes d'analyse du problème
<style>
  .details-menu summary{list-style:none;cursor:pointer;font-weight:700;padding:.25rem 0}
  .details-menu summary::-webkit-details-marker{display:none}
  .details-menu summary::before{content:"▶";font-size:.9em;margin-right:.5rem;transition:transform .2s ease}
  .details-menu[open] summary::before{content:"▼"}
</style>

1. <details class="details-menu"><summary>Obtenir l’<b>accord</b> sur la <b>définition du problème</b></summary>
   Aligner tout le monde sur le problème réel à résoudre (pas la solution).   <br></br>
   <b>Questions</b> : Quel impact ? Observable/mesurable du problème sur les activités (coût, délai, qualité, risque…). Affecte qui ? Lister les parties prenantes impactées (rôles, équipes, systèmes). Comment sait-on que c’est résolu ? Indiquer la valeur attendue en cas de résolution (quelques bénéfices clés, indicateurs cibles)
</details>

2. <details class="details-menu"><summary>Comprendre les <b>causes racines</b></summary>
   Éviter de traiter les symptômes. <br></br>
   <b>Quelques méthodes</b> : “5 pourquoi”, Ishikawa, analyse de données/incidents. 

    🔗 [Exemple diagramme d’Ishikawa (cause à effet)](https://www.biotechno.fr/IMG/scenari/dossierpse/co/Ishikawa.html)
</details>

3. <details class="details-menu"><summary>Identifier les <b>utilisateurs</b> et les <b>parties prenantes</b></summary>
   Savoir qui est impacté, qui décide et qui opère. <br></br>
   <b>Livrables</b> : carte des parties prenantes (intérêt/influence), acteurs/personas, RACI sommaire.
   
   {{< figure src="/420-310/images/stakeholders-degrees.png" caption="Carte des parties prenantes par degrés : 1) Utilisateurs directs du produit, 2) Personnes/systèmes travaillant avec les résultats, 3) Acteurs qui installent, déploient ou supportent le système." >}}
   
   > Astuce : cette carte aide à ne pas oublier des profils clés (ex. support, conformité, systèmes voisins) et à couvrir leurs préoccupations dans le SEL.
</details>

4. <details class="details-menu"><summary>Définir les <b>frontières de la solution</b></summary>
   Tracer le <i>in/out</i> et les interfaces externes.   <br></br>
   <b>L’environnement</b> : le système + ce qui interagit avec le système
</details>

5. <details class="details-menu"><summary>Identifier les <b>contraintes imposées</b> à la solution</summary>
   Lister les non-négociables (réglementaire, sécurité, techno, budget, délais).  
</details>

<div class="section-title"><h3>Où chercher l’information et comment la recueillir</h3></div>

Objectif : **transformer des informations brutes** (verbatims, observations, documents) en **exigences claires, mesurables et traçables** dans le SEL.

<style>
  .details-menu summary { list-style:none; cursor:pointer; font-weight:700; padding:.25rem 0; }
  .details-menu summary::-webkit-details-marker { display:none; }
  .details-menu summary::before { content:"▶"; font-size:.9em; margin-right:.5rem; transition:transform .2s ease; }
  .details-menu[open] summary::before { content:"▼"; }
  .tip { background:#f8f9fb; border:1px solid #e5e7eb; padding:10px 12px; margin:10px 0; }
</style>

### Quelques techniques

<details class="details-menu"><summary>Entretiens (semi-dirigés, 1:1 ou petits groupes)</summary>
<b>Quand</b> : explorer besoins/contraintes, comprendre langage métier.  
<b>Comment</b> : questions ouvertes (“Pouvez-vous me montrer… ?”), reformulation, exemples concrets, éviter le jargon technique.  
</details>

<details class="details-menu"><summary>Observation / shadowing</summary>
<b>Quand</b> : écart “ce qu’on dit” vs “ce qu’on fait”.  
<b>Comment</b> : observer une tâche, parcours actuel (*as-is*), chronométrer, noter exceptions/contournements, irritants mesurés,.  
</details>

<details class="details-menu"><summary>Ateliers collaboratifs (story mapping / event storming)</summary>
<b>Quand</b> : aligner rapidement plusieurs profils.  
<b>Comment</b> : post-its “activités → étapes → détails”, valider le flux bout-à-bout.  
</details>

<details class="details-menu"><summary>Analyse documentaire & contraintes</summary>
<b>Quand</b> : normes, politiques, contrats, conformité.  
<b>Comment</b> : extraire obligations, seuils, exceptions légales.  
</details>

<details class="details-menu"><summary>Questionnaires courts</summary>
<b>Quand</b> : sonder préférences/volumes à large échelle.  
<b>Comment</b> : questions fermées + 1 ouverte, limité à 5-10 min.  
</details>

<details class="details-menu"><summary>Prototypage papier / maquettes rapides</summary>
<b>Quand</b> : valider vocabulaire/flux sans coder.  
<b>Comment</b> : parcours cliquable minimal, tester 3 tâches clés.  
</details>

### Questions utiles 
- **Montrez-moi** comment vous faites aujourd’hui (étapes + outils).  
- **Quand est-ce difficile ?** (exemples récents, fréquence, impact)  
- **Quand est-ce réussi ?** (critères concrets d’un bon résultat)  
- **Que doit éviter le système ?** (risques, erreurs coûteuses)  

<div class="tip"><b>Attention aux biais</b> : éviter les “solutions prémâchées” (“vous voulez un chatbot ?”) ; rechercher d’abord le <i>problème</i>, les <i>règles</i>, les <i>exemples</i>, les <i>seuils mesurables</i>.</div>

{{< figure
    src="/420-310/images/requirements-workflow.png"
    alt="Flux itératif des exigences : analyser le problème, comprendre les besoins, définir le système, gérer le périmètre, affiner, gérer les changements"
    caption="Workflow d’ingénierie des exigences : boucles d’itération & gestion du changement en parallèle"
    width="720"
>}}

<div class="section-title"><h3>Exigences <b>fonctionnelles</b> vs <b>non fonctionnelles</b> </h3></div>
<!-- AJOUTER CONTRAINTES !!!  -->

Les exigences **non fonctionnelles** désignent les attributs de qualité d'un système qui **définissent ses performances plutôt que ses fonctions**. Contrairement aux exigences **fonctionnelles**, qui spécifient les **actions et les tâches qu'un système doit accomplir**, les exigences **non fonctionnelles** se concentrent sur les **caractéristiques globales et le comportement du système dans diverses conditions**. 
<!-- Elles abordent des aspects tels que la performance, la convivialité, la fiabilité et l'évolutivité, garantissant ainsi que le système répond aux normes de qualité et offre une expérience utilisateur satisfaisante. -->

<!-- ajouter les contraintes  -->
{{% tabs %}}

{{% tab title="Exigences fonctionnelles" %}}
### Fonctionnelles — *le quoi*
Ce que le système **fait** (capacités, règles métier, scénarios).  
Elles décrivent les **comportements observables** du point de vue des utilisateurs/systèmes externes.

#### Catégories courantes & exemples
- **Interactions utilisateur** : s’authentifier, créer un compte, rechercher un item, réserver, payer.
- **Règles métier** : calculer des frais, appliquer des politiques, autoriser/refuser selon conditions.
- **Gestion des données** : créer/lire/mettre à jour/supprimer (CRUD), importer/exporter.
- **Intégrations** : envoyer un courriel/SMS, consommer une API tierce, webhooks.
- **Rapports & tableaux de bord** : statistiques, historiques, export CSV/PDF.
- **Administration** : gestion des rôles, configuration de politiques/paramètres.

#### Niveaux de granularité (pour bien structurer)
- **Épic** → **Feature** → **User Story** → **Tâches**
- Alternative/formalisme : **Cas d’utilisation (Use Case)** pour détailler un scénario clé.

<style>
  .granular{margin:16px 0;}
  .granular input[type="radio"]{position:absolute; left:-9999px;}
  .granular .pills{display:flex; flex-wrap:wrap; gap:.5rem; align-items:center; margin-bottom:12px;}
  .granular .pill{
    display:inline-flex; align-items:center; gap:.4rem;
    padding:8px 14px; border:1px solid #e5e7eb; border-radius:999px;
    background:#f8fafc; color:#0f172a; font-weight:600; cursor:pointer; user-select:none;
  }
  .granular .pill:hover{background:#f1f5f9;}
  /* état sélectionné */
  #g-epic:checked ~ .pills label[for="g-epic"],
  #g-feature:checked ~ .pills label[for="g-feature"],
  #g-story:checked ~ .pills label[for="g-story"],
  #g-task:checked ~ .pills label[for="g-task"]{
    background:#eef2ff; border-color:#c7d2fe; color:#1e3a8a;
  }
  .granular .panels{border:1px solid #e5e7eb; border-radius:12px; padding:14px;}
  .granular .panel{display:none;}
  #g-epic:checked ~ .panels #p-epic{display:block;}
  #g-feature:checked ~ .panels #p-feature{display:block;}
  #g-story:checked ~ .panels #p-story{display:block;}
  #g-task:checked ~ .panels #p-task{display:block;}
  .granular h4{margin:.2rem 0 .6rem 0; font-size:1.2rem;}
  .granular p{margin:.2rem 0;}
  /* .dot{font-size:.85em; color:#64748b} */
  .arrow{ color:#9aa0a6; font-weight:700; }
</style>

<div class="granular">
  <input type="radio" name="gran" id="g-epic" checked>
  <input type="radio" name="gran" id="g-feature">
  <input type="radio" name="gran" id="g-story">
  <input type="radio" name="gran" id="g-task">

  <div class="pills">
    <label class="pill" for="g-epic">Épic</label><span class="arrow">→</span>
    <label class="pill" for="g-feature">Feature</label><span class="arrow">→</span>
    <label class="pill" for="g-story">User Story</label><span class="arrow">→</span>
    <label class="pill" for="g-task">Tasks</label>
  </div>

  <div class="panels">
    <div id="p-epic" class="panel">
      <h4>Épic</h4>
      <p>Un <strong>grand objectif métier</strong> couvrant plusieurs itérations (semaines / mois).</p>
      <p><em>Ex.</em> « Gérer le cycle complet <strong>réservation → prêt → retour</strong> des équipements. »</p>
    </div>
    <div id="p-feature" class="panel">
      <h4>Feature</h4>
      <p>Une <strong>capacité métier cohérente</strong> qui apporte de la valeur <em>en soi</em>.</p>
      <p><em>Ex.</em> « <strong>Réservation en ligne</strong> des équipements. »</p>
    </div>
    <div id="p-story" class="panel">
      <h4>User Story</h4>
      <p>Une <strong>petite valeur utilisateur</strong>, livrable en quelques jours, testable via <strong>critères d’acceptation</strong>.</p>
      <p><em>Ex.</em> « En tant qu’<strong>étudiant</strong>, je veux <strong>réserver un appareil photo</strong> afin de <strong>le récupérer demain au comptoir</strong>. »</p>
    </div>
    <div id="p-task" class="panel">
      <h4>Tâches</h4>
      <p>Les <strong>actions techniques</strong> pour réaliser une story (dev, tests, doc, UI…).</p>
      <p><em>Ex.</em> « Créer endpoint <code>POST /reservations</code> », « Valider conflits de créneau », « Formulaire UI + validations ». </p>
    </div>
  </div>
</div>

#### Formats recommandés
**User Story (+ critères d’acceptation)**  
> En tant que **\<acteur>**, je veux **\<capacité>** afin de **\<valeur>**.  
> **critères d’acceptation** (Given/When/Then) : mesurables, observables.

#### Exemples d'exigences fonctionnelles
- « Au paiement, si un article passe en rupture, le système empêche la commande et propose des alternatives. »
- « Après confirmation, le système envoie un courriel avec le récapitulatif et le numéro de suivi. »
- « Un patient peut prendre rendez-vous avec un praticien en choisissant un créneau disponible. »
- « Le système empêche la double réservation d’un même praticien sur un même créneau. »
- « Le système envoie un rappel 24 h avant le rendez-vous par SMS. »
- « Le système génère un PDF de relevé mensuel accessible dans l’espace client. »
- « L’enseignant peut annoter un PDF remis et publier une note avec commentaires. »
- « L’utilisateur peut sélectionner des sièges numérotés ; le système bloque les sièges 10 minutes pendant le paiement. »
  
{{% /tab %}}

{{% tab title="Exigences non fonctionnelles" %}}
### Non fonctionnelles — *le comment/qualités*
Il s'agit des qualités **mesurables** du système et contraintes globales. Elles sont généralement définies par :
- **Performance**: décrit la vitesse à laquelle le système doit fonctionner dans des conditions normales et de pointe, telles que les temps de chargement des pages ou la vitesse de traitement.
- **Évolutivité**: garantit que le système peut gérer la croissance de la demande des utilisateurs ou du volume de données sans perte de performances significative.
- **Convivialité**: l’objectif est de rendre le système intuitif et convivial, en améliorant l’expérience utilisateur grâce à la conception et à l’accessibilité.
- **Fiabilité**: garantit que le système fonctionne de manière cohérente et est disponible en cas de besoin, y compris la disponibilité du système et la tolérance aux erreurs.
- **Sécurité**: spécifie les normes de sécurité, telles que le cryptage des données, les contrôles d'accès et les mesures visant à empêcher l'accès non autorisé ou les violations de données.

#### Exemples d'exigences non fonctionnelles
- **Performance & latence** : p95 < 1,5 s ; p99 < 2,5 s ; ≥ 500 req/s soutenues.
- **Disponibilité & fiabilité** : disponibilité 99,5 %/mois ; MTTR < 30 min ; RTO 30 min / RPO 5 min.
- **Scalabilité & capacité** : tenir 3× la charge nominale par ajout d’instances ; files d’attente < 1 000 msgs.
- **Sécurité** : 2FA pour admin ; chiffrement TLS 1.3 en transit, AES-256 au repos ; correctifs critiques < 7 j.
- **Résilience / tolérance aux pannes** : retries avec backoff ; circuit breaker ; dégradation gracieuse documentée.
- **Maintenabilité & déployabilité** : couverture tests ≥ 80 % ; déploiement < 15 min ; complexité cyclomatique moyenne < 10.
- **Observabilité** : logs structurés (JSON) ; traces distribuées ; 10 métriques clés exposées (latence, erreurs, saturation…).
- **Compatibilité / portabilité** : navigateurs N-2 ; images Docker multi-arch ; OS supportés listés.
- **UX & accessibilité** : conformité WCAG 2.1 AA ; tâche clé en ≤ 3 clics ; focus visible clavier.
- **Conformité & données** : RGPD ; rétention 365 jours ; anonymisation des PII dans les logs.
- **Interopérabilité / API** : contrat OpenAPI versionné ; compat ascendante sur deux versions.
- **Coût / efficience** : coût cloud mensuel ≤ 1 200 $ pour l’environnement prod.
  
#### Comment bien formuler une exigence non fonctionnelle
Structure utile : **[Contexte] + [Métrique] + [Seuil] + [Période/Population] + [Méthode de mesure]**.
> Toujours **quantifier** (+ contexte de test).
  
**Exemple (phrase complète)**  
Lors d’une recherche sur le catalogue de 10 000 articles **aux heures de pointe**, le **95ᵉ percentile** de la **latence serveur** doit être **< 1,5 seconde** **sur une fenêtre glissante de 7 jours**, **mesuré par Prometheus** sur l’endpoint `/search`.

**Autre exemple**
- Vitesse de performance : le système doit traiter les demandes des utilisateurs dans un délai moyen de 2 secondes, même en cas de trafic utilisateur élevé.
- Disponibilité du système : le système doit maintenir une disponibilité de 99.9 % pour garantir aux utilisateurs un accès cohérent.
- Normes de sécurité : le système doit utiliser un cryptage 256 bits pour le stockage des données et se conformer aux réglementations en vigueur en matière de protection des données.

#### Qualité d’une exigence (checklist rapide)
- **Claire** (univoque), **nécessaire**, **testable**, **priorisée**, **traçable**.  
- Éviter les termes vagues : remplacer “rapide”, “sécurisé” par des **seuils mesurables**.  
- 1 exigence = 1 idée ; critères d’acceptation **observables**.
{{% /tab %}}

{{% /tabs %}}

<div class="section-title"><h3>Les contraintes — pense-bête (par catégories)</h3></div>

{{% tabs %}}

{{% tab title="Économiques" %}}

- Contraintes **financières / budgétaires** ?
- Considérations de **tarification** ?
- Problèmes de **licences** (coûts, modèles, limites) ?
{{% /tab %}}

{{% tab title="Politiques" %}}
- **Politiques internes / externes** qui impactent la solution ?
- **Problèmes interdépartementaux** (gouvernance, responsabilités) ?
{{% /tab %}}

{{% tab title="Techniques" %}}
- Choix **technologiques imposés** / **interdits** ?
- **Plateforme** ou **technologie existante** à utiliser ?
- Recours à des **composants logiciels achetés** (COTS) ?
{{% /tab %}}

{{% tab title="Systèmes (existants)" %}}
- La solution existe **déjà partiellement** dans nos systèmes ?
- **Compatibilité** requise avec les solutions en place ?
- **OS / environnements** à supporter ?
{{% /tab %}}

{{% tab title="Environnementales & légales" %}}
- Contraintes **environnementales** ?
- Obligations **légales / réglementaires** ?
- Exigences de **sécurité** (organisationnelles/techniques) ?
- **Standards** à suivre / certifs à obtenir ?
{{% /tab %}}

{{% tab title="Plan & ressources" %}}
- **Échéancier imposé** ?
- **Ressources** (humaines/équipements) **imposées** ?
- Possibilité de **sous-traiter** ?
- Peut-on **ajouter des ressources** (temporairement / en permanence) ?
{{% /tab %}}

{{% /tabs %}}

<style>
  .exercise-box{
    margin:16px 0; padding:14px 16px;
    background:#eef6ff;               
    border:1px solid #c7ddff;         
    border-left:6px solid #3b82f6;   
    border-radius:8px;
  }
  .exercise-box h3{ margin:0 0 8px 0; }
  .exercise-box blockquote{
    margin:8px 0 12px 0; padding:8px 12px;
    background:#ffffff; border-left:4px solid #93c5fd;
  }

  /* Flèche custom pour le menu déroulant */
  .details-menu summary { list-style: none; cursor: pointer; font-weight: 700; padding: .25rem 0; }
  .details-menu summary::-webkit-details-marker { display: none; }
  .details-menu summary::before { content: "▶"; font-size: .9em; margin-right: .5rem; transition: transform .2s ease; }
  .details-menu[open] summary::before { content: "▼"; }
</style>

<div class="exercise-box">
<h3>Exercice — rendre testables des exigences floues</h3>

<blockquote>
<b>Énoncé client</b><br>
« Le client souhaite une application qui soit <b>rapide</b>, <b>facile à utiliser</b>, qui <b>ne tombe jamais en panne</b>, et surtout <b>sécurisée</b>. L’application devra aussi <b>fonctionner sur les navigateurs les plus utilisés</b>. »
</blockquote>

<h4> À faire </h4>
<ul>
  <li>Identifier les <b>exigences mal formulées</b>.</li>
  <li>Reformuler chaque point en une <b>exigence fonctionnelle</b> ou <b>non fonctionnelle</b> <b>claire et testable</b>
      (avec métrique, seuil, contexte et, si pertinent, méthode de mesure).</li>
</ul>

<details class="details-menu">
  <summary>Voir une proposition de correction</summary>
  <ul>
    <li><b>Rapide →</b> « Le <b>temps de réponse</b> ne doit pas dépasser <b>2 secondes</b> pour <b>95 %</b> des requêtes sous une <b>charge de 500 utilisateurs simultanés</b>. »</li>
    <li><b>Facile à utiliser →</b> « L’interface doit respecter les <b>normes WCAG 2.1 niveau AA</b> et proposer une <b>navigation en 3 clics maximum</b> pour accéder aux fonctions principales. »</li>
    <li><b>Ne tombe jamais en panne →</b> « Le système doit garantir une <b>disponibilité de 99,9 %/mois</b>. »</li>
    <li><b>Sécurisée →</b> « Toutes les communications doivent être <b>chiffrées en TLS 1.3</b> et les mots de passe <b>stockés avec bcrypt</b>. »</li>
    <li><b>Navigateurs les plus utilisés →</b> « L’application doit être <b>compatible</b> avec les <b>deux dernières versions</b> de <b>Chrome</b>, <b>Firefox</b> et <b>Safari</b>. »</li>
  </ul>
</details>
</div>


<div class="section-title"><h3>Les composantes principales d’un <b>SEL</b></b> </h3></div>

1. **Méta & version** — titre, auteur·e·s, version, historique des changements. 
2. **Glossaire** — termes métier et acronymes.  
3. **Vision & contexte** — problème, objectifs, parties prenantes.  
4. **Portée (scope)** — **In/Out** + hypothèses et risques majeurs.  
5. **Exigences fonctionnelles** — épics, **user stories** ou **cas d’utilisation** + **critères d’acceptation**.  
6. **Exigences non fonctionnelles** — qualités **mesurées** (perf, sécu, disponibilité, etc.).  
7. **Vues/Modèles** — *Use Case Diagram*, aperçu **UML** (classes/séquence) au besoin.  
8. **Données & interfaces** — objets métier clés, **contrats API** (OpenAPI/GraphQL), formats d’échange.  
9.  **Contraintes & dépendances** — techno imposée, navigateurs cibles, normes, intégrations.  
10. **Traçabilité** — matrice **Exigence ↔ UC/Story ↔ Test d’acceptation**.  

{{% notice style="Activité" %}}
**Lecture guidée en classe — exemple de SEL**  
Nous analyserons ce rapport pour la structure d’un SEL, la formulation F/NF et la traçabilité.  
**Lien** : http://www.info2.uqam.ca/~makarenkov_v/INM5151/sel_ete2015/SEL_Les_AS_Rapport.pdf
{{% /notice %}}

<!-- === Styles locaux pour l'encadré d'exercice + flèche du détail === -->
<style>
  .exercise-box{
    margin:16px 0; padding:14px 16px;
    background:#eef6ff;               /* bleu pâle */
    border:1px solid #c7ddff;         /* contour bleu */
    border-left:6px solid #3b82f6;    /* accent */
    border-radius:8px;
  }
  .exercise-box h3{ margin:0 0 8px 0; }
  .exercise-box h4{ margin:10px 0 6px 0; }
  .exercise-box blockquote{
    margin:8px 0 12px 0; padding:8px 12px;
    background:#ffffff; border-left:4px solid #93c5fd;
  }

  /* Flèche custom pour les menus déroulants */
  .details-menu summary { list-style: none; cursor: pointer; font-weight: 700; padding: .25rem 0; }
  .details-menu summary::-webkit-details-marker { display: none; }
  .details-menu summary::before { content: "▶"; font-size: .9em; margin-right: .5rem; transition: transform .2s ease; }
  .details-menu[open] summary::before { content: "▼"; }
</style>

<div class="exercise-box">
<h3>Exercice — analyse d'un cas et extraction d'informations pertinentes </h3>

<blockquote>
<b>Consigne</b><br>
Téléchargez sur <b>Moodle</b> l’énoncé du cas « <i>Application d’entraide pour la communauté étudiante</i> ».<br>
À partir de la description du cas fourni, vous devez <b>extraire</b> et <b>rédiger</b> une première version du <b>SEL</b> en vous concentrant <b>sur les sections exigées uniquement</b>.
</blockquote>

<h4>À faire</h4>

1. <b>Identifier les parties prenantes</b> (rôles et intérêts). 
   
2. <b>Soutirer les exigences</b> et les <b>classer</b> :  
   - <b>Fonctionnelles (F)</b> — ce que le système fait.  
   - <b>Non fonctionnelles (NF)</b> — qualités mesurables/contraintes globales.  
   - <b>Contraintes (C)</b> — obligations externes (techno, accès, règles).  
3. <b>Rédiger</b> chaque exigence en <b>bonne forme</b> (univoque, testable, traçable).  

<p><i>Les solutions complètes seront discutées en classe (pas de correction révélée ici). </i> </p>
</div>


<!-- ![alt text](image.png) -->


<!-- Exemples TP -->
<!-- « Le membre peut rechercher des équipements par catégorie, mot-clé et disponibilité sur une plage de dates. »

« Le système doit empêcher la double réservation du même équipement sur des créneaux qui se chevauchent. »

« Lors de la confirmation, le système enregistre la réservation avec le statut “Confirmée” et notifie l’utilisateur par courriel. »

« Un employé peut mettre un équipement en maintenance, ce qui le retire automatiquement des créneaux réservables. »

« Un membre peut prolonger un prêt une fois, uniquement si aucune réservation n’existe pour la période suivante. » -->

<!-- Exemple complet (Bibliothèque d’Objets)
Chaîne Épic → Feature → Stories → Tâches
Épic : Cycle Réservation–Prêt–Retour

Feature : Réservation en ligne

Story 1
En tant que membre
je veux chercher un équipement disponible et réserver un créneau
afin de garantir sa disponibilité au comptoir.
Critères d’acceptation (Given/When/Then)

Given un appareil “Caméra A” disponible demain 9–12h
When je sélectionne ce créneau et confirme
Then une réservation avec référence est créée et un courriel de confirmation est envoyé.

Given une collision de créneau
When je tente de réserver
Then le système refuse et propose les créneaux libres adjacents.
Tâches (exemples)

Modèle Reservation (statuts, dates).

API GET /equipements?dispo=…, POST /reservations.

Vérif de conflit côté service + test unitaire.

Page “Résultats + sélection créneau” (UI) + validations.

Story 2 : Prolonger une réservation si aucun conflit.

Story 3 : Annuler une réservation (avant l’échéance).

Feature : Notifications

Story : Courriel de rappel 24 h avant l’échéance (fallback SMS plus tard).

Feature : Gestion des pénalités

Story : Bloquer la création de nouvelles réservations en cas de retard actif.

Variante en Use Case (même besoin)
UC : Réserver un équipement
Acteur principal : Membre
Préconditions : Membre authentifié, équipement existant.
Scénario nominal :

Le membre recherche un type d’équipement.

Le système affiche les créneaux disponibles.

Le membre choisit un créneau et confirme.

Le système crée la réservation, envoie la confirmation.
Alternatif : créneau plus disponible → proposer alternatives.
Exception : quota atteint → refuser avec message explicite.
Postconditions : réservation “Confirmée”, événement de notification planifié. -->


<!-- Exemple calucler la disponibilité sur un an de AWS -->