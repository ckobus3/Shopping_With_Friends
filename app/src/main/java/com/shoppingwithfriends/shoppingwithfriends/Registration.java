package com.shoppingwithfriends.shoppingwithfriends;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends ActionBarActivity {

    SharedPreferences sharedPreferences;
    Editor editor;
    Button buttonReg2;
    EditText txtUsername, txtPassword, txtEmail;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        txtUsername = (EditText) findViewById(R.id.Name);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.Email);
        buttonReg2 = (Button) findViewById(R.id.buttonReg2);

// creating an shared Preference file for the information to be stored
// first argument is the name of file and second is the mode, 0 is private mode

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
// get editor to edit in file
        editor = sharedPreferences.edit();

        buttonReg2.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {
                String name = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();

                if(txtUsername.getText().length()<=0){
                    Toast.makeText(Registration.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if( txtEmail.getText().length()<=0){
                    Toast.makeText(Registration.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                else if( txtPassword.getText().length()<=0){
                    Toast.makeText(Registration.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else{

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Email",email);
                    editor.putString("txtPassword",pass);
                    editor.commit();}   // commit the values

                // after saving the value open next activity
                Log.d("d", name + pass);
                Intent ob = new Intent(Registration.this, LoginActivity.class);
                startActivity(ob);

            }
        });
    }
}