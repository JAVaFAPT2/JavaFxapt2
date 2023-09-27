package org.example;
import entity.Account;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.AccountModel;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    protected void loginCheck(String accountname, String password, ActionEvent event) throws IOException {
        AccountModel accountModel = new AccountModel();
        Account account = accountModel.checkAcc(accountname, password);
        if (account != null && account.getAccountType() == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminsite.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("adminsite.css")).toExternalForm());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("admin site");
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.show();
        } else if (account != null && account.getAccountType() > 1) {
            System.out.println("account site");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accountsite.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("employee site");
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);
            stage.show();
        } else if (account == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("wrong account");
            alert.setHeaderText("Account not found");
            alert.setContentText("Please check your account");
            alert.show();
        }

    }
}
