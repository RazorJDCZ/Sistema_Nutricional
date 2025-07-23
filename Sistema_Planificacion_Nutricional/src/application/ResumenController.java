// ResumenController.java
package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.HostServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumenController {

    @FXML private Label lblGrupoEtario;
    @FXML private TableView<ResumenReceta> tablaResumen;
    @FXML private TableColumn<ResumenReceta, String> colNombre;
    @FXML private TableColumn<ResumenReceta, Integer> colCalorias;
    @FXML private TableColumn<ResumenReceta, Void> colEnlace;

    @FXML private TableView<ComparacionNutriente> tablaComparacion;
    @FXML private TableColumn<ComparacionNutriente, String> colNutriente;
    @FXML private TableColumn<ComparacionNutriente, Double> colRecomendado;
    @FXML private TableColumn<ComparacionNutriente, Double> colAportado;
    @FXML private TableColumn<ComparacionNutriente, String> colCumple;

    private ObservableList<ResumenReceta> resumenRecetas = FXCollections.observableArrayList();
    private ObservableList<ComparacionNutriente> comparaciones = FXCollections.observableArrayList();
    private HostServices hostServices;

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCalorias.setCellValueFactory(new PropertyValueFactory<>("calorias"));

        colEnlace.setCellFactory(param -> new TableCell<>() {
            private final Button btn = new Button("Abrir");
            {
                btn.setOnAction(event -> {
                    ResumenReceta receta = getTableView().getItems().get(getIndex());
                    if (hostServices != null) {
                        hostServices.showDocument(receta.getEnlace());
                    }
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        tablaResumen.setItems(resumenRecetas);

        colNutriente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRecomendado.setCellValueFactory(new PropertyValueFactory<>("recomendado"));
        colAportado.setCellValueFactory(new PropertyValueFactory<>("aportado"));
        colCumple.setCellValueFactory(new PropertyValueFactory<>("cumpleSimbolo"));

        tablaComparacion.setItems(comparaciones);
    }

    public void cargarResumenPorEdad(int edadUsuario) {
        String grupo = determinarGrupoEtario(edadUsuario);
        lblGrupoEtario.setText("Grupo etario detectado: " + grupo);

        resumenRecetas.setAll(RecetasSeleccionadas.obtenerTodas());

        Map<String, Double> requerimientos = obtenerRequerimientosPorGrupo(grupo);
        Map<String, Double> aportes = calcularAportes(resumenRecetas);

        comparaciones.clear();
        for (String nutriente : requerimientos.keySet()) {
            double recomendado = requerimientos.get(nutriente);
            double aportado = aportes.getOrDefault(nutriente, 0.0);
            comparaciones.add(new ComparacionNutriente(nutriente, recomendado, aportado));
        }
    }

    private String determinarGrupoEtario(int edad) {
        if (edad < 5) return "Primera Infancia";
        else if (edad <= 12) return "Niño";
        else if (edad < 60) return "Adulto";
        else return "Adulto Mayor";
    }

    private Map<String, Double> obtenerRequerimientosPorGrupo(String grupo) {
        Map<String, Double> mapa = new HashMap<>();
        switch (grupo) {
            case "Primera Infancia" -> {
                mapa.put("calorias", 1300.0);
                mapa.put("proteinas", 15.0);
                mapa.put("grasas", 30.0);
                mapa.put("carbohidratos", 130.0);
                mapa.put("azucar", 25.0);
                mapa.put("fibra", 10.0);
                mapa.put("calcio", 700.0);
                mapa.put("hierro", 7.0);
            }
            case "Niño" -> {
                mapa.put("calorias", 1700.0);
                mapa.put("proteinas", 25.0);
                mapa.put("grasas", 40.0);
                mapa.put("carbohidratos", 200.0);
                mapa.put("azucar", 30.0);
                mapa.put("fibra", 15.0);
                mapa.put("calcio", 1000.0);
                mapa.put("hierro", 10.0);
            }
            case "Adulto" -> {
                mapa.put("calorias", 2200.0);
                mapa.put("proteinas", 50.0);
                mapa.put("grasas", 70.0);
                mapa.put("carbohidratos", 300.0);
                mapa.put("azucar", 35.0);
                mapa.put("fibra", 25.0);
                mapa.put("calcio", 1000.0);
                mapa.put("hierro", 8.0);
            }
            case "Adulto Mayor" -> {
                mapa.put("calorias", 2000.0);
                mapa.put("proteinas", 60.0);
                mapa.put("grasas", 60.0);
                mapa.put("carbohidratos", 250.0);
                mapa.put("azucar", 30.0);
                mapa.put("fibra", 25.0);
                mapa.put("calcio", 1200.0);
                mapa.put("hierro", 8.0);
            }
        }
        return mapa;
    }

    private Map<String, Double> calcularAportes(List<ResumenReceta> recetas) {
        Map<String, Double> total = new HashMap<>();
        List<String> claves = List.of("calorias", "proteinas", "grasas", "carbohidratos", "azucar", "fibra", "calcio", "hierro");
        for (String clave : claves) total.put(clave, 0.0);

        ApiUSDAService api = new ApiUSDAService();

        for (ResumenReceta receta : recetas) {
            List<IngredienteReceta> ingredientes = RecetasSeleccionadas.obtenerIngredientesPorReceta(receta.getNombre());

            for (IngredienteReceta ing : ingredientes) {
                String nombre = ing.getNombreProducto().trim().toLowerCase();
                Map<String, Double> valores = api.obtenerNutrientesPorNombre(nombre);

                double cantidadGramos = extraerCantidadEnGramos(ing.getCantidad());

                for (String clave : claves) {
                    double valorPor100g = valores.getOrDefault(clave, 0.0);
                    double aporteReal = (valorPor100g * cantidadGramos) / 100.0;
                    total.put(clave, total.get(clave) + aporteReal);
                }
            }
        }
        return total;
    }

    private double extraerCantidadEnGramos(String cantidad) {
        try {
            String soloNumero = cantidad.trim().split(" ")[0].replace(",", ".");
            return Double.parseDouble(soloNumero);
        } catch (Exception e) {
            return 0.0;
        }
    }

    @FXML
    private void volverAtras() {
        Stage stage = (Stage) tablaResumen.getScene().getWindow();
        stage.close();
    }
}











