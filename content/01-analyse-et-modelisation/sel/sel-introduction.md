+++
pre = '<b>1.1 </b>'
title = "S.E.L"
weight = 1
+++

# spécifications des exigences logicielles

La **Spécification des Exigences Logicielles** (SEL) décrit **ce que** le système doit faire et **dans quelles conditions** il doit le faire.  
Elle sert de contrat **vérifiable** entre parties prenantes (métier, dev, QA, ops), encadre la **conception** et facilite les **tests d’acceptation**.

> Objectif : transformer un besoin flou en exigences **claires, mesurables et traçables**.

![Tree swing](/420-310/images/tree_swing.jpg)

L’image classique du **“tree swing”** illustre les malentendus possibles entre client, analyste, dev et test : chacun imagine une solution différente au même besoin, d’où l’importance d’un **SEL précis**.

## Exigences **fonctionnelles** vs **non fonctionnelles** 
Les exigences non fonctionnelles désignent les attributs de qualité d'un système qui définissent ses performances plutôt que ses fonctions. Contrairement aux exigences fonctionnelles, qui spécifient les actions et les tâches qu'un système doit accomplir, les exigences non fonctionnelles se concentrent sur les caractéristiques globales et le comportement du système dans diverses conditions. Elles abordent des aspects tels que la performance, la convivialité, la fiabilité et l'évolutivité, garantissant ainsi que le système répond aux normes de qualité et offre une expérience utilisateur satisfaisante.

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

#### Formats recommandés
**User Story (+ Critères d’acceptation)**  
> En tant que **\<acteur>**, je veux **\<capacité>** afin de **\<valeur>**.  
> **Critères d’acceptation** (Given/When/Then) : mesurables, observables.

- 
##### Exemples d'exigences fonctionnelles

### Non fonctionnelles — *le comment/qualités*
Il s'agit des qualités **mesurables** du système et contraintes globales. Elles sont généralement définies par :
- **Performance**: décrit la vitesse à laquelle le système doit fonctionner dans des conditions normales et de pointe, telles que les temps de chargement des pages ou la vitesse de traitement.
- **Évolutivité**: garantit que le système peut gérer la croissance de la demande des utilisateurs ou du volume de données sans perte de performances significative.
- **Convivialité**: l’objectif est de rendre le système intuitif et convivial, en améliorant l’expérience utilisateur grâce à la conception et à l’accessibilité.
- **Fiabilité**: garantit que le système fonctionne de manière cohérente et est disponible en cas de besoin, y compris la disponibilité du système et la tolérance aux erreurs.
- **Sécurité**: spécifie les normes de sécurité, telles que le cryptage des données, les contrôles d'accès et les mesures visant à empêcher l'accès non autorisé ou les violations de données.

##### Exemples d'exigences non fonctionnelles
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
  
###### Comment bien formuler une exigence non fonctionnelle
Structure utile : **[Contexte] + [Métrique] + [Seuil] + [Période/Population] + [Méthode de mesure]**.
- Toujours **quantifier** (+ contexte de test).
- 
**Exemple (phrase complète)**  
Lors d’une recherche sur le catalogue de 10 000 articles **aux heures de pointe**, le **95ᵉ percentile** de la **latence serveur** doit être **< 1,5 seconde** **sur une fenêtre glissante de 7 jours**, **mesuré par Prometheus** sur l’endpoint `/search`.

**Autre exemple**
- Vitesse de performance : le système doit traiter les demandes des utilisateurs dans un délai moyen de 2 secondes, même en cas de trafic utilisateur élevé.
- Disponibilité du système : le système doit maintenir une disponibilité de 99.9 % pour garantir aux utilisateurs un accès cohérent.
- Normes de sécurité : le système doit utiliser un cryptage 256 bits pour le stockage des données et se conformer aux réglementations en vigueur en matière de protection des données.

##### Qualité d’une exigence (checklist rapide)
- **Claire** (univoque), **nécessaire**, **testable**, **priorisée**, **traçable**.  
- Éviter les termes vagues : remplacer “rapide”, “sécurisé” par des **seuils mesurables**.  
- 1 exigence = 1 idée ; critères d’acceptation **observables**.
## Les cmposantes principales d’un **SEL**
1. **Méta & version** — titre, auteur·e·s, version, historique des changements.  
2. **Vision & contexte** — problème, objectifs, parties prenantes.  
3. **Portée (scope)** — **In/Out** + hypothèses et risques majeurs.  
4. **Glossaire** — termes métier et acronymes.  
5. **Exigences fonctionnelles** — épics, **user stories** ou **cas d’utilisation** + **critères d’acceptation**.  
6. **Exigences non fonctionnelles** — qualités **mesurées** (perf, sécu, disponibilité, etc.).  
7. **Vues/Modèles** — *Use Case Diagram*, aperçu **UML** (classes/séquence) au besoin.  
8. **Données & interfaces** — objets métier clés, **contrats API** (OpenAPI/GraphQL), formats d’échange.  
9. **Contraintes & dépendances** — techno imposée, navigateurs cibles, normes, intégrations.  
10. **Traçabilité** — matrice **Exigence ↔ UC/Story ↔ Test d’acceptation**.  
11. **Validation & acceptation** — plan de tests d’acceptation, données de test, critères “Done”.  
12. **Gestion du changement** — processus de modification (PR), numérotation, ADR liés.

{{% notice style="Activité" %}}
**Lecture guidée en classe — exemple de SEL**  
Nous analyserons ce rapport pour la structure d’un SEL, la formulation F/NF et la traçabilité.  
**Lien** : http://www.info2.uqam.ca/~makarenkov_v/INM5151/sel_ete2015/SEL_Les_AS_Rapport.pdf
{{% /notice %}}


<!-- ![alt text](image.png) -->