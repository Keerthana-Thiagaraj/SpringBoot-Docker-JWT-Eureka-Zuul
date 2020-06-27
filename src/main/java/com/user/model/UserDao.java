package com.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "userdetails")
public class UserDao {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    public UserDao() {
    }

    public UserDao(Integer id, String username, String password) {
        super();
        this.userid = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return userid;
    }

    public void setId(Integer id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
