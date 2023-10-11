package controller;

import entity.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.AccountModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    AccountModel accountModel;
    Window window;
    Alert alert = new Alert(Alert.AlertType.WARNING);

    public void initialize(URL url, ResourceBundle rb) {
    }

    public LoginController() {
        AccountModel accountModel = new AccountModel();
    }

    @FXML
    private void login() throws Exception {
        String inputName = txtUserName.getText();
        String inputPassword=txtPassword.getText();
        if (isValidated()){
            Account account = accountModel.checkAcc(inputName,inputPassword);
            if (account.getName().isEmpty()||account.getId()==0) {
                Stage stage = (Stage)this.btnLogin.getScene().getWindow();
                stage.close();
                Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/view/MainPanelView.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Admin Panel");
                stage.getIcons().add(new Image("/asset/icon.png"));
                stage.show();
            } else {
                alert.setTitle("Unable to login");
                alert.setHeaderText("Account not found");
                alert.setContentText("Please check your account name and password");
                alert.show();
                this.txtUserName.requestFocus();
            }
        }
    }

    private boolean isValidated() {
        boolean flag=true;
        this.window = this.btnLogin.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        StringBuilder message = new StringBuilder();
        if (this.txtUserName.getText().isEmpty()) {
            message= new StringBuilder("Username text field cannot be blank.");
            this.txtUserName.requestFocus();
            flag=false;
        }
        if (this.txtPassword.getText().isEmpty()) {
            message.append("\nPassword field cannot be blank.");
            this.txtPassword.requestFocus();
            flag=false;
        }

        return flag;
    }

    @FXML
    private void showRegisterStage() throws IOException {
        Stage stage = (Stage)this.btnLogin.getScene().getWindow();
        stage.close();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/view/RegisterView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("User Registration");
        stage.getIcons().add(new Image("/asset/icon.png"));
        stage.show();
    }

    @FXML
    private void switchToDashboard() throws IOException {
        App.setRoot("dashboard");
    }
}

