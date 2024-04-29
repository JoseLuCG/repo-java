package EjercicioBaseDatos;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Scanner;

public class Functions {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    public static Scanner sc = new Scanner(System.in);
    static Connection connection = null;

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

    /**
     * Get the departments from the database
     */
    public static void getDepartments () {
        Statement mySqlSelect = null;
        ResultSet mySqlResult = null;
        String sqlQuery = "SELECT * FROM departamento";

        try {
            if (connection()) {
                mySqlSelect = connection.createStatement();
                mySqlResult = mySqlSelect.executeQuery(sqlQuery);

                while (mySqlResult.next()) {
                    outPut.printf("%10d ",mySqlResult.getInt(1));
                    outPut.printf("%10s ",mySqlResult.getString("nome"));
                    outPut.printf("%10s ",mySqlResult.getString("cidade"));
                    outPut.printf("%10d ",mySqlResult.getInt("id_provincia"));
                    outPut.println();
                }
            }
            mySqlResult.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Add a new department in database.
     */
    public static void setDepartment () {
        PreparedStatement insertDepartment = null;
        String name;
        String city;
        int id_province;

        outPut.println("Inserte el nombre del nuevo departamento:");
        name = sc.nextLine();
        outPut.println("Ingrese el nombre de la ciudad donde está ubicado el departamento:");
        city = sc.nextLine();
        outPut.println("Inserte el id correspondiente a la provincia de su ciudad.");
        id_province = sc.nextInt();
        sc.nextLine();

        if (connection()) {
            try {
                String sqlQuery = "INSERT INTO departamento(nome,cidade,id_provincia) VALUES(?,?,?)";
                insertDepartment = connection.prepareStatement(sqlQuery);
                insertDepartment.setString(1,name);
                insertDepartment.setString(2, city);
                insertDepartment.setInt(3,id_province);
                insertDepartment.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }

    public static void getEmployees() {
        PreparedStatement mySqlSelect = null;
        ResultSet mySqlResult = null;
        int departmentName;

        outPut.println("Seleccione el departamento del que desea ver sus empleados:");
        departmentName = sc.nextInt();
        try {
            if (connection()) {
                String sqlQuery = "SELECT * FROM empregado WHERE departamento = ? ";
                mySqlSelect = connection.prepareStatement(sqlQuery);
                mySqlSelect.setInt(1,departmentName);
                mySqlResult = mySqlSelect.executeQuery();

                while (mySqlResult.next()) {
                    outPut.printf("%10d ",mySqlResult.getInt(1));
                    outPut.printf("%20s ",mySqlResult.getString("apelidos"));
                    outPut.printf("%15s ",mySqlResult.getString("nome"));
                    outPut.printf("%5d ",mySqlResult.getInt("departamento"));
                    outPut.printf("%10.2f ",mySqlResult.getBigDecimal("salario_bruto"));
                    outPut.println();
                }
                outPut.println();
            }
            mySqlResult.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deleteEmployee() {

    }
}
