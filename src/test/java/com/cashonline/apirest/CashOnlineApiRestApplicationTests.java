package com.cashonline.apirest;

import com.cashonline.apirest.controllers.UserRestController;
import com.cashonline.apirest.controllers.dto.UserDto;
import com.cashonline.apirest.models.entity.User;
import com.cashonline.apirest.models.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class UserTests {

//    Injection:
    @Autowired
    UserRestController userRestController;

    @Autowired
    private IUserRepository userRepository;


//    TEST IN THE REPOSITORY:

//    Test to create user:
    @Test
    @Transactional
    @Rollback
    public void createUser() {
        User user = new User("123151561651alfredoggallardo50@gmail.com", "alfredo", "gallardo");
        User newUser = userRepository.save(user);

        assertNotNull(newUser);
    }

//    Test to delete user:
    @Test
    @Transactional
    @Rollback
    void deleteUser() {
        Integer id = 1;

        boolean isExistBeforeDelete = userRepository.findById(id).isPresent();
        userRepository.deleteById(id);
        boolean notExistAfterDelete = userRepository.findById(id).isPresent();
        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);
    }

//    TEST IN THE CONTROLLER:

//    Test to find by id:
    @Test
    @Transactional
    @Rollback
    void GetById() {
        User user = new User("gettest@gmail.com", "get", "test");
        userRestController.create(user);
        UserDto userById = userRestController.show(4);

        Assertions.assertEquals(user.getFirstName(), userById.getFirstName());
        Assertions.assertEquals(user.getLastName(), userById.getLastName());
        Assertions.assertEquals(user.getEmail(), userById.getEmail());
    }

}
