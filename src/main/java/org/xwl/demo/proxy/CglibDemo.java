package org.xwl.demo.proxy;

import java.lang.reflect.Method;

import org.xwl.demo.reflect.MyClass;
import org.xwl.demo.reflect.MyClass2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDemo {

	@SuppressWarnings("unchecked")
	public static <T> T createProxy(Class<T> target, Class<?>[] argumentTypes, Object[] arguments,
			MethodInterceptor interceptor) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target);
		enhancer.setCallback(interceptor);
		return (T) enhancer.create(argumentTypes, arguments);
	}

	public static <T> T createProxy(Class<T> target, MethodInterceptor interceptor) {
		return createProxy(target, new Class[] {}, new Object[] {}, interceptor);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		
		MethodInterceptor interceptor = new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("calling method: " + method.getName());
				return proxy.invokeSuper(obj, args);
			}
		};

		MyClass m1 = createProxy(MyClass.class, interceptor);
		
		MyClass2 m2 = createProxy(MyClass2.class, new Class[] { Class.forName("[Ljava.lang.Class;") },
				new Object[] { new Class[] { CglibDemo.class } }, interceptor);

		System.out.println(m1);
		System.out.println();
		System.out.println(m2);

	}

}
