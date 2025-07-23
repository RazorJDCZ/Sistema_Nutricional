package application;

public class ComparacionNutriente {
    private String nombre;
    private double recomendado;
    private double aportado;
    private boolean cumple;

    public ComparacionNutriente(String nombre, double recomendado, double aportado) {
        this.nombre = nombre;
        this.recomendado = recomendado;
        this.aportado = aportado;

        // ✅ Nueva lógica: cumple si aportado ≥ recomendado
        if (recomendado == 0) {
            this.cumple = aportado == 0;
        } else {
            this.cumple = aportado >= recomendado;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getRecomendado() {
        return Math.round(recomendado * 100.0) / 100.0;
    }

    public double getAportado() {
        return Math.round(aportado * 100.0) / 100.0;
    }

    public boolean isCumple() {
        return cumple;
    }

    public String getCumpleSimbolo() {
        return cumple ? "Cumple" : "No cumple";
    }
}






