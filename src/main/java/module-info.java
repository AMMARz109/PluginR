module me.ammardev.pluginr {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.ammardev.pluginr to javafx.fxml;
    exports me.ammardev.pluginr;
}