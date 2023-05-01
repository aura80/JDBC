package JDBC.connectionsWithMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutionAndMapping {
    public static void main(String[] args) throws SQLException {

        ResultSet rs = MethodsForConnection.getStatement().executeQuery("select * from student where id_student=4");
        while (rs.next()) {
            String name = rs.getString("student_name");
            String phone = rs.getString("phone");
            int id = rs.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        ResultSet rs1 = MethodsForConnection.getStatement().executeQuery("select * from student where id_student=3");
        while (rs1.next()) {
            String name = rs1.getString("student_name");
            String phone = rs1.getString("phone");
            int id = rs1.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        ResultSet rs2 = MethodsForConnection.getStatement().executeQuery("select * from student where id_student=6");
        while (rs2.next()) {
            String name = rs2.getString("student_name");
            String phone = rs2.getString("phone");
            int id = rs2.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        ResultSet rs3 = MethodsForConnection.getStatement().executeQuery("select * from student where id_student<=3");
        while (rs3.next()) {
            String name = rs3.getString("student_name");
            String phone = rs3.getString("phone");
            int id = rs3.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }
        
        MethodsForConnection.closeConnection();

    }
}
