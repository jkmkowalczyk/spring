package com.kchmielewski.sda.java6.spring01java.web;

import com.kchmielewski.sda.java6.spring01java.dao.Player;
import com.kchmielewski.sda.java6.spring01java.service.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class PlayerControllerTest {
    private final PlayerService service = mock(PlayerService.class);
    private final PlayerController controller = new PlayerController(service);
    private final MockMvc mvc = standaloneSetup(controller).build();


    @Test
    public void display() throws Exception {
        mvc.perform(get("/display")).andExpect(status().isOk());

        verify(service).getPlayers();
    }

    @Test
    public void add() throws Exception {

        mvc.perform(post("/add").param("name", "John").param("surname", "Doe")).andExpect(status().isOk());

        Player player = new Player();
        player.setName("John");
        player.setSurname("Doe");

        verify(service).add(player);

    }

    @Test
    public void delete() throws Exception {
        mvc.perform(post("/delete").param("name", "Adam").param("surname",
                "Lallana")).andExpect(status().isOk());


        Player player = new Player();
        player.setName("Adam");
        player.setSurname("Lallana");

        verify(service).delete(player);

    }
}
