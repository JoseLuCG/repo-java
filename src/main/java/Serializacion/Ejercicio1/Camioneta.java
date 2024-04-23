package Serializacion.Ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;

public class Camioneta extends Vehiculo {
    //  ATRIBUTOS
    private double capacidadCarga;

    //  CONSTRUCTOR
    public Camioneta() {
    }

    public Camioneta(String marca, String modelo, LocalDate fechaFabricacion, String color, double capacidadCarga) {
        super(marca, modelo, fechaFabricacion, color);
        this.capacidadCarga = capacidadCarga;
    }

    //  GETTER/SETTER
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    //  METODOS
    @Override
    public int calcularCostoMantenimiento() {
        int costoMantenimiento=(int) (COSTEBASE * Math.pow((1+0.05),aniosAntiguedad()) + capacidadCarga * 15);
        return costoMantenimiento;
    }

    @Override
    public String toString() {
        return "Camioneta: \n" +
                "|capacidadCarga: " + capacidadCarga + '\n' +
                "|marca: " + marca + '\n' +
                "|modelo: " + modelo + '\n' +
                "|fechaFabricacion: " + fechaFabricacion + '\n' +
                "|color: " + color + '\n' +
                "|costebase: " + COSTEBASE + '\n' +
                "|CosteMantenimiento: " + calcularCostoMantenimiento()
                ;
    }
}
