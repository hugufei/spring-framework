package spring.learn.demo04_scanner.anno;

import org.springframework.context.annotation.Import;
import spring.learn.demo04_scanner.core.MyScannerImportBeanDefinitionRegistrar;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyScannerImportBeanDefinitionRegistrar.class)
public @interface MyMapperScanner {

	String[] basePackages();

}
