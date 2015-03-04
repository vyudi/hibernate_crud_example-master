package home.project.example.hibernate.dao;

import home.project.example.hibernate.entities.Book;

public interface BookDao {

    void save(Book book);
    void update(Book book);
    void delete(Book book);

}
