module intento {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens intento to javafx.fxml;
    exports intento;
}
