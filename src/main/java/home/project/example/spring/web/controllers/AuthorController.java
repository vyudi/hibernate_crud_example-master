package home.project.example.spring.web.controllers;

import home.project.example.hibernate.bo.AuthorBo;
import home.project.example.hibernate.bo.impl.AuthorBoImpl;
import home.project.example.hibernate.entities.Author;
import home.project.example.hibernate.util.HibernateUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AuthorController {

    @RequestMapping(value = "/author/list", method = RequestMethod.GET)
    public ModelAndView list() throws Exception {
        ApplicationContext appContext = HibernateUtil.getContext();
        AuthorBo authorBo = (AuthorBo)appContext.getBean("authorBo");
        List<Author> authors = authorBo.list();

        ModelAndView mav = new ModelAndView("list");
        mav.addObject("author", new Author());
        mav.addObject("authors", authors);
        mav.addObject("authorsCount", authors.size());

        return mav;
    }

    @RequestMapping("/author/remove/{id}")
    public String removeAuthor(@PathVariable("id") int id){
        ApplicationContext appContext = HibernateUtil.getContext();
        AuthorBo authorBo = (AuthorBo)appContext.getBean("authorBo");
        authorBo.removeAuthor(id);
        return "redirect:/author/list";
    }

    @RequestMapping("/author/view/{id}")
    public ModelAndView viewAuthor(@PathVariable("id") int id) {

        ModelAndView mva = new ModelAndView("view");

        ApplicationContext appContext = HibernateUtil.getContext();
        AuthorBo authorBo = (AuthorBo)appContext.getBean("authorBo");

        mva.addObject("author", authorBo.getAuthorById(id));

        return mva;
    }

    @RequestMapping(value= "/author/add", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") Author author){
        ApplicationContext appContext = HibernateUtil.getContext();
        AuthorBo authorBo = (AuthorBo)appContext.getBean("authorBo");

        if(author.getId() == 0){
            authorBo.save(author);
        }else{
            authorBo.update(author);
        }

        return "redirect:/author/view/" + author.getId();

    }

    @RequestMapping("/author/edit/{id}")
    public ModelAndView editAuthor(@PathVariable("id") int id) {

        ModelAndView mva = new ModelAndView("edit");

        ApplicationContext appContext = HibernateUtil.getContext();
        AuthorBo authorBo = (AuthorBo)appContext.getBean("authorBo");

        mva.addObject("author", authorBo.getAuthorById(id));
        return mva;
    }


/*    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }*/



}
