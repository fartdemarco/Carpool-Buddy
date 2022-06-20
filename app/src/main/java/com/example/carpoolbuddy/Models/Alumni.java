package com.example.carpoolbuddy.Models;

/**
 * The type Alumni.
 */
public class Alumni extends User {

    private int gradYear;

    /**
     * Instantiates a new Alumni.
     */
    public Alumni() {

    }

    /**
     * Instantiates a new Alumni.
     *
     * @param uid      the uid
     * @param name     the name
     * @param email    the email
     * @param gradYear the grad year
     */
    public Alumni(String uid, String name, String email, int gradYear) {
        super(uid, name, email);
        this.gradYear = gradYear;
    }

    /**
     * Gets grad year.
     *
     * @return the grad year
     */
    public int getGradYear() {
        return gradYear;
    }

    /**
     * Sets grad year.
     *
     * @param gradYear the grad year
     */
    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
}
