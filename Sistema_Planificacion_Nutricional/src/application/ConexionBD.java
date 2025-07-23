package application;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3307/sistema_nutricional";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = ""; // Dejar en blanco si no usas contraseña

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public static void reducirCantidadProducto(String nombreProducto) {
        String sql = "UPDATE productos SET cantidad_disponible = GREATEST(cantidad_disponible - 1, 0) WHERE LOWER(nombre_producto) = LOWER(?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreProducto);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al reducir cantidad de '" + nombreProducto + "': " + e.getMessage());
        }
    }

    public static boolean estaDisponible(String nombreProducto) {
        String sql = "SELECT cantidad_disponible FROM productos WHERE LOWER(nombre_producto) = LOWER(?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("cantidad_disponible") > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar disponibilidad: " + e.getMessage());
        }
        return false; // Por defecto no disponible si hay error
    }

    public Map<String, Double> obtenerValoresNutricionalesDesdeBD(String nombreProducto) {
        Map<String, Double> valores = new HashMap<>();
        String sql = "SELECT * FROM valoresnutricionalesapi WHERE LOWER(nombre_producto) = LOWER(?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                valores.put("calorias", rs.getDouble("calorias"));
                valores.put("proteinas", rs.getDouble("proteinas"));
                valores.put("grasas", rs.getDouble("grasas"));
                valores.put("carbohidratos", rs.getDouble("carbohidratos"));
                valores.put("azucar", rs.getDouble("azucar"));
                valores.put("fibra", rs.getDouble("fibra"));
                valores.put("calcio", rs.getDouble("calcio"));
                valores.put("hierro", rs.getDouble("hierro"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener nutrientes de '" + nombreProducto + "': " + e.getMessage());
        }

        return valores;
    }
}






