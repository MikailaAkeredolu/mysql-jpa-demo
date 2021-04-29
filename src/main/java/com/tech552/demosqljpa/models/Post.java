package com.tech552.demosqljpa.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // primary key

    private String username;

    private Date date;


// POST AND COMMENTS RELATIONSHIP
    //Cascade.All - when we save a post we also save a comment and vice versa
    //Eager - when we fetch the post, we also want all the comments associated with that post
    // @JoinColumn - Join the Post and comment table and add a new column / foreign key to the comments table
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<Comment> commentList;

    public Post() {
    }

    public Post(Integer id, String username, Date date, List<Comment> commentList) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
