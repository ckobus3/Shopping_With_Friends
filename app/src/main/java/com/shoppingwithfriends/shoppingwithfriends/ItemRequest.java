package com.shoppingwithfriends.shoppingwithfriends;


import android.support.v4.app.FragmentActivity;

public class ItemRequest {

    private int requestId;
    private User requester;
    private String name;
    private int maxPrice;
    private String location;
    public static ItemRequest currentItem;

    public ItemRequest(FragmentActivity activity) {
    }

    public ItemRequest(User user, String name, int price, String location) {
        this.requester = user;
        this.name = name;
        this.maxPrice = price;
        this.location = location;
    }

    public int getRequestId() {
        return requestId;
    }

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
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int price) {
        this.maxPrice = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }


}
