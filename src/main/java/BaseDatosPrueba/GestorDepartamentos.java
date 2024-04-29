package BaseDatosPrueba;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class GestorDepartamentos {
    public static PrintStream outPut = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    static Connection connection = null;

    public static boolean conexion() {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/"; //podemos indicar la url "jdbc:mysql://localhost:3306"
        String db = "departamentos";	// nombre de la base de datos;
        String user = "root";			// usuario
        String pwd = "abc123.";			// contraseña

        try {
            //nos conectamos al servidor, sin conectarnos con una bd en concreto
            connection = DriverManager.getConnection(dbUrl, user, pwd);
            connection.setCatalog(db);
            System.out.println("Conexion realizada con exito");

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static void altaDepartamento(String a, String b, int c) {
        PreparedStatement insertarDepartamento = null;
        int inserciones;

        if (conexion()) {
            try{
                String insertString = "insert into departamento (nome,cidade,id_provincia) values (?,?,?)";
                insertarDepartamento = connection.prepareStatement(insertString);
                insertarDepartamento.setString(1, a);
                insertarDepartamento.setString(2,b);
                insertarDepartamento.setInt(3, c);
                inserciones = insertarDepartamento.executeUpdate(insertString, Statement.RETURN_GENERATED_KEYS);
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("La conexion ha fallado.");
        }
    }

    public static void consulta () {
        Statement mySqlSelect = null;
        ResultSet mySqlResult = null;

        try {
            if (conexion()) {
                mySqlSelect = connection.createStatement();
                mySqlResult = mySqlSelect.executeQuery("SELECT * FROM departamento ORDER BY cidade ASC");

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

    public static void update() {
        Statement modificarDepartamento = null;
        int inserciones;

        if (conexion()) {
            try{
                modificarDepartamento = connection.createStatement();
                String insertString = "UPDATE departamento SET nome = 'Central' where codigo = 1";
                inserciones = modificarDepartamento.executeUpdate(insertString, Statement.RETURN_GENERATED_KEYS);
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("La conexion ha fallado.");
        }
    }

    public static void main(String[] args) {
        //altaDepartamento();
        consulta();
        update();
    }
}
