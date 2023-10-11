/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 * The type User.
 *
 * @author GreenRain
 */
public class User {
    private int id;
    private int user_id;
    private String username;
    private String password;
    private int role;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param user_id  the user id
     * @param username the username
     * @param password the password
     * @param role     the role
     */
    public User(int id, int user_id, String username, String password, int role) {
        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Instantiates a new User.
     *
     * @param user_id  the user id
     * @param username the username
     * @param password the password
     * @param role     the role
     */
    public User(int user_id, String username, String password, int role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets user id.
     *
     * @param user_id the user id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(int role) {
        this.role = role;
    }

}
