package EjercicioBaseDatos;

import EjercicioBaseDatos.Models.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import static EjercicioBaseDatos.Functions.*;

public class DAODepartment {
    // ======================================================================
    /**
     * Gets the departments from the database.
     * @return Returns a HashMap of Department objects with the database information.
     */
    public static HashMap<Integer, Department> getDepartments () {
        HashMap<Integer, Department> departments = new HashMap<>();
        Statement mySqlSelect = null;
        ResultSet mySqlResult = null;
        String sqlQuery = "SELECT * FROM departamento";

        try {
            if (connection()) {
                mySqlSelect = connection.createStatement();
                mySqlResult = mySqlSelect.executeQuery(sqlQuery);

                while (mySqlResult.next()) {
                    Department dep = new Department(
                            mySqlResult.getInt(1),
                            mySqlResult.getString("nome"),
                            mySqlResult.getString("cidade"),
                            mySqlResult.getInt("id_provincia")
                    );

                    departments.put(dep.getCode(), dep);
                    /*
                    outPut.printf("%10d ",mySqlResult.getInt(1));
                    outPut.printf("%10s ",mySqlResult.getString("nome"));
                    outPut.printf("%10s ",mySqlResult.getString("cidade"));
                    outPut.printf("%10d ",mySqlResult.getInt("id_provincia"));
                    outPut.println();
                     */
                }
            }
            mySqlResult.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return departments;
    }

    // ======================================================================
    /**
     * Add a new department in database.
     */
    public static void setDepartment (Department dep) {
        PreparedStatement insertDepartment = null;

        if (connection()) {
            try {
                String sqlQuery = "INSERT INTO departamento(nome,cidade,id_provincia) VALUES(?,?,?)";
                insertDepartment = connection.prepareStatement(sqlQuery);
                insertDepartment.setString(1,dep.getName());
                insertDepartment.setString(2, dep.getCity());
                insertDepartment.setInt(3,dep.getIdProvince());
                int rows = insertDepartment.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }

    // ======================================================================

    /**
     * Update the table departamento with the object data passed as parameter.
     * @param dep The Department object that contains the new information to update and the code of the department
     *            to change.
     */
    public static void updateDepartment (Department dep) {
        PreparedStatement insertDepartment = null;

        if (connection()) {
            try {
                String sqlQuery = "UPDATE departamento SET nome = ?, cidade = ?, id_provincia = ? WHERE codigo = ? ";
                insertDepartment = connection.prepareStatement(sqlQuery);
                insertDepartment.setString(1,dep.getName());
                insertDepartment.setString(2, dep.getCity());
                insertDepartment.setInt(3,dep.getIdProvince());
                insertDepartment.setInt(4,dep.getCode());
                int rows = insertDepartment.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else outPut.println("La conexión ha fallado.");
    }

    // ======================================================================

    /**
     * Obtains from database one row of the table departments. Requests the user a code of the department that want to
     * get the information and take it.
     * @return - The object with all data of the department request.
     */
    public static Department getOneDepartment () {
        PreparedStatement mySqlSelect = null;
        ResultSet mySqlResult = null;
        int departmentCode;
        Department dep = null;

        outPut.println("Seleccione el departamento del que desea traer de la base de datos:");
        departmentCode = sc.nextInt();
        sc.nextLine();
        try {
            if (connection()) {
                String sqlQuery = "SELECT * FROM departamento WHERE codigo = ? ";
                mySqlSelect = connection.prepareStatement(sqlQuery);
                mySqlSelect.setInt(1,departmentCode);
                mySqlResult = mySqlSelect.executeQuery();

                while (mySqlResult.next()) {
                    dep = new Department(
                            mySqlResult.getInt(1),
                            mySqlResult.getString("nome"),
                            mySqlResult.getString("cidade"),
                            mySqlResult.getInt("id_provincia")
                    );
                }
                mySqlResult.close();
                connection.close();
                return dep;
            }
            return null;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
