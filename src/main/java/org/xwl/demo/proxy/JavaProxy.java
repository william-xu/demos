package org.xwl.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.xwl.demo.inf.FirstInterface;
import org.xwl.demo.inf.SecondInterface;
import org.xwl.demo.inf.ThirdInterface;

/**
 * 相对Cglib，Java动态代理只支持有实现接口的类的代理
 * 被代理类不能是抽象的
 * 需要先创建被代理类的实例，传给InvocationHandler去代理
 * 被代理类实现多个接口时，调用不同接口方法时需要先转换为对应接口类型
 * 创建的代理类实例均继承Proxy类
 * 调用重复方法时，无论使用哪种类型，总是调用最靠近被代理类的方法 
 * @author xwl
 *
 */
public class JavaProxy extends AbstractJavaProxy implements FirstInterface, SecondInterface, ThirdInterface {

	@Override
	public String sayGoodbye() {
		return "Goodbye!";
	}

	@Override
	public String sayHello() {
		return "Hello!";
	}

	@Override
	public void saySomething() {
		System.out.println("I am called ...");
	}

	public static void main(String[] args) {
		
		class JPInvocationHandler implements InvocationHandler{
			private JavaProxy target;
			public JPInvocationHandler(JavaProxy target) {
				this.target = target;
			}
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.getReturnType().equals(String.class)) {
					return "say " + method.invoke(target, args);
				}else {
					return method.invoke(target, args);
				}
			}		
		}
		
		InvocationHandler handler = new JPInvocationHandler(new JavaProxy());
		
		Object proxy = Proxy.newProxyInstance(JavaProxy.class.getClassLoader(), JavaProxy.class.getInterfaces(), handler);
		FirstInterface first = (FirstInterface)proxy;
		SecondInterface second = (SecondInterface)proxy;
		ThirdInterface third = (ThirdInterface)proxy;
		
		System.out.println(second.sayGoodbye());
		System.out.println(first.sayHello());
		
		first.move();
		second.move();
		third.move();
		
		first.saySomething();
		second.saySomething();
		third.saySomething();
		
	}





}
