package Serializacion.Ejercicio1;

import java.time.LocalDate;

public class Automovil extends Vehiculo{
    //  ATRIBUTOS
    private int numeroPuertas;

    //  CONSTRUCTOR

    public Automovil() {
    }

    public Automovil(String marca, String modelo, LocalDate fechaFabricacion, String color, int numeroPuertas) {
        super(marca, modelo, fechaFabricacion, color);
        this.numeroPuertas = numeroPuertas;
    }

    //  GETTER/SETTER

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    //  METODOS
    @Override
    int calcularCostoMantenimiento() {
        int costoMantenimiento= (int) (COSTEBASE * Math.pow((1+0.05),aniosAntiguedad()) + numeroPuertas * 10);
        return costoMantenimiento;
    }

    @Override
    public String toString() {
        return "Automovil: \n" +
                "|numeroPuertas: " + numeroPuertas + '\n' +
                "|marca: " + marca + '\n' +
                "|modelo: " + modelo + '\n' +
                "|fechaFabricacion: " + fechaFabricacion + '\n' +
                "|color: " + color + '\n' +
                "|costebase: " + COSTEBASE + '\n' +
                "|CosteMantenimiento: " + calcularCostoMantenimiento()
                ;
    }
}
