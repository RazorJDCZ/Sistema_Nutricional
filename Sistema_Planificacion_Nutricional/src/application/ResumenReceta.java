package application;

public class ResumenReceta {
    private String nombre;
    private int calorias;
    private String enlace;

    public ResumenReceta(String nombre, int calorias, String enlace) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.enlace = enlace;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getEnlace() {
        return enlace;
    }
}

