package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class ProductosController {

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colUnidad;
    @FXML private TableColumn<Producto, String> colCategoria;
    @FXML private TableColumn<Producto, String> colMarca;
    @FXML private TableColumn<Producto, String> colFuente;
    @FXML private TableColumn<Producto, Double> colCantidad;

    @FXML private TextField txtBuscar;

    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUnidad.setCellValueFactory(new PropertyValueFactory<>("unidad"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colFuente.setCellValueFactory(new PropertyValueFactory<>("fuente"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tablaProductos.setItems(productos);

        cargarProductos();

        txtBuscar.textProperty().addListener((obs, oldVal, newVal) -> filtrarProductos(newVal));
    }

    private void cargarProductos() {
        productos.clear();
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {

            while (rs.next()) {
                productos.add(new Producto(
                    rs.getString("nombre_producto"),
                    rs.getString("unidad"),
                    rs.getString("categoria"),
                    rs.getString("marca"),
                    rs.getString("fuente"),
                    rs.getInt("cantidad_disponible")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void filtrarProductos(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            tablaProductos.setItems(productos);
            return;
        }

        ObservableList<Producto> filtrados = FXCollections.observableArrayList();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(filtro.toLowerCase())
             || p.getCategoria().toLowerCase().contains(filtro.toLowerCase())
             || p.getMarca().toLowerCase().contains(filtro.toLowerCase())) {
                filtrados.add(p);
            }
        }
        tablaProductos.setItems(filtrados);
    }

    @FXML
    private void volverAtras() {
        Stage stage = (Stage) tablaProductos.getScene().getWindow();
        stage.close();
    }
}




