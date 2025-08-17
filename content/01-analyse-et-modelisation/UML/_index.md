+++
pre = '<b>1.2 </b>'
title = "UML"
weight = 2
+++

UML (Unified Modeling Language) est un langage de modélisation graphique conçu comme une méthode normalisée de visualisation pour le développement logiciel et la conception orientée objet. En pratique, UML sert de langage visuel commun pour exprimer besoins, interactions et structure d’un système logiciel et son environnement.

UML propose une multitude de diagrammes. On distingue souvent :

- Les diagrammes structurels : classes, objets, composants, structure composite, déploiement, paquetages…
- Les diagrammes comportementaux : cas d’utilisation, séquence, communication, activité, états (state machine), temporisation…

L’accent sera mis, dans le présent module, sur l’essentiel pour passer du besoin au modèle :
1. **[Le diagramme de cas d’utilisation]({{< relref "diag-de-cas.md" >}})**: identifier acteurs & cas, formuler un use case clair (objectif, pré/postconditions, scénario nominal/alternatifs).
2. **[Le diagramme de séquence système (SSD)]({{< relref "dss.md" >}})** (+ aperçu des séquences détaillées) : extraire les événements système (acteur → : système), nommer les opérations et comprendre messages/variantes (alt/opt).
3. **[Le diagramme de classes]({{< relref "diag-de-classes.md" >}})** (modèle de domaine) : poser les concepts, attributs, associations avec multiplicités, héritage, agrégation/composition.