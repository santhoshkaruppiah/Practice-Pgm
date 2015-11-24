package com.bit.test;

public class BitArithTest {

	public static void main(String[] args) {

		regular_multiplication(5, 2);
		regular_multiplication(5, 4);
		regular_multiplication(5, 3);//failure test case
		quotient(0,2);
		quotient(0,0);
		quotient(4,4);
		quotient(100,5);//failure test case
		quotient(20,2);
	}
	
	public static int quotient(int num,int den) {
		if (den==0) return 0;
		int quotient = num/den;
		System.out.println("Quotient="+quotient+",bit_div="+twoPowShiftDiv(num,den)+
				",is equal?"+(twoPowShiftDiv(num,den)==quotient));
		return (num/den);
	}
	
	public static int twoPowShiftDiv(int num,int den){
		if (den==0) return 0;
		return (num>>(int)log2(den));
	}
	
	public static void regular_multiplication(int num,int multiplier){
		int reg_result = num*multiplier;
		int bit_result = twoPowLftShiftMul(num, multiplier);
		int bit_result_all=bitwiseMultiply(num, multiplier);
		System.out.println("reg_mul="+reg_result+",2^LeftShiftMul="+bit_result+",bit_result_all="+bit_result_all+"\n"+"2^LeftShiftMul equal?"+(reg_result==bit_result)+",bitwiseMultiply eq?"+(bit_result_all==reg_result));
	}

	/**
	 * This can multiply only by powers of 2
	 * @param num
	 * @param multiplier
	 * @return
	 */
	public static int twoPowLftShiftMul(int num, int multiplier) {
		return (num<<(int)log2(multiplier));
	}
	
	public static double logb( double a, double b )
	{
		return Math.log(a) / Math.log(b);
	}

	public static double log2( double a )
	{
		return logb(a,2);
	}
	
	public static int bitwiseMultiply(int n1, int n2) {
		
		/* This value will hold n1 * 2^i for varying values of i.  It will
	     * start off holding n1 * 2^0 = n1, and after each iteration will 
	     * be updated to hold the next term in the sequence.
	     */
        int a = n1;
        
        /* This value will be used to read the individual bits out of n2.
         * We'll use the shifting trick to read the bits and will maintain
         * the invariant that after i iterations, b is equal to n2 >> i.
         */
        int b = n2;
        
        /* This value will hold the sum of the terms so far. */
        int result=0;
        
        while (b != 0) { // Iterate the loop till b==0
        
        	/* Using the bitwise AND trick, determine whether the ith 
             * bit of b is a zero or one.  If it's a zero, then the
             * current term in our sum is zero and we don't do anything.
             * Otherwise, then we should add n1 * 2^i.
             */
        	
            if ((b & 01) != 0) // Logical ANDing of the value of b with 01
            {
            	/* Recall that a = n1 * 2^i at this point, so we're adding
                 * in the next term in the sum.
                 */
                result = result + a; // Update the result with the new value of a.
            }
            
            /* To maintain that a = n1 * 2^i after i iterations, scale it
             * by a factor of two by left shifting one position.
             */
            a <<= 1;// Left shifting the value contained in 'a' by 1.
            
            /* To maintain that b = n2 >> i after i iterations, shift it
             * one spot over.
             */
            b >>= 1;// Right shifting the value contained in 'b' by 1.
        }
        return result;
    }

    public static int bitwiseAdd(int n1, int n2) {
        int x = n1, y = n2;
        int xor, and, temp;
        and = x & y;
        xor = x ^ y;

        while (and != 0) {
            and <<= 1;
            temp = xor ^ and;
            and &= xor;
            xor = temp;
        }
        return (xor);
    }

}
