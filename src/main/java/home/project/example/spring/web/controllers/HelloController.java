package home.project.example.spring.web.controllers;

import home.project.example.hibernate.bo.AuthorBo;
import home.project.example.hibernate.bo.BookBo;
import home.project.example.hibernate.entities.Author;
import home.project.example.hibernate.util.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/welcome")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        ApplicationContext appContext = HibernateUtil.getContext();

        AuthorBo authorBo = (AuthorBo)appContext.getBean("authorBo");
        BookBo bookBo = (BookBo)appContext.getBean("bookBo");


        Author author = new Author();
        author.setName("spring mvc web");
        author.setDateOfBirth(new Date());
        author.setCountry(50);
        authorBo.save(author);
        model.addAttribute("message", "Hello, World!");
        return "hello";

    }

}
