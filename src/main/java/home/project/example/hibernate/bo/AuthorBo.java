package home.project.example.hibernate.bo;

import home.project.example.hibernate.entities.Author;

import java.util.List;

public interface AuthorBo {

    void save(Author author);
    void update(Author author);
    void delete(Author author);
    Author findByCountry(int country);
    List<Author> list();
    void removeAuthor(int id);
    Author getAuthorById(int id);
}
