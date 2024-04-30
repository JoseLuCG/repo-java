package EjercicioBaseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static EjercicioBaseDatos.Functions.*;

public class DAOEmployees {
    // ======================================================================
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

    // ======================================================================

    /**
     *
     */
    public static void deleteEmployee() {
        PreparedStatement deleteEmployee = null;
        int dni;

        outPut.println("Inserta el dni del empleado a borrar.");
        dni = sc.nextInt();

        if (connection()) {
            try {
                String sqlQuery = "DELETE FROM empregado WHERE DNI = ?";
                deleteEmployee = connection.prepareStatement(sqlQuery);
                deleteEmployee.setInt(1,dni);
                deleteEmployee.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }
}
