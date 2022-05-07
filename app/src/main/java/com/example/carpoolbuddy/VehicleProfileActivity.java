package com.example.carpoolbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.carpoolbuddy.Models.Vehicle;

public class VehicleProfileActivity extends AppCompatActivity {
    private static final String TAG = "Vehicle Activity";

    private TextView model;
    private TextView owner;
    private TextView capacity;
    private TextView price;
    private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);

        model = (TextView) findViewById(R.id.textViewModel);
        owner = (TextView) findViewById(R.id.textViewOwner);
        capacity = (TextView) findViewById(R.id.textViewCapacity);
        price = (TextView) findViewById(R.id.textViewPrice);

        if(getIntent().hasExtra("selected vehicle")) {
            vehicle = getIntent().getParcelableExtra("selected vehicle");
            Log.d(TAG, "onCreate: "+ vehicle.toString());

            model.setText(vehicle.getModel());
            owner.setText(vehicle.getOwner());
            capacity.setText(vehicle.getMaxCapacity());
            price.setText(String.valueOf(vehicle.getBasePrice()));
        }

    }
}