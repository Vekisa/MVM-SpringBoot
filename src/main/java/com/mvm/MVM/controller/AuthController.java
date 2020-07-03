package com.mvm.MVM.controller;

import com.mvm.MVM.dto.UserDto;
import com.mvm.MVM.model.User;
import com.mvm.MVM.repository.UserRepository;
import com.mvm.MVM.service.CategoryService;
import com.mvm.MVM.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService; 

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userRegistration(@RequestBody UserDto user){
        userService.newUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/current_user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> currentUser(){
    	UserDto dto = new UserDto();
        return new ResponseEntity<>(dto.user2dto(userService.getCurrentUser()),HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserDto dto) {
    	User user = userService.findByUsername(dto.getUsername());
    	user.setCategory(categoryService.findByName(dto.getCategory()));
    	user.setName(dto.getName());
    	user.setPassword(dto.getPassword());
    	user.setUsername(dto.getUsername());
    	userService.save(user);
    	return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/sub", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> subUser(@RequestParam String token){
        userService.subscribeToTopic(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/unSub", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> unSubUser(@RequestParam String token){
        userService.unSubscribeToTopic(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
