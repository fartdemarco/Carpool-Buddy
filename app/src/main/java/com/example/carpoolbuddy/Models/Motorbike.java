package com.example.carpoolbuddy.Models;

/**
 * The type Motorbike.
 */
public class Motorbike extends Vehicle{
    /**
     * Instantiates a new Motorbike.
     */
    public Motorbike() {

    }

    /**
     * Instantiates a new Motorbike.
     *
     * @param owner     the owner
     * @param model     the model
     * @param capacity  the capacity
     * @param id        the id
     * @param basePrice the base price
     * @param type      the type
     */
    public Motorbike(String owner, String model, int capacity, String id, double basePrice, String type) {
        super(owner, model, capacity, id, basePrice, type);
    }
}
