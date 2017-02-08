package me.mylogo.javaftp.managers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.mylogo.javaftp.JavaFTP;
import me.mylogo.javaftp.interfaces.JsonSerializable;
import me.mylogo.javaftp.util.MyServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennisheckmann on 29.01.17.
 */
public class ServerManager implements JsonSerializable {

    private List<MyServer> serverList;

    public ServerManager() {
        serverList = new ArrayList<>();
        serverList.add(new MyServer("Temp", "host.host", 88, "uu", "pw"));
    }

    public ServerManager(JsonObject json) {
        this();
        JsonArray servers = json.get("servers").getAsJsonArray();
        for (JsonElement element : servers) {
            MyServer myServer = MyServer.fromJson(element.getAsJsonObject());
            serverList.add(myServer);
        }
    }

    public void addServer(MyServer myServer) {
        serverList.add(myServer);
        JavaFTP.instance().saveConfig();
    }

    @Override
    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        JsonArray servers = new JsonArray();
        for (MyServer server : serverList) {
            servers.add(server.toJson());
        }
        json.add("servers", servers);
        return json;
    }

    public List<MyServer> getServerList() {
        return serverList;
    }

}
