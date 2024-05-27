package EjercicioBaseDatos;

import EjercicioBaseDatos.Models.Department;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import static EjercicioBaseDatos.DAODepartment.*;

public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);
    static Connection connection = null;
    // ======================================================================
    /**
     * Connect to the database.
     * @return - True if I connect, false if not.
     */
    public static boolean connection () {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/"; //podemos indicar la url "jdbc:mysql://localhost:3306"
        String db = "departamentos";	// nombre de la base de datos;
        String user = "root";			// usuario
        String pwd = "abc123.";			// contraseña

        try {
            connection = DriverManager.getConnection(dbUrl, user, pwd);
            connection.setCatalog(db);
            outPut.println("Conexión establecida con éxito.");

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // ======================================================================
    /**
     * Creates a Department object for use it en the database connection.
     * @param option Option 1 creates the object with the primary key code. Option 2 creates the object without the code.
     * @return Returns a object Department.
     */
    public static Department createDepartment (int option) {
        String name;
        String city;
        int id_province;
        Department department;
        int code;

        if (option == 2) {
            outPut.println("Inserte el nombre del nuevo departamento:");
            name = sc.nextLine();
            outPut.println("Ingrese el nombre de la ciudad donde está ubicado el departamento:");
            city = sc.nextLine();
            outPut.println("Inserte el id correspondiente a la provincia de su ciudad.");
            id_province = sc.nextInt();
            sc.nextLine();
            department = new Department(name,city, id_province);

            return department;
        } else {
            outPut.println("Inserte el nuevo nombre departamento:");
            name = sc.nextLine();
            outPut.println("Ingrese la nueva ciudad donde está ubicado el departamento:");
            city = sc.nextLine();
            outPut.println("Inserte el id correspondiente a la nueva provincia de su ciudad.");
            id_province = sc.nextInt();
            sc.nextLine();
            outPut.println("Indique el código del departamento a modificar:");
            code = sc.nextInt();
            sc.nextLine();
            department = new Department(code, name,city, id_province);

            return department;
        }
    }
    // ======================================================================
    public static void showData () {
        HashMap<Integer,Department> collection = getDepartments();
        /*
            for (Department dep: collection) {

            }
        */

    }

}
