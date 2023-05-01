package JDBC.connectionsWithMethods;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public abstract class MethodsForConnection {

    private static final String database = "jdbc_exercises";
    private static final String username = "changeIt";    // de modificat pt pus pe GitHub
    private static final String password = "changeIt";  // de modificat pt pus pe GitHub

    private static Connection connection;

    public static MysqlDataSource getMysqlDataSourceObject() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", database));
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource;
    }

    public static Connection getConnection() throws SQLException {
        try {
            connection = getMysqlDataSourceObject().getConnection();
            return connection;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public static void describeTable(String tableName) {
        String describeTable = String.format("DESCRIBE TABLE %s", tableName);

        // try with resources
        try (Connection connection = getConnection();
             PreparedStatement describeTableStatement = connection.prepareStatement(describeTable)) {

            describeTableStatement.executeQuery();
            System.out.println("Table was described successfully!");
        } catch (SQLException e) {
            System.out.println("Table was not described successfully due to: " + e.getMessage());
        }
    }

    public static void insertInTable(String tableName, String studentName, String phone) {
        String insertInTable = String.format("INSERT INTO %s (student_name, phone) VALUES ('%s', '%s')", tableName, studentName, phone);

        // try with resources
        try (Connection connection = getConnection();
             PreparedStatement insertTableStatement = connection.prepareStatement(insertInTable)) {

            insertTableStatement.executeUpdate();
            System.out.println("Table was updated successfully!");
        } catch (SQLException e) {
            System.out.println("Table was not updated successfully due to: " + e.getMessage());
        }
    }

    public static void deleteById(String tableName, int id) {
        String deleteById = String.format("DELETE FROM %s WHERE id_student = ?", tableName);

        try (Connection connection = getConnection();
             PreparedStatement deleteByIdStatement = connection.prepareStatement(deleteById)) {

            deleteByIdStatement.setInt(1, id);
            deleteByIdStatement.executeUpdate();
            System.out.println("Value was deleted by id successfully!");
        } catch (SQLException e) {
            System.out.println("Value was not deleted successfully by id due to: " + e.getMessage());
        }
    }

    public static void showTable(String tableName) {
        String selectFromTable = String.format("SELECT * FROM %s", tableName);

        // try with resources
        try (Connection connection = getConnection();
             PreparedStatement selectFromTableStatement = connection.prepareStatement(selectFromTable)) {

            System.out.println("-----------START OF THE TABLE-----------");
            ResultSet resultSet = selectFromTableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("student_name");
                String phone = resultSet.getString("phone");
                int id = resultSet.getInt("id_student");
                System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Table was not shown successfully due to: " + e.getMessage());
        } finally {
            System.out.println("-----------END OF THE TABLE-----------");
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
