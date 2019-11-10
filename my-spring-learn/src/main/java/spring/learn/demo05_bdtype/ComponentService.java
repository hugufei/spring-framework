package spring.learn.demo05_bdtype;

import org.springframework.stereotype.Component;

@Component
public class ComponentService {

	public ComponentService() {
		System.out.println("from @Component");
	}


}
