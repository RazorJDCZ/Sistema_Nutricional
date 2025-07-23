package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DetallePlan {

    private final StringProperty dia;
    private final StringProperty producto;
    private final StringProperty cantidad;

    public DetallePlan(String dia, String producto, String cantidad) {
        this.dia = new SimpleStringProperty(dia);
        this.producto = new SimpleStringProperty(producto);
        this.cantidad = new SimpleStringProperty(cantidad);
    }

    public StringProperty diaProperty() {
        return dia;
    }

    public StringProperty productoProperty() {
        return producto;
    }

    public StringProperty cantidadProperty() {
        return cantidad;
    }
}

