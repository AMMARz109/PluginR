package me.ammardev.pluginr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    BorderPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VBox box = (VBox) rootPane.getCenter();
        try {
            BorderPane pattern = FXMLLoader.load(getClass().getResource("patterns/ServerPattern.fxml"));
            box.getChildren().add(pattern);
        } catch (IOException e) {
            throw new RuntimeException(e);        }

    }

    public void changeToServers(){

        System.out.println("Server");
    }

    public void changeToAbout(){

    }

    public void changeToSettings(){

    }

}
