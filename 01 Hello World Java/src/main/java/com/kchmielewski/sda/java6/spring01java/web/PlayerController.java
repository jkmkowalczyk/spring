package com.kchmielewski.sda.java6.spring01java.web;

import com.kchmielewski.sda.java6.spring01java.dao.Player;
import com.kchmielewski.sda.java6.spring01java.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("players")
public class PlayerController {
    private final PlayerService playerService;


    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;

    }

    @ModelAttribute
    public Player defaultPlayer() {
        Player defaultPlayer = new Player();
        return defaultPlayer;
    }

    //widok
    @GetMapping("display")
    public String display(Model model) {
        model.addAttribute("players", playerService.getPlayers());
        return "players";
    }


    @GetMapping("add")
    public String add() {
        return "addplayer";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute Player player, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "addplayer";

        model.addAttribute("players", playerService.add(player));
        return "redirect:display";
    }


    @PostMapping("delete")
    public String delete(Player player, Model model) {
        model.addAttribute("players", playerService.delete(player));
        return "redirect:display";
    }

}
