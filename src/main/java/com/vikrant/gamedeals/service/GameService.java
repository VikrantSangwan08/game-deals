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

    public String getGameDetails(String gameId) {
        String url = "https://store.steampowered.com/api/appdetails/?appids=" + gameId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getBody());
        JSONObject root = new JSONObject(response.getBody());
        JSONObject appId = root.getJSONObject(gameId);
        JSONObject data = appId.getJSONObject("data");
        JSONObject price_overview = data.getJSONObject("price_overview");
        System.out.println(price_overview);
        // List<Game> gameToInsert = new ArrayList<>();
        // for(int i = 0 ; i< apps.length();i++) {
        // JSONObject currentJSONObj = apps.getJSONObject(i);
        // Game game = new
        // Game(currentJSONObj.getLong("appid"),currentJSONObj.getString("name"));
        // gameToInsert.add(game);
        // }
        // gameRep.saveAll(gameToInsert);

        return price_overview.toString();
    }
}
