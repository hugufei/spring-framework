package spring.learn.demo02_factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFactoryBean implements FactoryBean<UserService> {

	@Nullable
	@Override
	public UserService getObject() throws Exception {
		return new UserService();
	}

	@Nullable
	@Override
	public Class<?> getObjectType() {
		return UserService.class;
	}
}
