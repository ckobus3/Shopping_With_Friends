package com.shoppingwithfriends.shoppingwithfriends;

/**
 * Created by JohnSnow on 3/5/2015.
 */
public class ItemReport {
    private int reporterId;
    private User reporter;
    private String name;
    private int price;
    private String location;

    public ItemReport() {
    }
    // this takes in the User, name, price and location of the item
    // and add it to the item list
    public ItemReport(User user, String name, int price, String location) {
        this.reporter = user;
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public int getRequestId() {
        return reporterId;
    } // returns user ID

    public void setRequestId(int id) {
        this.reporterId = id;
    }

    public User getRequester() {
        return reporter;
    }

    public void setRequester(User user) {
        this.reporter = user;
    }

    public String getName() {
        return name;
    } // returns name

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPrice() {
        return price;
    } // return price

    public void setMaxPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    } // return location of the item

    public void setLocation(String loc) {
        this.location = loc;
    }


}
