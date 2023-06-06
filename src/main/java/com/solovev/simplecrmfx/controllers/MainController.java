package com.solovev.simplecrmfx.controllers;

import com.solovev.simplecrmfx.App;
import com.solovev.simplecrmfx.model.User;
import com.solovev.simplecrmfx.repositories.SendUserRepository;
import com.solovev.simplecrmfx.repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class MainController {
    @FXML
    public TableView<User> tableView = new TableView<>();
    private FileChooser fileChooser = new FileChooser();
    private File chosenFile;

    public void initialize() {
        //main columns initialization
        //todo format columns to match strings?
        TableColumn<User, Boolean> zeroColumn = new TableColumn<>("Mail sent");
        TableColumn<User, String> idColumn = new TableColumn<>("ID");
        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        TableColumn<User, String> emailColumn = new TableColumn<>("e-mail");
        TableColumn<User, String> actionColumn = new TableColumn<>("Send e-mail");

        //factories for main columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        zeroColumn.setCellFactory(tableColumn ->
                new TableCell<User, Boolean>() {
                    CheckBox btn = new CheckBox();

                    {
                        btn.setDisable(true);
                        btn.setStyle("-fx-opacity: 1;");
                        btn.setAlignment(Pos.CENTER);
                    }

                    @Override
                    public void updateItem(Boolean item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setSelected(tableView.getItems().get(getIndex()).getIsSend());
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                }
        );

        actionColumn.setCellFactory(tableColumn ->
                new TableCell<User, String>() {
                    Button btn = new Button("Send email");

                    {
                        btn.getStyleClass().add("primary");
                        btn.setAlignment(Pos.CENTER);
                    }

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                App.openWindowAndWait("sendMailScene.fxml", "Mail to user", tableView.getItems().get(getIndex()));
                                reloadTable();
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                }
        );

        //personal data columns
        TableColumn<User, TableColumn<User, ?>> fourthColumn = new TableColumn<>("Personal data");
        TableColumn<User, LocalDateTime> registrationDateColumn = new TableColumn<>("Registration date");
        TableColumn<User, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<User, String> countryColumn = new TableColumn<>("Country");
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        fourthColumn.getColumns().setAll(registrationDateColumn, ageColumn, countryColumn);

        tableView
                .getColumns()
                .setAll(zeroColumn, idColumn, nameColumn, emailColumn, fourthColumn, actionColumn);
    }

    public void menuItemOpen(ActionEvent actionEvent) {
        File root = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(root);
        fileChooser
                .getExtensionFilters()
                .setAll(new FileChooser.ExtensionFilter("json files", "*.json"),
                        new FileChooser.ExtensionFilter("txt", "*.txt")
                );

        chosenFile = fileChooser.showOpenDialog(null);
        reloadTable();
    }

    /**
     * reloads tableView based on the sendUsers data
     */
    private void reloadTable() {
        if (chosenFile != null) {
            try {
                UserRepository repo = new UserRepository(chosenFile);
                tableView.setItems(FXCollections.observableList(repo.getUsers()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Deletes all data from send User data
     *
     * @param actionEvent button action
     */
    public void refreshButton(ActionEvent actionEvent) {
        new SendUserRepository().clear();
        reloadTable();
    }
}