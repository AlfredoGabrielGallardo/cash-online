package com.cashonline.apirest.models.service;

import com.cashonline.apirest.models.entity.User;
import java.util.List;

public interface IUserService {

//    CRUD:
    List<User> findAll();     //To find all users.
    User findById(int id);    //To find a user by an indicated id.
    User save(User user);     //To save a created user.
    void delete(int id);      //To delete a user by an indicated id.

}
