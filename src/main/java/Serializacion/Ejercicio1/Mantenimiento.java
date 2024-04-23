package Serializacion.Ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;
enum TipoMantenimiento {
    PREVENTIVO,CORRECTIVO
}
public class Mantenimiento implements Comparable<Mantenimiento>, Serializable {
    private Vehiculo vehiculo;
    private TipoMantenimiento tipo;
    private LocalDate fechaMantenimiento;

    public Mantenimiento(Vehiculo vehiculo, TipoMantenimiento tipo, LocalDate fechaMantenimiento) {
        this.vehiculo = vehiculo;
        this.tipo = tipo;
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }


    @Override
    public int compareTo(Mantenimiento o) {
        return vehiculo.fechaFabricacion.compareTo(o.vehiculo.fechaFabricacion);
    }

    @Override
    public String toString() {
        return "Mantenimiento: \n" +
                "\nvehiculo: " + vehiculo +
                "\ntipo: " + tipo +
                "\nfechaMantenimiento: " + fechaMantenimiento;
    }
}

