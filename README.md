# Expérience utilisateur

## Boutons
    Les boutons principaux d'une calculatrice sont mis à disposition de l'utilisateur:
        - Les chiffres
        - Les 4 opérateurs de base
        - Bouton "suppr" qui permet de supprimer le dernier caractère tappé
        - Bouton "exec" permettant d'éxécuter le calcul demandé

    Le bouton "suppr" est présent dans cette première version plutôt qu'un bouton "CE" qui supprimerais l'entièreté de ce qui est écrit, car semble plus pratique pour un utilisateur qui voudrait taper une grande expression: s'il se trompe de caractère, il peut simplement effacer ce caractère au lieu de recommencer son expression entière.


    Les boutons sont collés les uns aux autres, ce qui est peu pratique car peut entrainer l'activation du mauvais bouton par l'utilisateur et réduit la compréhensibilité de l'affichage.

## Couleurs
    Les boutons ont 3 couleurs différentes:
        - <> pour les chiffres
        - <> pour les opérateurs
        - <> pour "suppr" et "exec"
    
    Ces différentes couleurs permettent à l'utilisateur de rapidement se repérer parmis les différents boutons, ce qui essentiel pour une utilisation agréable.

## Résultat

    Si l'expression est valide, elle est effacée pour laisser place au résultat, ce qui permet à l'utilisateur d'utiliser ce dernier pour son prochain calcul.

## Erreurs

    Si l'expression donnée par l'utilisateur n'est pas évaluable, le message "Invalid operation" s'affiche pour avertir l'utilisateur. Cependant, ce message d'erreur est toujours le même quelquesoit l'erreur et ne permet donc pas à l'utilisateur de comprendre d'où vient l'erreur
    
# Voies d'amélioration

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
    

# Implémentation


## Layout

    Pour l'affichage de ma calculatrice, j'utilise deux layout:
        - Un RelativeLayout prennant les dimensions de l'écran entier, servant seulement à placer le second layout:
        - Un TableLayout me permettant de former une grille de boutons afin de les ordonner simplement

## Evaluation de l'expression

    L'expression donnée par l'utilisateur est évalué grâce à la méthode Expression.evaluate().

    L'utilisation de cette méthode est justifiée par le fait qu'elle permet de reconnaitre tout type d'opérations, dont les opérations dont l'ajout est prévu, ce qui me permettra de les ajouter sans modifier cette partie du code.
    Il faut cependant, en utilisant cette fonction, prendre garde aux exceptions qu'elle renvoie afin de gérer nous même les différentes erreurs.