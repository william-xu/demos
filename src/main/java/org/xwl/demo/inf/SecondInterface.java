package org.xwl.demo.inf;

public interface SecondInterface {
	String sayGoodbye();
	
	void move();
	
	default void saySomething() {
		System.out.println("What else I can say ?");
	}
}
