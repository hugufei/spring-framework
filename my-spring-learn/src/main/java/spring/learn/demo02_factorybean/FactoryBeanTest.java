package spring.learn.demo02_factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.learn.demo02_factorybean")
public class FactoryBeanTest {
	/**
	 * FactoryBean获取流程分析：
	 * <p>
	 * 1)  循环Spring容器中所有的beanNames
	 * 2)  再根据beanName获取对应的Bean实例，判断获取的Bean实例是不是FactoryBean类型的Bean
	 * 3） 如果是，则调用Bean的getObjectType方法获取Class，将获取到的Class和传入的Class进行匹配，
	 * 4） 如果匹配到，则将此beanName和传入的Class建立一个映射关系。
	 * 5） 再根据beanName获取到Spring容器中对应的Bean
	 * 6） 调用Bean的getObject方法来获取对应的实例。
	 * <p>
	 * 重点：
	 * 1）FactoryBean生成出来的对象存在单例和缓存中，和普通bean分开
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(FactoryBeanTest.class);
		System.out.println(aca.getBean(UserService.class).getClass());
		System.out.println(aca.getBean("userServiceFactoryBean").getClass());
		//下面这两种取法都是错的
		System.out.println(aca.getBean("@userServiceFactoryBean").getClass());
		//System.out.println(aca.getBean("userService").getClass());//这里报错
	}

}
