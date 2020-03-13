package org.xwl.demo.inf;

public interface FirstInterface {
	String sayHello();
	
	void move();
	
	default void saySomething() {
		System.out.println("I have nothing to say.");
	};
}
