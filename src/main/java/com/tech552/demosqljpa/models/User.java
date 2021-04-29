package com.tech552.demosqljpa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// https://www.baeldung.com/jpa-joincolumn-vs-mappedby
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    //USER AND USER ROLE RELATIONSHIP

    //One user can have many user roles - eg: I can be a user and an Admin in the application
    //MappedBy - use the property name (user) from the UserRole pojo

    //Cascade - specifies what will happen to the roles that are attached to the user, if the user is deleted
    //FetchType - how we want it to be loaded
    // - Lazy: we do not want to be loaded immediately - cos user can have 100's of post ..that we need loaded
    // - Eager: we want it to load immediately - cos user roles are not that many
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post>posts;

    public User() {
    }

    public User(Integer id, String username, Set<UserRole> userRoles, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.userRoles = userRoles;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
