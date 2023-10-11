/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


public class Classes {
    private int class_id;
    private String class_name;

    /**
     * Instantiates a new Classes.
     *
     * @param class_id   the class id
     * @param class_name the class name
     */
    public Classes(int class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    /**
     * Instantiates a new Classes.
     */
    public Classes() {
    }

    /**
     * Instantiates a new Classes.
     *
     * @param class_name the class name
     */
    public Classes(String class_name) {
        this.class_name = class_name;
    }

    /**
     * Gets class id.
     *
     * @return the class id
     */
    public int getClass_id() {
        return class_id;
    }

    /**
     * Sets class id.
     *
     * @param class_id the class id
     */
    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    /**
     * Gets class name.
     *
     * @return the class name
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * Sets class name.
     *
     * @param class_name the class name
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    
    
}
