package com.example.carpoolbuddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected TextView ownerText;
    protected TextView modelText;
    protected TextView capacityText;
    protected TextView priceText;

    MyAdapter.OnVehicleListener onVehicleListener;

    public MyViewHolder(@NonNull View itemView, MyAdapter.OnVehicleListener onVehicleListener) {
        super(itemView);

        ownerText = itemView.findViewById(R.id.OwnerTextView);
        modelText = itemView.findViewById(R.id.ModelTextView);
        capacityText = itemView.findViewById(R.id.CapacityTextView);
        priceText = itemView.findViewById(R.id.PriceTextView);
        this.onVehicleListener = onVehicleListener;

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onVehicleListener.onVehicleClick(getAdapterPosition());
    }
}
