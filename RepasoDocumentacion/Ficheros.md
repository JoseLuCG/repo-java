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