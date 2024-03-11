package com.eazybytes.cards.service;

import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*
Infos:
7. Expliquez l'architecture MVC dans le contexte d'une application Spring Boot. Comment les composants Model, View, et Controller interagissent-ils ?
Le repository agit com un interface entre le service et la bd, c’est elle qui interagit avec la bd.
Le service instaure les methodes de manipulation de la bd.
Le Controlleur agit comme un interface entre le service et le client, il reçoit les requetes du client et les transmet au service, puis renvoie la reponse au client.
Le model (ici Cards) est la classe qui definit les objets qui seront manipulés par l’application, elle contient les attributs qui definissent les objets.
La vue est la partie front-end de l’application, elle est responsable de l’affichage des données et de la reception des requetes de l’utilisateur.

On peut se demander ou est la vue? Dans le cas de cette application, la vue est le client qui envoie les requetes au controlleur. La classe Cards est le model, le controlleur est le CardsController, le service est le CardService et le repository est le CardsRepository. La vue est un client qui tape des requetes http pour interagir avec l’application.

 */

@Service
public class CardService { //le service est le coeur de l'application, il contient la logique metier, il definie les operations qu'on peut faire sur les cartes

    @Autowired //injecter le repository dans ce service... autowired permet de faire l'injection de dépendance
    private CardsRepository cardsRepository; //injection
    private static final Logger logger = LoggerFactory.getLogger(CardService.class);

    public List<Cards> getAllCards() {
        List<Cards> allCards = new ArrayList<Cards>();
        cardsRepository.findAll().forEach(card -> allCards.add(card));
        logger.debug("Number of cards fetched: {}", allCards.size());

        return allCards;
    }

    public Cards getCardById(int id) {
        return cardsRepository.findById(id).get();
    }

    @Transactional // needs Transactionnal bc it does multiple db operation
    public List<Cards> getCardsByType(String cardType) {
        //Il faut creer methode perso pour aller get Card getCardsByType
        List<Cards> cardsFind = cardsRepository.findByCardType(cardType);

        if (cardsFind != null && !cardsFind.isEmpty()) {
            return cardsFind;
        } else {
            return null;
        }
    }

    public String saveCard(Cards card) {

        // need to check the customer exist in the future livrables
        if (card.getTotalLimit() < 1000) {
            return "failed, limit too low!";
        } else {
            card.setCreateDt(LocalDate.now());
            // Calculer la valeur de availableAmount
            int availableAmount = (card.getTotalLimit() - card.getAmountUsed());
            card.setAvailableAmount(availableAmount);

            cardsRepository.save(card);
            return "saved";
        }
    }

    @Transactional
    public List<Cards> newCards(List<Cards> cardList) {
        List<Cards> savedCards = new ArrayList<>();
        for (Cards card : cardList) {
            card.setCreateDt(LocalDate.now());
            cardsRepository.save(card);
            savedCards.add(card);
        }
        return savedCards;
    }

    public String updateCard(int id, Cards updateCard) {
        Cards cardFind = cardsRepository.findById(id).orElse(null);
        if (cardFind != null) {
            updateCard.setCardId(id);
            updateCard.setCreateDt(LocalDate.now());
            cardsRepository.save(updateCard);
            return "update successful!";
        } else {
            return "card not found!";
        }
    }

    public String updateCardLimit(int id, int limit) {
        Cards cardFind = cardsRepository.findById(id).orElse(null);
        if (cardFind != null) {
            cardFind.setTotalLimit(limit);
            cardsRepository.save(cardFind);
            return "update successful!";
        } else {
            return "card not found!";
        }
    }

    public String deleteCard(int id) {
        Cards cardFind = cardsRepository.findById(id).orElse(null);
        if (cardFind != null) {
            cardsRepository.deleteById(id);
            return "deleted!";
        } else {
            return "card not found!";
        }
    }

    public String deleteCardByNumber(String cardNumber) {
        Cards cardFind = cardsRepository.findByCardNumber(cardNumber);
        if (cardFind != null) {
            cardsRepository.delete(cardFind);
            return "Succès";
        } else {
            return "Carte non-trouvé";
        }
    }

    @Transactional
    public String deleteCardsByCustomerId(int customerId) {
        List<Cards> cardsFind = cardsRepository.findByCustomerId(customerId);
        if (cardsFind != null && !cardsFind.isEmpty()) {
            cardsRepository.deleteAll(cardsFind);
            return "deleted!";
        } else {
            return "card not found!";
        }
    }

    @Transactional
    public String deleteMultipleCards(List<Integer> cardIds) {
        try {
            for (Integer id : cardIds) {
                cardsRepository.deleteById(id);
            }
            return "Succès";
        } catch (Exception e) {
            return "Échec de suppression";
        }
    }


}
