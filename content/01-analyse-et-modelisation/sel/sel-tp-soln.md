<!-- ---
title: "SEL — Bibliothèque d’Objets du Cégep"
version: "0.1"
status: "Draft"
date: "2025-08-09"
auteurs: ["Équipe ___"]
---

# Page de garde
- Cours/projet : 420-310-MV — Architecture de logiciel  
- Cliente : Bibliothécaire en chef (jeu de rôles par l’enseignante)  
- Références : WCAG 2.1 AA, SSO institutionnel (à confirmer), politiques internes TI  
- Dépôt : (lien à insérer)

## Historique des changements
| Version | Date       | Auteur     | Description                 |
|--------:|------------|------------|-----------------------------|
| 0.1     | 2025-08-09 | Équipe ___ | Ébauche initiale (verbatim) |

---

# 1. Introduction

## 1.1 Objectifs du document
Décrire **ce que** doit faire la future application de **Bibliothèque d’Objets** et **dans quelles conditions**, afin d’aligner les parties prenantes et de préparer la conception, les tests d’acceptation et la mise en œuvre. Le document cible la cliente, l’équipe de dev/QA/ops et le corps enseignant.

## 1.2 Portée
**Nom** : BiblioObjets (nom de travail)  
**But** : gérer **réservation → prêt → retour** d’équipements (portables, caméras, trépieds, kits Arduino, micros), la **maintenance**, les **notifications** et un **tableau de bord** d’usage.  
**In (v1)** :
- Réservation et calendrier de disponibilité par **catégorie** / **règles** (ex. caméras 48 h max)  
- Prêt/retour **au comptoir** via **scan code-barres** (kiosque)  
- Prolongation si non réservé par autrui  
- Notifications (courriel; SMS **optionnel**)  
- Mise en **maintenance** (bloque les réservations) + note/photo  
- Import **CSV** d’inventaire (cleanup minimal)  
- Tableau de bord : emprunts/rotation, objets en maintenance, historiques
**Out (v1)** :
- Paiement en ligne des pénalités (reporté)  
- Applis mobiles natives (web responsive uniquement)  
- Reco “IA” / suggestions avancées  
**Contexte** : application **web** responsive, poste **kiosque** au comptoir, pics d’usage **semaines 1–3** et avant certains cours.

## 1.3 Définitions, acronymes et abréviations
- **SEL** : Spécification des Exigences Logicielles  
- **NFR** : exigences non fonctionnelles (qualités mesurables)  
- **SSO** : authentification unique institutionnelle  
- **WCAG 2.1 AA** : norme d’accessibilité web  
- **Kiosque** : poste de comptoir avec lecteur **code-barres**  
- **RTO/RPO** : objectifs de reprise (temps/point)

---

# 2. Description générale

## 2.1 Vue d’ensemble des fonctions
- **Chercher / réserver** un équipement selon disponibilité et règles de catégorie  
- **Prêter / retourner** rapidement via **scan** (tolérance brèves pannes réseau)  
- **Prolonger** un prêt si possible  
- **Notifier** (confirmation, rappel d’échéance, retards)  
- Gérer **maintenance** (blocage réservation + journal d’intervention, photo)  
- **Importer** et maintenir l’inventaire (codes-barres)  
- **Tableau de bord** (usage, rotation, maintenance, historiques)

## 2.2 Parties prenantes & utilisateurs (rôles pressentis)
- Emprunteur (membre de la communauté) • Personnel de comptoir • Gestion/administration • Maintenance/tech • (occasionnellement) bénévoles  
*(Les équipes préciseront les personae lors de l’analyse.)*

## 2.3 Contraintes
- **SSO** institutionnel si disponible (éviter mots de passe locaux)  
- **Tolérance aux pannes réseau courtes** au kiosque (queue locale + sync)  
- **Accessibilité** : **WCAG 2.1 AA** sur écrans publics  
- **Bilingue** FR/EN (priorité FR en v1)  
- **Simplicité & coût** : démarrage sans abonnement coûteux; hébergement aligné aux pratiques TI actuelles  
- **Confidentialité** : journaux sobres (éviter données perso inutiles), **journalisation des opérations sensibles**, sauvegardes régulières  
- **Performance comptoir** : objectif **≥ 5 scans/sec** cumulés en rush (ou cible révisée et mesurable)

---

# 3. Exigences

