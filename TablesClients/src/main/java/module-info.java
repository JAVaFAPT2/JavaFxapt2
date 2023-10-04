module com.example.tablesclients {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.tablesclients to javafx.fxml;
    exports com.example.tablesclients;
}