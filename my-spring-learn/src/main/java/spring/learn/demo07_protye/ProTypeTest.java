package spring.learn.demo07_protye;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan("spring.learn.demo07_protye")
public class ProTypeTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(ProTypeTest.class);
		Map<String, Object> bean =  ac.getBeansWithAnnotation(MyAnno.class);
		for(Map.Entry object: bean.entrySet()){
			//System.out.println(object.getKey());
			//System.out.println(object.getValue().getClass().getSimpleName());
			System.out.println(ac.getBean((String)object.getKey()));
		}
	}

}
