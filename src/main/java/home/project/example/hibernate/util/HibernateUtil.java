package home.project.example.hibernate.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {

    public static ApplicationContext appContext = null;

    public static ApplicationContext getContext() {
        if(appContext == null) {
            appContext = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        }
        return appContext;
    }

}
