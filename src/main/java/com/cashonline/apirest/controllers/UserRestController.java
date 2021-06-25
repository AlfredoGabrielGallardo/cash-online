package com.cashonline.apirest.controllers;

import com.cashonline.apirest.controllers.dto.ItemDto;
import com.cashonline.apirest.controllers.dto.UserDto;
import com.cashonline.apirest.controllers.exception.NotFoundUserException;
import com.cashonline.apirest.models.entity.Loan;
import com.cashonline.apirest.models.entity.User;
import com.cashonline.apirest.models.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRestController {

//    Injection:
    @Autowired
    private IUserService userService;

//    Controllers:

//    Controller to get all users:
    @GetMapping("/users")
    public List<User> index(){
        return userService.findAll();
    }

//    Controller to get a user indicated with id/ Application of DTO:
    @GetMapping("/users/{id}")
    public UserDto show(@PathVariable int id) {
        User user = userService.findById(id);

        if(user == null){
            throw new NotFoundUserException("[ERROR] User ID doesn't exist in the database.");
        }

        List<Loan> loans = user.getLoans();
        List<ItemDto> listItem = new ArrayList<>();

        for (Loan loan: loans) {
            ItemDto itemDto = new ItemDto(loan.getId(), loan.getTotal().intValue(), loan.getUser().getId());
            listItem.add(itemDto);
        }
        UserDto userDto = new UserDto(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), listItem);

        return userDto;
    }

//    Controller to create user:
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User user) {

        User userNew = null;
        Map<String, Object> response = new HashMap<>();

        try{
            userNew = userService.save(user);
        } catch(DataAccessException e){
            response.put("[ERROR]", "Failed to create a new user. Check the information.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("[ACCEPTED]", "The client has been create successfully!");
        response.put("user", userNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

//    Controller to delete a user indicated with id:
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete (@PathVariable int id) {

        Map<String, Object> response = new HashMap<>();

        try{
            userService.delete(id);
        } catch(DataAccessException e){
            response.put("[ERROR]", "Failed to delete user. The ID doesn't correspond to any user in the database.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("[ACCEPTED]", "The client has been delete successfully!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
