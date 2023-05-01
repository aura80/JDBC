package JDBC.connectionsWithService.controller;

import JDBC.connectionsWithService.daoSendDataToDB.BookDAO;
import JDBC.connectionsWithService.daoSendDataToDB.BookDAOImplementation;
import JDBC.connectionsWithService.entity.BookEntityDBFields;
import JDBC.connectionsWithService.service.BaseBookHandlingConnections;

import java.sql.SQLException;

public class BookController extends BaseBookHandlingConnections {

    private final BookDAO bookDAO;


    public BookController(String tableName) throws SQLException {
        super(tableName, getConnection());
        try {
            bookDAO = new BookDAOImplementation(tableName, getConnection());
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static void main(String[] args) throws SQLException {

        BookController bookController = new BookController("book");
        bookController.bookDAO.dropTableIfExistsQUERY();
        bookController.bookDAO.createTableQUERY();
        BookEntityDBFields bookEntityDBFields = new BookEntityDBFields(1, "HELLO BEAUTIFUL", "Ann Napolitano", 400);
        bookController.bookDAO.insertInsideTableQUERY(bookEntityDBFields);
        BookEntityDBFields bookEntityDBFields1 = new BookEntityDBFields(2, "LESSONS IN CHEMISTRY", "Bonnie Garmus", 400);
        bookController.bookDAO.insertInsideTableQUERY(bookEntityDBFields1);
        BookEntityDBFields bookEntityDBFields2 = new BookEntityDBFields(3, "SIMPLY LIES", "David Baldacci", 416);
        bookController.bookDAO.insertInsideTableQUERY(bookEntityDBFields2);
        BookEntityDBFields bookEntityDBFields3 = new BookEntityDBFields(4, "HANG THE MOON", "Jeannette Walls", 368);
        bookController.bookDAO.insertInsideTableQUERY(bookEntityDBFields3);
        BookEntityDBFields bookEntityDBFields4 = new BookEntityDBFields(5, "THE WAGER", "David Grann", 352);
        bookController.bookDAO.insertInsideTableQUERY(bookEntityDBFields4);
        bookController.bookDAO.findAllQUERY();

        bookController.bookDAO.findByIdQUERY(1);
        bookController.bookDAO.findByIdQUERY(3);
        bookController.bookDAO.findByIdQUERY(2);
        bookController.bookDAO.findByIdQUERY(5);
        bookController.bookDAO.findByIdQUERY(4);

        bookController.bookDAO.deleteByIdQUERY(5);

        bookController.bookDAO.findAllQUERY();

        bookController.bookDAO.findByIdQUERY(1);
        bookController.bookDAO.findByIdQUERY(3);
    }

}
