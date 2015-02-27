package com.shoppingwithfriends.shoppingwithfriends;


public class ItemRequest {

    private int requestId;
    private User requester;
    private String name;
    private int maxPrice;
    private String location;

    public ItemRequest() {
    }
    // this takes in the User, name, price and location of the item
    // and add it to the item list
    public ItemRequest(User user, String name, int price, String location) {
        this.requester = user;
        this.name = name;
        this.maxPrice = price;
        this.location = location;
    }

    public int getRequestId() {
        return requestId;
    } // returns user ID

    public void setRequestId(int id) {
        this.requestId = id;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User user) {
        this.requester = user;
    }

    public String getName() {
        return name;
    } // returns name

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPrice() {
        return maxPrice;
    } // return price

    public void setMaxPrice(int price) {
        this.maxPrice = price;
    }

    public String getLocation() {
        return location;
    } // return location of the item

    public void setLocation(String loc) {
        this.location = loc;
    }


}
