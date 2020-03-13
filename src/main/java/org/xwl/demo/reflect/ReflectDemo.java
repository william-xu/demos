package org.xwl.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {

		String className = "org.xwl.demo.reflect.MyClass";
		
		MyClass mc1 = (MyClass) newInstance(className);

		MyClass mc2 = (MyClass) newInstance(className, 
											new Class[] { Class.forName("[Ljava.lang.Class;") },
											new Object[] { new Class[] { ReflectDemo.class } });

		Collection<String> al = new ArrayList<>();
		al.add("A1");al.add("B2");al.add("C3");
		String[] strs = new String[] { "AA", "BB", "CC" };

		MyClass mc3 = (MyClass) newInstance(className,
						new Class[] { java.lang.Class.class, Collection.class, Class.forName("[Ljava.lang.String;") },
						new Object[] { ReflectDemo.class, al, strs });

		System.out.println(mc1);
		System.out.println(mc2);
		System.out.println(mc3);
	}

	/**
	 * 通过反射创建目标类的实例
	 * 
	 * @param className    	  要创建实例的类完整名称
	 * @param parameterTypes 要使用构造器的参数类型数组，无参构造器可以使用空数组
	 * @param params         使用含参构造器时对应的参数值数组
	 * @return
	 */
	public static Object newInstance(String className, Class<?>[] parameterTypes, Object[] params) {
		Object obj = null;
		try {
			// 获取类对象
			Class<?> clazz = Class.forName(className);
			// 获取对应的构造器
			Constructor<?> cs = clazz.getDeclaredConstructor(parameterTypes);
			// 创建实例
			obj = cs.newInstance(params);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Object newInstance(String className) {
		return newInstance(className, new Class[] {}, new Object[] {});
	}
	

}
