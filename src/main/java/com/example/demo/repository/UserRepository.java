package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//package com.example.demo.repository;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public User save(User user){
        user.setId((long)(users.size() +1));
        users.add(user);
        return user;
    }
    public List<User> findAll(){
        return users;
    }

    public Optional<User> findById(Long id){
        return  users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User update(User user){
        for(int i = 0; i < users.size(); i ++){
            if(users.get(i).getId().equals(user.getId())){
                users.set(i,user);
                return user;
            }
        }
        return null;
    }

}
