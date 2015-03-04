package home.project.example.hibernate.dao.impl;


import home.project.example.hibernate.dao.BookDao;
import home.project.example.hibernate.entities.Book;
import home.project.example.hibernate.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("bookDao")
public class BookDaoImpl extends CustomHibernateDaoSupport implements BookDao {

    @Transactional
    public void save(Book book) {
        getHibernateTemplate().save(book);
    }


    public void update(Book book) {
        getHibernateTemplate().save(book);
    }


    public void delete(Book book) {
        getHibernateTemplate().save(book);
    }
}
