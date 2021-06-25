package com.cashonline.apirest.models.repository;

import com.cashonline.apirest.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
