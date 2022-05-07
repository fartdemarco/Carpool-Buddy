package com.example.carpoolbuddy.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {
    private String owner;
    private String model;
    private int maxCapacity;
    private String id;
    private double basePrice;
    private boolean open;

    public Vehicle() {

    }

    public Vehicle(String owner, String model, int maxCapacity, String id, double basePrice) {
        this.owner = owner;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.id = id;
        this.basePrice = basePrice;
        open = true;
    }

    protected Vehicle(Parcel in) {
        owner = in.readString();
        model = in.readString();
        maxCapacity = in.readInt();
        id = in.readString();
        basePrice = in.readDouble();
        open = in.readByte() != 0;
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setRating(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                ", model='" + model + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", id='" + id + '\'' +
                ", basePrice=" + basePrice +
                ", open=" + open +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(owner);
        dest.writeString(model);
        dest.writeInt(maxCapacity);
        dest.writeString(id);
        dest.writeDouble(basePrice);
        dest.writeByte((byte) (open ? 1 : 0));
    }
}
