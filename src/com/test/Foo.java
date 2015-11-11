package com.test;
import com.test.Subject;

public class Foo {

	private int val1;
	private String val2;
	private int val3;
	private Subject x;
	Foo(Subject s){
		this.x=s;
		this.val1=x.getVal1();
		this.val2=x.getVal2();
	}
	
	public int getVal1() {
		return this.val1=x.getVal1();
	}
	
	public String getVal2() {
		return val2=x.getVal2();
	}
	
	public int getVal3() {
		return val3;
	}
	public void setVal3(int val3) {
		this.val3 = val3;
	}
	
	public String toString(){
		return "val1="+val1+" ,val2="+val2+" ,val3="+val3;
		
	}
	
}
