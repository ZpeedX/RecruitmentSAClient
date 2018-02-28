/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.ByteArrayOutputStream;
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
import model.Reply;
import model.User;

/**
 *
 * @author Emil
 */
public class RestCommunication {

    private static final String BASE_URL = "http://localhost:8080/RecruitmentServ/webresources";
    private static final String AUTH_PATH = "auth";
    private static final String LOGIN_PATH = "login";
    private static final String REGISTER_PATH = "register";
    private static final String LOGOUT_PATH = "logout";
    private static final String AUTHORIZATION_SCHEMA = "Bearer ";

    public static void test(String username, String password) {
        System.out.println("hello " + username + " " + password);
    }

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
    public static Response register(String json) {
        Invocation.Builder request = getRequestToPath(Arrays.asList(AUTH_PATH, REGISTER_PATH));

        Response registerResponse = request.post(Entity.json(json));
        registerResponse.bufferEntity();
        //exctractTokenAndRoleFromResponse(registerResponse);

        return registerResponse;
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
