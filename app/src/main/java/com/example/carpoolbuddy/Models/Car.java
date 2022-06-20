package com.example.carpoolbuddy.Models;


/**
 * The type Car.
 */
public class Car extends Vehicle {
    /**
     * Instantiates a new Car.
     */
    public Car() {

    }

    /**
     * Instantiates a new Car.
     *
     * @param owner     the owner
     * @param model     the model
     * @param capacity  the capacity
     * @param id        the id
     * @param basePrice the base price
     * @param type      the type
     */
    public Car(String owner, String model, int capacity, String id, double basePrice, String type) {
        super(owner, model, capacity, id, basePrice, type);
    }
}
