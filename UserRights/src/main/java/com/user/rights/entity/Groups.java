package com.user.rights.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "groups")
public class Groups {


    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, targetEntity=Groups.class)
    @JoinColumn(name="id")
    private List<User> user;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, targetEntity=Groups.class)
    @JoinColumn(name="id")
    private List<Rights> rights;


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

    public List<User> getUser() {
        return user;
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
}
