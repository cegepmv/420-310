## Atelier — rédiger votre premier SEL (V0)

### La bibliothèque d’objets du cégep
Le cégep veut une plateforme permettant aux étudiant·e·s et au personnel d’**emprunter des équipements** (portables, caméras, kits Arduino/Raspberry Pi, trépieds, micros). L’application doit gérer **réservation → prêt → retour**, les **pénalités** (retard, bris), la **maintenance** et les **notifications**. 

L'atelier suivant débutera par l'analyse la première rencontre avec votre « cliente ». La personne responsable du contact client (vendeur) revient d’une rencontre de cadrage avec la bibliothécaire en chef et vous remet le verbatim. À partir de ce verbatim, vous devez amorcer la rédaction d’un SEL V0. 

> **En classe** — pendant l’atelier, **l’enseignante jouera le rôle de la cliente** (bibliothécaire en chef). 

### Verbatim de la rencontre
Vendeur : Bonjour, merci de nous recevoir. On a entendu parler de votre projet de Bibliothèque d’Objets — prêt d’équipements (portables, caméras, trépieds, kits Arduino, micros…). Vous pouvez nous dire où vous en êtes ?

Cliente (Bibliothécaire en chef) : Oui. On prête déjà des objets, mais tout est manuel : tableur + étiquettes. On voudrait une application pour réserver, prêter, retourner, suivre l’état et envoyer des notifications. On espère commencer avec le web (desktop/mobile). Un kiosque au comptoir avec lecteur de code-barres serait idéal.

Vendeur : D’accord. Comment se passe une journée “typique” ?

Cliente : En début de session, c’est la cohue. Les gens font la queue, on coche les emprunts dans un fichier Excel, on scan les codes-barres quand ça marche, sinon on tape à la main. On doit vérifier si l’objet est réservé. Les retards et bris sont notés… parfois.

Vendeur : Vous avez parlé de réservations. Qui peut réserver ? Combien de temps à l’avance ?

Cliente : Les membres de la communauté du cégep (enseignants, étudiants, autre membre du personnel). Parfois on doit limiter la durée selon la catégorie (ex. caméras max 48 h). J’aimerais un calendrier de disponibilité et des règles par type d’objet. Pour prolonger, c’est permis si personne n’a réservé derrière.

Vendeur : Et côté notifications ?

Cliente : Un courriel à la réservation et un rappel avant l’échéance. Pour les retards, un message automatique serait utile. On aimerait aussi un SMS, mais ce n’est pas obligatoire au départ.

Vendeur : Vous avez des pics d’utilisation ?

Cliente : Oui : semaines 1–3 de la session et juste avant certains cours. On aimerait savoir combien d’objets sont dehors, et voir en direct si un type d’objet est épuisé.

Vendeur : Parlons contrôle au comptoir.

Cliente : Il faut que le scan soit très rapide. Quand il y a du monde, l’app doit tenir même si le réseau décroche quelques minutes : on voudrait enregistrer les scans et synchroniser après.

Vendeur : Vous avez des règles pour les pénalités ?

Cliente : Oui, mais elles changent. L’important, c’est de configurer les politiques (amendes, blocage, délais). On ne veut pas coder les règles en dur.

Vendeur : Des rapports ?

Cliente : Un tableau de bord simple : emprunts par catégorie, taux de rotation, objets en maintenance, historique par utilisateur/objet, et un résumé mensuel.

Vendeur : À propos de maintenance…

Cliente : On doit mettre un objet en maintenance pour empêcher les réservations et noter ce qui a été fait (ex. changement de pile, réparation). Une photo rapide nous aiderait.

Vendeur : Gestion des comptes ?

Cliente : On aimerait éviter de créer des mots de passe. S’il existe un SSO institutionnel, ça nous va. Côté rôles, on verra, mais au comptoir il y a des employés et parfois des bénévoles.

Vendeur : Des contraintes budgétaires ou techniques ?

Cliente : Débuter simple, sans abonnement coûteux. Si on peut héberger comme nos autres applis, parfait. Et on tient à la francisation ; l’anglais viendra ensuite si possible. On souhaite WCAG 2.1 AA sur les écrans publics.

Vendeur : Avez-vous un inventaire existant ?

Cliente : Oui, dans un CSV avec des colonnes pas très propres. Les objets ont des codes-barres (pas tous). Il faudra importer et peut-être recoller de nouvelles étiquettes.

Vendeur : Concernant la performance au comptoir, vous avez un objectif ?

Cliente : Disons… ≥ 5 scans/seconde cumulés au poste principal pendant les gros rush, sur quelques minutes. Si c’est irréaliste, proposez quelque chose d’atteignable et mesurable.

Vendeur : Et sécurité / vie privée ?

Cliente : Les journaux doivent être utiles mais sobres : éviter de stocker des infos personnelles inutiles. J’aimerais une journalisation des opérations sensibles (qui a prêté quoi, quand), et des sauvegardes.

Vendeur : On peut essayer vos outils actuels ?

Cliente : Non. Pas en production. Si vous avez besoin d’un bac à sable, on peut en parler en labo, mais je ne veux pas mélanger des tests avec de vrais prêts.

Vendeur : Parfait. L’équipe va analyser ce verbatim et produire un SEL V0. Si on a des questions, on vous écrit quand ?

Cliente : Je serais joignable en début de semaine prochaine jusqu'à mercredi par mio ou via temas. Je répondrai vite pendant les périodes annoncées. N’envoyez pas 15 messages séparés : regroupez vos questions.

<!-- Équipes paires : insister sur le délai de developpement -->
