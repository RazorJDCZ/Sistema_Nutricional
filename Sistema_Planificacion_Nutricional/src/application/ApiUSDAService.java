package application;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ApiUSDAService {

    public Map<String, Double> obtenerNutrientesPorNombre(String nombreProducto) {
        Map<String, Double> valores = new HashMap<>();
        String query = "SELECT * FROM valoresnutricionalesapi WHERE LOWER(nombre_producto) = LOWER(?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombreProducto.trim().toLowerCase());
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
            } else {
                return valoresVacios();
            }

        } catch (Exception e) {
            System.out.println("Error al consultar nutrientes: " + e.getMessage());
           return valoresVacios();
        }

        return valores;
    }

    private Map<String, Double> valoresVacios() {
        Map<String, Double> vacio = new HashMap<>();
        vacio.put("calorias", 0.0);
        vacio.put("proteinas", 0.0);
        vacio.put("grasas", 0.0);
        vacio.put("carbohidratos", 0.0);
        vacio.put("azucar", 0.0);
        vacio.put("fibra", 0.0);
        vacio.put("calcio", 0.0);
        vacio.put("hierro", 0.0);
        return vacio;
    } 
}








