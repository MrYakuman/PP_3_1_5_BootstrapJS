package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    public void addRole(Role role);

    Role findById(Long role_id);

    List<Role> getAllRoles();

    public void deleteRole(Long id);

    public void editRole(Role role);
}