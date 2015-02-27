package com.shoppingwithfriends.shoppingwithfriends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainScreen extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, FriendListFragment.Callbacks, AddFriendFragment.Callbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        if (position == 1) { //goes to friend list
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new FriendListFragment())
                    .commit();
        } else if (position == 2) { //goes to add friend
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new AddFriendFragment())
                    .commit();
        } else if (position == 3) { //logs out
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new AddItemFragment())
                    .commit();
        } else if (position == 5) { //logs out
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new ItemListFragment())
                    .commit();
        } else if (position == 4) { //logs out
            logout();

        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = "Item List";
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main_screen, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void logout() {
        Intent logout = new Intent(this, LogoutActivity.class);
        startActivity(logout);
    }

    @Override
    public void onItemSelected(String task, int id) {
        //DatabaseHandler db = new DatabaseHandler(this);
        //if (task.equals("add"))
            //db.addFriend(User.currentUser, db.getUser(id));
    }

    public void removeFriend(View view) {
        DatabaseHandler db = new DatabaseHandler(this);
        //removes the friend from the database
        db.deleteFriend(User.currentUser, FriendDetailFragment.user);
        db.close();

        //goes to friend list fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, new FriendListFragment())
                .commit();
    }

    /**
     * Adds a new item request the user
     * @param view the item request view
     */
    public void addItemRequest(View view) {
        //Button button = (Button) findViewById(R.id.button);
        EditText nameText = (EditText) findViewById(R.id.editText);
        EditText priceText = (EditText) findViewById(R.id.editText2);
        EditText locText = (EditText) findViewById(R.id.editText4);

        DatabaseHandler db = new DatabaseHandler(this);
        String name = nameText.getText().toString();
        String price = priceText.getText().toString();
        String location = locText.getText().toString();
        EditText mNameView = (EditText) findViewById(R.id.editText);
        EditText mPriceView = (EditText) findViewById(R.id.editText2);
        if (name.equals("") || price.equals("")) {
            mNameView.setError("Name and price must be completed");
            mNameView.requestFocus();
        } else if (!isNumber(price)) {
            mPriceView.setError("Price must be an integer");
            mPriceView.requestFocus();
        } else {

            ItemRequest item = new ItemRequest(User.currentUser, name,
                    Integer.parseInt(price), location);
            db.addItemRequest(item);

            db.close();

            gotoMainScreen(getWindow().getDecorView().findViewById(android.R.id.content));
        }
    }
//    public void removeItem(View view) {
//        DatabaseHandler db = new DatabaseHandler(this);
//        //removes the friend from the database
//        db.deleteFriend(User.currentUser, FriendDetailFragment.user);
//        db.close();
//
//        //goes to friend list fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, new FriendListFragment())
//                .commit();
//    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Returns to the Welcome Screen if user decides to cancel registration
     * @param view the registration view
     */
    public void gotoMainScreen(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}