package spring.learn.demo04_scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.learn.demo04_scanner.anno.MyMapperScanner;
import spring.learn.demo04_scanner.dal.IUserDao;

@Configuration
@ComponentScan("spring.learn.demo04_scanner")
@MyMapperScanner(basePackages = {"spring.learn.demo04_scanner.dal"})
public class MyMapperScannerTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyMapperScannerTest.class);
		IUserDao userDao = ac.getBean(IUserDao.class);
		userDao.selectList();
	}

}
