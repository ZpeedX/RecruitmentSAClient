
package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for a User object which contains the user credentials for either a user trying to log in or
 * one trying to register.
 * @author Emil
 */
@XmlRootElement
public class User {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String ssn;
    private String email;
    
    /**
     * Created a user from a username and a password used for logging on
     * @param username  entered username
     * @param password  entered password
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    /**
     * Created a user fom all the available fields for registering
     * @param username  entered username
     * @param password  entered password
     * @param name      entered first name
     * @param surname   entered surname
     * @param ssn       entered social security number
     * @param email     entered email address
     */
    public User(String username, String password, String name, String surname, String ssn, String email){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.email = email;
    }
    /**
     * Returns the entered username.
     * @return entered username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Sets the username
     * @param username entered username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Returns the entered password
     * @return entered password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the entered password
     * @param password entered password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Sets the entered first name
     * @return entered first name
     */
    public String getName() {
        return name;
    }
    /**
     * Set the first name
     * @param name the entered name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the entered surname
     * @return entered surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Sets the surname
     * @param surname the entered surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Returns the entered social security number
     * @return entered social security number
     */
    public String getSsn() {
        return ssn;
    }
    /**
     * Sets the social security number
     * @param ssn entered social security number
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    /**
     * Returns the entered email adrress
     * @return entered email address
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the email address
     * @param email entered email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
