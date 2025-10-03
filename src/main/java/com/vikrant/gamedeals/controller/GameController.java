package com.vikrant.gamedeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.gamedeals.entity.Game;
import com.vikrant.gamedeals.entity.User;
import com.vikrant.gamedeals.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/getGames")
    public String getGames(){
        return gameService.getGames();
    }

    @GetMapping("/searchGame")
    public List<Game> getGameByName(@RequestParam(required = false) String name,@RequestParam(required = false) String prefix){
        return gameService.searchGame(name,prefix);
    }
   @GetMapping("/getGameDetails")
   public String getGameDetails(@RequestParam String appId){
    return gameService.getGameDetails(appId);
   }
}
