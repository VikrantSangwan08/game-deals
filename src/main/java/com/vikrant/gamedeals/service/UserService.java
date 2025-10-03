package com.vikrant.gamedeals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikrant.gamedeals.entity.User;
import com.vikrant.gamedeals.repository.UserRepo;
@Service
public class UserService{
    @Autowired
    UserRepo userRep ;
    public String addNewUser(User user){
            try{
                userRep.save(user);
            return "Sucesss";
            }catch(IllegalArgumentException ia){
               return "Error" + ia.getMessage();
                
            }
    }
    public User getUserById(String userId){
         return  userRep.findById(userId).orElse(null); 
    }

    public List<User> findAllUserContaining(String name,String email,String prefix){
        if(prefix != null) return userRep.findByPrefix(prefix);
        if(name !=null) return userRep.findByName(name);
        if(email !=null) return userRep.findByEmail(email);
        return null;
    }

    public void updateUser(User user){
            userRep.save(user);     
    }

    public void deleteUser(User user){
        userRep.delete(user);
    }
}