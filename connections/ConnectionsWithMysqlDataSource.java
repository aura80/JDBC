package JDBC.connections;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionsWithMysqlDataSource {
    private static final String database = "jdbc_exercises";
    private static final String username = "root";
    private static final String password = "123456";

    public static void main(String[] args) throws SQLException {
        // new object of type MysqlDataSource created
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        // setting the credentials
        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", database));
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        // connection established
        Connection connection = mysqlDataSource.getConnection();

        // creating statement
        Statement statement = connection.createStatement();

        // query execution
        ResultSet rs = statement.executeQuery("select * from student inner join school on school.id_student=student.id_student");

        // deserialization - mapping the resources between attributes of the same type
        while (rs.next()) {
            int id = rs.getInt("id_student");
            int id2 = rs.getInt("id_school");
            String schoolName = rs.getString("school_name");
            String studentName = rs.getString("student_name");
            System.out.println("Student id = " + id + ",   Student name = " + studentName + "    School id = " + id2 + ",   School name = " + schoolName);
        }

        rs.close();
        statement.close();
        connection.close();

    }
}
