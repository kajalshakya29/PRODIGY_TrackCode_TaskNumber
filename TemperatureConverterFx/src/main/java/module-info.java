module com.example.temperatureconverterfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.temperatureconverterfx to javafx.fxml;
    exports com.example.temperatureconverterfx;
}