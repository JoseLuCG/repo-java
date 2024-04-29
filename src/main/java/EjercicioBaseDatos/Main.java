package EjercicioBaseDatos;

import static EjercicioBaseDatos.Functions.*;

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
            sc.nextLine();

            switch (option) {
                case 1: connection(); break;
                case 2: getDepartments(); break;
                case 3: setDepartment(); break;
                case 4: getEmployees(); break;
                case 5: deleteEmployee(); break;
                case 6: outPut.println("Cerrando sesión..."); break;
                default:
                    outPut.println("Se ha producido un error. Intentelo de nuevo o eliga una opción válida.");
            }
        } while (option != 6);
    }
}
