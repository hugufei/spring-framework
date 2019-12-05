package spring.learn.demo08_constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorService {

	public ConstructorService() {

	}

	@Autowired(required = false)
	public ConstructorService(C1Service c1Service) {
		System.out.println("1");
	}

	@Autowired(required = false)
	public ConstructorService(C2Service c2Service) {
		System.out.println("2");
	}

	@Autowired(required = false)
	public ConstructorService(C1Service c1Service, C2Service c2Service) {
		System.out.println("1-2");
	}

	@Autowired(required = false)
	public ConstructorService(C1Service c1Service, C2Service c2Service, C2Service c3Service) {
		System.out.println("1-2-2");
	}

}
