package com.shoppingwithfriends.shoppingwithfriends;


public class Item {

    private int postId;
    private User poster;
    private String name;
    private int price;
    private String location;

    public Item() {
    }
    // this takes in the User, name, price and location of the item
    // and add it to the item list
    public Item(User user, String name, int price, String location) {
        this.poster = user;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public int getPostId() {
        return postId;
    } // returns user ID

    public void setPostId(int id) {
        this.postId = id;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User user) {
        this.poster = user;
    }

    public String getName() {
        return name;
    } // returns name

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    } // return price

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    } // return location of the item

    public void setLocation(String loc) {
        this.location = loc;
    }


}
