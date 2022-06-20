package com.example.carpoolbuddy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The type My view holder.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /**
     * The Owner text.
     */
    protected TextView ownerText;
    /**
     * The Model text.
     */
    protected TextView modelText;
    /**
     * The Capacity text.
     */
    protected TextView capacityText;
    /**
     * The Price text.
     */
    protected TextView priceText;

    /**
     * The On vehicle listener.
     */
    MyAdapter.OnVehicleListener onVehicleListener;

    /**
     * Instantiates a new My view holder.
     *
     * @param itemView          the item view
     * @param onVehicleListener the on vehicle listener
     */
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
