/**
 *
 */
package com.eazybytes.cards.controller;

        import com.eazybytes.cards.model.Cards;
        import com.eazybytes.cards.service.CardService;
        import io.swagger.v3.oas.annotations.Operation;
        import io.swagger.v3.oas.annotations.responses.ApiResponse;
        import io.swagger.v3.oas.annotations.responses.ApiResponses;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
//un controlleur est un composant spring qui reçoit les requetes http et renvoie les reponses venant du service(qui lui vient du repository qui lui get les infos de la bd)
@RestController //indique que c'est un controller qui va gerer les requetes http
public class CardsController {

    @Autowired //injecter le service dans le controller... autowired permet de faire l'injection de dépendance
    private CardService cardService; //injection, montre que le controlleur depend du service qui lui depend du repository

    @Operation(summary = "récuperer les infos d'une carte par id (/myCard/id)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carte récupérée avec succès"),
            @ApiResponse(responseCode = "404", description = "Carte non trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping("/myCard/{id}") //getMapping pour recuperer les infos d'une carte par id
    public Cards getCardDetails(@PathVariable("id") int id) {
        return cardService.getCardById(id);
    }

    @Operation(summary = "récuperer toute les cartes d'une certain type (/cardsByType/cardType)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartes récupérées avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune carte trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping("/cardsByType/{cardType}")
    public List<Cards> getCardsByType(@PathVariable("cardType") String cardType) {
        return cardService.getCardsByType(cardType);
    }

    @Operation(summary = "get all cards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartes récupérées avec succès"),
            @ApiResponse(responseCode = "404", description = "Aucune carte trouvée"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @GetMapping("/AllCards")
    public List<Cards> getAllCards() {
        return cardService.getAllCards();
    }

    @Operation(summary = "create a new card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carte créée avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de création de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping("/newCard")
    public String newCard(@RequestBody Cards card) {
        return cardService.saveCard(card);
    }

    @Operation(summary = "créer plusieurs cartes à la fois(/newCards)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cartes créées avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de création de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PostMapping("/newCards")
    public List<Cards> newCards(@RequestBody List<Cards> card) {
        return cardService.newCards(card);
    }

    @Operation(summary = "update les infos complet d'une carte par id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carte mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de mise à jour de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping("/update/{id}") //localhost:8080/update/1 sur postman et
    // body = { "customerId": 1, "cardNumber": "123456789", "cardType": "Visa", "totalLimit": 1000,
    // "amountUsed": 0, "availableAmount": 1000, "createDt": "2021-07-01" }
    public String updateCard(@PathVariable("id") int id, @RequestBody Cards updateCard) {
        return cardService.updateCard(id, updateCard);
    }

    @Operation(summary = "update la limite total par id (/updateCardLimit/id/limit)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Limite de carte mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de mise à jour de limite de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping("/updateCardLimit/{id}/{limit}")
    public String updateCardLimit(@PathVariable("id") int id, @PathVariable("limit") int limit) {
        return cardService.updateCardLimit(id, limit);
    }

    @Operation(summary = "supprimer par id (/deleteCard/id)") //localhost:8080/deleteCard/1 va delete la carte avec id 1
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carte supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de suppression de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable("id") int id) {
        return cardService.deleteCard(id);
    }

    @Operation(summary = "supprimer par numero de carte (/deleteCardByNumber/cardNumber)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carte supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de suppression de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping("/deleteCardByNumber/{cardNumber}")
    public String deleteCardByNumber(@PathVariable("cardNumber") String cardNumber) {
        return cardService.deleteCardByNumber(cardNumber);
    }

    @Operation(summary = "supprimer par id de client (/deleteCardsByCustomerId/customerId)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartes supprimées avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de suppression de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping("/deleteCardsByCustomerId/{customerId}")
    public String deleteCardsByNumber(@PathVariable("customerId") int customerId) {
        return cardService.deleteCardsByCustomerId(customerId);
    } //@Pathvar pour recuperer la valeur de customerId

    @Operation(summary = "supprimer plusieurs cartes (/deleteMultipleCards)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartes supprimées avec succès"),
            @ApiResponse(responseCode = "404", description = "Échec de suppression de carte"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @DeleteMapping("/deleteMultipleCards")
    public String deleteMultipleCards(@RequestBody List<Integer> cardIds) {
        return cardService.deleteMultipleCards(cardIds);
    }
}

