package com.user.rights.dto;

import com.user.rights.entity.Groups;
import com.user.rights.entity.Rights;

public class UserDTO {

    private Long id;

    private String name;

    private Groups group;

    private Rights rights;

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

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }
}
