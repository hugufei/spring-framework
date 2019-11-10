package spring.learn.demo06_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(value = {"spring.learn.demo06_lifecycle"})
public class TestLifeCycleService {

    /**
     * 关于AnnotationConfigApplicationContext：
     * 1) AnnotationConfigApplicationContext是基于注解的ApplicationContext
     *
     * @@@构造函数传一个注解类时
     * 1）构造函数---》 new AnnotatedBeanDefinitionReader()-->AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry)
     * 2) 注册注解类
     *
     * @@@构造函数传一个路径时
     *
     * 1）构造函数---》 new AnnotatedBeanDefinitionReader()-->AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry)
     * 2）扫描路径 --》 ClassPathBeanDefinitionScanner.scan() --> AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry)
     */

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestLifeCycleService.class);
		ctx.registerShutdownHook();
        LifeCycleService lifeCycleService = ctx.getBean(LifeCycleService.class);
        lifeCycleService.test();
        ctx.close();
    }

}
