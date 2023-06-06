package com.solovev.simplecrmfx.controllers;

import com.solovev.simplecrmfx.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendMessageController implements ControllerData<User>{
    @FXML
    public TextField fieldID;
    @FXML
    public TextField fieldName;
    @FXML
    public TextArea textFieldPersonalInfo;
    @FXML
    public TextField textFiledEmail;
    @FXML
    public TextArea emailTextFiled;
    @FXML
    public Button sendEmail;

    @Override
    public void initData(User data) {

    }

    public void closeButton(ActionEvent actionEvent) {
    }

    public void sendButton(ActionEvent actionEvent) {
    }
}
