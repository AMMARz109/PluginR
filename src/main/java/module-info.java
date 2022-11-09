module PluginR {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;

    exports me.ammardev.pluginr;
    opens me.ammardev.pluginr to javafx.fxml;
}