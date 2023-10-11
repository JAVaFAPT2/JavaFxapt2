/**
 *
 */
module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jetbrains.annotations;



    exports controller;
    opens controller to javafx.fxml;
}
