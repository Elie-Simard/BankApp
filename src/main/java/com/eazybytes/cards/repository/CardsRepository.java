package com.eazybytes.cards.repository;

import com.eazybytes.cards.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Integer> { // agit comme une interface entre le service et la db


    List<Cards> findByCustomerId(int customerId);

    List<Cards> findByCardType(String cardType);

    Cards findByCardNumber(String cardNumber);

}
