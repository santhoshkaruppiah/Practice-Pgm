package com.math;

import static org.junit.Assert.*;
import static com.math.FactorialSol.factSol1;
import static com.math.FactorialSol.factSol2;

import org.junit.Test;

public class FactorialSolTest {

	@Test
	public void testFactSol1Pos1() {
		assertSame(1, factSol1(0));
	}

	@Test
	public void testFactSol1Pos2() {
		assertSame(1, factSol1(1));
	}
	
	@Test
	public void testFactSol1Pos3() {
		assertSame(120, factSol1(5));
	}
	
	@Test
	public void testFactSol2Pos1() {
		assertSame(1, factSol2(0));
	}

	@Test
	public void testFactSol2Pos2() {
		assertSame(1, factSol2(1));
	}
	
	@Test
	public void testFactSol2Pos3() {
		assertSame(120, factSol2(5));
	}
}
