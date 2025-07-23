package application;

public class IngredienteReceta {
    private String nombreProducto;
    private String cantidad;

    public IngredienteReceta(String nombreProducto, String cantidad) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public String getNombreProducto() { return nombreProducto; }
    public String getCantidad() { return cantidad; }
}

