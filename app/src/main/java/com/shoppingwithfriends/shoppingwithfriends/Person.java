package com.shoppingwithfriends.shoppingwithfriends;

import java.util.ArrayList;

public class Person {
    private String name;
    private String username;
    private String password;
    private String email;
    private ArrayList<Person> friends;
    private static ArrayList<Person> users;
    private int rating;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Person> getFriends() {
        return friends;
    }

    public static ArrayList<Person> getUsers() {
        return users;
    }

//name, email, rating, num sell reports generated
    //username, password, locked out, friends, admin
}
