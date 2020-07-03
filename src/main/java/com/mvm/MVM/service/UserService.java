package com.mvm.MVM.service;

import java.util.Arrays;
import java.util.Optional;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.TopicManagementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mvm.MVM.dto.UserDto;
import com.mvm.MVM.model.Category;
import com.mvm.MVM.model.User;
import com.mvm.MVM.repository.RoleRepository;
import com.mvm.MVM.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CategoryService categoryService;


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
    
    public User findByUsername(String username) {
    	return userRepository.findByUsername(username).get();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User newUser(UserDto userDTO) {

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }

        String password = passwordEncoder.encode(userDTO.getPassword());

        System.out.println("AAAAAA " + userDTO.getCategory());

        Category category = categoryService.findByName(userDTO.getCategory());

        User user = new User();
        user.setCategory(category);
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPassword(password);
        user = userRepository.save(user);

        category.getUsers().add(user);
        categoryService.save(category);

        userDTO.setPassword("");

        return user;

    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(auth.getName());
        return user.get();
    }

    public void subscribeToTopic(String token){
        TopicManagementResponse response = null;

        System.out.println(getCurrentUser().getCategory().getName().trim());
        System.out.println(token);

        try {
            response = FirebaseMessaging.getInstance().subscribeToTopic(Arrays.asList(token),getCurrentUser().getCategory().getName().trim());
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully sent message: " + response.getSuccessCount());

    }

    public void unSubscribeToTopic(String token){
        TopicManagementResponse response= null;
        try {
            response = FirebaseMessaging.getInstance().unsubscribeFromTopic(Arrays.asList(token),getCurrentUser().getCategory().getName().trim());
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully sent message: " + response.getSuccessCount());

    }
}
