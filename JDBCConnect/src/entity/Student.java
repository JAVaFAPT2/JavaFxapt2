/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * @author To Hoang Anh
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String email;
    private String dob;
    private String address;
    private String phone;
    private double avgMark;


    public Student() {
    }

    public Student(int id, String name, int age, String email, String dob, String address, String phone, double avgMark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.avgMark = avgMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }
}


