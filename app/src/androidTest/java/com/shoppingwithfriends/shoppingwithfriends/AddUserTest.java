package com.shoppingwithfriends.shoppingwithfriends;

/**
* @author Youssef Hammoud
*/
import android.content.Context;
import android.test.AndroidTestCase;

@SuppressWarnings("ALL")
public class AddUserTest extends AndroidTestCase {
    Context c;
    DatabaseHandler friends = new DatabaseHandler(c);
    User us1 = new User("Youssef","yhh","yhh@gatech.edu", "pass");
    User us2 = new User("Colby", "co","co@gatech.edu","pass");

    public void testInsertUser() {
        friends.addUser(us1);
        friends.addUser(us2);
        assertEquals(2, friends.getUsersCount());
        assertEquals(us1.getName(), friends.getAllUsers().get(0));
        assertEquals(us2.getName(), friends.getAllUsers().get(1));
    }

}
