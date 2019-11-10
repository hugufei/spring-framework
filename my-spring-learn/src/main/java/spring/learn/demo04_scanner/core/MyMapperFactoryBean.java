package spring.learn.demo04_scanner.core;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Mapper接口动态代理对象的FactoryBean
// 实现自动注入的核心
public class MyMapperFactoryBean<T> implements FactoryBean<T>{

	private Class<T> mapperInterface;

	public MyMapperFactoryBean(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Nullable
	@Override
	public T getObject() throws Exception {
		return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("method Name: " + method.getName());
				System.out.println("method return:  " + method.getReturnType());
				System.out.println("method args： " + args);
				return null;
			}
		});
	}

	@Nullable
	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
