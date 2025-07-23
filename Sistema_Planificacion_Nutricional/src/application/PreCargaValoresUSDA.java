package application;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PreCargaValoresUSDA {

    public static void main(String[] args) {
        ApiUSDAService api = new ApiUSDAService();

        // Lista de productos comunes para precargar (puedes ampliarla si quieres)
        List<String> productos = Arrays.asList(
            "arroz", "lentejas", "pollo", "zanahoria", "huevo", "leche", "pan", "manzana",
            "atun", "aceite de girasol", "fideos", "espinaca", "tomate", "papa", "plátano",
            "queso", "avena", "frejol", "naranja", "yogur"
        );

        for (String producto : productos) {
            System.out.println("🔍 Consultando: " + producto);
            Map<String, Double> nutrientes = api.obtenerNutrientesPorNombre(producto);

            if (nutrientes.isEmpty()) {
                System.out.println("❌ No se encontraron nutrientes para: " + producto);
            } else {
                System.out.println("✅ Guardado en BD: " + producto + " → " + nutrientes);
            }
        }

        System.out.println("\n🚀 Precarga finalizada.");
    }
}

