package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    private TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        welcome = findViewById(R.id.welcomeSign);
        welcome.setText(mUser.getDisplayName());

    }

    public void signOut(View v) {
        mAuth.signOut();
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
        finish();
    }

    public void seeVehicles(View v) {
        Intent intent = new Intent(this, VehiclesInfoActivity.class);
        startActivity(intent);
        finish();
    }

    public void addVehicles(View v) {
        Intent intent = new Intent(this, AddVehicleActivity.class);
        startActivity(intent);
        finish();
    }

}