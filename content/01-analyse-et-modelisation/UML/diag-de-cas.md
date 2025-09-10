+++
pre = '<b>1.2.1 </b>'
title = "Le diagramme de cas d’utilisation"
weight = 1
+++

Un diagramme de cas d’utilisation sert à **recueillir, analyser et organiser les besoins**, en listant les **grandes fonctionnalités** vues par un utilisateur externe. C’est souvent la **première étape d’analyse UML** pour cadrer le système. 

Il **capture le comportement** d’un système (ou sous-système) tel que perçu de l’extérieur et **scinde la fonctionnalité** en *cas d’utilisation* cohérents **ayant du sens pour les acteurs**. 

### Éléments du diagramme

##### Acteur
Un **acteur** est un **rôle** (personne, processus, dispositif) qui **interagit** avec le système. 

Il se représente par un petit bonhomme (*stickman*) avec son nom (figure 1). 
{{< figure src="/420-310/images/actor-stickman.png" caption="Figure 1 — Exemple de représentation d’un acteur"  width="150" >}}
Il est également possible de représenter un acteur sous la forme d’un classeur stéréotypé 
 `«actor»` (figure 2).
{{< figure src="/420-310/images/actor-stereotype.png" caption="Figure 2 — Exemple de représentation d’un acteur sous la forme d’un classeur"  width="180" >}}

##### Cas d’utilisation
Un ***use case*** est une **fonctionnalité observable de bout en bout** (déclenchement → déroulement → fin) qui rend un **service** à l’acteur initiateur. 
Il se représente par une ellipse contenant le nom du cas (un verbe à l’infinitif), et optionnellement, au-dessus du nom, un stéréotype (figure 3).
{{< figure src="/420-310/images/usecase-ellipse.png" caption="Figure 3 — Exemple de représentation d’un cas d’utilisation (ellipse)" width="250" >}}

Il est également possible de le représenter sous la forme d’un classeur stéréotypé  `«use case»` (figure 4), dans le cas où l’on désire présenter les attributs ou les opérations du cas d’utilisation.
> Nous reviendrons sur les notions d’attributs ou d’opération lorsque nous aborderons les diagrammes de classes et d’objets.

{{< figure src="/420-310/images/usecase-stereotype.png" caption="Figure 4 — Exemple de représentation d’un cas d’utilisation sous la forme d’un classeur" width="250" >}}

##### Frontière du système
Le **cadre** du diagramme porte le **nom du système** ; **acteurs à l’extérieur**, **cas d’utilisation à l’intérieur**. 

{{< figure src="/420-310/images/system-boundary.png" caption="Figure 5 — Exemple simplifié de diagramme de cas d’utilisation modélisant une borne d’accès à une banque" >}}

### Les relations

### Association (acteur ↔ cas)
Le chemin de **communication** entre un acteur et un cas : **trait continu**. 

### Acteur **principal** / **secondaire**
Un acteur est qualifié de principal pour un cas d’utilisation lorsque ce cas rend service à cet acteur; il reçoit un **résultat observable**. Un cas d’utilisation a **au plus un** acteur principal. L'acteur secondaire quant à lui, est sollicité pour des informations complémentaires. 

- Le stéréotype  `«primary»` représente l’association reliant un cas d’utilisation à son acteur principal, 
- Le stéréotype `«secondary»` est utilisé pour les acteurs secondaires (figure 6).
  
{{< figure src="/420-310/images/actor-stereotypes.png" caption="Figure 6 — Exemple de diagramme de cas d’utilisation représentant un logiciel de partage de fichiers" >}}

### Les cas d’utilisation **interne**
Il s'agit des cas **non relié** directement à un acteur. 

- **`include`** : A **inclut** B si le comportement de A **dépend** de B. Lorsque A est sollicité, B l’est obligatoirement, comme une partie de A. (figure.7). Utile pour **factoriser** un sous-comportement commun (figure.7), ou décomposer un cas complexe en sous-cas plus simples (figure 8). 
- **`extend`** : A **étend** B lorsque le cas d’utilisation A peut être appelé au cours de l’exécution du cas d’utilisation B (figure 7). Exécuter B peut éventuellement entraîner l’exécution de A, contrairement à l’inclusion, l’extension est **optionnellement**.
  
> Un diagramme de cas d'utilisation **n’a pas de temporalité** : on **n’enchaîne** pas des cas, on **exprime** des capacités. 

{{< figure src="/420-310/images/usecase-relations.png" caption="Figure 7 — Exemple de diagramme de cas d’utilisation avec les différentes relations interne" >}}

{{< figure src="/420-310/images/usecase-decomposition.png" caption="Figure 8 — Exemple de diagramme de cas d’utilisation avec décomposition d'un cas complexe" >}}

### Identifier **les acteurs**
- Lister les **rôles** des utilisateurs (ex. responsable, admin…) et les **systèmes externes** / **périphériques** qui interagissent **directement** avec le système.  
- Se représenter la **frontière** : *dehors = acteurs*, *dedans = fonctionnalités*.  
- Éviter les **faux acteurs** (pas d’interaction directe). 

> Ne pas confondre **acteur** et **utilisateur** : un acteur peut être un **humain**, un **système** ou un **dispositif** ; une **même personne** peut jouer **plusieurs rôles**.

### Recenser **les cas d’utilisation**
L’ensemble des cas d’utilisation doit décrire exhaustivement les exigences fonctionnelles du système.
- Chaque cas = **fonction métier** du point de vue d’un **acteur** ; se demander **pourquoi** l’acteur utilise le système.  
- **Nommer** avec un **verbe à l’infinitif + complément** en vous plaçant du point de vue de l’acteur et non pas de celui du système(Ex.: **“retirer de l’argent”**, pas “distribuer de l’argent”).  
- **Limiter** le nombre, éviter la **décomposition fonctionnelle** trop fine en se situant à un bon niveau d’abstraction. 

