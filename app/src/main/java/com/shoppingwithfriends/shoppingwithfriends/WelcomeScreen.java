package com.shoppingwithfriends.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class WelcomeScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * Returns to Login view upon cancel
     * @param view
     */
    public void gotoLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Goes to UserRegistration screen
     * @param view
     */
    public void gotoRegistration(View view) {
        Intent intent = new Intent(this, UserRegistration.class);
        startActivity(intent);
    }

    
}
