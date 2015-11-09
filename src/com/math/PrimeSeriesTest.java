package com.math;

import static org.junit.Assert.*;
import static com.math.PrimeSeries.isPrime;

import org.junit.Test;

public class PrimeSeriesTest {

	@Test
	public void testIsPrime1() {
		System.out.println("testIsPrime1="+isPrime(2));
		assertTrue("true",isPrime(2));
	}

	@Test
	public void testIsPrime2() {
		System.out.println("testIsPrime2="+isPrime(4));
		assertFalse("false",isPrime(4));
	}
	@Test
	public void testIsPrime3() {
		System.out.println("testIsPrime3="+isPrime(5));
		assertTrue("true",isPrime(5));
	}
	
}
