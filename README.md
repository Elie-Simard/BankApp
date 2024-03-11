# Application CART - Service Spring Boot

## Introduction

Cette application Spring Boot, intitulée 'CART', a été conçue à des fins éducatives.
 *****J'ai intégré le tutoriel fonctionnel 'Calculateur' dans le projet pour assurer une base solide semblable à celle du tutoriel initial.
 Cette intégration est une étape préparatoire pour le développement et le déploiement des tests spécifiques à l'application 'CART'.

##Configuration de l'environnement de développement
1- Assurez-vous que Java 17 et maven est installé et configuré correctement sur votre machine.
2- Ouvrez un terminal et naviguez jusqu'au répertoire racine de l'application 'CART'.
3- Exécutez la commande suivante pour démarrer l'application :

mvn clean install
---et---
mvn spring-boot:run

pour accéder à l'application, ouvrez un navigateur et tapez l'url suivante :

http://localhost:8080/swagger-ui.html

## Configuration de l'environnement de test

Pour exécuter les tests et générer le rapport de couverture avec JaCoCo, suivez les étapes ci-dessous :

1. Assurez-vous que Maven est installé et configuré correctement sur votre machine.
2. Ouvrez un terminal et naviguez jusqu'au répertoire racine de l'application 'CART'.
3. Exécutez la commande suivante pour nettoyer le projet, exécuter les tests et vérifier la couverture :

## Accès au rapport JaCoCo

Le rapport de couverture de JaCoCo est généré dans le répertoire `target/site/jacoco` après l'exécution des tests. **
*******Cependant, si vous rencontrez des difficultés pour accéder au rapport `index.html` via votre navigateur,
*******vous pouvez démarrer un serveur HTTP local dans le dossier `site` comme solution de contournement.

Pour démarrer un serveur HTTP et consulter le rapport JaCoCo :

1. Installez un serveur HTTP de votre choix si ce n'est pas déjà fait. (Exemple : `http-server`):
     npm install --global http-server

2. Naviguez jusqu'au dossier `site` dans le répertoire `target` de l'application:
     cd target/site

3. Démarrez le serveur HTTP. Si vous utilisez `http-server`, exécutez :
     http-server