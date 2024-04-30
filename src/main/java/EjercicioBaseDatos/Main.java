package EjercicioBaseDatos;

import EjercicioBaseDatos.Models.Department;

import static EjercicioBaseDatos.Functions.*;
import static EjercicioBaseDatos.DAODepartment.*;
import static EjercicioBaseDatos.DAOEmployees.*;

public class Main {
    public static void main(String[] args) {
        int option;

        do {
            outPut.println("Seleccione la opción que desea realizar:");
            outPut.println("[1] - Modificar un departamento.");
            outPut.println("[2] - Listar los departamentos existentes.");
            outPut.println("[3] - Dar de alta un nuevo departamento.");
            outPut.println("[4] - Listar los empleados de un departamento.");
            outPut.println("[5] - Eliminar un empleado.");
            outPut.println("[6] - Salir.");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    Department depUp = createDepartment(1);
                    updateDepartment(depUp);
                    break;
                case 2: getDepartments(); break;
                case 3:
                    Department dep = createDepartment(2);
                    setDepartment(dep);
                    break;
                case 4: getEmployees(); break;
                case 5: deleteEmployee(); break;
                case 6: outPut.println("Cerrando sesión..."); break;
                default:
                    outPut.println("Se ha producido un error. Intentelo de nuevo o eliga una opción válida.");
            }
        } while (option != 6);
    }
}
