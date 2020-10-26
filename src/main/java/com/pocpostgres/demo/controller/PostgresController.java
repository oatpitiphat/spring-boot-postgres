package com.pocpostgres.demo.controller;

import com.pocpostgres.demo.model.BudgetStructure;
import com.pocpostgres.demo.model.User;
import com.pocpostgres.demo.repository.BudgetStructureResositoryImpl;
import com.pocpostgres.demo.service.BudgetStructureService;
import com.pocpostgres.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostgresController {

    Logger log = LoggerFactory.getLogger(PostgresController.class);

    @Autowired
    UserService userService;

    @Autowired
    BudgetStructureService budgetStructureService;

    @Autowired
    BudgetStructureResositoryImpl budgetStructureResositoryImpl;

    @GetMapping(path = "/api/user/getData")
    public ResponseEntity getUser() {
        List<User> users = new ArrayList<>();
        try {
            users = userService.findAllUser();
        } catch (Exception ex) {
            log.error("/api/getData | Cannot getData");
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping(path = "/api/user/getDataByName")
    public ResponseEntity getUserByName(@RequestParam String name) {
        User user;
        try {
            user = userService.findByName(name);
        } catch (Exception ex) {
            log.error("/api/getData | Cannot getData by name");
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping(path = "/api/user/getDataByAgeAndMoney")
    public ResponseEntity getUserByAgeMoney(@RequestParam Integer age, @RequestParam BigDecimal money) {
        List<User> users = new ArrayList<>();
        try {
            users = userService.findAllByAgeAndMoney(age, money);
        } catch (Exception ex) {
            log.error("/api/getData | Cannot getData by age and money");
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping(path = "/api/user/save")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        try {
           User response = userService.createUser(user);
           return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "api/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        try {
            boolean response = userService.deleteUserById(id);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/api/user/getAllRoleName")
    public ResponseEntity getAllByRole(@RequestParam String search) {
        List<User> users = userService.getAllByRoleName(search);
        return new ResponseEntity(users, HttpStatus.OK);
    }


    @GetMapping(path = "/api/budget/structures")
    public ResponseEntity getAllStructure() {
        List<BudgetStructure> list = budgetStructureService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping(path = "/api/budget/structure")
    public ResponseEntity saveStructure(@Valid @RequestBody BudgetStructure structure) {
        BudgetStructure data = budgetStructureService.save(structure);
        return new ResponseEntity(data, HttpStatus.OK);
    }


    @GetMapping(path = "/api/budget/test")
    public ResponseEntity getList() {
        List<BudgetStructure> list = budgetStructureService.getList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
