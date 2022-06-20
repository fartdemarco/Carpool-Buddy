package com.example.carpoolbuddy.Models;

import com.example.carpoolbuddy.Models.User;

/**
 * The type Student.
 */
public class Student extends User {
    private int gradeLevel;

    /**
     * Instantiates a new Student.
     */
    public Student() {

    }

    /**
     * Instantiates a new Student.
     *
     * @param uid        the uid
     * @param name       the name
     * @param email      the email
     * @param gradeLevel the grade level
     */
    public Student(String uid, String name, String email, int gradeLevel) {
        super(uid, name, email);
        this.gradeLevel = gradeLevel;
    }

    /**
     * Gets grade level.
     *
     * @return the grade level
     */
    public int getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Sets grade level.
     *
     * @param gradeLevel the grade level
     */
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
