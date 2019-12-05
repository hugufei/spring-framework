package spring.learn.demo07_protye;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProroTypeBean2 {

	public ProroTypeBean2() {
		System.out.println("new prototypeBean2...");
	}
}
