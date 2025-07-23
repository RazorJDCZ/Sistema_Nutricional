package application;

import java.util.List;

public class Receta {
    private int id;
    private String nombre;
    private String descripcion;
    private String grupoEtario;
    private int caloriasTotal;
    private String instrucciones;
    private String link;
    private List<IngredienteReceta> ingredientes;

    public Receta(int id, String nombre, String descripcion, String grupoEtario,
                  int caloriasTotal, String instrucciones, String link,
                  List<IngredienteReceta> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupoEtario = grupoEtario;
        this.caloriasTotal = caloriasTotal;
        this.instrucciones = instrucciones;
        this.link = link;
        this.ingredientes = ingredientes;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGrupoEtario() {
        return grupoEtario;
    }

    public int getCaloriasTotal() {
        return caloriasTotal;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public String getLink() {
        return link;
    }

    public List<IngredienteReceta> getIngredientes() {
        return ingredientes;
    }
}

