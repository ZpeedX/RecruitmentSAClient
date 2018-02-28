
package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
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
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String name, String surname, String ssn, String email){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
