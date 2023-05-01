package JDBC.connectionsWithService.entity;

import lombok.Data;

@Data
public class BookEntityDBFields {

    private Integer id;
    private String bookName;
    private String author;
    private Integer noPages;

    public BookEntityDBFields(Integer id, String bookName, String author, Integer noPages) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.noPages = noPages;
    }
}
