package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HelloWorldTest {

	public static void main(String[] args) {
		HelloWorldInterface helloWorld = new HelloWorld();
		InvocationHandler handler = new HelloWorldHandler(helloWorld);   // Associate the handler with the helloWorld object
		
		HelloWorldInterface proxy = (HelloWorldInterface)Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), handler);
		proxy.sayHello();
	}
}
