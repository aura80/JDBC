package JDBC.connectionsWithService.service;

import JDBC.connectionsWithService.daoSendDataToDB.BookDAOImplementation;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseBookHandlingConnections extends BookDAOImplementation {

    public static final String database = "library";
    public static final String username = "root";
    public static final String password = "123456";

    private static Connection connection;

    public BaseBookHandlingConnections(String tableName, Connection connection) {
        super(tableName, connection);
    }

    protected static Connection getConnection() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setURL(String.format("jdbc:mysql://localhost:3306/%s", database));
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource.getConnection();
    }

    protected static void closeConnection() throws SQLException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new SQLException(e);
        }

    }
}
