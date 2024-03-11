package com.eazybytes.cards;

import org.springframework.boot.SpringApplication; //pour demarrer l'application
import org.springframework.boot.autoconfigure.SpringBootApplication; //autofig va mettre en place les beans et les configurations
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan; //context et annotaion von
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.eazybytes.cards.controller")}) //pour scanner les classes de notre package et les injecter dans le contexte, soit notre base de données
@EnableJpaRepositories("com.eazybytes.cards.repository") // active le jpa repo que l'on a implementé dans clientRepo
@EntityScan("com.eazybytes.cards.model") //difference entre entite vs component: entite est une classe qui va etre mappé avec une table dans la db, component est une classe qui va etre gerer par spring
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
