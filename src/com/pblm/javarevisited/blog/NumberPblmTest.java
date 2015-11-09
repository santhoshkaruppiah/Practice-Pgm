package com.pblm.javarevisited.blog;

import static org.junit.Assert.*;
import static com.pblm.javarevisited.blog.NumberPblm.reverseNumber;
import org.junit.Test;

public class NumberPblmTest {

	@Test
	public void testreverseNumberPositive() {
		System.out.println(reverseNumber(1234));
		if (reverseNumber(1234)==4321){
			System.out.println("equal");
		}else{
			System.out.println("not equal");
		}
	}

}
