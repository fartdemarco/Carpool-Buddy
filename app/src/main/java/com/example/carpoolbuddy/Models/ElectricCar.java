package com.example.carpoolbuddy.Models;

/**
 * The type Electric car.
 */
public class ElectricCar extends Vehicle {

    /**
     * Instantiates a new Electric car.
     */
    public ElectricCar() {

    }

    /**
     * Instantiates a new Electric car.
     *
     * @param owner     the owner
     * @param model     the model
     * @param capacity  the capacity
     * @param id        the id
     * @param basePrice the base price
     * @param type      the type
     */
    public ElectricCar(String owner, String model, int capacity, String id, double basePrice, String type) {
        super(owner, model, capacity, id, basePrice, type);
    }
}
