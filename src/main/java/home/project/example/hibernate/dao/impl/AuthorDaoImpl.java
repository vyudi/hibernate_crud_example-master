package home.project.example.hibernate.dao.impl;

import home.project.example.hibernate.dao.AuthorDao;
import home.project.example.hibernate.entities.Author;
import home.project.example.hibernate.util.CustomHibernateDaoSupport;
import org.hibernate.FlushMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("authorDao")
public class AuthorDaoImpl extends CustomHibernateDaoSupport implements AuthorDao {


    @Transactional
    public void save(Author author){
        getHibernateTemplate().save(author);
    }

    @Transactional
    public void update(Author author){
        getHibernateTemplate().update(author);
    }

    @Transactional
    public void delete(Author author){
        getHibernateTemplate().delete(author);
    }

    public Author findByCountry(int country){
        List list = getHibernateTemplate().find(
                "from Author where country=?",country
        );
        return (Author)list.get(0);
    }

    public List<Author> list() {
        List list = getHibernateTemplate().find("from Author");
        return list;
    }

    @Transactional
    public void removeAuthor(int id) {
        Author author = getHibernateTemplate().load(Author.class, new Integer(id));
        if(null != author){
            getHibernateTemplate().delete(author);
        }
        logger.info("Author deleted successfully, author details="+author);
    }

    @Transactional
    public Author getAuthorById(int id) {
        Author author = getHibernateTemplate().load(Author.class, new Integer(id));
        logger.info("Author loaded successfully, Author details="+author);
        return author;
    }





}