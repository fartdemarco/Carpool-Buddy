package com.example.carpoolbuddy.Models;

public class Car extends Vehicle {
    public Car() {

    }

    public Car(String owner, String model, int capacity, String id, double basePrice) {
        super(owner, model, capacity, id, basePrice);
    }
}
