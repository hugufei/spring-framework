package spring.learn.demo05_bdtype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationService {

	public static class BeanService {
		public BeanService() {
			System.out.println("from @Bean");
		}
	}

	@Bean
	public BeanService beanService(){
		return new BeanService();
	}

}
