package Serializacion.Ejercicio1;

import java.util.Comparator;

//  EL último punto dice que "Los objetos serán ordenables por marca y ante igualdad por fecha, por eso he creado esto.

public class ComparatorMarcaFecha implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        int comparacion1=o2.marca.compareTo(o1.marca);
        if (comparacion1!=0) {
            return comparacion1;
        }
        return o2.fechaFabricacion.compareTo(o1.fechaFabricacion);
    }
}
