package com.vikrant.gamedeals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vikrant.gamedeals.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name Like %:prefix%")
    public List<User> findByPrefix(@Param("prefix") String prefix);



}
