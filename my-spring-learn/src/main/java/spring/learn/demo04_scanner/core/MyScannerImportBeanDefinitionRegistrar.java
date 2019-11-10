package spring.learn.demo04_scanner.core;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import spring.learn.demo04_scanner.anno.MyMapperScanner;

public class MyScannerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyMapperScanner.class.getName()));
		String[] basePackages = annoAttrs.getStringArray("basePackages");
		//importingClassMetadata.getAnnotationAttributes(MyMapperScanner.class.getName());
		MyMapperBeanDefinitionScanner myMapperBeanDefinitionScanner = new MyMapperBeanDefinitionScanner(registry);
		int result = myMapperBeanDefinitionScanner.scan(basePackages);
		System.out.println(result);
	}

}
