package com.example.carpoolbuddy;

public class Vehicle {
    private String model;
    private int maxCapacity;
    private String owner;
    private int rating;

    public Vehicle() {

    }

    public Vehicle(String model, int maxCapacity, String owner, int rating) {
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.owner = owner;
        this.rating = rating;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
