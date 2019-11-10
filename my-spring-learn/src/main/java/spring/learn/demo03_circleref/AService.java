package spring.learn.demo03_circleref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {

	@Autowired
	private BService bService;

	public BService getbService() {
		return bService;
	}

}
