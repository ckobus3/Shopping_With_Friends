package com.shoppingwithfriends.shoppingwithfriends;

/**
 * Created by nguyentuan1990 on 4/2/15.
 */
import android.test.AndroidTestCase;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("ALL")
public class Junit extends AndroidTestCase {
    ItemListFragment item = new ItemListFragment();
    List<Item> itemList = new ArrayList();
    List<String> itemNameList = new ArrayList();
        User us1 = new User("Tuan","tu","tu@gmail.com", "123");
        User us2 = new User("Colby", "co","co@gmail.com","123");
        Item i1 = new Item(us1, "pen",100,"Atlanta");
        Item i2 = new Item(us2, "pencil", 100, " New York");


    public void makeTestCase() {
        itemList.add(i1);
        itemList.add(i2);
    }
    public void testInsertUser() {
        makeTestCase();
        item.addItemRequest(itemList,itemNameList);
        assertEquals(2, itemList.size());
        assertEquals(2,itemNameList.size());
        assertEquals(i1.getName(),itemNameList.get(0));
        assertEquals(i2.getName(),itemNameList.get(1));
    }

}
