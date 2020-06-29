package com.mvm.MVM.dto;

import com.mvm.MVM.model.User;

public class UserDto {

	private String id;
	
    private String username;

    private String name;

    private String password;

    private String category;

    public UserDto(){

    }

    public UserDto user2dto(User user) {
    	this.setId(user.getId().toString());
    	this.setCategory(user.getCategory().getName());
    	this.setName(user.getName());
    	this.setPassword(user.getPassword());
    	this.setUsername(user.getUsername());
    	return this;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
