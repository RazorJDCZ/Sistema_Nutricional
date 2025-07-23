package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recetario {
    public static List<Receta> obtenerRecetas() {
        List<Receta> recetas = new ArrayList<>();

        recetas.add(new Receta(
            1,
            "Arroz con pollo",
            "Fácil y balanceada",
            "Adulto",
            521,
            "Mezclar todo y servir frío.",
            "https://www.lasrecetascocina.com/prepara-este-arroz-con-pollo-y-zanahoria/",
            Arrays.asList(
                new IngredienteReceta("Pollo", "150 g"),
                new IngredienteReceta("Zanahoria", "80 g"),
                new IngredienteReceta("Arroz", "100 g")
            )
        ));

        recetas.add(new Receta(
            2,
            "Galleta energética",
            "Ideal para niños",
            "Niño",
            596,
            "Hornear 15 minutos.",
            "https://www.youtube.com/watch?v=EgyCna2qXbc",
            Arrays.asList(
                new IngredienteReceta("Avena", "50 g"),
                new IngredienteReceta("Galletas", "80 g")
            )
        ));

        recetas.add(new Receta(
            3,
            "Arroz con vegetales",
            "Económica y saludable",
            "Adulto Mayor",
            197,
            "Saltear todo junto.",
            "https://www.youtube.com/watch?v=KfhuvCjUQA0",
            Arrays.asList(
                new IngredienteReceta("Arroz", "120 g"),
                new IngredienteReceta("Zanahoria", "60 g"),
                new IngredienteReceta("Cebolla", "40 g")
            )
        ));

        recetas.add(new Receta(
            4,
            "Pollo guisado con arroz",
            "Comida completa y saciante",
            "Adulto",
            508,
            "Guisar el pollo con cebolla y servir con arroz.",
            "https://www.youtube.com/watch?v=qMe22sDGbQI",
            Arrays.asList(
                new IngredienteReceta("Pollo", "150 g"),
                new IngredienteReceta("Arroz", "100 g"),
                new IngredienteReceta("Cebolla", "50 g")
            )
        ));

        recetas.add(new Receta(
            5,
            "Ensalada fría de pasta",
            "Fácil y fresca",
            "Niño",
            320,
            "Cocer la pasta y mezclar con atún y verduras cocidas.",
            "https://www.youtube.com/watch?v=IcKySR9Rrh8&t=4s",
            Arrays.asList(
                new IngredienteReceta("Pasta", "100 g"),
                new IngredienteReceta("Atún", "80 g"),
                new IngredienteReceta("Choclo", "40 g")
            )
        ));

        recetas.add(new Receta(
            6,
            "Tortilla de papa",
            "Rica en energía",
            "Adulto",
            128,
            "Freír la papa y luego mezclar con huevo y sal.",
            "https://www.paulinacocina.net/tortilla-de-papas-espanola/10476?utm_source=chatgpt.com",
            Arrays.asList(
                new IngredienteReceta("Papa", "150 g"),
                new IngredienteReceta("Cebolla", "30 g")
            )
        ));

        recetas.add(new Receta(
            7,
            "Ensalada de frutas",
            "Ideal para desayuno",
            "Primera Infancia",
            300,
            "Cortar y juntar todo.",
            "https://www.youtube.com/watch?v=Ihutc0Io__k&t=3s",
            Arrays.asList(
                new IngredienteReceta("Manzana", "50 g"),
                new IngredienteReceta("Piña", "50 g"),
                new IngredienteReceta("Platano", "150 g")
            )
        ));

        recetas.add(new Receta(
            8,
            "Porridge de avena",
            "Desayuno nutritivo",
            "Adulto Mayor",
            395,
            "Cocer la avena con leche y endulzar al gusto.",
            "https://www.youtube.com/watch?v=P4AE_rRHhk0",
            Arrays.asList(
                new IngredienteReceta("Avena", "80 g"),
                new IngredienteReceta("Leche", "200 ml")
            )
        ));

        recetas.add(new Receta(
            9,
            "Vegetales al vapor",
            "Ligera y saludable",
            "Adulto",
            88,
            "Cocer vegetales al vapor por 10 minutos.",
            "https://cookpad.com/ar/recetas/24843995?ref=search&search_term=choclo+zanahoria+cebolla",
            Arrays.asList(
                new IngredienteReceta("Zanahoria", "70 g"),
                new IngredienteReceta("Cebolla", "30 g"),
                new IngredienteReceta("Choclo", "50 g")
            )
        ));

        recetas.add(new Receta(
            10,
            "Pollo con piña",
            "Combinación agridulce",
            "Adulto",
            409,
            "Saltear el pollo y agregar piña en cubos.",
            "https://comidasperuanas.net/pollo-con-pina/",
            Arrays.asList(
                new IngredienteReceta("Pollo", "150 g"),
                new IngredienteReceta("Piña", "100 g")
            )
        ));

        return recetas;
    }
}


