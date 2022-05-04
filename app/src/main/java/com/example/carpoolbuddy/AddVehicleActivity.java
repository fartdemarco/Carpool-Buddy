package com.example.carpoolbuddy;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.carpoolbuddy.Models.Car;
import com.example.carpoolbuddy.Models.ElectricCar;
import com.example.carpoolbuddy.Models.Motorbike;
import com.example.carpoolbuddy.Models.Vehicle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddVehicleActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText ownerField;
    private EditText modelField;
    private EditText capacityField;
    private EditText basePriceField;

    private LinearLayout layout;
    private Spinner vehicleTypeSpinner;
    private String selectedType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        layout = findViewById(R.id.linearLayoutCreateVehicle);
        vehicleTypeSpinner = findViewById(R.id.selectVechicleTypeSpinner);
        setupSpinner();


    }

    private void setupSpinner() {
        String[] vehicleTypes = {Constants.CAR, Constants.ELECTRIC_CAR, Constants.MOTOR_BIKE};
        // add user types to spinner
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(AddVehicleActivity.this,
                android.R.layout.simple_spinner_item, vehicleTypes);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(langArrAdapter);

        //triggered whenever user selects something different
        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedType = parent.getItemAtPosition(position).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void addFields() {
        commonFields();
        if(!selectedType.equals(Constants.MOTOR_BIKE)) {
            capacityField = new EditText(this);
            capacityField.setHint(Constants.CAPACITY_HINT);
            layout.addView(capacityField);
        }
    }

    public void commonFields() {
        layout.removeAllViewsInLayout();
        ownerField = new EditText(this);
        ownerField.setHint(Constants.OWNER_HINT);
        layout.addView(ownerField);
        modelField = new EditText(this);
        modelField.setHint(Constants.MODEL_HINT);
        layout.addView(modelField);
        basePriceField = new EditText(this);
        basePriceField.setHint(Constants.BASE_PRICE_HINT);
        layout.addView(basePriceField);
    }

    public void createVehicle(View v) {
        //generate + get new key
        DocumentReference newRideRef = firestore.collection(Constants.VEHICLE_COLLECTION).document();
        String vehicleId = newRideRef.getId();

        //make new vehicle according to selected vehicle type
        Vehicle newVehicle = null;

        //get data from form
        String ownerString = ownerField.getText().toString();
        String modelString = modelField.getText().toString();
        double basePriceDouble = Double.parseDouble(basePriceField.getText().toString());

        //check which type of vehicle was created
        if(selectedType.equals(Constants.CAR)) {
            int capacityInt = Integer.parseInt(capacityField.getText().toString());
            newVehicle = new Car(ownerString, modelString, capacityInt, vehicleId, basePriceDouble);
        }
        else if(selectedType.equals(Constants.ELECTRIC_CAR)) {
            int capacityInt = Integer.parseInt(capacityField.getText().toString());
            newVehicle = new ElectricCar(ownerString, modelString, capacityInt, vehicleId, basePriceDouble);
        }
        else if(selectedType.equals(Constants.MOTOR_BIKE)) {
            newVehicle = new Motorbike(ownerString, modelString, 2, vehicleId, basePriceDouble);
        }

        //add the new vehicle to the database
        newRideRef.set(newVehicle);

        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

//    public void addVehicle(View v) {
//        String owner = this.owner.getText().toString();
//        String model = this.model.getText().toString();
//        int capacity = parseInt(this.capacity.getText().toString());
//        int rating = parseInt(this.rating.getText().toString());
//
//        Vehicle newVehicle = new Vehicle(model, capacity, owner, rating);
//        firestore.collection("vehicles").document().set(newVehicle);
//
//    }
}