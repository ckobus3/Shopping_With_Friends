package com.shoppingwithfriends.shoppingwithfriends;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    //private ArrayList<User> friends;
    private int rating;
    private int numReports;
    private boolean isLocked;
    private boolean isAdmin;

    public static User currentUser;

    public User() {
    }

    public User(String name, String username, String pw) {
        this.name = name;
        this.username = username;
        this.password = pw;
    }

    public User(int id, String name, String username, String pw, String email, int rating,
                int numReports, int isLocked, int isAdmin) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = pw;
        this.email = email;
        this.numReports = numReports;
        this.rating = rating;
        this.isLocked = isLocked == 1;
        this.isAdmin = isAdmin == 1;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getNumReports() {
        return numReports;
    }

    public void setNumReports(int numReports) {
        this.numReports = numReports;
    }
    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }



//name, email, rating, num sell reports generated
    //username, password, locked out, friends, admin
}
