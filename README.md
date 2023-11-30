# Sommaire

1/Expérience utilisateur
2/Voies d'amélioration
3/Implementation
4/Problèmes rencontrés

# Important

Les 3 premières parties concernent l'application telle que dans la branche master,
et la partie 4 concerne la branche MVP (voir partie 4 pour l'explication de son existance)

# 1/Expérience utilisateur

## Boutons
Les boutons principaux d'une calculatrice sont mis à disposition de l'utilisateur:
    - Les chiffres
    - Les 4 opérateurs de base
    - Bouton "suppr" qui permet de supprimer le dernier caractère tappé
    - Bouton "exec" permettant d'éxécuter le calcul demandé

Le bouton "suppr" est présent dans cette première version plutôt qu'un bouton "CE" qui supprimerais l'entièreté
de ce qui est écrit, car semble plus pratique pour un utilisateur qui voudrait taper une grande expression:
s'il se trompe de caractère, il peut simplement effacer ce caractère au lieu de recommencer son expression entière.


Les boutons sont collés les uns aux autres, ce qui est peu pratique car peut entrainer l'activation du mauvais
bouton par l'utilisateur et réduit la compréhensibilité de l'affichage.

## Résultat

Si l'expression est valide, elle est effacée pour laisser place au résultat, ce qui permet à l'utilisateur
d'utiliser ce dernier pour son prochain calcul.

## Erreurs

Si l'expression donnée par l'utilisateur n'est pas évaluable, le message "Invalid operation" s'affiche pour
avertir l'utilisateur. Cependant, ce message d'erreur est toujours le même quelquesoit l'erreur et ne permet
donc pas à l'utilisateur de comprendre d'où vient l'erreur, et ne s'efface pas automatiquement si l'utilisateur
écrit à nouveau

# 2/Voies d'amélioration

## Ajout de boutons:
- "CE" supprimant l'entièreté de l'expression entrée
- Boutons de parenthèses
- Bouton "." afin de pouvoir manipuler des nombres non entiers
- Boutons "sin" et "cos"
- Bouton "^" pour pouvoir utiliser l'exponentiation

## Historique
Une partie du haut de l'écran n'est pas encore utilisée, et servira dans une version ultérieure à afficher l'historique des calculs effectués.

## Meilleurs messages d'erreur

Séparer les cas:
    - Division par 0
    - Opérande manquante


# 3/Implémentation


## Layout

Pour l'affichage de ma calculatrice, j'utilise deux layout:
    - Un RelativeLayout prennant les dimensions de l'écran entier, servant seulement à placer le second layout:
    - Un TableLayout me permettant de former une grille de boutons afin de les ordonner simplement

## Evaluation de l'expression

L'expression donnée par l'utilisateur est évalué grâce à la méthode Expression.evaluate().

L'utilisation de cette méthode est justifiée par le fait qu'elle permet de reconnaitre tout type d'opérations, dont les opérations dont l'ajout est prévu, ce qui me permettra de les ajouter sans modifier cette partie du code.
Il faut cependant, en utilisant cette fonction, prendre garde aux exceptions qu'elle renvoie, qui ouvrent une faille de sécurité, laissant la possibilité à un attaquant d'envoyer du code potentiellement nocif.

# 4/Problèmes rencontrés

Il y a des grandes chances pour que vous considéreriez que dans la suite je "raconte ma vie", ce qui serais
parfaitement légitime, mais je l'ai mis ici afin d'expliquer le problème rencontré le jour du rendu et essayer
de faire rentrer en compte le travail fourni malgré ce problème.

N'ayant pas d'ordinateur personnel permettant d'utiliser android studio, j'ai été contraint 
d'effectuer ce travail sur les ordinateurs de l'école, ce qui est une grande perte de temps.
Une après midi sans grand succès: je ne pouvais plus lancer d'émulateur android pour tester
l'application, ce qui m'a au moins permis après un long moment à essayer de régler l'erreur
de découvrir comment déployer l'application sur mon appareil, ce qui est beaucoup plus long
que l'émulateur.
    
## Jour du rendu:

### Problème

L'après midi, dès avoir allumé l'ordinateur, android studio ne connaissait plus aucune
classe ou méthode, alors que tout marchait au moment d'éteindre le matin, malgré les
différentes tentatives (redémarrage, changer l'importation, ...). J'ai donc dû jusqu'au
moment du rendu continuer de coder "à l'aveugle" (sans pouvoir tester mon application
puisqu'il y a des erreurs de classes et méthodes inconnues)

### Solution

J'ai donc donc deux branches dans mon projet github:
    - la branche master contient le code tel qu'il était la dernière fois que j'ai pu
    l'éxécuter avant ce problème.
    - une deuxième branche contenant le code ajouté et modifié "à l'aveugle" à cause de
    ce problème. Ce code n'est donc pas testé et est donné afin d'indiquer les 
    modifications que j'aurais voulu faire sans ce contre-temps.

Modifications/Ajouts:

    - Modifications pour une architecture MVP valide:
        - Répartition dans 3 packages "Model" "Presenter" et "View"
        - Renomage de classes:
            - MainActivity -> MainView
            - CalculatorActivity -> CalculatorView
        - Modification des responsabilités des classes pour respecter l'architecture MVP:
        C'est maintenant la classe CalculatorView qui met à jour les textes affichés et non
        plus CalculatorPresenter
    - Taille de texte des boutons s'adaptant à la taille du bouton (CalculatorView.java l.53 et l.71)
    - Utilisation dans activity_calculatrice.xml des attributs android:autoSizeMaxType et
    android:autoSizeMinTextSize afin de faire en sorte que la taille du texte entré par l'utilisateur
    s'adapte au nombre de ligne, afin que le texte n'atteigne plus le haut de l'écran, ce qui décalait
    les boutons vers le bas.
    - Utilisation dans CalculatorView d'une variable booléenne indiquant si un message d'erreur est affiché,
    afin que l'utilisateur puisse entrer son calcul sans avoir à effacer lui même le message d'erreur.
    - Ajout d'un nouveau TextView afin d'afficher le résultat à chaque nouveau caractère entré,
    puis de le transférer dans le TextView de saisie de calcul à l'appuie du bouton "exec".
    - Couleur des boutons:
        Les boutons ont 3 couleurs différentes:
        - Cyan pour les chiffres
        - Bleu pour les opérateurs
        - Violet pour "suppr" et "exec"

        Je n'ai pas pu voir si ces couleurs offrent une utilisation agréable, mais elles doivent permettre
        à l'utilisateur de rapidement se repérer parmis les différents boutons, ce qui est essentiel pour
        une utilisation agréable.
    