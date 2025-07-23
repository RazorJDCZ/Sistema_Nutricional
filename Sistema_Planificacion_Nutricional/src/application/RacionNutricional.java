package application;

public class RacionNutricional {

    private final String categoria;
    private final String cantidad;

    public RacionNutricional(String categoria, String cantidad) {
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCantidad() {
        return cantidad;
    }
}

