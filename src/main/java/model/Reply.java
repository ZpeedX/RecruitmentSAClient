
package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emil
 */
@XmlRootElement
public class Reply {
    private String error;
    private String token;
    private String role;
    
    public Reply(String error){
        this.error = error;
    }
    public Reply(String token, String role){
        this.token = token;
        this.role = role;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
