package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

	private static Map<String,List<Foo>> map= new HashMap<String,List<Foo>>();
	
	public static void main(String d[]){
		Subject v=setSubject(1, "one");
		List<Foo> s=new ArrayList<Foo>();
		Foo one=new Foo(v);
		one.setVal3(1);
		Foo two=new Foo(v);
		two.setVal3(1);
		s.add(one);
		s.add(two);
		map.put("test", s);
		System.out.println(map.toString());
		v=setSubject(2, "two");
		System.out.println(map.toString());

	}
	
	public static Subject setSubject(int val1,String val2){
		Subject v=new Subject();
		v.setVal1(val1);
		v.setVal2(val2);
		return v;
	}
}
