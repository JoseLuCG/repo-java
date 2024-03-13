package herencia;

import java.time.LocalDate;

public class Entrenador extends SeleccionFutbol{
    private String idFederacion;

    public Entrenador(int id, String nombre, String apellidos, int edad, LocalDate fecha, String idFederacion) {
        super(id, nombre, apellidos, edad, fecha);
        this.idFederacion = idFederacion;
    }

    public Entrenador() {
        super();
    }

    public String getIdFederacion() {
        return idFederacion;
    }

    @Override
    public String toString() {
        return "Entrenador: " +
                "idFederacion='" + idFederacion + '\'' + super.toString();
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }
    public void dirigirPartido(){}
    public void dirigirEntrenamiento() {}
}
