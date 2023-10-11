/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Scanner;

/**
 * The type Teacher.
 *
 * @author GreenRain
 */
public class Teacher {

    private int teacher_id;
    private String fullname;
    private String gender;
    private String email;
    private String phoneNumber;

    /**
     * Instantiates a new Teacher.
     */
    public Teacher() {
    }

    /**
     * Instantiates a new Teacher.
     *
     * @param teacher_id  the teacher id
     * @param fullname    the fullname
     * @param gender      the gender
     * @param email       the email
     * @param phoneNumber the phone number
     */
    public Teacher(int teacher_id, String fullname, String gender, String email, String phoneNumber) {
        this.teacher_id = teacher_id;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Teacher.
     *
     * @param fullname    the fullname
     * @param gender      the gender
     * @param email       the email
     * @param phoneNumber the phone number
     */
    public Teacher(String fullname, String gender, String email, String phoneNumber) {
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets teacher id.
     *
     * @return the teacher id
     */
    public int getTeacher_id() {
        return teacher_id;
    }

    /**
     * Sets teacher id.
     *
     * @param teacher_id the teacher id
     */
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    /**
     * Gets fullname.
     *
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets fullname.
     *
     * @param fullname the fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
