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

public class login extends AppCompatActivity {

    private TextView userAuthApp, createNewUser, loginCreateNewUser;
    private EditText logEmail, logPassword;
    private Button login;
    private ProgressBar progressbar_login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        createNewUser = findViewById(R.id.createNewAcc_title);
        userAuthApp = findViewById(R.id.loginAuth);
        logEmail = findViewById(R.id.login_email);
        logPassword = findViewById(R.id.login_password);
        login = findViewById(R.id.loginBtn);
        loginCreateNewUser = findViewById(R.id.loginCreateNewUser);
        progressbar_login = findViewById(R.id.progressBarLogin);

        loginCreateNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent loginPage = new Intent(login.this, register.class);
                startActivity(loginPage);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginAccount();
            }
        });
    }

    private void loginAccount(){

        String email, password;

        email = logEmail.getText().toString();
        password = logPassword.getText().toString();

        if (email.isEmpty()) {
            logEmail.setError("Email is required");
            logEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            logPassword.setError("Password is required");
            logPassword.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), email + " Logged!", Toast.LENGTH_LONG).show();
                            progressbar_login.setVisibility(View.GONE);

                            Intent loginPage = new Intent(login.this, MainActivity.class);
                            startActivity(loginPage);
                        } else {
                            Toast.makeText(getApplicationContext(), "Unsuccessful login! Check your credentials." , Toast.LENGTH_LONG).show();
                            progressbar_login.setVisibility(View.GONE);
                        }
                    }
                }
        );


    }
}