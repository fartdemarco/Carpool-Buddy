package com.example.carpoolbuddy.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * The type Vehicle.
 */
public class Vehicle implements Parcelable {
    private String owner;
    private String model;
    private int maxCapacity;
    private String id;
    private double basePrice;
    private String type;
    private boolean open;
    private ArrayList<String> reservedUids;

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {

    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param owner       the owner
     * @param model       the model
     * @param maxCapacity the max capacity
     * @param id          the id
     * @param basePrice   the base price
     * @param type        the type
     */
    public Vehicle(String owner, String model, int maxCapacity, String id, double basePrice, String type) {
        this.owner = owner;
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.id = id;
        this.basePrice = basePrice;
        this.type = type;
        open = true;
        reservedUids = new ArrayList<>();
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param in the in
     */
    protected Vehicle(Parcel in) {
        owner = in.readString();
        model = in.readString();
        maxCapacity = in.readInt();
        id = in.readString();
        basePrice = in.readDouble();
        type = in.readString();
        open = in.readByte() != 0;
        reservedUids = in.createStringArrayList();
    }

    /**
     * The constant CREATOR.
     */
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

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets max capacity.
     *
     * @return the max capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets max capacity.
     *
     * @param maxCapacity the max capacity
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets base price.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Gets reserved uids.
     *
     * @return the reserved uids
     */
    public ArrayList<String> getReservedUids() {
        return reservedUids;
    }

    /**
     * Sets reserved uids.
     *
     * @param reservedUids the reserved uids
     */
    public void setReservedUids(ArrayList<String> reservedUids) {
        this.reservedUids = reservedUids;
    }

    /**
     * Add reserved uid.
     *
     * @param string the string
     */
    public void addReservedUid(String string) {
        this.reservedUids.add(string);
    }

    /**
     * Sets base price.
     *
     * @param basePrice the base price
     */
    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Is open boolean.
     *
     * @return the boolean
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Sets open.
     *
     * @param open the open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
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
        dest.writeString(type);
        dest.writeByte((byte) (open ? 1 : 0));
        dest.writeStringList(reservedUids);
    }
}
