package test;

public abstract class Base<T extends Object>  implements IBase{

	private static String s="sdf";
	
	public void method1(){
		System.out.println(getS());
	}
	
	String getS(){
		return s;
	}
	
}
