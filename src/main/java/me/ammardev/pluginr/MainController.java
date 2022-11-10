package me.ammardev.pluginr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    BorderPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        }catch (Exception e){
            e.printStackTrace();
        }
        //after pre-add

    }

    public void changeToAbout(){

    }

    public void changeToSettings(){

    }

    void loadServers(){

    }

}
