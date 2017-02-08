package me.mylogo.javaftp.util;

import com.google.gson.JsonObject;
import me.mylogo.javaftp.interfaces.JsonSerializable;
import me.mylogo.javaftp.remote.RemoteFileLocation;

import java.io.IOException;

/**
 * Created by dennisheckmann on 29.01.17.
 */
public class MyServer implements JsonSerializable {

    private FTPClientWrapper client;
    private String name;
    private String host;
    private int port;
    private String username;
    private String password;

    public MyServer(String name, String host, int port, String username, String password) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    @Override
    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        json.addProperty("host", host);
        json.addProperty("port", port);
        json.addProperty("username", username);
        json.addProperty("password", password);
        return json;
    }

    public static MyServer fromJson(JsonObject json) {
        String name = json.get("name").getAsString();
        String host = json.get("host").getAsString();
        int port = json.get("port").getAsInt();
        String username = json.get("username").getAsString();
        String password = json.get("password").getAsString();
        return new MyServer(name, host, port, username, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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

    public void connect() throws IOException {
        client = new FTPClientWrapper(getHost(), getPort());
    }

    public void login() throws IOException {
        client.login(getUsername(), getPassword());
    }

    public FTPClientWrapper getClient() {
        return this.client;
    }

}
