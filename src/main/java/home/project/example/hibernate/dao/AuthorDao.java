package home.project.example.hibernate.dao;

import home.project.example.hibernate.entities.Author;

import java.util.List;

public interface AuthorDao {

    void save(Author author);
    void update(Author author);
    void delete(Author author);
    Author findByCountry(int country);
    List<Author> list();
    public void removeAuthor(int id);
    public Author getAuthorById(int id);

}
