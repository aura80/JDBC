package JDBC.connectionsWithService.daoSendDataToDB;

import JDBC.connectionsWithService.entity.BookEntityDBFields;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDAO {

    public void dropTableIfExistsQUERY();

    public void createTableQUERY();

    public void insertInsideTableQUERY(BookEntityDBFields bookEntityDBFields);

    public void deleteByIdQUERY(int id);

    public Optional<BookEntityDBFields> findByIdQUERY(int id);

    public List<BookEntityDBFields> findAllQUERY() throws SQLException;
}
