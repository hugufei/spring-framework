package spring.learn.demo08_constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("spring.learn.demo08_constructor")
public class ConstructorServiceTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConstructorServiceTest.class);
		ac.getBean(ConstructorService.class);
	}

}
