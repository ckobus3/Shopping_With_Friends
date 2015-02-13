package com.shoppingwithfriends.shoppingwithfriends;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private ArrayList<User> friends;
    private static ArrayList<User> users;
    private int rating;
    private int numReports;
    private boolean isLocked;
    private boolean isAdmin;

    public User() {
    }

    public User(String name, String username, String pw, String email) {
        this.name = name;
        this.username = username;
        this.password = pw;
        this.email = email;
    }

    public User(int id, String name, String username, String pw, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = pw;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

//    public ArrayList<User> getFriends() {
//        return friends;
//    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String un) {
        this.username = un;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }



//name, email, rating, num sell reports generated
    //username, password, locked out, friends, admin
}
