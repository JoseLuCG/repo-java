package herencia;

import java.time.LocalDate;

public class Masajista extends SeleccionFutbol{

    private String titulacion;
    private int aniosExperiencia;

    // Constructores

    public Masajista(int id, String nombre, String apellidos, int edad, LocalDate fecha, String titulacion, int aniosExperiencia) {
        super(id, nombre, apellidos, edad, fecha);
        this.titulacion = titulacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Masajista() {
        super();
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public void darMasaje() {}

    @Override
    public String toString() {
        return "Masajista: " + super.toString() +
                ", titulacion='" + titulacion + '\'' +
                ", aniosExperiencia=" + aniosExperiencia;
    }
}
