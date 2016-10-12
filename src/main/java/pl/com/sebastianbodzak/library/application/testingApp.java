package pl.com.sebastianbodzak.library.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.sebastianbodzak.library.api.SessionManager;

/**
 * Created by Dell on 2016-10-11.
 */
public class testingApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
        SessionManager sessionManager = applicationContext.getBean("workerManager", SessionManager.class);
    }
}
