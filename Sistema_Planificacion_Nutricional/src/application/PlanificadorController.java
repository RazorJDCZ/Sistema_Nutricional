package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.List;

public class PlanificadorController {

    @FXML private ComboBox<String> cmbFiltroGrupo;
    @FXML private TableView<Receta> tablaRecetas;
    @FXML private TableColumn<Receta, String> colNombre;
    @FXML private TableColumn<Receta, String> colDescripcion;
    @FXML private TableColumn<Receta, Void> colAccion;

    @FXML private TableView<DetallePlan> tablaDetalle;
    @FXML private TableColumn<DetallePlan, String> colDia;
    @FXML private TableColumn<DetallePlan, String> colProducto;
    @FXML private TableColumn<DetallePlan, String> colCantidad;

    private ObservableList<Receta> recetas = FXCollections.observableArrayList();
    private ObservableList<DetallePlan> planActual = FXCollections.observableArrayList();
    private List<Receta> recetasSeleccionadas = new ArrayList<>();

    @FXML
    private void initialize() {
        cmbFiltroGrupo.setItems(FXCollections.observableArrayList(
            "Primera Infancia", "Niño", "Adulto", "Adulto Mayor"
        ));

        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colDescripcion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescripcion()));

        colDia.setCellValueFactory(data -> data.getValue().diaProperty());
        colProducto.setCellValueFactory(data -> data.getValue().productoProperty());
        colCantidad.setCellValueFactory(data -> data.getValue().cantidadProperty());

        tablaDetalle.setItems(planActual);

        agregarBotonAgregar();
        cargarRecetas();
    }

    private void agregarBotonAgregar() {
        Callback<TableColumn<Receta, Void>, TableCell<Receta, Void>> cellFactory = param -> new TableCell<>() {
            private final Button btn = new Button("Agregar");

            {
                btn.setOnAction(event -> {
                    Receta receta = getTableView().getItems().get(getIndex());
                    agregarRecetaVisualmente(receta);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        };
        colAccion.setCellFactory(cellFactory);
    }

    private void agregarRecetaVisualmente(Receta receta) {
        for (IngredienteReceta ing : receta.getIngredientes()) {
            planActual.add(new DetallePlan("Plan Nutricional", ing.getNombreProducto(), ing.getCantidad()));
        }

        recetasSeleccionadas.add(receta); // Solo se agrega a la lista visual

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Receta agregada");
        alerta.setHeaderText(null);
        alerta.setContentText("La receta '" + receta.getNombre() + "' fue agregada visualmente al plan.");
        alerta.showAndWait();
    }

    @FXML
    private void filtrarRecetas() {
        String grupo = cmbFiltroGrupo.getValue();
        if (grupo == null || grupo.isEmpty()) {
            tablaRecetas.setItems(recetas);
        } else {
            ObservableList<Receta> filtradas = FXCollections.observableArrayList();
            for (Receta r : recetas) {
                if (r.getGrupoEtario().equalsIgnoreCase(grupo)) {
                    filtradas.add(r);
                }
            }
            tablaRecetas.setItems(filtradas);
        }
    }

    @FXML
    private void guardarPlan() {
        StringBuilder agotados = new StringBuilder();

        for (Receta receta : recetasSeleccionadas) {
            for (IngredienteReceta ing : receta.getIngredientes()) {
                if (!ConexionBD.estaDisponible(ing.getNombreProducto())) {
                    agotados.append("- ").append(ing.getNombreProducto()).append("\n");
                }
            }
        }

        if (!agotados.isEmpty()) {
            Alert advertencia = new Alert(Alert.AlertType.WARNING);
            advertencia.setTitle("Productos no disponibles");
            advertencia.setHeaderText("No se puede guardar el plan");
            advertencia.setContentText("Los siguientes productos no están disponibles:\n" + agotados);
            advertencia.showAndWait();
            return;
        }

        for (Receta receta : recetasSeleccionadas) {
            for (IngredienteReceta ing : receta.getIngredientes()) {
                ConexionBD.reducirCantidadProducto(ing.getNombreProducto());
            }

            // ✅ Agregar receta al resumen solo si pasa la validación
            RecetasSeleccionadas.agregar(
                new ResumenReceta(receta.getNombre(), receta.getCaloriasTotal(), receta.getLink()),
                receta.getIngredientes()
            );
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Plan Guardado");
        alert.setHeaderText(null);
        alert.setContentText("El plan fue guardado exitosamente y se descontaron los ingredientes del banco.");
        alert.showAndWait();
    }

    @FXML
    private void volverAtras() {
        Stage stage = (Stage) tablaDetalle.getScene().getWindow();
        stage.close();
    }

    private void cargarRecetas() {
        recetas.clear();
        recetas.addAll(Recetario.obtenerRecetas());
        tablaRecetas.setItems(recetas);
    }
}


