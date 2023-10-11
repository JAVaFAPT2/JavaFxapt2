package view;
import javafx.scene.control.*;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class LoginController  {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    Alert alert = new Alert(INFORMATION);

    public void userLogIn(ActionEvent event) throws IOException {
        userLogin();

    }

    private void userLogin() throws IOException {
        App m = new App();
        if(userName.getText().equals("root") && password.getText().equals("root")) {
            Alert alert = new Alert(INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success");
            alert.setContentText("Success");
            alert.showAndWait();
            m.changeScene("dashboard");
        }

        else if(userName.getText().isEmpty() && password.getText().isEmpty()) {
            Alert alert = new Alert(ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to login");
            alert.setContentText("Please check username and password");
            alert.showAndWait();
        }


        else {
            Alert alert = new Alert(ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to login");
            alert.setContentText("Please enter username and password");
            alert.showAndWait();
        }
    }
}
