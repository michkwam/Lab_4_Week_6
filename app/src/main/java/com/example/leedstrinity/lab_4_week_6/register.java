package com.example.leedstrinity.lab_4_week_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;

public class register extends AppCompatActivity {

    private TextView userAuthApp, login;
    private EditText regEmail, regPassword, fullName, regPhone;
    private Button registerBtn;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        fullName = findViewById(R.id.fullName);
        regEmail = findViewById(R.id.register_email);
        regPassword = findViewById(R.id.register_password);
        regPhone = findViewById(R.id.register_phone);
        registerBtn = findViewById(R.id.register_Btn);
        login = findViewById(R.id.login_User);
        progressbar = findViewById(R.id.progressBar);
        userAuthApp = findViewById(R.id.loginAuth_reg);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginPage = new Intent(register.this, login.class);
                startActivity(loginPage);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });


    }


    private void registerUser(){

        String name, email, password, phone;
        name = fullName.getText().toString();
        email = regEmail.getText().toString();
        password = regPassword.getText().toString();
        phone = regPhone.getText().toString();

        progressbar.setVisibility(View.VISIBLE);

        if (name.isEmpty()) {
            fullName.setError("Name is required");
            fullName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            regEmail.setError("Email is required");
            regEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            regPassword.setError("Password is required");
            regPassword.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            regPhone.setError("Phone is required");
            regPhone.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Account " + email + " Registed!", Toast.LENGTH_LONG).show();
                            progressbar.setVisibility(View.GONE);

                            Intent loginPage = new Intent(register.this, MainActivity.class);
                            startActivity(loginPage);
                        } else {
                            Toast.makeText(getApplicationContext(), "Unsuccessful registration! Check your credentials." , Toast.LENGTH_LONG).show();
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                }
        );

    }

}