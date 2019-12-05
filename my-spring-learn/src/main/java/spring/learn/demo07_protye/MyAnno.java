package spring.learn.demo07_protye;


import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Scope("prototype")
public @interface MyAnno {
	
}
