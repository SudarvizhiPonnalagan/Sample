package com.user.rights.dto;

import com.user.rights.entity.Rights;
import com.user.rights.entity.User;

import java.util.Date;
import java.util.List;


public class GroupsDTO {

    private Long id;

    private String name;

    private List<User> user;

    private List<Rights> rights;

    private Date createdDate;

    private Date updatedDate;

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

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Rights> getRights() {
        return rights;
    }

    public void setRights(List<Rights> rights) {
        this.rights = rights;
    }

    public List<User> getUser() {
        return user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
