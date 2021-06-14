package com.yaskovskyi.task5.controller;

import com.yaskovskyi.task5.game.GameCreating;
import com.yaskovskyi.task5.model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    GameCreating gc;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

//    @GetMapping("/game")
//    public String createGame(Model model,
//                             @RequestParam(value = "name", required = false) String name,
//                             @RequestParam(value = "id", required = false) String id) {
//        if (name.equals("") && id.equals("")) {
//            return "index";
//        }
//        Player player = new Player();
//        player.setName(name);
//        gc.createGame(player, id);
//        return "game";
//    }

    @GetMapping("/create_game")
    public String createGamePage() {
        return "create_game";
    }

    @GetMapping("/game")
    public String game() {
        return "game";
    }


}
