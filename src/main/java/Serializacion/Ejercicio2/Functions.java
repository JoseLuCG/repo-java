package Serializacion.Ejercicio2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;
/*resources*/
public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    public static Scanner sc = new Scanner(System.in);

    public static HashMap<Integer, Cliente> clientList = new HashMap<>();

    /**
     * Create a file in the path: -src/main/java/Serializacion/Ejercicio2/Ficheros/-.
     */
    public static void creteFile () {
        try {
            File f=new File("src/main/java/Serializacion/Ejercicio2/Ficheros/clientes.bin");
            if( !f.exists() ) {
                f.createNewFile();
                outPut.println("El archivo se ha creado correctamente.");
            } else {
                outPut.println("El fichero ya existe.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates a new client and add it in the hashMap.
     * @param clients - The hachMap to fill out.
     */
    public static void addClient (HashMap<Integer, Cliente> clients) {
        String name, surname, phoneNumber;
        int age;

        outPut.println("Escriba el nombre del cliente:");
        name = sc.nextLine();
        outPut.println("Escriba los apellidos del cliente:");
        surname = sc.nextLine();
        outPut.println("Escriba el teléfono del cliente:");
        phoneNumber = sc.nextLine();
        outPut.println("Escriba la edad del cliente:");
        age = sc.nextInt();

        Cliente newClient = new Cliente(name, surname, phoneNumber, age);

        clients.put(1,newClient);
        serialize();
    }

    /**
     * Show the clients list.
     * @param clients HashMap to show.
     */
    public static void listClients (HashMap<Integer, Cliente> clients) {
        outPut.println(clients.toString());
    }

    /**
     * Deletes the file.
     */
    public static void deleteFile () {
        File file = new File("src/main/java/Serializacion/Ejercicio2/Ficheros/clientes.bin");
        if ( !file.exists() ) {
            outPut.println("El archivo no existe:");
        } else {
            if (file.delete()) {
                outPut.println("El archivo se ha eliminado correctamente.");
            } else {
                outPut.println("Fallo al borrar el fichero.");
            }
        }
    }

    /**
     * Serializes data added to the collection.
     */
    public static void serialize () {
        try {
            FileOutputStream file = new FileOutputStream("src/main/java/Serializacion/Ejercicio2/Ficheros/clientes.bin");
            ObjectOutputStream collection = new ObjectOutputStream(file);
            collection.writeObject(clientList);
            collection.close();
            file.close();
            outPut.println("HashMap serializado correctamente.");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Deserializes the data from the file.
     */
    public static void deserialize () {
        try {
            FileInputStream file = new FileInputStream("src/main/java/Serializacion/Ejercicio2/Ficheros/clientes.bin");
            ObjectInputStream collection = new ObjectInputStream(file);
            clientList = (HashMap<Integer, Cliente>) collection.readObject();
            collection.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
