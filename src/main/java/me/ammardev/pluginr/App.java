package me.ammardev.pluginr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        setup();
    }

    void setup() throws IOException {
        stage.setTitle("PluginR");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("App.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
