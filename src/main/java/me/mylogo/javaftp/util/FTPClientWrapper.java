package me.mylogo.javaftp.util;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class FTPClientWrapper {

    private String host;
    private int port;
    private FTPClient client;

    public FTPClientWrapper(String host, int port) throws IOException {
        this(new FTPClient(), host, port);
    }

    public FTPClientWrapper(FTPClient client, String host, int port) throws IOException {
        this.client = client;
        this.host = host;
        this.port = port;
        client.connect(host, port);
    }

    public void login(String username, String password) throws IOException {
        client.login(username, password);
    }

    public FTPClient getFTPClient() {
//        try {
//            client.abort();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        client = new FTPClient();
//        try {
//            client.connect(host, port);
//            client.login("u743641551", "E0t4l3XtOdlurk07fo");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return client;
    }

}
