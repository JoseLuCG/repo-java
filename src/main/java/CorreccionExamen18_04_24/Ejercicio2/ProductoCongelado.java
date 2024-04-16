package CorreccionExamen18_04_24.Ejercicio2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductoCongelado extends Producto{
    private int temperatura;
    private LocalDate fechaElaboracion;
    private LocalDate fechaCaducidad;

    // Constructors.
    public ProductoCongelado () {}

    public ProductoCongelado(String ean, String nombre, int precio, int existencias, int temperatura, LocalDate fechaElaboracion, LocalDate fechaCaducidad) {
        super(ean, nombre, precio, existencias);
        this.temperatura = temperatura;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Setters

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setFechaElaboracion(LocalDate fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters

    public int getTemperatura() {
        return temperatura;
    }

    public LocalDate getFechaElaboracion() {
        return fechaElaboracion;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    // ToString
    @Override
    public String toString() {
        return "ProductoCongelado: " +
                "\n"+super.toString() +
                "\ntemperatura: " + temperatura +
                "\nfechaElaboracion: " + fechaElaboracion +
                "\nfechaCaducidad: " + fechaCaducidad;
    }

    public long diasDeCaducidad () {
        return ChronoUnit.DAYS.between(fechaElaboracion, fechaCaducidad);
    }

}
