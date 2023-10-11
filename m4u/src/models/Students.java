/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Scanner;

/**
 * The type Students.
 *
 * @author GreenRain
 */
public class Students {

    private int student_id;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String birthday;
    private String gender;
    private String image_path;

    /**
     * Instantiates a new Students.
     */
    public Students() {
    }

    /**
     * Instantiates a new Students.
     *
     * @param student_id  the student id
     * @param fullname    the fullname
     * @param birthday    the birthday
     * @param gender      the gender
     * @param email       the email
     * @param phoneNumber the phone number
     * @param address     the address
     * @param image_path  the image path
     */
    public Students(int student_id, String fullname, String birthday, String gender, String email, String phoneNumber, String address, String image_path) {
        this.student_id = student_id;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.image_path = image_path;
    }

    /**
     * Instantiates a new Students.
     *
     * @param fullname    the fullname
     * @param email       the email
     * @param phoneNumber the phone number
     * @param address     the address
     * @param birthday    the birthday
     * @param gender      the gender
     * @param image_path  the image path
     */
    public Students(String fullname, String email, String phoneNumber, String address, String birthday, String gender, String image_path) {
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.image_path = image_path;
    }

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImage_path() {
        return image_path;
    }

    /**
     * Sets image path.
     *
     * @param image_path the image path
     */
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public int getStudent_id() {
        return student_id;
    }

    /**
     * Sets student id.
     *
     * @param student_id the student id
     */
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "student_id=" + student_id + ", fullname=" + fullname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", birthday=" + birthday + ", gender=" + gender + ", image_path=" + image_path;
    }

    

}
