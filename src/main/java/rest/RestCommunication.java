
package rest;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.User;

/**
 * Takes credentials from the controller and sends them over to the server and returns a Response
 * @author Emil
 */
public class RestCommunication {

    private static final String BASE_URL = "http://localhost:8080/RecruitmentServ/webresources";
    private static final String AUTH_PATH = "auth";
    private static final String LOGIN_PATH = "login";
    private static final String REGISTER_PATH = "register";
    private static final String LOGOUT_PATH = "logout";
    private static final String AUTHORIZATION_SCHEMA = "Bearer ";

 
    /**
     * This method sends a login json object to the remote server to login the
     * user.
     *
     * @param user  the username as entered by user
     * @param pass  the password as entered by user
     * @return Response the servers response to the login attempt.
     */
    public static Response login(String user, String pass) {
        Invocation.Builder request = getRequestToPath(Arrays.asList(AUTH_PATH, LOGIN_PATH));
        User newUser = new User(user, pass);
        return request.post(Entity.entity(newUser, MediaType.APPLICATION_JSON));
    }
    
    

    /**
     * This method sends a register json object to the remote server to try to
     * register a new user.
     *
     * @param json registration credentials sent to the server.
     * @return Response with the registration attempt.
     */
    public static Response register(User json) {
        Invocation.Builder request = getRequestToPath(Arrays.asList(AUTH_PATH, REGISTER_PATH));
        return request.post(Entity.entity(json, MediaType.APPLICATION_JSON));
    }

    /**
     * Adds token to target header for user validation in server side.
     *
     * @param target Invocation target
     * @return target with token
     */
    private static Invocation.Builder addAuthorizationHeader(Invocation.Builder target) {
        String token;
        try {
            token = "hello";
        } catch (Exception ex) {
            token = "";
        }

        return target.header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_SCHEMA + token);
    }

    /**
     * This method sends a logout request to the remote server.
     *
     * @return Response with the remote server status report.
     */
    public static Response logout() {
        Invocation.Builder request = getRequestToPath(Arrays.asList(AUTH_PATH, LOGOUT_PATH));
        request = addAuthorizationHeader(request);
        Response logoutResponse = request.get();
        
        return logoutResponse;
    }

    /**
     * Build a new webtarget with provides base url and inner paths.
     *
     * @param paths inner paths
     * @return reequested webtarget
     */
    private static Invocation.Builder getRequestToPath(List<String> paths) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL);

        for (String path : paths) {
            target = target.path(path);
        }

        return target.request();
    }
}
