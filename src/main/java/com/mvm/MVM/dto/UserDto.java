package com.mvm.MVM;

import com.mvm.MVM.model.Category;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class UserDto {

    private String username;

    private String name;

    private String password;

    private String category;

    public UserDto(){

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
}
