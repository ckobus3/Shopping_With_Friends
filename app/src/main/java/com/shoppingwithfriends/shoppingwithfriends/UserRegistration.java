package com.shoppingwithfriends.shoppingwithfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserRegistration extends Activity {

    private Button button;
    private EditText nameText;
    private EditText unText;
    private EditText passText;

    /**
     * Sets content, creates new HashMap if one doesn't exist
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        button = (Button)findViewById(R.id.button);
        nameText = (EditText)findViewById(R.id.editText);
        unText = (EditText)findViewById(R.id.editText2);
        passText = (EditText)findViewById(R.id.editText3);
    }

    /**
     * Registers the user
     * @param view the registration view
     */
    public void register(View view) {
        DatabaseHandler db = new DatabaseHandler(this);
        String name;
        if (nameText.getText() == null)
            name = "";
        else
            name = nameText.getText().toString();
        String un = unText.getText().toString();
        String pass = passText.getText().toString();
        EditText mUsernameView = (EditText) findViewById(R.id.editText2);
        if (db.checkUser(un)) {
            mUsernameView.setError("Username already exists");
            mUsernameView.requestFocus();
        } else {
            db.addUser(new User(name, un, pass));
            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);
        }
    }

    /**
     * Returns to the Welcome Screen if user decides to cancel registration
     * @param view the registration view
     */
    public void gotoWelcomeScreen(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
    }

}