package com.shoppingwithfriends.shoppingwithfriends;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


@SuppressWarnings("JavaDoc")
public class WelcomeScreen extends PlusBaseActivity {

    @Override
    protected void onPlusClientRevokeAccess() {

    }

    @Override
    protected void onPlusClientSignIn() {
    }

    @Override
    protected void onPlusClientSignOut() {

    }

    @Override
    protected void onPlusClientBlockingUI(boolean show) {

    }

    @Override
    protected void updateConnectButtonState() {

    }

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

    public void gPlusSignIn(View view) {
        signIn();
        signOut();
    }


    @Override
    public void onConnectionSuspended(int i) {

    }
}
