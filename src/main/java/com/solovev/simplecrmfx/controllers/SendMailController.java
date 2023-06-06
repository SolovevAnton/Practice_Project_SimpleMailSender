package com.solovev.simplecrmfx.controllers;

import com.solovev.simplecrmfx.App;
import com.solovev.simplecrmfx.model.User;
import com.solovev.simplecrmfx.repositories.SendUserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendMailController implements ControllerData<User> {
    @FXML
    public TextField fieldID;
    @FXML
    public TextField fieldName;
    @FXML
    public TextArea textFieldPersonalInfo;
    @FXML
    public TextField textFieldEmail;
    @FXML
    public TextArea emailTextArea;
    @FXML
    public TextField textFieldTopic;


    @Override
    public void initData(User user) {
        fieldID.setText(String.valueOf(user.getId()));
        fieldName.setText(user.getName());
        textFieldEmail.setText(user.getEmail());
        String delimiter = "\n";
        String personalInfo = "Age: " + user.getAge() + delimiter +
                "Country: " + user.getCountry() + delimiter +
                "Registration date: " + user.getRegistrationDate();
        textFieldPersonalInfo.setText(personalInfo);
    }

    @FXML
    public void closeButton(ActionEvent actionEvent) {
        App.closeWindow(actionEvent);
    }

    @FXML
    public void sendButton(ActionEvent actionEvent) {
        sendMail();
        SendUserRepository sendRepo = new SendUserRepository();
        sendRepo.addUser(Integer.parseInt(fieldID.getText()));
        sendRepo.save();

        closeButton(actionEvent);
    }

    /**
     * Method to send mail with specific text to selected user TODO finish
     */
    private void sendMail() {
    }
}
