package spring.learn.demo05_bdtype;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = {"classpath:spring.xml"})
@ComponentScan(basePackages = {"spring.learn.demo05_bdtype"})
public class BeanDefinitionTypeTest {

	//测试各种BeanDefinition的类型，包括：
	// 1) xml中定义的各种bean ： GenericBeanDefinition
	// 2) @component以及其子类注解 ： ScannedGenericBeanDefinition
	// 3) 加了@Bean注解的方法 ： ConfigurationClassBeanDefinition
	// 4) 手动注册的配置类： AnnotatedGenericBeanDefinition
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(BeanDefinitionTypeTest.class);
		ac.refresh();

		// GenericBeanDefinition： xml中注册的bean都是
		System.out.println(ac.getBeanDefinition("xmlService").getClass().getSimpleName());

		// ScannedGenericBeanDefinition: 扫描@compenent注解和子类注解 出来的各种类
		System.out.println(ac.getBeanDefinition("componentService").getClass().getSimpleName());
		System.out.println(ac.getBeanDefinition("configurationService").getClass().getSimpleName());

		// ConfigurationClassBeanDefinition： 加了@Bean注解的
		System.out.println(ac.getBeanDefinition("beanService").getClass().getSimpleName());

		// AnnotatedGenericBeanDefinition: 手动注册给AnnotationConfigApplicationContext的类
		// AnnotatedBeanDefinitionReader底层会直接 new AnnotatedGenericBeanDefinition
		System.out.println(ac.getBeanDefinition("beanDefinitionTypeTest").getClass().getSimpleName());
		ac.close();

	}

}
