package com.example.f23comp1011tasks1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CreateUserViewController {

    @FXML
    private TextField emailTextField;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField userNameTextField;
    @FXML
    void submitPressed(ActionEvent event) {
        if (!userNameTextField.getText().isEmpty() && !emailTextField.getText().isEmpty())
        {
            //there is a username and password in the fields, create a user
            try{
                User user = new User(emailTextField.getText(),userNameTextField.getText());
                String msg = DBUtility.saveUserToDB(user);
                msgLabel.setText(msg);
            } catch (IllegalArgumentException e)
            {
                msgLabel.setText(e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            msgLabel.setText("both user name & email required");
        }
    }
}