## 3.1 Exigences **fonctionnelles** (User stories / Use cases)
**F-01** Réservation d’un équipement avec **calendrier** et règles par **catégorie**  
**F-02** Confirmation par **courriel** lors d’une réservation  
**F-03** **Prêt** au comptoir par **scan** (équipement + identité)  
**F-04** **Retour** par scan, avec détection **retard** et application de politique  
**F-05** **Prolongation** d’un prêt si pas de réservation subséquente  
**F-06** Mise en **maintenance** d’un item (blocage réservation + note/photo)  
**F-07** **Notifications** automatiques : rappel d’échéance, avis de retard (courriel; SMS optionnel)  
**F-08** **Import** d’inventaire (CSV) + mise à jour codes-barres  
**F-09** **Tableau de bord** (emprunts, rotation, maintenance, historiques)  
**F-10** **Gestion de politiques** (durées max, blocages, pénalités) **paramétrables**  
**F-11** **Accès** via **SSO** (rôles : comptoir, gestion, maintenance, emprunteur)  
**F-12** **Journalisation** des opérations sensibles (qui/quoi/quand)

### Critères d’acceptation (exemples)
- **F-01 Réserver**  
  *Given* un item disponible sur la plage X, *When* je confirme la réservation, *Then* je reçois un **courriel** de confirmation et le **calendrier** est mis à jour sans double réservation.  
- **F-03 Prêter (scan)**  
  *Given* un item éligible et un identifiant valide, *When* je **scanne** l’item et l’identifiant, *Then* le prêt est **enregistré en < 200 ms** localement et **synchronisé** dès que le réseau est rétabli.

## 3.2 Exigences **non fonctionnelles** (NFR)
| Catégorie | Exigence mesurable |
|---|---|
| **Performance (kiosque)** | Débit de **≥ 5 scans/sec** cumulés pendant **10 min** aux heures de pointe; en cas d’objectif jugé irréaliste, proposer une **cible révisée** documentée. |
| **Latence (réservation)** | p95 **< 1,5 s** pour créer/annuler une réservation (10k items) aux heures de pointe. |
| **Disponibilité** | **99,5 %/mois** ; sauvegardes quotidiennes ; restauration testée mensuellement. |
| **Résilience** | Kiosque **offline-tolerant** jusqu’à **5 min** : mise en file locale + **rejeu** ordonné. |
| **Sécurité** | **SSO** pour rôles étendus; **TLS 1.3**; journaux sans PII inutile; journalisation des actions sensibles. |
| **Accessibilité** | **WCAG 2.1 AA** pour les écrans publics et formulaires essentiels. |
| **Observabilité** | **Logs structurés**, métriques (latence, erreurs, débit scan), traces des flux prêt/retour. |
| **Internationalisation** | **FR/EN** avec détection langue navigateur; éléments non traduits tolérés en v1. |
| **Compatibilité** | Navigateurs **N-2**; kiosque plein écran; lecteur **code-barres HID**. |
| **Paramétrabilité** | Politiques (durées, pénalités, blocages) modifiables **sans redéploiement**. |

**Exemple (phrase complète)** — *Au poste kiosque principal, le débit de scan cumulé doit atteindre **≥ 5 scans/seconde** pendant au moins **10 minutes consécutives** durant les heures de pointe, mesuré via métriques locales et corrélé aux logs serveur.*

---

# 4. Modèles et vues (aperçu)
- **Use Case Diagram** (acteurs ↔ cas) — à produire par l’équipe  
- (Optionnel) **Séquence** pour “Prêter par scan” et “Réserver”  
- **Données** (brouillon) : Équipement, Catégorie, Réservation, Prêt, Utilisateur, Pénalité, Maintenance

---

# 5. Conception détaillée (cadrage bref)

## 5.1 Interfaces externes (UI / API)
- UI web responsive (recherche, calendrier, prêt/retour, maintenance, tableau de bord); **mode kiosque** (plein écran; gros boutons scan).  
- API (à définir) pour réservations/ prêts/ retours/ maintenance/ import; Webhooks **optionnels** pour notifications.

## 5.2 Données (préliminaire)
- Clés : `Equipement(id, code_barres, categorie, etat, …)`, `Reservation(id, equipement_id, du, au, statut)`, `Pret(id, equipement_id, utilisateur_id, date_debut, date_retour_prevu, date_retour, retard, …)`, `Maintenance(id, equipement_id, motif, photo_url, du, au)`…  
- **Contraintes** : unicité code-barres; intégrité réservation ↔ prêt; historisation minimale.

