package com.user.rights.dto;

import com.user.rights.entity.Rights;
import com.user.rights.entity.User;


public class GroupsDTO {

    private Long id;

    private String name;

    private User user;

    private Rights right;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rights getRight() {
        return right;
    }

    public void setRight(Rights right) {
        this.right = right;
    }
}
