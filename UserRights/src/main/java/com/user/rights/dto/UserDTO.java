package com.user.rights.dto;

import com.user.rights.entity.Group;
import com.user.rights.entity.Rights;

public class UserDTO {

    private Long id;

    private String name;

    private Group group;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }
}
