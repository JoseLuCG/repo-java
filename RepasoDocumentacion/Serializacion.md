# **Serialización y deserialización en Java**

La reialización ean Java es el proceso de convertir un objeto en una secuencia de bytes, para posteriormente almacenar o transmitir. Esto nos permite guardar el estado de un objeto en un archivo, enviarlo a través de una red o incluso almacenarlo en una base de datos. La deserialización es el proceso inverso: recuperar el objeto original a partir de los bytes serializados.

En Java, la serialización y deserialización de objetos se logran mediante las interfaces `Serializable` y `Externalizable`:
1. `Serializable`: Es una interfaz de marcador que indica que una clase puede ser serializada. No tiene métodos, pero permite que la clase sea procesada por el mecanismo de serialización de Java.
2. `Externalizable`: Externalizable : Proporciona métodos personalizados para controlar el proceso de serialización y deserialización. Si necesitas un mayor control sore el proceso, puedes implementar esta interfaz.

## Ejemplo de serialización de objetos personalizados:

```Java
import java.io.Serializable;
class Empleado implements Serializable {
    String nombre;
    String direccion;
}
```

```Java
public class EjemploSerializacion {
    public static void main(String[] args) {
        // Crear un objeto Empleado
        Empleado empleado = new Empleado();
        empleado.nombre = "Juan Pérez";
        empleado.direccion = "Calle Principal, Ciudad";
    
        // Serializar el objeto a un archivo
        try {
            File0utputStream archivoSalida = new File0utputStream("empleado.ser");
            0bject0utputStream objetoSalida = new 0bject0utputStream(archivoSalida);
            objetoSalida.write0bject(empleado);
            objetoSalida.close();
            archivoSalida.close();
            System.out.println("0bjeto Empleado serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
En este ejemplo, creamos un objeto Empleado , lo serializamos y guardamos en un archivo
llamado "empleado.ser".

## Serialización de colecciones en Java

```Java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arraylist;
import java.util.List;

public class SerializacionArraylist {
    public static void main(String[] args) {
        List<String> nombres = new Arraylist<>();
        nombres.add("Ana");
        nombres.add("Carlos");
        nombres.add("María");

        try {
            FileOutputStream archivoSalida = new FileOutputStream("nombres.ser");
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(nombres);
            objetoSalida.close();
            archivoSalida.close();
        }
    }
} 
```
En este caso, hemos serializado un Arraylist de nombres y lo hemos guardado en un archivo llamado "nombres.ser". Recuerda que al deserializar, debes manejar las excepciones

## Serialización de HashMap con objetos de la clase Persona en Java

```Java
import java.io.*;
import java.util.HashMap;

class Persona implements Serializable {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    // Getters y setters (omito para simplificar el ejemplo) 
    // toString ...
}
```
Serialización:
```Java
public class SerializacionHashMap {
    public static void main(String[] args) {
        // Crear un HashMap de personas
        HashMap<Integer, Persona> personas = new HashMap<>();
        personas.put(l, new Persona("Juan", 30));
        personas.put(2, new Persona("Maria", 25));
        personas.put(3, new Persona("Carlos", 28));
        
        // Serializar el HashMap a un archivo
        try {
            FileOutputStream archivoSalida = new FileOutputStream("personas.ser");
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(personas);
            objetoSalida.close();
            archivoSalida.close();
            System.out.println("HashMap de personas serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}       
```
Deserializar el HashMap desde el archivo:
```Java
// Deserializar el HashMap desde el archivo 

try {
    FileinputStream archivoEntrada = new FileinputStream("personas.ser");
    ObjectinputStream objetoEntrada = new ObjectinputStream(archivoEntrada);
    HashMap<Integer, Persona> personasDeserializadas =  (HashMap<Integer, Persona>) objetoEntrada.readObject();
    objetoEntrada.close();
    archivoEntrada.close();

    //Imprimir las personas deserializadas
    System.out.println("Personas deserializadas:");
    for (Persona p : personasDeserializadas.values()) {
        System.out.println(p);
    }
} catch (IOException I ClassNotFoundException ex) {
    ex.printStackTrace();
} 
```
En este ejemplo, hemos creado un HashMap llamado personas que almacena objetos de la
clase Persona . Luego, lo serializamos a un archivo llamado "personas.ser" y posteriormente lo deserializamos para recuperar las personas almacenadas. 