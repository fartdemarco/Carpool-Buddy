package com.example.carpoolbuddy.Models;

public class Alumni extends User {

    private int gradYear;

    public Alumni() {

    }

    public Alumni(String uid, String name, String email, int gradYear) {
        super(uid, name, email);
        this.gradYear = gradYear;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }
}
