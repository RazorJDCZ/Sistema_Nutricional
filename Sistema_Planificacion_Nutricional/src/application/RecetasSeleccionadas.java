package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class RecetasSeleccionadas {

    private static final ObservableList<ResumenReceta> seleccionadas = FXCollections.observableArrayList();
    private static final Map<String, List<IngredienteReceta>> ingredientesPorReceta = new HashMap<>();

    // ✅ Agrega la receta si no ha sido seleccionada antes
    public static void agregar(ResumenReceta receta, List<IngredienteReceta> ingredientes) {
        boolean existe = seleccionadas.stream().anyMatch(r -> r.getNombre().equalsIgnoreCase(receta.getNombre()));
        if (!existe) {
            seleccionadas.add(receta);
            ingredientesPorReceta.put(receta.getNombre(), ingredientes);
        }
    }

    // ✅ Devuelve todas las recetas seleccionadas
    public static ObservableList<ResumenReceta> obtenerTodas() {
        return FXCollections.unmodifiableObservableList(seleccionadas);
    }

    // ✅ Limpia selección
    public static void limpiar() {
        seleccionadas.clear();
        ingredientesPorReceta.clear();
    }

    // ✅ Accede a los ingredientes almacenados por nombre real de la receta
    public static List<IngredienteReceta> obtenerIngredientesPorReceta(String nombreReceta) {
        return ingredientesPorReceta.getOrDefault(nombreReceta, List.of());
    }
}




