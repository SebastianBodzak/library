package pl.com.sebastianbodzak.library.api;

import pl.com.sebastianbodzak.library.domain.JobTitle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Dell on 2016-10-20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequiresAuth {

    JobTitle[] roles() default {};
}
