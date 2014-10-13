outcontact
==========

Projet de concéption d'une application web de gestion de contacts 

Promotion : 5A ESIEA

Groupe : KIRSZ Arthur PORCHERON David LEVIN Warren

Documentation d'installation :
GitHub https://github.com/arthurkirsz/outcontact.git

Téléchargez l'archive .zip dans le portail web Github à l'adresse notée ci-dessus
Dézippez l'archive dans votre workspace
Lancez Eclipse en sélectionnant votre workspace, puis importez le projet dans le "Package Explorer"

Technologies utilisées :

  - Spring 3.1.1 (Spring MVC)
  - Google App Engine SDK

Architecture du projet :

Sous outcontact/src/fr/esiea/outcontact, vous trouverez l'ensemble des sources du projet.
  - Le package controller, contenant l'ensemble des controllers de l'application
    (chaque page jsp est relié à un controller distinct, pour permettre une meilleure lecture du code)
  - Le package dao, contenant les deux classes simulant la persistance de l'application.
  - Le package model, contenant l'ensemble des modèles de l'application.
  - Le package services, contenant l'ensemble des classes qui permettent la liaison entre les controllers
    et les DAO.
  - Le package validator, contenant l'ensemble des classes permettant la validation des entrées utilisateur
    dans les formulaires de saisie.

L'ensemble de la documentation se situe dans le répertoire /outcontact/doc
  - /doc/images : contenant l'ensemble des images/diagrammes en lien avec
  le projet
  - /doc/yuml : contenant l'ensemble des scripts yUML permettant la
  modélisation des diagrammes
  - /doc/RapportIHM.docx : rapport au format .docx
