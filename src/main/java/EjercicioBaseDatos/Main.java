package EjercicioBaseDatos;

import static BaseDatosPrueba.Functions.*;

public class Main {
    public static void main(String[] args) {
        int option;

        do {
            outPut.println("Seleccione la opción que desea realizar:");
            outPut.println("[1] - Obtener conexión.");
            outPut.println("[2] - Listar los departamentos existentes.");
            outPut.println("[3] - Dar de alta un nuevo departamento.");
            outPut.println("[4] - Listar los empleados de un departamento.");
            outPut.println("[5] - Eliminar un empleado.");
            outPut.println("[6] - Salir.");
            option = sc.nextInt();

            switch (option) {
                case 1: System.out.println("1"); break;
                case 2: System.out.println("2"); break;
                case 3: System.out.println("3"); break;
                case 4: System.out.println("4"); break;
                case 5: System.out.println("5"); break;
                case 6: System.out.println("6"); break;
                default:
                    outPut.println("Se ha producido un error. Intentelo de nuevo o eliga una opción válida.");
            }
        } while (option != 6);
    }
}