## 5.3 Stratégie de tests
- Tests **unitaires** (règles de durée/éligibilité), **intégration** (scan/prêt/retour), **acceptation** (critères Given/When/Then).  
- Tests **perf** (kiosque, réservation), tests **offline** (file + resync), **accessibilité** (WCAG).

## 5.4 Architecture applicative (esquisse)
- **Web app** + **service API** ; stockage **BD** relationnelle; file locale au kiosque + **queue** (resync) ; e-mail (SMTP/transactionnel), **SMS (optionnel)**.

---

# 6. Exigences détaillées — Cas d’utilisation

## UC-01 — **Réserver un équipement**
| Champ | Contenu |
|---|---|
| **Objectif** | Assurer la disponibilité d’un équipement sur une plage horaire conforme aux règles. |
| **Acteur principal** | Membre de la communauté |
| **Acteurs secondaires** | — |
| **Préconditions** | Équipement réservable; créneau disponible; authentification valide. |
| **Scénario nominal** | 1) Rechercher un équipement 2) Choisir un créneau valide 3) Confirmer 4) Réception du courriel de confirmation 5) Calendrier mis à jour. |
| **Alternatifs** | A1) Créneau devenu indisponible → proposition de créneaux proches. |
| **Exceptions** | E1) Règle de catégorie violée (durée max) → message explicite. |
| **Postconditions** | Réservation **active** et traçable; notification envoyée. |
| **Notes** | NFR latence p95 < 1,5 s; emails délivrés; journaliser l’opération. |

## UC-02 — **Prêter un équipement (scan kiosque)**
| Champ | Contenu |
|---|---|
| **Objectif** | Enregistrer un prêt **très rapidement**, même en panne réseau brève. |
| **Acteur principal** | Opérateur de comptoir |
| **Acteurs secondaires** | — |
| **Préconditions** | Équipement prêtable; identité valide; permissions adéquates. |
| **Scénario nominal** | 1) Scanner l’équipement 2) Scanner l’identité 3) Validation 4) Enregistrement **local** immédiat (< 200 ms) 5) **Synchronisation** automatique. |
| **Alternatifs** | A1) Réservation prioritaire détectée → avertir/empêcher prêt. |
| **Exceptions** | E1) Lecteur non reconnu → saisie manuelle/code fallback. |
| **Postconditions** | Prêt actif; horodatage; prêt visible au tableau de bord. |
| **Notes** | NFR débit ≥ 5 scans/s; offline-tolerant 5 min; journaliser. |

## UC-03 — **Retourner un équipement** *(bref)*  
## UC-04 — **Prolonger un prêt** *(bref)*  
## UC-05 — **Mettre en maintenance** *(bref)*  
## UC-06 — **Configurer les politiques** *(bref)*  
*(Renseigner selon le même canevas que UC-01/02.)*

---

# 7. Traçabilité (v0)
| Exigence | UC/Story | Critères d’acceptation | Test(s) | Composant |
|---|---|---|---|---|
| F-01 | UC-01 | CA-R1/CA-R2 | AT-R-001 | Réservations |
| F-03 | UC-02 | CA-P1/CA-P2 | AT-P-001 | Kiosque/Prêts |
| F-06 | UC-05 | CA-M1 | AT-M-001 | Maintenance |
| NFR-Perf-K | UC-02 | — | PERF-K-001 | Kiosque |
| NFR-Acc-Web | — | — | A11Y-001 | UI Web |

---

# 8. Acceptation & données de test
- **Jeux d’essai** : 50 équipements (5 catégories), 100 utilisateurs, 200 réservations factices.  
- **Done** (extraits) :  
  - Réservation bloque double-booking; e-mail délivré  
  - Scan prêt/retour enregistre et synchronise; latence et débit conformes  
  - Maintenance bloque réservation; note/photo visible

# 9. Gestion du changement
- Proposer les modifications via **PR** (docs/sel/SEL-v0x.md), indiquer impact, approbation par la cliente (enseignante).

# 10. Annexes
- Glossaire étendu, diagrammes UML exportés (PNG/PDF), captures d’écrans (maquettes éventuelles). -->
