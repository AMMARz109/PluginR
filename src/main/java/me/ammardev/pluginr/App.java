package me.ammardev.pluginr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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

        //create save dir -------------------------
        if (!Path.of(Statics.mainDir).toFile().exists()){
            File dir = new File(Statics.mainDir);
            dir.mkdirs();
            File file = new File(Statics.serversDir);
            file.createNewFile();
            System.out.println("Path created at: " + dir.getAbsolutePath());
        }
    }
}
