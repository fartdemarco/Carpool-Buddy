package com.example.carpoolbuddy;

import com.example.carpoolbuddy.ui.User;

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
