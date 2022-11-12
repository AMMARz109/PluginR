package me.ammardev.pluginr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class MainController implements Initializable {

    @FXML
    BorderPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeToServers();
    }

    public void changeToServers(){
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //System.out.printf("%f | %f", stage.getX(), stage.getY());
        //pre-add self structures
        ScrollPane rootScroll = new ScrollPane();
        VBox rootbox = new VBox();
        rootScroll.setContent(rootbox);

        rootbox.prefWidthProperty().bind(rootScroll.widthProperty());

        rootPane.setCenter(rootScroll);


        long add = 0;
        try {
            BorderPane pane = FXMLLoader.load(getClass().getResource("patterns/NewServer.fxml"));
            VBox.setMargin(pane, new Insets(5));
            rootbox.getChildren().add(pane);
            for (Server server: loadServers()) {
                add += 130;
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
        rootbox.setPrefHeight(rootbox.getHeight() + add);
    }

    public void changeToAbout() throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("patterns/aboutPattern.fxml"));
        rootPane.setCenter(pane);
        BorderPane inPane = (BorderPane) pane.getLeft();
        Hyperlink hyperlink = (Hyperlink) inPane.getBottom();
        hyperlink.setOnAction(event -> sendSite());
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

    public void sendSite(){
        try{
            Desktop.getDesktop().browse(new URI("https://ammardevz.wordpress.com"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
