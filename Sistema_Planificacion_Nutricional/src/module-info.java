module Sistema_Planificacion_Nutricional {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens application to javafx.fxml, javafx.base;
    exports application;
}

