package application;

public class Producto {
    private String nombre;
    private String unidad;
    private String categoria;
    private String marca;
    private int cantidad;
    private String fuente;

    public Producto(String nombre, String unidad, String categoria, String marca, String fuente, int cantidad) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.categoria = categoria;
        this.marca = marca;
        this.fuente = fuente;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFuente() {
        return fuente;
    }
}

