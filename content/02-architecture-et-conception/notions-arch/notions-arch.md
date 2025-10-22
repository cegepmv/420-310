+++
pre = '<b>2.1 </b>'
title = "Notions d’architecture logicielle"
weight = 1
draft = false 
+++

Les architectures logicielles courantes comprennent les **architectures monolithiques**, les **microservices**, les **architectures en couches**, **orientées événements**, **client-serveur** et les **architectures orientées services (SOA)**. Le choix dépend des besoins du projet, tels que la complexité, l'évolutivité et le temps de réponse souhaité. 

À travers ce module, nous passerons en revue quelques **styles d’architecture logicielle** (n-tiers, microservices, etc.) afin d’apprendre à **les distinguer**, à comprendre leurs **forces et limites**, et à reconnaître les contextes dans lesquels chacun excelle. Nous verrons aussi comment planifier une migration progressive (ex.: monolithe → monolithe modulaire → microservices), en minimisant les risques et en maximisant la valeur pour le projet et l’équipe.

### N-tiers / en couches (layered)
N-tiers est un style structurant (équivaut à “en couches / *layered*”) : on parle d’organisation logique et parfois de tiers déployés séparément.

L'idée est d'organiser le système par **responsabilités** bien séparées, typiquement **UI → métier → accès aux données**, avec la possibilité de déployer ces couches soit **ensemble** (même artefact), soit en **tiers** distincts (2-tiers, 3-tiers, n-tiers).

---

### L'architecture monolithe (classique)
L’application est déployée en **un seul artefact** (processus/binaire) : toutes les couches (UI, logique métier, accès données) vivent dans le même déploiement et la même base de code.

**Avantages**
- déploiement **très simple**, onboarding rapide
- **performances** intra-processus (appels en mémoire).
- outil idéal pour **MVP**, petites équipes, time-to-market.

**Inconvénients**
- **couplage fort** : évolution risquée, effets de bord.
- **build/deploy** plus lourds à mesure que l’application grossit.
- **scalabilité** globale (on scale tout, pas seulement le goulot).

**Quand l’utiliser ?**
On choisit une architecture monolithique surtout au **démarrage d’un produit**, quand il faut livrer vite avec des **contraintes de temps et de budget**. Elle convient bien à un **domaine peu complexe**, avec une charge modérée et des **besoins qui évoluent peu** au début. En bref, c’est un bon **point de départ simple** avant d’envisager une structure plus découpée.

{{< figure
    src="/420-310/images/monolith_tamara.webp"
    alt="Monolithe, monolithe modulaire et monolithe modulaire distribué"
    title="Monolithe vs monolithe modulaire vs monolithe modulaire distribué"
    attr="Chien @ Tamara Tech"
    attrlink="https://tech.tamara.co/monolith-architecture-5f00270f384e"
    class="rounded shadow"
>}}

---

### L'architecture en microservices
L’application est répartie en **services indépendants**, chacun avec **son propre déploiement** et souvent **sa propre base de données**. Chaque service couvre un **domaine fonctionnel** (ex. *Catalogue*, *Commande*, *Paiement*) et communique avec les autres via des **APIs** (HTTP/gRPC) ou des **événements** (pub/sub).

**Avantages**
- **scalabilité fine** : on augmente les ressources uniquement pour le service qui en a besoin
- **autonomie d’équipe** : chaque équipe déploie son service sans bloquer les autres
- **résilience** : une panne reste **circonscrite** à un service au lieu d’arrêter tout le système

**Inconvénients**
- **complexité opérationnelle** plus élevée (CI/CD, observabilité, réseau)
- **cohérence des données** plus difficile entre services (transactions distribuées)
- **coûts** d’infrastructure et de gouvernance (gateway, traçage, sécurité)

**Quand l’utiliser ?**  
On retient les microservices quand l’application devient **grande et très utilisée**, que l’organisation compte **plusieurs équipes** qui doivent avancer en parallèle, et que l’on vise une **forte disponibilité** avec des **déploiements fréquents**. C’est un bon choix si les **frontières de domaine** sont claires et stables (ex. DDD) et si l’équipe dispose d’une **maturité DevOps/Cloud** suffisante pour gérer la plateforme et l’observabilité.

<!-- **Bonnes pratiques**
- Définir des **frontières fonctionnelles** claires (bounded contexts) et des **contrats d’API** stables.
- Préférer la **communication asynchrone** (événements) quand c’est possible ; utiliser des **sagas/outbox** pour la cohérence.
- Mettre en place **observabilité** et **automatisation** (logs corrélés, métriques, traces, CI/CD) **avant** de multiplier les services.
- Éviter les **nanoservices** (services trop petits) qui coûtent cher pour peu de valeur. -->
