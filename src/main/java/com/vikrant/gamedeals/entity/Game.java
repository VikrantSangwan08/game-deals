package com.vikrant.gamedeals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id private Long appid;
    private String name ;

    public Game(){
        
    }
    public Game(Long appid,String name){
        this.appid = appid;
        this.name = name;
    }

    public Long getAppid() {
        return appid;
    }
   
    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
