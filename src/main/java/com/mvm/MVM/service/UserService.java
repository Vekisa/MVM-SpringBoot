package com.mvm.MVM.service;

import com.mvm.MVM.model.Role;
import com.mvm.MVM.model.User;
import com.mvm.MVM.repository.RoleRepository;
import com.mvm.MVM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with id: " + id + "does not exist!");
        return user.get();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User newUser(User userDTO) {

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }


        //Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role can't be found!"));

        //Set<Role> tempRoles = new HashSet<>();

        String password = passwordEncoder.encode(userDTO.getPassword());

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        //tempRoles.add(role);
        //user.setRoles(tempRoles);
        user.setPassword(password);
        user = userRepository.save(user);

        userDTO.setPassword("");

        return user;

    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(auth.getName());
        return user.get();
    }
}
