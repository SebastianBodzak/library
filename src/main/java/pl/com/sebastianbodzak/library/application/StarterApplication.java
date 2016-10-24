package pl.com.sebastianbodzak.library.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.sebastianbodzak.library.api.StarterConfigurator;

/**
 * Created by Dell on 2016-10-24.
 */
public class StarterApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
        StarterConfigurator starter = applicationContext.getBean(StarterConfigurator.class);

        starter.createAdmin();
        starter.createBasicEmailMessages();

    }
}
