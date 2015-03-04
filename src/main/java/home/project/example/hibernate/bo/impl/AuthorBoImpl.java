package home.project.example.hibernate.bo.impl;

import home.project.example.hibernate.bo.AuthorBo;
import home.project.example.hibernate.dao.AuthorDao;
import home.project.example.hibernate.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authorBo")
public class AuthorBoImpl implements AuthorBo {

    @Autowired
    AuthorDao authorDao;

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author){
        authorDao.save(author);
    }

    public void update(Author author){
        authorDao.update(author);
    }

    public void delete(Author author){
        authorDao.delete(author);
    }


    public Author findByCountry(int country){
        return authorDao.findByCountry(country);
    }

    public List<Author> list() {
        return authorDao.list();
    }

    public void removeAuthor(int id) {
        authorDao.removeAuthor(id);
    }

    public Author getAuthorById(int id) {
        return authorDao.getAuthorById(id);
    }


}