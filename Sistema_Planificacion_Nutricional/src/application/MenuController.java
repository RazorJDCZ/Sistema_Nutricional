package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MenuController {

    @FXML
    private Label lblCalorias;
    private double caloriasMantenimiento;
    private int edadUsuario;

    public void setCaloriasMantenimiento(double calorias) {
        this.caloriasMantenimiento = calorias;
        lblCalorias.setText("Tus calorías de mantenimiento son: " + (int) calorias + " kcal");
    }

    public void setEdadUsuario(int edad) {
        this.edadUsuario = edad;
    }

    @FXML
    private void abrirProductos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Productos.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Productos Disponibles");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirPlanificador() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Planificador.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Planificador Nutricional");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirResumen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resumen.fxml"));
            Parent root = loader.load();

            ResumenController controller = loader.getController();
            controller.setHostServices(Main.getAppHostServices());
            controller.cargarResumenPorEdad(edadUsuario);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Resumen Nutricional Sugerido");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void volverAInicio() {
        try {
            // Limpiar recetas seleccionadas
            RecetasSeleccionadas.limpiar();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Inicio");
            stage.show();

            Stage currentStage = (Stage) lblCalorias.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

