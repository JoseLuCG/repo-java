# Ficheros

En Java, los ficheros de texto se utilizan para almacenar y manipular datos en forma de texto legible. Java proporciona diversas clases y métodos en el paquete `java.io` para trabajar con ficheros de texto.

## Lectura de Ficheros de texto.

Para leer datos desde un fichero de texto en Java, se pueden seguir estos pasos:

1. **Abrir el Fichero**: Utiliza la clase `FileReader` o `BufferedReader` para abrir el fichero en modo de lectura.
2. **Leer el Contenido**: Utiliza los métodos `readLine()` o `read()` para leer líneas o
caracteres del fichero, respectivamente.
3. **Cerrar el Fichero**: No olvides cerrar el fichero después de terminar de leerlo para liberar los recursos utilizando el método `close()`.

Ejemplo de lectura de un fichero de texto en Java:
```Java
try (BufferedReader lector = new BufferedReader(new FileReader("archivo.txt"))) {
    String linea;

    while ((linea = lector.readLine()) != null) {
    // Procesa la línea leída
    System.out.println(linea);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```
+ `FileReader`: Esta clase se utiliza para leer caracteres de un archivo. Toma el nombre del archivo o un objeto `File` como argumento en su constructor. Lee los datos del archivo como caracteres Unicode.
+ `BufferedReader`: Esta clase mejora la eficiencia de la lectura al almacenar en búfer los caracteres leídos del archivo. Proporciona el método `readLine()` que lee una línea
completa de texto desde el archivo.


## Escritura en Ficheros de texto

Puedes usar la clase `FileWriter` para escribir en un archivo de texto. Al igual que con la lectura, puedes envolverlo en un `BufferedWriter` para mejorar la eficiencia. Aquí tienes un ejemplo:

```Java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraArchivoTexto {
    public static void main(String[] args) {
        String nombreArchivo = "archivo_salida.txt";
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("Hola, este es un ejemplo de escritura en archivo de texto.")
            bw.newLine();
            bw.write("¡Espero que te sea útil!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
+ `FileWriter`: Esta clase se utiliza para escribir caracteres en un archivo. Toma el nombre del archivo o un objeto `File` como argumento en su constructor. Escribe los datos en el archivo como caracteres Unicode. `FileWriter` permite la sobreescritura de archivos mediante el segundo parámetro booleano. Estos son parametros: 
```java
new FileWriter(file,true); // true = append, false = overwrite
```

+ `BufferedWriter`: Similar a `BufferedReader`, esta clase mejora la eficiencia de la escritura al almacenar en búfer los caracteres escritos en el archivo. Proporciona el método `write()` para escribir cadenas de texto en el archivo, así como el método `newLine()` para escribir un salto de línea.