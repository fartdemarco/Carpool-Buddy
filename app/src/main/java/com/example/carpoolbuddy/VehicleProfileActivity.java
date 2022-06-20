package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carpoolbuddy.Models.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * The type Vehicle profile activity.
 */
public class VehicleProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Vehicle Activity";

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private TextView model;
    private TextView owner;
    private TextView capacity;
    private TextView price;
    private Vehicle vehicle;
    private Button buttonReserveRide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


        if(getIntent().hasExtra("selected vehicle")) {
            vehicle = getIntent().getParcelableExtra("selected vehicle");
            Log.d(TAG, "onCreate: "+ vehicle.toString());

            model = (TextView) findViewById(R.id.textViewModel);
            owner = (TextView) findViewById(R.id.textViewOwner);
            capacity = (TextView) findViewById(R.id.textViewCapacity);
            price = (TextView) findViewById(R.id.textViewPrice);

            model.setText("Model: "+vehicle.getModel());
            owner.setText("Owner: "+vehicle.getOwner());
            capacity.setText("Capacity: "+String.valueOf(vehicle.getMaxCapacity()));
            price.setText("Base price: "+String.valueOf(vehicle.getBasePrice()));
        }
        buttonReserveRide = findViewById(R.id.bookRideButton);


    }

    /**
     * Book a ride.
     */
    public void bookARide()
    {//close vehicle if user took last seat available
        if(vehicle.getMaxCapacity() == 1) {
            firestore.collection("vehicles").document(vehicle.getId())
                    .update("open", false);
        }

        // update capacity
        firestore.collection("vehicles").document(vehicle.getId())
                .update("maxCapacity", vehicle.getMaxCapacity() - 1);

        // add user's uid to the list of reservedUids
        vehicle.addReservedUid(mAuth.getUid());
        firestore.collection("vehicles").document(vehicle.getId())
                .update("reservedUids", vehicle.getReservedUids())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // go back to VehiclesInfoActivity
                        Intent intent = new Intent(getApplicationContext(), VehiclesInfoActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        // right here
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == buttonReserveRide.getId()) {
            bookARide();
        }
        /*
        else if(i == buttonCancelRide.getID()) {
            cancelRide();
        }
        */
    }
}