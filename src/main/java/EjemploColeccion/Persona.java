package EjemploColeccion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Persona implements  Comparable<Persona>{
    // Attributes:

    private String nombre;
    private String apellidos;
    private String dni;
    private LocalDate fechaNacimiento;

    // Constructor

    public Persona () {}

    public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Setter

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setApellido(String apellido) { this.apellidos = apellido; }

    public void setDni(String dni) { this.dni = dni; }

    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    // Getter

    public String getNombre() { return nombre; }

    public String getApellido() { return apellidos; }

    public String getDni() { return dni; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    @Override
    public String toString() {
        return "Nombre = " + nombre + '\t' +
                "  apellidos = " + apellidos + '\t' +
                "  dni = " + dni + '\t' +
                "  fechaNacimiento = " + fechaNacimiento + '\t' +
                "  Edad = " + getEdad();
    }

    // Methods:
    public long getEdad() {
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }


    @Override
    public int compareTo(Persona o) {
        int x = this.apellidos.compareTo(o.apellidos);

        if (x == 0) {
            return this.nombre.compareTo(o.nombre);
        } else return x;

    }
}

class comaradorFecha implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
    }

}

class comaradorEdad implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        return (int) (o1.getEdad() - o2.getEdad());
    }

}
