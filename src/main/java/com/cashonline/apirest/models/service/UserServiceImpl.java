package com.cashonline.apirest.models.service;

import com.cashonline.apirest.models.entity.User;
import com.cashonline.apirest.models.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

//    Injection:
    @Autowired
    private IUserRepository userRepository;

//    CRUD Implementation:

//    Implementation of find all users
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

//    Implementation of find a user with an indicate id:
    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

//    Implementation of save a user created:
    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

//    Implementation of delete a user with an indicate id:
    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

}