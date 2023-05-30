module com.solovev.simplecrmfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.solovev.simplecrmfx to javafx.fxml;
    exports com.solovev.simplecrmfx;
}