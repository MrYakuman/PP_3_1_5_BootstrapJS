package ru.kata.spring.boot_security.demo.service;


import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }


    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);

    }

    @Override
    public void editRole(Role role) {
        role.setId(role.getId());
        roleRepository.save(role);
    }
}