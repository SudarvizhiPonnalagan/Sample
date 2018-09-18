package com.user.rights.dto;

import com.user.rights.entity.Groups;

import java.util.Date;

public class RightsDTO {

    private Long id;

    private String name;

    private Groups groups;

    private String description;

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

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
