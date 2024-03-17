# BankApp - Service Spring Boot / React

## Update, delete

https://github.com/Elie-Simard/BankApp/assets/104814268/330b9e35-67f6-4a1c-854b-57f88ac6fd1c

## Add, Search

https://github.com/Elie-Simard/BankApp/assets/104814268/6e7bc994-97f7-4b1e-8aeb-aaeba8dfa1b3



## Clients table

https://github.com/Elie-Simard/BankApp/assets/104814268/7e330d50-641a-4584-8276-63d3681a2ab0







## UseCase

BankApp est une solution de gestion bancaire conçue à des fins éducatives. Elle offre une interface API permettant d'effectuer une variété d'opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur la base de données, rendant la gestion de comptes clients et de cartes bancaires à la fois fluide et intuitive.

## Fonctionnalités de l'API

- **Gestion des Clients** : Ajout de nouveaux clients, mise à jour des informations des clients existants, suppression de clients.
- **Gestion des Cartes** : Ajout de nouvelles cartes bancaires, modification des limites de crédit, mise à jour des informations des cartes, suppression de cartes.
- **Transactions et Opérations** : Support pour les transactions financières standard, y compris mais non limité à l'édition et la mise à jour des soldes et des limites.

## Mise en place côté serveur avec Spring Boot

### Introduction

Cette application Spring Boot a été conçue à des fins éducatives.
J'ai intégré le test fonctionnel 'Calculateur' dans le projet pour assurer une base solide. Cette intégration est une étape préparatoire pour le développement et le déploiement des tests spécifiques à l'application 'CART'.

### Configuration de l'environnement de développement

1. Assurez-vous que Java 8 (ou ultérieure) et Maven sont installés et configurés correctement sur votre machine.
2. Ouvrez un terminal et naviguez jusqu'au répertoire racine de 'CARDS'.
3. Exécutez les commandes suivantes pour démarrer l'application :

   ```bash
   mvn clean install
   ```

   et

   ```bash
   mvn spring-boot:run
   ```

Pour accéder à l'application, ouvrez un navigateur et tapez l'URL suivante :

```
http://localhost:8080/swagger-ui.html
```

### Configuration de l'environnement de test

Pour exécuter les tests et générer le rapport de couverture avec JaCoCo, suivez les étapes ci-dessous :

1. Assurez-vous que Maven est installé et configuré correctement sur votre machine.
2. Ouvrez un terminal et naviguez jusqu'au répertoire racine de l'application 'CART'.
3. Exécutez la commande suivante pour nettoyer le projet, exécuter les tests et vérifier la couverture :

### Accès au rapport JaCoCo

Le rapport de couverture de JaCoCo est généré dans le répertoire `target/site/jacoco` après l'exécution des tests. Cependant, si vous rencontrez des difficultés pour accéder au rapport `index.html` via votre navigateur, vous pouvez démarrer un serveur HTTP local dans le dossier `site` comme solution de contournement.

Pour démarrer un serveur HTTP et consulter le rapport JaCoCo :

1. Installez un serveur HTTP de votre choix si ce n'est pas déjà fait. (Exemple : `http-server`)
2. Naviguez jusqu'au dossier `site` dans le répertoire `target` de l'application.
3. Démarrez le serveur HTTP. Si vous utilisez `http-server`, exécutez :

   ```bash
   http-server
   ```
