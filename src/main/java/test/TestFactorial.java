package test;

public class TestFactorial {

	public static void main(String[] args) {
		
//		System.out.println("Rec="+ factorial_recursive(5) +
//							",iter method1="+factorialIter_method1(5)+
//							",iter method2="+factorialIter_method2(5)+
//							",is equal ="+(factorial_recursive(5)==factorialIter_method1(5)));
//		System.out.println("method-2="+factorialIter_method2(5));
		
//		System.out.println(isPowerOfTow(7));
//		System.out.println(3/2+","+3%2);
		generatePowTwo(10);
		
	}
	
	/**
	 * Powers of 2 in reverse order:
	 * 2048,1024,512,256,128,64,32,16,8,4,2,1

	
		2=00000010		3=00000011		4=00000100		5=00000101		6=00000110		8=00001000
		1=00000001		2=00000010		3=00000011		4=00000100		5=00000101		7=00000111
		&=00000000		&=00000010		&=00000000		&=00000100		&=00000100		&=00000000

	 * @param n
	 * @return
	 */
	static boolean isPowerOfTow(int n){
		return (n > 0) && ((n & (n - 1)) == 0);
	}
	
	static void generatePowTwo(int i) {
		for (int j = 0; j < i; j++) {
			System.out.println("j="+j+",two Pow_Iter="+powerOfTwo(j));
			System.out.print("j="+j+",two Pow_Rec="+powerOfTwo_rec(j));
			System.out.println(",is Equal="+(powerOfTwo(j)==powerOfTwo_rec(j)));
		}
	}
	
	static int powerOfTwo(int v){
		if (v==0) return 1;
		int result =1;
		for (int i = v; i >0; i--) {
			result = result*2; 
		}
		
		return result;
	}
	
	static int powerOfTwo_rec(int v){
		if (v==0) return 1;
		return (2*powerOfTwo_rec(v-1));
	}
	
	static int factorial_recursive (int v){
		if (v==1) return 1;
		return v*factorial_recursive(v-1);
	}
	
	static int factorialIter_method1 (int v){
		int result = 1;
		for (int i = v; i > 0; i--) {
			result = result * i;
		}
		return result;
	}
	
	static int factorialIter_method2 (int v){
		int result = 1;
		for (int i = 1; i <= v; i++) {
			result = result * i;
		}
		return result;
	}
}
