package com.pblm.javarevisited.blog;

import static org.junit.Assert.*;
import static com.pblm.javarevisited.blog.StringPblm.isPalindrome;
import static com.pblm.javarevisited.blog.StringPblm.removeChar;
import static com.pblm.javarevisited.blog.StringPblm.stringPermutationIterSol1;
import static com.pblm.javarevisited.blog.StringPblm.stringPermutationRecSol1;
import static com.pblm.javarevisited.blog.StringPblm.reverseStringRecursion;
import static com.pblm.javarevisited.blog.StringPblm.isUniqueCharInString;
import static com.pblm.javarevisited.blog.StringPblm.reverseStringArray;
import static com.pblm.javarevisited.blog.StringPblm.reverseString2;
import static com.pblm.javarevisited.blog.StringPblm.reverseString;

import java.util.Arrays;

import org.junit.Test;

public class StringPblmTest {

	@Test
	public void testisPalindromePositive() {
		System.out.println(isPalindrome("malayalam"));
		assertTrue(isPalindrome("malayalam"));
	}

	@Test
	public void testisPalindromeNegative() {
		System.out.println(isPalindrome("santhosh"));
		assertFalse(isPalindrome("santhosh"));
	}

	@Test
	public void testisPalindromeNegative2() {
		System.out.println(isPalindrome(""));
		assertFalse(isPalindrome(""));
	}

	@Test
	public void testisPalindromeNegative3() {
		System.out.println(isPalindrome("s"));
		assertTrue(isPalindrome("s"));
	}

	@Test
	public void testRemoveCharPositive() {
		String ip = "santhosh";
		assertEquals("santhsh", removeChar(ip, "o"));
	}

	@Test
	public void testRemoveCharPositive2() {
		String ip = "santhosh";
		assertEquals("santos", removeChar(ip, "h"));
	}

	@Test
	public void teststringPermutationIterSol1Positive1() {
		String ip = "abc";
		String result = stringPermutationIterSol1(ip);
		assertEquals("aababcbbcc", result);
	}

	/*
	 * @Test public void teststringPermutationRecSol1Positive1() { String
	 * ip="abc"; String result=stringPermutationRecSol1(ip,ip,"");
	 * System.out.println(result); assertEquals("aababcbbcc",result ); }
	 */

	@Test
	public void testReverseStringRecursionPositive1() {
		String ip = "abc";
		String result = reverseStringRecursion(ip);
		System.out.println(result);
		assertEquals("cba", result);
	}

	@Test
	public void testReverseStringRecursionPositive2() {
		String ip = "a";
		String result = reverseStringRecursion(ip);
		System.out.println(result);
		assertEquals("a", result);
	}

	@Test
	public void testReverseStringRecursionPositive3() {
		String ip = "ab";
		String result = reverseStringRecursion(ip);
		System.out.println(result);
		assertEquals("ba", result);
	}

	@Test
	public void testReverseStringRecursionPositive4() {
		String ip = "";
		String result = reverseStringRecursion(ip);
		System.out.println(result);
		assertEquals("", result);
	}

	@Test
	public void testReverseStringRecursionPositive5() {
		String ip = "saanthosh";
		String result = reverseStringRecursion(ip);
		System.out.println(result);
		assertEquals("hsohtnaas", result);
	}

	@Test
	public void testisUniqueCharInString1() {
		String ip = "saanthosh";
		System.out.println(isUniqueCharInString(ip));
		assertFalse(isUniqueCharInString(ip));
	}

	@Test
	public void testisUniqueCharInString2() {
		String ip = "abcd";
		System.out.println(isUniqueCharInString(ip));
		assertTrue(isUniqueCharInString(ip));
	}

	@Test
	public void testReverseStringArrayTwo() {

		String names[] = { "Aaa", "Baa" };
		String expected[] = { "Baa", "Aaa" };
		assertEquals(Arrays.equals(expected, reverseStringArray(names)), true);
	}

	@Test
	public void testReverseStringArrayOdd() {

		String names[] = { "Aaa", "Baa", "Caa", "Ddd", "Eee" };
		String expected[] = { "Eee", "Ddd", "Caa", "Baa", "Aaa" };
		assertEquals(Arrays.equals(expected, reverseStringArray(names)), true);
	}

	@Test
	public void testReverseStringArrayEven() {
		String names[] = { "Aaa", "Baa", "Caa", "Ddd", "Eee", "Fff" };
		String expected[] = { "Fff", "Eee", "Ddd", "Caa", "Baa", "Aaa" };
		assertEquals(true, Arrays.equals(expected, reverseStringArray(names)));
	}
	
	@Test
	public void testReverseStringArrayEven2() {
		String names[] = { "Aaa", "Baa", "Caa", "Ddd" };
		String expected[] = { "Ddd", "Caa", "Baa", "Aaa" };
		assertEquals(true, Arrays.equals(expected, reverseStringArray(names)));
	}
	
	@Test
	public void testReverseString2Two() {

		String names = "AB";
		String expected = "BA";
		assertEquals(expected, reverseString2(names));
	}

	@Test
	public void testReverseString2Odd() {

		String names= "ABC";
		String expected = "CBA";
		assertEquals(expected, reverseString2(names));
	}

	@Test
	public void testReverseString2Even() {
		String names = "ABCD";
		String expected = "DCBA";
		assertEquals(expected, reverseString2(names));
	}
	
	@Test
	public void testReverseStringTwo() {

		String names = "AB";
		String expected = "BA";
		assertEquals(expected, reverseString(names));
	}

	@Test
	public void testReverseStringOdd() {

		String names= "ABC";
		String expected = "CBA";
		assertEquals(expected, reverseString(names));
	}

	@Test
	public void testReverseStringEven() {
		String names = "ABCD";
		String expected = "DCBA";
		assertEquals(expected, reverseString(names));
	}

}
