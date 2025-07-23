package application;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static HostServices hostServices;

    @Override
    public void start(Stage primaryStage) {
        try {
            hostServices = getHostServices();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Sistema de Planificación Nutricional");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HostServices getAppHostServices() {
        return hostServices;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


