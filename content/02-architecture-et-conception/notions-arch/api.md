+++
pre = '<b>2.2 </b>'
title = "API REST"
weight = 2
draft = false 
+++

Au sein d'une organisation **N-tiers**, l’API **REST** fait office de **frontière** entre les tiers : le ***frontend*** dialogue avec le ***backend*** au moyen d’URL, de verbes HTTP et de codes de statut, tandis que l’intérieur du *backend* reste structuré en **MVC** (contrôleur qui reçoit la requête, service qui porte la logique, repository qui accède aux données). 

En contexte **monolithique**, les couches de l’application communiquent surtout **en interne** par appels de méthodes, mais l’API REST demeure le **contrat** exposé vers l’extérieur (applications web ou mobiles, intégrations). On garde la même discipline **MVC** à l’intérieur du monolithe pour préserver la clarté du code et préparer d’éventuelles évolutions. En architecture **microservices**, chaque service expose sa propre API (souvent REST) et peut aussi échanger par événements ; chacun conserve son mini-MVC en interne.
 On conserve la même discipline MVC pour garder un code clair et préparer d’éventuelles évolutions. En architecture microservices, chaque service expose sa propre API (souvent REST) et peut aussi échanger par événements ; chacun conserve son mini-MVC en interne.

### Qu’est-ce qu’une API ?
Une **API** est un **contrat d’échange** : un ensemble de **endpoints/fonctions**, leurs **signatures**, et **règles d’usage** pour obtenir un résultat. Le but est de **séparer** les responsabilités client/serveur afin d’améliorer **portabilité** et **évolutivité** (le client peut évoluer sans casser le serveur, et inversement).

### REST vs SOAP
Il existe actuellement deux types d’architecture très utilisée pour les APIs : 
- Simple Object Access Protocol (SOAP) 
- Representational State Transfer (REST).

| Critère | **REST** | **SOAP** |
|---|---|---|
| Nature | **Style** architectural | **Protocole** formel |
| Transport | HTTP (principalement), simple | HTTP, mais enveloppe **XML** stricte |
| Format des messages | JSON (souvent), possible XML | **XML** obligatoire |
| Contrats | Souvent via **OpenAPI** (Swagger) | **WSDL** (contrat formel) |
| Cas d’usage | Web/Mobile, microservices, APIs publiques | Intégrations **entreprises** formelles, exigences WS-* (sécurité avancée, transactions) |
| Courbe d’apprentissage | Faible / moyenne | Plus **élevée** |
| Souplesse | **Haute** | Plus **rigide** |

**En bref :** REST privilégie la **simplicité** et l’usage naturel d’HTTP ; SOAP apporte un **cadre très formel** utile quand on a besoin de standards WS-* et de contrats XML stricts.

### Les bases de **REST**
Le principe **stateless**
- Le serveur **ne mémorise pas** de contexte entre deux appels.  
- **Chaque requête** contient tout le nécessaire (auth, paramètres, corps).  
- Avantage : **scalabilité** (répartition sur plusieurs serveurs sans affinité).

**Verbes HTTP et CRUD**
| Méthode | CRUD | Action |
|---|---|---|
| **GET** | Read | Récupérer des données demandées|
| **POST** | Create | Créer une ressource / un enregistrement|
| **PUT / PATCH** | Update | Modifier (PUT = remplacement complet, PATCH = partiel) |
| **DELETE** | Delete | Supprimer un enregistrement existant |

**Exemples (équipements)**
- `GET /api/equipements` → liste paginée  
- `GET /api/equipements/{id}` → détail  
- `POST /api/equipements` → créer  
- `PATCH /api/equipements/{id}` → modifier partiellement  
- `DELETE /api/equipements/{id}` → supprimer

**Les codes de statut HTTP (réponses)**
| Code | Signification |
|---:|---|
| **200 OK** | Requête réussie : tout s'est bien passé|
| **201 Created** | Ressource créée (**Location** avec l’URL): les attributs de la nouvelle ressource sont aussi renvoyés dans la réponse (l’URL de cette ressource nouvellement créée est ajoutée via un header Location)|
| **204 No Content** | Succès sans corps (delete/update) : même principe que pour la 201, mais cette fois-ci, le contenu de la ressource nouvellement créée ou modifiée n'est pas renvoyé en réponse|
| **304 Not Modified** | Rien de nouveau vs cache : le contenu n'a pas été modifié depuis la dernière fois qu'elle a été mise en cache|
| **400 Bad Request** | Requête invalide : la demande n'a pas pu être traitée correctement |
| **401 Unauthorized** | Authentification requise/échouée / l'authentification a échoué|
| **403 Forbidden** | Non autorisé : l'accès à cette ressource n'est pas autorisé |
| **404 Not Found** | Introuvable : la ressource n'existe pas|
| **500 Server Error** | Erreur serveur : le serveur a rencontré un problème |

<!-- 
| Code | Définition |
|---:|---|
| **200 OK** | Tout s’est bien passé. |
| **201 Created** | Ressource **créée**. Souvent on renvoie la ressource en réponse et on place son URL dans l’en-tête **`Location`**. |
| **204 No Content** | Succès **sans corps** de réponse (ex. suppression, mise à jour sans retour). |
| **304 Not Modified** | Rien n’a changé depuis la version mise en cache côté client. |
| **400 Bad Request** | Requête invalide (format, champs manquants). |
| **401 Unauthorized** | Authentification requise/échouée. |
| **403 Forbidden** | Authentifié, mais **pas autorisé**. |
| **404 Not Found** | Ressource inexistante. |
| **500 Server Error** | Erreur interne côté serveur. | -->

<!-- **Quelques bonnes pratiques rapides**
- Les ressources **au pluriel** : `/api/reservations`, `/api/equipements`.  
- **Filtres** en query string : `?categorie=camera&disponible=true`.  
- **JSON** cohérent + **validations** claires.  
- Avoir une **pagination** : `?page=1&size=20` + métadonnées (`total`, `pages`).  
- **Versioning** si besoin : `/api/v1/...`.  
- Assurer la **sécurité** : `Authorization: Bearer <JWT>`. -->

--- 

<!-- > **À suivre dans la page MVC + Spring Boot :** mise en place concrète d’un **Contrôleur REST**, passage par un **Service** métier, et persistance via un **Repository JPA** (avec codes 200/201/204/404 bien utilisés). -->