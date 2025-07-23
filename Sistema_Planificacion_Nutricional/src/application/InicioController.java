package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class InicioController {

    @FXML private ComboBox<String> cmbGenero;
    @FXML private TextField txtEdad;
    @FXML private TextField txtPeso;
    @FXML private TextField txtAltura;
    @FXML private Slider sliderFrecuencia;
    @FXML private Label lblFrecuencia;
    @FXML private Label lblResultado;
    @FXML private Button btnContinuar;

    private double caloriasMantenimiento;
    private int edad;

    @FXML
    private void initialize() {
        cmbGenero.getItems().addAll("Masculino", "Femenino");
        cmbGenero.setValue("Masculino");

        sliderFrecuencia.valueProperty().addListener((obs, oldVal, newVal) -> {
            int dias = newVal.intValue();
            sliderFrecuencia.setValue(dias); // snap to tick
            lblFrecuencia.setText(dias + " días");
        });

        btnContinuar.setDisable(true); // deshabilitado hasta que se calculen calorías
    }

    @FXML
    private void calcularCalorias() {
        try {
            String genero = cmbGenero.getValue();
            edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            int frecuencia = (int) sliderFrecuencia.getValue();

            double tmb = (genero.equalsIgnoreCase("Masculino")) ?
                10 * peso + 6.25 * altura - 5 * edad + 5 :
                10 * peso + 6.25 * altura - 5 * edad - 161;

            double factor;
            if (frecuencia <= 1) factor = 1.2;
            else if (frecuencia <= 3) factor = 1.375;
            else if (frecuencia <= 5) factor = 1.55;
            else factor = 1.725;

            caloriasMantenimiento = Math.round(tmb * factor);
            lblResultado.setText("Calorías de mantenimiento: " + (int) caloriasMantenimiento + " kcal");

            btnContinuar.setDisable(false); // habilita el botón para avanzar

        } catch (NumberFormatException e) {
            lblResultado.setText("Por favor ingresa valores válidos.");
            btnContinuar.setDisable(true);
        }
    }

    @FXML
    private void irAPlan() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            MenuController controller = loader.getController();
            controller.setCaloriasMantenimiento(caloriasMantenimiento);
            controller.setEdadUsuario(edad);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Menú de Planificación");
            stage.show();

            ((Stage) txtEdad.getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





