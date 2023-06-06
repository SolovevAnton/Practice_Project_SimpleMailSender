package com.solovev.simplecrmfx.controllers;

import com.solovev.simplecrmfx.App;
import com.solovev.simplecrmfx.model.User;
import com.solovev.simplecrmfx.repositories.MailLogRepo;
import com.solovev.simplecrmfx.repositories.SendUserRepository;
import com.solovev.simplecrmfx.util.MailSender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

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
    public TextField textFieldSubject;


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
    public void sendButton(ActionEvent actionEvent) throws IOException {
        sendMail();
        SendUserRepository sendRepo = new SendUserRepository();
        sendRepo.addUser(Integer.parseInt(fieldID.getText()));
        sendRepo.save();

        closeButton(actionEvent);

        String alertMessage = String.format("Mail sent to User: %s email: %s",fieldName.getText(),textFieldEmail.getText());
        App.showAlertWithoutHeaderText("Success", alertMessage, Alert.AlertType.INFORMATION); //todo is this ok? sometimes alert doesnot contain text
    }

    /**
     * Method to send mail with specific text to selected user
     * true if mail successfully send, error otherwise
     */
    private boolean sendMail() throws IOException {
        MailLogRepo logger = new MailLogRepo();
        MailSender sender = new MailSender(logger.getLog(), logger.getPass(), textFieldEmail.getText());
        return sender.send(textFieldSubject.getText(),emailTextArea.getText());
    }
}
