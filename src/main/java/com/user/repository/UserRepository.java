package com.user.repository;

import com.user.model.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Integer> {

    UserDao findByUsername(String username);
}
