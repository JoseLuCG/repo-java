package Serializacion.Ejercicio2;

import static Serializacion.Ejercicio2.Functions.*;

public class Main {
    public static void main(String[] args) {
        int option;
        // src/main/resources/
        // MENU:

        do {
            outPut.println("Indique que operación desea realizar:");
            outPut.println("[1] - Crear nuevo fichero.");
            outPut.println("[2] - Añadir nuevo cliente.");
            outPut.println("[3] - Listar los clientes.");
            outPut.println("[4] - Borrar fichero.");
            outPut.println("[5] - Salir.");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    creteFile(); break;
                case 2:
                    addClient(clientList); break;
                case 3:
                    listClients(clientList); break;
                case 4:
                    deleteFile(); break;
                case 5:
                    System.out.println("5"); break;
                default: outPut.println("Selecciona una opción válida.");
            }
        }while (option != 5);
    }
}
