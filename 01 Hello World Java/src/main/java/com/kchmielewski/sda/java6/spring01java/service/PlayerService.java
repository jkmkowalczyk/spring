package com.kchmielewski.sda.java6.spring01java.service;

import com.kchmielewski.sda.java6.spring01java.dao.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    public PlayerService() {
        Player player = new Player();
        player.setName("Adam");
        player.setSurname("Lallana");
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> add(Player player) {
        players.add(player);
        return players;
    }

    public List<Player> delete(Player player) {
        players.remove(player);
        return players;
    }


}

