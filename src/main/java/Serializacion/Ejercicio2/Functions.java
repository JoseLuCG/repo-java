package Serializacion.Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/*resources*/
public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    public static Scanner sc = new Scanner(System.in);

    public static void creteFile () {
        try {
            File f=new File("src/main/java/Serializacion/Ejercicio2/Ficheros/clientes.bin");
            if( !f.exists() ) {
                f.createNewFile();
                System.out.println("El archivo se ha creado.");
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
