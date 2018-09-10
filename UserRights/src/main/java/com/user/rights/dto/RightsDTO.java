package com.user.rights.dto;

import com.user.rights.entity.Groups;

import java.util.TreeSet;

public class RightsDTO {

    private Long id;

    private String name;

    private TreeSet<Groups> groups = new TreeSet<>();

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

    public TreeSet<Groups> getGroups() {
        return groups;
    }

    public void setGroups(TreeSet<Groups> groups) {
        this.groups = groups;
    }
}
