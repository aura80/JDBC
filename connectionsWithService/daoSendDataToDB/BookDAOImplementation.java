package JDBC.connectionsWithService.daoSendDataToDB;

import JDBC.connectionsWithService.entity.BookEntityDBFields;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAOImplementation implements BookDAO {

    private final String tableName;
    private final Connection connection;

    public BookDAOImplementation(String tableName, Connection connection) {
        this.tableName = tableName;
        this.connection = connection;
    }

    @Override
    public void dropTableIfExistsQUERY() {
        String dropQuery = String.format("DROP TABLE IF EXISTS %s", tableName);

        try (PreparedStatement drop = connection.prepareStatement(dropQuery)) {

            drop.executeUpdate();
            System.out.println("Table dropped successfully");

        } catch (SQLException e) {
            System.out.println("Table not dropped because - " + e.getMessage());
        }
    }

    @Override
    public void createTableQUERY() {
        String createQuery = String.format("CREATE TABLE %s (id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "bookName VARCHAR(255), author VARCHAR(255), noPages INTEGER)", tableName);

        try (PreparedStatement create = connection.prepareStatement(createQuery)) {

            create.executeUpdate();
            System.out.println("Table created successfully");

        } catch (SQLException e) {
            System.out.println("Table not created because - " + e.getMessage());
        }
    }

    @Override
    public void insertInsideTableQUERY(BookEntityDBFields bookEntityDBFields) {
        String insertQuery = String.format("INSERT INTO %s (id, " +
                        "bookName, author, noPages) VALUES (%s, '%s', '%s', %s)",
                tableName, bookEntityDBFields.getId(), bookEntityDBFields.getBookName(),
                bookEntityDBFields.getAuthor(), bookEntityDBFields.getNoPages());

        try (PreparedStatement insert = connection.prepareStatement(insertQuery)) {

            insert.executeUpdate();
            System.out.println("Record inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Record not inserted because - " + e.getMessage());
        }
    }

    @Override
    public void deleteByIdQUERY(int id) {
        String deleteQuery = String.format("DELETE FROM %s WHERE id = ?", tableName);

        try (PreparedStatement delete = connection.prepareStatement(deleteQuery)) {

            delete.setInt(1, id);
            delete.executeUpdate();
            System.out.println();
            System.out.println("Deletion by id successfully!");

        } catch (SQLException e) {
            System.out.println("Record not deleted by id because - " + e.getMessage());
        }
    }

    @Override
    public Optional<BookEntityDBFields> findByIdQUERY(int id) {
        String findByIdQuery = String.format("SELECT * FROM %s WHERE id = ?", tableName);

        System.out.println();

        try (PreparedStatement findById = connection.prepareStatement(findByIdQuery)) {

            findById.setInt(1, id);
            ResultSet rs = findById.executeQuery();

            while (rs.next()) {
                BookEntityDBFields be = new BookEntityDBFields(rs.getInt("id"),
                        rs.getString("bookName"), rs.getString("author"), rs.getInt("noPages"));

                System.out.println(be);
                System.out.println("Record found by id " + id + ", successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Record not found by id because - " + e.getMessage());
        } finally {
            System.out.println("Searched id = " + id);
        }

        return Optional.empty();
    }

    @Override
    public List<BookEntityDBFields> findAllQUERY() {
        List<BookEntityDBFields> bookList = new ArrayList<>();
        String findAllQuery = String.format("SELECT * FROM %s", tableName);

        try (PreparedStatement findAll = connection.prepareStatement(findAllQuery)) {

            ResultSet rs = findAll.executeQuery();
            while (rs.next()) {

                BookEntityDBFields be = new BookEntityDBFields(rs.getInt("id"),
                        rs.getString("bookName"), rs.getString("author"), rs.getInt("noPages"));

                bookList.add(be);
            }

            System.out.println(bookList);

            System.out.println("All records were found!");

        } catch (SQLException e) {
            System.out.println("Records not found because - " + e.getMessage());
        }

        return bookList;
    }
}
