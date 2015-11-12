package com.math;

import static org.junit.Assert.*;
import static com.math.FibnocciSol.fibSol1;
import static com.math.FibnocciSol.fibSol3;

import org.junit.Test;

public class FibnocciSolTest {

	@Test
	public void testFibSol1() {
		assertEquals(3, fibSol1(4));
	}

	@Test
	public void testFibSol2() {
		assertEquals(0, fibSol1(0));
	}
	
	@Test
	public void testFibSol3() {
		assertEquals(1, fibSol1(1));
	}
	
	@Test
	public void testFibSol4() {
		assertEquals(144, fibSol1(12));
	}
	
	@Test
	public void testFibSol31() {
		assertEquals(3, fibSol3(4));
	}

	@Test
	public void testFibSol32() {
		assertEquals(0, fibSol3(0));
	}
	
	@Test
	public void testFibSol33() {
		assertEquals(1, fibSol3(1));
	}
	
	@Test
	public void testFibSol34() {
		assertEquals(144, fibSol3(12));
	}
}
