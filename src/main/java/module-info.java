module com.example.medsea {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.medsea to javafx.fxml;
    exports com.example.medsea;
}