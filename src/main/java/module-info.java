module com.solovev.simplecrmfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.mail.api;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens com.solovev.simplecrmfx to javafx.fxml;
    exports com.solovev.simplecrmfx;
    exports com.solovev.simplecrmfx.controllers;
    exports com.solovev.simplecrmfx.model;
    opens com.solovev.simplecrmfx.controllers to javafx.fxml;
}