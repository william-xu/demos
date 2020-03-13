package org.xwl.demo.reflect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//no default constructor， for dynamic proxy test
public class MyClass2 {

	Class<?>[] classes;
	Collection<?> data;
	List<String> params;

	public MyClass2(Class<?> anotherClass, Collection<?> data, String... strings) {
		this.classes = new Class<?>[] { anotherClass };
		this.data = data;
		params = new ArrayList<String>();
		if (strings != null) {
			for (int i = 0; i < strings.length; i++) {
				params.add(strings[i]);
			}
		}
	}

	public MyClass2(Class<?>... classes) {
		this.classes = classes;
	}

	public String toString() {
		String classesNames = this.getClass().getSimpleName() + ": ";
		for (int i = 0; i < classes.length; i++) {
			classesNames += classes[i].getName() + ",";
		}
		classesNames = classesNames.length() > 0 ? classesNames.substring(0, classesNames.length() - 1) : classesNames;
		return classesNames + (data == null ? "" : "--" + data) + (params == null ? "" : "--" + params);
	}

}
