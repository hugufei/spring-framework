package spring.learn.demo01_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlServiceTest {

	//测试XMl的启动流程
	// 1) 使用XmlBeanDefinitionReader解析xml文件
	// 2) DefaultNamespaceHandlerResolver解析spring的特殊标签： property-placeholder、annotation-config、component-scan
	// 3) ComponentScanBeanDefinitionParser===> 注册注解后置处理器: AnnotationConfigUtils.registerAnnotationConfigProcessors
	// 4) ComponentScanBeanDefinitionParser===> new
	public static void main(String[] args) {
		ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("classpath:spring.xml");
		XmlService xmlService = xml.getBean(XmlService.class);
	}
}
