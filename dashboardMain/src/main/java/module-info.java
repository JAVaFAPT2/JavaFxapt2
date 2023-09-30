module com.example.dashboardmain {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.dashboardmain to javafx.fxml;
    exports com.example.dashboardmain;
}