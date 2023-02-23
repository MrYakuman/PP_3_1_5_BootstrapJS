package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
public class Init {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Init(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    public void doInit() {
        if (userRepository.findAll().size() == 0) {
            Role roleUser = new Role("ROLE_USER");
            Role roleAdmin = new Role("ROLE_ADMIN");
            User user = new User();
            user.setAge(25);
            user.setEmail("admin@mail.ru");
            user.setName("admin");
            user.setLastName("admin");
            user.setPassword(passwordEncoder.encode("100"));

            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
            userRepository.save(user);
            user.getRoles().add(roleRepository.findRoleByRole("ROLE_ADMIN"));
            user.getRoles().add(roleRepository.findRoleByRole("ROLE_USER"));
            userRepository.save(user);
        }
    }
}
