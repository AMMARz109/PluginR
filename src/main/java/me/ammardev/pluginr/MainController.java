package me.ammardev.pluginr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class MainController implements Initializable {

    @FXML
    BorderPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addServer(new Server(ServerType.Spigot, "reload", "1.8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        changeToServers();
    }

    public void changeToServers(){
        //pre-add self structures
        VBox rootbox = new VBox();
        rootPane.setCenter(rootbox);

        try {
            BorderPane pane = FXMLLoader.load(getClass().getResource("patterns/NewServer.fxml"));
            VBox.setMargin(pane, new Insets(5));
            rootbox.getChildren().add(pane);
            for (Server server: loadServers()) {
                BorderPane item = FXMLLoader.load(getClass().getResource("patterns/ServerPattern.fxml"));
                Pane left = (Pane) item.getLeft();
                Label name  = (Label) left.getChildren().get(0);
                Label version  = (Label) left.getChildren().get(2);
                Label type  = (Label) left.getChildren().get(3);
                name.setText(server.getServerName());
                version.setText(server.getVersion());
                type.setText(server.getServerType().name());

                VBox.setMargin(item, new Insets(5));
                rootbox.getChildren().add(item);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        //after pre-add

    }

    public void changeToAbout(){

    }

    public void changeToSettings(){

    }

    List<Server> loadServers() throws FileNotFoundException {
        File file = Paths.get(Statics.serversDir).toFile();
        Collection<Server> collection = new ArrayList<>();
        if (file.length() > 0){
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            collection = new ArrayList<>(gson.fromJson(new FileReader(file), new TypeToken<List<Server>>(){}.getType()));
        }
        return new ArrayList<>(collection);
    }

    public void addServer(Server server) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List<Server> servers = loadServers();
        servers.add(server);

        try (Writer writer = new FileWriter(Statics.serversDir)){
            writer.write(gson.toJson(servers));
            writer.flush();
        }
    }

}