### La description textuelle d'un cas 
Le diagramme **ne suffit pas** : rédiger une **fiche** (souple, testable). Le diagramme de cas d’utilisation décrit les grandes fonctions d’un système du point de vue des acteurs, mais n’expose pas de façon détaillée le dialogue entre les acteurs et les cas d’utilisation.
**Gabarit recommandé** :  

<table style="width:100%; border-collapse:collapse; border:1px solid #bbb; font-size:0.98rem;">
  <tr>
    <th style="border:1px solid #bbb; padding:6px; width:22%;">Champ</th>
    <th style="border:1px solid #bbb; padding:6px;">Contenu</th>
  </tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Id / Version</td><td style="border:1px solid #bbb; padding:6px;">UC-XX / v0.1</td></tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Nom</td><td style="border:1px solid #bbb; padding:6px;">&lt;verbe à l’infinitif&gt; (Ex.: se connecter au système)</td></tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Objectif</td><td style="border:1px solid #bbb; padding:6px;">Intention principale du cas (résumé en 1–2 phrases).</td></tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Acteur principal</td><td style="border:1px solid #bbb; padding:6px;">Rôle qui initie le cas et reçoit un résultat observable.</td></tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Acteurs secondaires</td><td style="border:1px solid #bbb; padding:6px;">Rôles informés/assistants (optionnel).</td></tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Préconditions</td><td style="border:1px solid #bbb; padding:6px;">État requis du système avant le déclenchement.</td></tr>
  <tr>
    <td style="border:1px solid #bbb; padding:6px;">Scénario nominal</td>
    <td style="border:1px solid #bbb; padding:6px;">
      1) … 2) … 3) … (échanges acteur ↔ système, 5–9 étapes max).
    </td>
  </tr>
  <tr>
    <td style="border:1px solid #bbb; padding:6px;">Scénarios alternatifs</td>
    <td style="border:1px solid #bbb; padding:6px;">A1) … ; A2) … (variantes métier)</td>
  </tr>
  <tr>
    <td style="border:1px solid #bbb; padding:6px;">Scénarios d’exception</td>
    <td style="border:1px solid #bbb; padding:6px;">E1) … ; E2) … (erreurs / validations)</td>
  </tr>
  <tr><td style="border:1px solid #bbb; padding:6px;">Postconditions</td><td style="border:1px solid #bbb; padding:6px;">État du système après exécution (effets observables à l’issue des différents scénarios).</td></tr>
</table>

---
<!-- Exercice de use case dans rencontre 03 à la fin  : reprendre TP réda -->

<!-- 1 utiolisat 2 rôles : sophie (utilisatrice réelle) peut 
- demander de l’aide en programmation → Acteur : Étudiant·e aidé·e (initie « Demander de l’aide », « Consulter ses rendez-vous ») ;
- offrir de l’aide en maths → Acteur : Tuteur·rice (initie « Offrir son aide », « Déclarer une séance », « Se désinscrire comme tuteur »). -->


<!-- Autres acteurs (exemples)
- Conseiller pédagogique : valide les candidatures de tuteurs, consulte des rapports.
- SSO institutionnel (système externe) : authentifie les usagers.
- Service MIO (système externe) : envoie les notifications. -->

<!-- Faux acteurs (à ne pas modéliser comme acteurs)
- Base de données : interne à l’application (à l’intérieur de la frontière système) → pas un acteur.
- Comité pédagogique : partie prenante qui définit des politiques, mais n’utilise pas directement l’application (aucun cas d’utilisation déclenché).
- Badge “Tuteur” : objet/artefact, pas un rôle qui interagit. 
La paie qui définit cmb de tueurs on à le droit-->

<!-- Parties prenantes ≠ acteurs : si elles n’initient/consomment aucun cas d’utilisation, ne pas les modéliser en acteurs (mais les garder dans la section « parties prenantes » du SEL). -->
<!-- Définition (ISO/IEC/IEEE 42010) : une partie prenante est une personne, équipe ou organisation qui a des préoccupations vis-à-vis du système.
→ Un système en tant qu’objet technique n’a pas de “préoccupations”; ce sont ses propriétaires/opérateurs qui en ont.

En pratique (ingénierie des exigences) : on dit parfois “le système de paiement est une partie prenante” par raccourci, parce qu’il impose des contraintes (interface, sécurité, SLA) et influence le projet. -->

<!-- Mémo “Acteur vs Partie prenante”
Acteur : rôle qui interagit directement avec le système (humain, autre système, dispositif).
Partie prenante : personne/équipe/organisme impacté(e) ou ayant des attentes (peut être sans interaction directe). -->

<!-- décomposition trop fine attention 
Cas d’utilisation listés (trop détaillés, décrivent des étapes UI plutôt qu’un but observable) :

Cliquer sur « Ajouter au panier »
Saisir quantité
Retirer un article du panier
Saisir code promo
Valider le panier
Saisir adresse de livraison
Choisir mode de livraison
Saisir adresse de facturation
Saisir numéro de carte
Confirmer la commande
Recevoir courriel de confirmation
Télécharger la facture PDF

Problème : ces “UC” sont des interactions fines (clics/champs) ou des effets internes ; ils fragmentent un même objectif métier (“Acheter un produit”). Le diagramme devient verbeux, difficile à lire et à tester. -->