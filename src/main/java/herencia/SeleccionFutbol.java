package herencia;

import java.time.LocalDate;

public class SeleccionFutbol {
    // Attributes.

    protected int id;
    protected String nombre;
    protected String apellidos;
    protected int edad;
    protected LocalDate fechaNacimiento;

    // Methods.

    // Constructors.
    public SeleccionFutbol(int id, String nombre, String apellidos, int edad, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fecha;
    }

    public SeleccionFutbol() {}

    // Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                 ", Fecha nacimiento: "+ fechaNacimiento.toString();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Own Methods.
    public void Concentrarse () {
        // instruccciones metodo
    }
    public void Viajar () {
        //instruccciones metodo
    }


}
