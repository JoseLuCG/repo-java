package herencia;

import java.time.LocalDate;

public class Futbolista extends SeleccionFutbol{
    // Attributes

    private int dorsal;
    private String demarcacion;

    // Methods.
    // Constructors.

    public Futbolista(int id, String nombre, String apellidos, int edad, LocalDate fecha, int dorsal, String demarcacion) {
        super(id, nombre, apellidos, edad, fecha);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public Futbolista(int dorsal, String demarcacion) {
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    public Futbolista() {
        super();
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    @Override
    public String toString() {
        return "Futbolista: " + super.toString() +
                ", dorsal=" + dorsal +
                ", demarcacion='" + demarcacion + '\'';
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    // m especificos

    public void jugarPartido (){
        //Instrucciones del método.
    }

    public void entrenar () {
        //Instrucciones del método.
    }
}
