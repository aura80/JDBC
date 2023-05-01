package JDBC.connectionsWithMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutionAndMapping {

    private static final String tableName = "student";

    public static void main(String[] args) throws SQLException {

        ResultSet rs = MethodsForConnection.getStatement().executeQuery("select * from student where id_student=4");
        while (rs.next()) {
            String name = rs.getString("student_name");
            String phone = rs.getString("phone");
            int id = rs.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        System.out.println("----------------------------------------------");

        ResultSet rs1 = MethodsForConnection.getStatement().executeQuery("select * from student where id_student=3");
        while (rs1.next()) {
            String name = rs1.getString("student_name");
            String phone = rs1.getString("phone");
            int id = rs1.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        System.out.println("----------------------------------------------");

        ResultSet rs2 = MethodsForConnection.getStatement().executeQuery("select * from student where id_student=6");
        while (rs2.next()) {
            String name = rs2.getString("student_name");
            String phone = rs2.getString("phone");
            int id = rs2.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        System.out.println("----------------------------------------------");

        ResultSet rs3 = MethodsForConnection.getStatement().executeQuery("select * from student where id_student<=3");
        while (rs3.next()) {
            String name = rs3.getString("student_name");
            String phone = rs3.getString("phone");
            int id = rs3.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        System.out.println("----------------------------------------------");

        ResultSet rs4 = MethodsForConnection.getStatement().executeQuery("select * from student");
        while (rs4.next()) {
            String name = rs4.getString("student_name");
            String phone = rs4.getString("phone");
            int id = rs4.getInt("id_student");
            System.out.println("Student: " + name + ",  Phone: " + phone + ",  Id: " + id);
        }

        System.out.println("----------------------------------------------");

        MethodsForConnection.describeTable(tableName);

        System.out.println("----------------------------------------------");

//        must be renewed, change its arguments at every new run

//        MethodsForConnection.insertInTable(tableName, "Ica", "0735418725");
//        MethodsForConnection.insertInTable(tableName, "Zora", "0745687123");
//        MethodsForConnection.insertInTable(tableName, "Elena", "0747159357");

//        MethodsForConnection.insertInTable(tableName, "Mariana", "0735418725");
//        MethodsForConnection.insertInTable(tableName, "Dariana", "0745687123");
//        MethodsForConnection.insertInTable(tableName, "Dorina", "0747159357");

        System.out.println("----------------------------------------------");

        MethodsForConnection.deleteById(tableName, 35);
        MethodsForConnection.deleteById(tableName, 34);
        MethodsForConnection.deleteById(tableName, 39);

        MethodsForConnection.showTable(tableName);

        MethodsForConnection.closeConnection();

    }
}
