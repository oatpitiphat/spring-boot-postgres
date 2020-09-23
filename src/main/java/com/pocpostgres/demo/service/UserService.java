package com.pocpostgres.demo.service;

import com.pocpostgres.demo.model.User;
import com.pocpostgres.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.getAllData();
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findAllByAgeAndMoney(Integer age, BigDecimal money) {
        return userRepository.findAllByAgeAndMoney(age, money);
    }

    public Optional<User> findUserById(Integer Id) {
        return userRepository.findById(Id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUserById(Integer Id) {
        boolean isSuccess = false;
        try {
            userRepository.deleteById(Id);
            isSuccess = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }


    public List<User> getAllByRoleName(String text) {
        return userRepository.getAllRoleName(text);
    }
}
