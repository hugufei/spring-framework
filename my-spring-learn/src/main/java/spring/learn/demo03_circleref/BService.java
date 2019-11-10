package spring.learn.demo03_circleref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BService {

	@Autowired
	private AService aService;

	public AService getaService() {
		return aService;
	}
}
