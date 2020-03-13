package org.xwl.demo.inf;

public interface ThirdInterface {
	
	void move();
	
	default void saySomething() {
		System.out.println(" third interface ");
	}
}
