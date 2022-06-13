package com.example.carpoolbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.carpoolbuddy.Models.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class VehiclesInfoActivity extends AppCompatActivity implements MyAdapter.OnVehicleListener {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private RecyclerView recyclerView;
    private Spinner userRoleSpinner;
    private String selectedRole;


    //added for testing
    private ArrayList<Vehicle> vehiclesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_info);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.RecyclerView);

        userRoleSpinner = findViewById(R.id.spinner2);


        vehiclesList = new ArrayList<Vehicle>();

        setupSpinner();


        //added for testing
    }

    private void setupSpinner() {
        String[] vehicleTypes = {"All", "Car", "Electric Car", "Motorbike"};
        // add user types to spinner
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(VehiclesInfoActivity.this,
                android.R.layout.simple_spinner_item, vehicleTypes);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userRoleSpinner.setAdapter(langArrAdapter);

        //triggered whenever user selects something different
        userRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedRole = parent.getItemAtPosition(position).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void addFields() {
        recyclerView.removeAllViewsInLayout();
        if(selectedRole.equals("All")) {
            testDB("All");
        }
        if(selectedRole.equals("Car")) {
            testDB("Car");
        }
        if(selectedRole.equals("Electric Car")) {
            testDB("Electric Car");
        }
        if(selectedRole.equals("Motorbike")) {
            testDB("Motorbike");
        }
    }

    public void testDB(String type) {
        vehiclesList.clear();
        TaskCompletionSource<String> getAllRidesTask = new TaskCompletionSource<>();
        firestore.collection(Constants.VEHICLE_COLLECTION).whereEqualTo("open", true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if(selectedRole.equals("All")) {
                            vehiclesList.add(document.toObject(Vehicle.class));
                        }
                        else if(selectedRole.equals(type)){
                            if(document.toObject(Vehicle.class).getType().equals(type)) {
                                vehiclesList.add(document.toObject(Vehicle.class));
                            }
                        }
                    }
                    getAllRidesTask.setResult(null);
                }
                else {
                    Log.d("VehiclesInfoActivity", "Error getting documents from db: ", task.getException());
                }
            }
        });
        // when all rides have been retrieved, update RecyclerView
        getAllRidesTask.getTask().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                System.out.println("VEHICLE INFO: " + vehiclesList.toString());
                MyAdapter myAdapter = new MyAdapter(vehiclesList, VehiclesInfoActivity.this);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(VehiclesInfoActivity.this));
            }
        });
    }

    public void gotoUserProfile(View v) {
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void onVehicleClick(int position) {
        vehiclesList.get(position);
        Intent intent = new Intent(this, VehicleProfileActivity.class);
        intent.putExtra("selected vehicle", vehiclesList.get(position));
        startActivity(intent);
    }
}