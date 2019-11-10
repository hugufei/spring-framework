package spring.learn.demo04_scanner.core;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import spring.learn.demo04_scanner.anno.MyMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

//自定义 scanner,核心：
// 1) 自定义filter - 过滤出BeanDefinition
// 2) 重写isCandidateComponent - 判断BeanDefinition是否
public class MyMapperBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

	public MyMapperBeanDefinitionScanner(BeanDefinitionRegistry registry) {
		super(registry);
		// 重置默认的filter
		super.resetFilters(false);
		// 设置过滤器只扫MyMapper注解
		super.addIncludeFilter(new AnnotationTypeFilter(MyMapper.class));
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		// 这行代码会将MyMapper注解变成一个BeanDefinition，并注册到bean工厂里
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
		// 将扫描到的BeanDefinition进行修改
		if (beanDefinitions.isEmpty()) {
			logger.warn("No MyBatis mapper was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
		} else {
			processBeanDefinitions(beanDefinitions);
		}
		return beanDefinitions;
	}

	// 这个方法和过滤器有关，过滤器在上面重置了，直接用父类方法就好
	@Override
	protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
		return super.isCandidateComponent(metadataReader);
	}

	// 这个方法是判断Bd是否符合条件
	// 这里判断是接口就好
	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		AnnotationMetadata metadata = beanDefinition.getMetadata();
		return metadata.isInterface();
	}

	// 核心代码： 修改扫描出来的BeanDefinitions，用MyMapperFactoryBean代替
	private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitions) {
			GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
			String beanClassName = beanDefinition.getBeanClassName();
			// 修改BeanClass为MyMapperFactoryBean
			beanDefinition.setBeanClass(MyMapperFactoryBean.class);
			// 添加构造函数
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
		}
	}

}
