package Serializacion.Ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehiculo implements Serializable {
    //  ATRIBUTOS
    protected String marca;
    protected String modelo;
    protected LocalDate fechaFabricacion;
    protected String color;
    protected final int COSTEBASE =80;

    //  CONSTRUCTORES
    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, LocalDate fechaFabricacion, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.color = color;
    }

    //  GETTERS/SETTERS


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //  METODOS
    abstract int calcularCostoMantenimiento ();

    public int aniosAntiguedad() {
        long anios= ChronoUnit.YEARS.between(fechaFabricacion,LocalDate.now());
        return (int)anios;
    }

}
