package me.mylogo.javaftp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import me.mylogo.javaftp.gui.GuiUtil;
import me.mylogo.javaftp.local.LocalSimpleFile;
import me.mylogo.javaftp.managers.ServerManager;
import me.mylogo.javaftp.remote.RemoteFileLocation;
import me.mylogo.javaftp.remote.RemoteSimpleFile;
import me.mylogo.javaftp.util.FTPClientWrapper;
import me.mylogo.javaftp.util.MyServer;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennisheckmann on 28.01.17.
 */
public class JavaFTP extends Application {

    private static JavaFTP instance;
    public static final Gson GSON = new Gson();
    private File storageFile;
    private ServerManager serverManager;

    public static void main(String[] args) throws Exception {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {
        instance = this;
        initJavaFTP();
        //TODO: Add GUI
    }

    private void initJavaFTP() {
        storageFile = new File("config.json");
        if (storageFile.exists()) {
            readConfig();
        } else {
            createConfig();
        }
    }

    private void readConfig() {
        serverManager = new ServerManager();
    }

    public void saveConfig() {
        JsonObject root = new JsonObject();
        root.add("serverManager", serverManager.toJson());
        try (FileWriter writer = new FileWriter(storageFile)) {
            GSON.toJson(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createConfig() {
        try {
            storageFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverManager = new ServerManager();
    }

    public ServerManager getServerManager() {
        return  serverManager;
    }

    public static JavaFTP instance() {
        return instance;
    }

}
