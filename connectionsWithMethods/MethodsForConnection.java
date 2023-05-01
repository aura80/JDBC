package JDBC.connectionsWithMethods;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MethodsForConnection {

    private static final String database = "jdbc_exercises";
    private static final String username = "set_your_own_username";
    private static final String password = "set_your_own_password";

    private static Connection connection;

    public static MysqlDataSource getMysqlDataSourceObject() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s",database));
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource;
    }

    public static Connection getConnection() throws SQLException {
        try{
            connection = getMysqlDataSourceObject().getConnection();
            return connection;
        } catch (SQLException e){
            throw new SQLException(e);
        }
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
