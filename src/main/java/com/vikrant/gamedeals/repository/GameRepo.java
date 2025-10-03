package com.vikrant.gamedeals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vikrant.gamedeals.entity.Game;



@Repository
public interface GameRepo extends JpaRepository <Game,Long>  {
    List<Game> findByName(String name);
    
    @Query("SELECT g FROM Game g WHERE LOWER(g.name) Like :prefix%")
    public List<Game> findByPrefix(@Param("prefix") String prefix);
} 
