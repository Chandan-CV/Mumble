module com.mumble.server.mumble {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires spark.core;
    requires json.simple;
    requires java.desktop;


    opens com.mumble.server.mumble to javafx.fxml;
    exports com.mumble.server.mumble;
}