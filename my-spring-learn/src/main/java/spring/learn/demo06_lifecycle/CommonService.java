package spring.learn.demo06_lifecycle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:my.properties"})
public class CommonService {

	@Value("${application}")
	private String application;

	public String getApplication(){
		return this.application;
	}

}
