package com.example.leedstrinity.lab_4_week_6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    TextView fullName, email, phone;

    ImageView profilePic;
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    String userID;

    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = findViewById(R.id.userPhoneNumber);
        fullName = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);
        // instantiate objects
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        profilePic = findViewById(R.id.imageView);
        logout = findViewById(R.id.logOut);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPage = new Intent(MainActivity.this, login.class);
                startActivity(registerPage);
            }
        });

        DocumentReference documentReference = fstore.collection("user").document(userID);
        //Snap shot listener
        documentReference.addSnapshotListener(this,
                new EventListener<DocumentSnapshot>(){
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e){
                        phone.setText(documentSnapshot.getString("phone"));
                        fullName.setText(documentSnapshot.getString("fName"));
                        email.setText(documentSnapshot.getString("email"));
                        profilePic.setImageResource(R.drawable.imge);
                    }
                });

        // Use get methods
    }


}