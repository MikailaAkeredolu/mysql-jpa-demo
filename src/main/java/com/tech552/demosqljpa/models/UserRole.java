package com.tech552.demosqljpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//The class between the user and the role

@Entity
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRoleId;

    //BI-DIRECTIONAL OR TWO WAY RELATIONSHIP
    // Reverse/Other side of the relationship gets the many to one  - because many userRoles CAN belong to one user
                        //MappedBy - relationship between a (user) and the (userRole)
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore  //User HAS A UserRole AND UserRole has a User - will create infinite loop so we add JSONIgnore
    private User user;


    //One userRole can have Many roles
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    private UserRole(){}

    public UserRole(Integer userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
