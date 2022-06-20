package com.example.carpoolbuddy.Models;

import com.example.carpoolbuddy.Models.User;

/**
 * The type Teacher.
 */
public class Teacher extends User {
    private String subject;

    /**
     * Instantiates a new Teacher.
     */
    public Teacher() {

    }

    /**
     * Instantiates a new Teacher.
     *
     * @param uid     the uid
     * @param name    the name
     * @param email   the email
     * @param subject the subject
     */
    public Teacher(String uid, String name, String email, String subject){
        super(uid, name, email);
        this.subject = subject;
    }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
