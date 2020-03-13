package org.xwl.demo.proxy;

import org.xwl.demo.inf.SecondInterface;

public abstract class AbstractJavaProxy implements SecondInterface{

	public abstract String sayGoodbye();

	@Override
	public void move() {
		System.out.println("move to the east.");
	}

}
