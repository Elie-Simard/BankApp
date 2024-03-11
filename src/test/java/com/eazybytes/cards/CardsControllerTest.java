package com.eazybytes.cards;

import com.eazybytes.cards.controller.CardsController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class CardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCardDetails_Success() throws Exception {
        mockMvc.perform(get("/myCard/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void getCardDetails_NotFound() throws Exception {
        mockMvc.perform(get("/myCard/{id}", 100)) // Remplacez 100 par un ID de carte qui n'existe pas
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCardsByType_Success() throws Exception {
        mockMvc.perform(get("/cardsByType/{cardType}", "Credit"))
                .andExpect(status().isOk());
    }

    @Test
    public void getCardsByType_NotFound() throws Exception {
        mockMvc.perform(get("/cardsByType/{cardType}", "erreur")) // Remplacez "Debit" par un type de carte qui n'existe pas
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllCards_Success() throws Exception {
        mockMvc.perform(get("/AllCards"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllCards_NotFound() throws Exception {
        mockMvc.perform(get("/AllCardsBUG"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteCard_Success() throws Exception {
        mockMvc.perform(delete("/deleteCard/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCard_Failure() throws Exception {
        mockMvc.perform(delete("/deleteCard/{id}", 10454))
                .andExpect(status().isNotFound());
    }
}
