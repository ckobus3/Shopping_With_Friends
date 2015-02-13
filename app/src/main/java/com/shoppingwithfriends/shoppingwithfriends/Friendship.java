package com.shoppingwithfriends.shoppingwithfriends;


public class Friendship {

    private User baseUser;
    private User friend;

    public Friendship() {
    }

    public Friendship(User base, User friend) {
        this.baseUser = base;
        this.friend = friend;
    }

    public User getBase() {
        return baseUser;
    }

    public void setBase(User user) {
        this.baseUser = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

}
