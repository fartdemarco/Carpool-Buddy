package com.example.carpoolbuddy.Models;

import com.example.carpoolbuddy.Models.User;

public class Student extends User {
    private int gradeLevel;

    public Student() {

    }

    public Student(String uid, String name, String email, int gradeLevel) {
        super(uid, name, email);
        this.gradeLevel = gradeLevel;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
