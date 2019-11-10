package spring.learn.demo06_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class LifeCycleService implements InitializingBean,ApplicationContextAware {

	@Autowired
	private CommonService commonService;
	@Resource
	private CommonService commonService1;

    public void test(){
        System.out.println(commonService.getApplication());
		System.out.println(commonService1.getApplication());
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("1、setApplicationContext");
	}

    @PostConstruct
	void init(){
		System.out.println("2、 @PostConstruct...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("3、initializeBean： afterPropertiesSet");
	}

    @PreDestroy
	void destory(){
		System.out.println("4、@PreDestroy...");
	}

}
