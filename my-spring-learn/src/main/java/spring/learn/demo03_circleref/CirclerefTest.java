package spring.learn.demo03_circleref;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"spring.learn.demo03_circleref"})
public class CirclerefTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CirclerefTest.class);
		AService aService = ctx.getBean(AService.class);
		BService bService = ctx.getBean(BService.class);
		System.out.println(aService.hashCode());
		System.out.println(bService.getaService().hashCode());
		System.out.println(bService.hashCode());
		System.out.println(aService.getbService().hashCode());
		ctx.close();
	}

}
