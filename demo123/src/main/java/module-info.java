/**
 *
 */
module demo123.src.main.java.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jetbrains.annotations;

    exports view;
    exports controller;
    opens controller to javafx.fxml;
}

