package data;

import java.util.Objects;

/**
 * User class
 */
public class User {
    String username;
    String password;
    String name;
    int CIN;
    char gender;
    boolean isAdmin;

    public User() {

    }

    public User(String username, String password, String name, int CIN, char gender){
        this.username = username;
        this.password = password;
        this.name = name;
        this.CIN = CIN;
        this.gender = gender;
        this.isAdmin = false;
    }

    public User(String username, String password, String name, int CIN, char gender, boolean isAdmin){
        this.username = username;
        this.password = password;
        this.name = name;
        this.CIN = CIN;
        this.gender = gender;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin() {
        isAdmin = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o){
        User otherUser = (User) o;
        if(CIN == otherUser.getCIN())
            return true;
        return false;
    }

}
