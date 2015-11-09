package com.math;

import static org.junit.Assert.*;
import static com.math.MathUtil.isPowerOf2;
import static com.math.MathUtil.isPower2;

import org.junit.Test;

public class MathUtilTest {

	@Test
	public void testisPowerOf2EvenNum() {
		System.out.println("Method=isPowerOf2()");
		assertTrue(isPowerOf2(4));
	}
	
	@Test
	public void testisPowerOf2OddNum() {
		System.out.println("Method=isPowerOf2()");
		assertFalse(isPowerOf2(3));
	}
	
	@Test
	public void testisPowerOf2Zero() {
		System.out.println("Method=isPowerOf2()");
		assertFalse(isPowerOf2(0));
	}
	
	@Test
	public void testisPower2EvenNum() {
		System.out.println("Method=isPowerOf2()");
		assertTrue(isPower2(4));
	}
	
	@Test
	public void testisPower2OddNum() {
		System.out.println("Method=isPowerOf2()");
		assertFalse(isPower2(3));
	}
	
	@Test
	public void testisPower2Zero() {
		System.out.println("Method=isPowerOf2()");
		assertFalse(isPower2(0));
	}

}
