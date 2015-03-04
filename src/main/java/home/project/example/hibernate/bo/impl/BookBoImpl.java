package home.project.example.hibernate.bo.impl;

import home.project.example.hibernate.bo.BookBo;
import home.project.example.hibernate.dao.BookDao;
import home.project.example.hibernate.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookBo")
public class BookBoImpl implements BookBo {

    @Autowired
    BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book) {
        bookDao.save(book);
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(Book book) {
        bookDao.save(book);
    }
}
