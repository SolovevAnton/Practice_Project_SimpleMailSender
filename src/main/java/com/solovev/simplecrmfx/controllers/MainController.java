package com.solovev.simplecrmfx.controllers;

import com.solovev.simplecrmfx.repositories.UserRepository;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {
    @FXML
    public TableView tableView;
    private FileChooser fileChooser = new FileChooser();
    public void menuItemOpen(ActionEvent actionEvent) throws IOException {
        File root = new File("src/main/resources/com/solovev/files");
        fileChooser.setInitialDirectory(root);
        File chosenFile = fileChooser.showOpenDialog(null);
        if(chosenFile != null) {
            UserRepository repo = new UserRepository(chosenFile);
          //  tableView.setItems(FXCollections.observableList(repo.getUsers()));
        }
    }
}