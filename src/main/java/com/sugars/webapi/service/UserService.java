package com.sugars.webapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sugars.webapi.domain.User;
import com.sugars.webapi.domain.UserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> findUser(Long userid){
        return userRepository.findById(userid);
    }
    public List<User> findUsers(){
        return userRepository.findAll();
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public void delete(Long userid) {
        userRepository.deleteById(userid);
    }
    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }
}
