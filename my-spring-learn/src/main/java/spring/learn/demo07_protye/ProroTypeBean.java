package spring.learn.demo07_protye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@MyAnno
public class ProroTypeBean {

	@Autowired
	private ProroTypeBean2 proroTypeBean2;

	public ProroTypeBean() {
		System.out.println("new ProroTypeBean");
	}
}
