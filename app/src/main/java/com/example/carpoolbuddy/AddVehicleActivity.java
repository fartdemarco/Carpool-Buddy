package com.example.carpoolbuddy;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText owner;
    private EditText model;
    private EditText capacity;
    private EditText rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        owner = findViewById(R.id.ownerInput);
        model = findViewById(R.id.modelInput);
        capacity = findViewById(R.id.capacityInput);
        rating = findViewById(R.id.ratingInput);

    }

    public void addVehicle(View v) {
        String owner = this.owner.getText().toString();
        String model = this.model.getText().toString();
        int capacity = parseInt(this.capacity.getText().toString());
        int rating = parseInt(this.rating.getText().toString());

        Vehicle newVehicle = new Vehicle(model, capacity, owner, rating);
        firestore.collection("vehicles").document().set(newVehicle);

    }
}