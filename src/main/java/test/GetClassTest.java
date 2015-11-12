package test;

import java.io.Serializable;
import java.util.HashMap;

public class GetClassTest {

	
	
	public static void main(String[] args) {
		C obj = new A();
		C obj2 = new B();
		x objX=new s();
		
		System.out.println("objX's class="+objX.getClass().getSimpleName());

		System.out.println("obj's class="+obj.getClass().getSimpleName());
		System.out.println("obj's Super-class="+obj.getClass().getSuperclass());
		System.out.println("obj2's class="+obj2.getClass().getSimpleName());
		
		System.out.println();

		//primitive
		System.out.println(int.class.getName());
		System.out.println(int.class.getCanonicalName());
		System.out.println(int.class.getSimpleName());

		System.out.println();

		//class
		System.out.println(String.class.getName());
		System.out.println(String.class.getCanonicalName());
		System.out.println(String.class.getSimpleName());

		System.out.println();

		//inner class
		System.out.println(HashMap.SimpleEntry.class.getName());
		System.out.println(HashMap.SimpleEntry.class.getCanonicalName());
		System.out.println(HashMap.SimpleEntry.class.getSimpleName());        

		System.out.println();

		//anonymous inner class
		System.out.println(new Serializable(){}.getClass().getName());
		System.out.println(new Serializable(){}.getClass().getCanonicalName());
		System.out.println(new Serializable(){}.getClass().getSimpleName());
	}
}

abstract class C{}
class B extends C {}
class A extends B {}

interface x {}
class s implements x{}