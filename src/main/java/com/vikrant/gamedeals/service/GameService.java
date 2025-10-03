package com.vikrant.gamedeals.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vikrant.gamedeals.dto.GameDeal;
import com.vikrant.gamedeals.entity.Game;
import com.vikrant.gamedeals.entity.User;
import com.vikrant.gamedeals.repository.GameRepo;

@Service
public class GameService {
    @Autowired
    GameRepo gameRep;
    RestTemplate restTemplate = new RestTemplate();

    final Map<Integer,String> storeIdMaps =  Map.of(1,"Steam",2,"GamersGate",4,"Amazon",5,"GameStop",25,"Epic Games Store");
   
    public String getGames() {
        storeIdMaps.put(11,"abc");
        String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getBody());
        JSONObject root = new JSONObject(response.getBody());
        JSONObject applist = root.getJSONObject("applist");
        JSONArray apps = applist.getJSONArray("apps");
        List<Game> gameToInsert = new ArrayList<>();
        for (int i = 0; i < apps.length(); i++) {
            JSONObject currentJSONObj = apps.getJSONObject(i);
            Game game = new Game(currentJSONObj.getLong("appid"), currentJSONObj.getString("name"));
            gameToInsert.add(game);
        }
        gameRep.saveAll(gameToInsert);
        return response.getBody();
    }

    public List<Game> searchGame(String name, String prefix) {

        if (prefix != null)
            return gameRep.findByPrefix(prefix.toLowerCase());
        if (name != null)
            return gameRep.findByName(name);
        return gameRep.findByName(name);
    }

    public List<GameDeal> getGameDetails(String gameId) {
        String url = "https://www.cheapshark.com/api/1.0/deals?AppID=" + gameId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        JSONArray root = new JSONArray(response.getBody());
        List<GameDeal> gameDeals = new ArrayList<>();
        for(int i = 0 ; i <root.length();i++ ){
            JSONObject currObject = root.getJSONObject(i);
        
            GameDeal gameDeal = new GameDeal(currObject.getString("title"),
            storeIdMaps.getOrDefault(Integer.parseInt(currObject.getString("storeID")), currObject.getString("storeID")),
            currObject.getString("normalPrice"),
            currObject.getString("isOnSale").equals("1")?true:false,
            currObject.getString("savings"),   
            currObject.getString("metacriticScore")   
            );
            
            gameDeals.add(gameDeal);
        }
        return gameDeals;
    }
}
