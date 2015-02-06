package com.shoppingwithfriends.shoppingwithfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;


public class UserRegistration extends Activity {

    private Button button;
    private EditText nameText;
    private EditText unText;
    private EditText passText;
    public static HashMap<String, String> reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        if (reg == null)
            reg = new HashMap<>();
        button = (Button)findViewById(R.id.button);
        nameText = (EditText)findViewById(R.id.editText);
        unText = (EditText)findViewById(R.id.editText2);
        passText = (EditText)findViewById(R.id.editText3);
    }

    public void register(View view) {
        String name = nameText.getText().toString();
        String un = unText.getText().toString();
        String pass = passText.getText().toString();
        Intent intent = new Intent(this, WelcomeScreen.class);
        reg.put(un, pass);
        startActivity(intent);
    }

    public void gotoWelcomeScreen(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
    }

}