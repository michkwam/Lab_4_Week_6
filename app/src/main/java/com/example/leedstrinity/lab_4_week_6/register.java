package com.example.leedstrinity.lab_4_week_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity {

    TextView userAuthApp, login;
    EditText email, password, fullName, phone;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        phone = findViewById(R.id.register_phone);
        registerBtn = findViewById(R.id.register_Btn);
        login = findViewById(R.id.login_User);
        userAuthApp = findViewById(R.id.loginAuth_reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginPage = new Intent(register.this, login.class);
                startActivity(loginPage);
            }
        });
    }




}