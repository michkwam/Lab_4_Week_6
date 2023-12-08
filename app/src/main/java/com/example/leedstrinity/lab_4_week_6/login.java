package com.example.leedstrinity.lab_4_week_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    TextView userAuthApp, createNewUser, loginCreateNewUser;
    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createNewUser = findViewById(R.id.createNewAcc_title);
        userAuthApp = findViewById(R.id.loginAuth);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.loginBtn);
        loginCreateNewUser = findViewById(R.id.loginCreateNewUser);

        loginCreateNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPage = new Intent(login.this, register.class);
                startActivity(registerPage);
            }
        });
    }
}