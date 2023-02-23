package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface ServiceUser {

    List<User> findAll();

    User findOne(Long id);

    void saveUser(User user);

    void update(Long id, User updatedUser);

    void deleteUser(Long id);
}
