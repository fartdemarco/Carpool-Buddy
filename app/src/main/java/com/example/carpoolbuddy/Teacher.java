package com.example.carpoolbuddy;

import com.example.carpoolbuddy.ui.User;

public class Teacher extends User {
    private String subject;

    public Teacher() {

    }

    public Teacher(String uid, String name, String email, String subject){
        super(uid, name, email);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
