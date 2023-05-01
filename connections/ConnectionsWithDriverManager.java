package JDBC.connections;

import java.sql.*;

public class ConnectionsWithDriverManager {
    private static final String database = "jdbc_exercises";
    private static final String username = "set_your_own_username";
    private static final String password = "set_your_own_password";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // we load the driver from Maven, it throws ClassNotFoundException
        Class.forName("com.mysql.cj.jdbc.Driver");

        // get the connection using DriverManager
        String url = String.format("jdbc:mysql://localhost:3306/%s", database);
        Connection connection = DriverManager.getConnection(url, username, password);

        // we create a statement
        Statement statement = connection.createStatement();

        // Deserialization - mapping entities at receiving info
        // Query execution
        ResultSet rs = statement.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            // mapping between variables with the correct type
            int id = rs.getInt("id_student");
            String name = rs.getString("student_name");
            int phone = rs.getInt("phone");
            System.out.println(String.format("id = %s, name = %s, phone = %s", id, name, phone));
        }

        // closing connection
        rs.close();
        statement.close();
        connection.close();

    }
}
