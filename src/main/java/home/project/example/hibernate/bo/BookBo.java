package home.project.example.hibernate.bo;


import home.project.example.hibernate.entities.Book;

public interface BookBo {

    void save(Book book);
    void update(Book book);
    void delete(Book book);

}
