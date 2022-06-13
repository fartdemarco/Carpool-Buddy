package com.example.carpoolbuddy;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpoolbuddy.Models.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {

    ArrayList<Vehicle> vehicleList;
    private OnVehicleListener mOnVehicleListener;

    public MyAdapter(ArrayList<Vehicle> data, OnVehicleListener onVehicleListener) {
        vehicleList = data;
        this.mOnVehicleListener = onVehicleListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);

        MyViewHolder holder = new MyViewHolder(myView, mOnVehicleListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ownerText.setText("Owner: "+vehicleList.get(position).getOwner());
        holder.modelText.setText("Model: "+vehicleList.get(position).getModel());
        holder.capacityText.setText("Capacity: "+String.valueOf(vehicleList.get(position).getMaxCapacity()));
        holder.priceText.setText("Price: "+String.valueOf(vehicleList.get(position).getBasePrice()));
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }


    public interface OnVehicleListener{
        void onVehicleClick(int position);
    }
}
