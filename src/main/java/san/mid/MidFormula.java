package san.mid;

public class MidFormula {

	public static void main(String[] args) {
//		System.out.println("Div-Op");
//		System.out.println(divideOp(9, 2));
//		System.out.println(divideOp(8, 2));
//		System.out.println("Mod-Op");
//		System.out.println(modOp(4, 2));
//		System.out.println(modOp(5, 2));
//		System.out.println("Mid-Op");
//		System.out.println(mid(1, 5));
//		System.out.println(mid(1, 7));
//		System.out.println(mid(1, 4));
		
		System.out.println("Optimized="+reverseOptimized("abcde")+
							",Naive="+reverseNaive("abcde")+
							",is equal="+reverseOptimized("abcde").equals(reverseNaive("abcde")));
		System.out.println("Optimized="+reverseOptimized("abce")+
							",Naive="+reverseNaive("abce")+
							",is equal="+reverseOptimized("abce").equals(reverseNaive("abce")));
		System.out.println("Optimized="+reverseOptimized("1234567")+
							",Naive="+reverseNaive("1234567")+
							",is equal="+reverseOptimized("1234567").equals(reverseNaive("1234567"))
						);
		System.out.println("Optimized="+reverseOptimized("12345678")+
							",Naive="+reverseNaive("12345678")+
							",is equal="+reverseOptimized("12345678").equals(reverseNaive("12345678"))
						);
	}
	
	public static double divideOp(int numerator,int denotminator) {
		return (numerator/denotminator);
	}
	
	public static double modOp(int numerator,int denotminator) {
		return (numerator/denotminator);
	}
	
	public static double mid(int start, int end){
		return ((start+end)/2);
	}
	
	public static boolean isEven(int num){
		return (num%2==0);
	}
	
	public static String reverseOptimized(String toReverse) {
		char[] reverseString = new char[toReverse.length()];
		int mid = (int) mid(1, toReverse.length());
		mid = mid-1;
//		System.out.println("mid="+mid);
		for (int i=0, decL=toReverse.length()-1;i<=mid;i++,decL--) {
			reverseString[i] = toReverse.charAt(decL);
			reverseString[decL] = toReverse.charAt(i);
//			System.out.println("I="+i);
		}
		return (new String(reverseString));
	}
	
	public static String reverseNaive(String toReverse) {
		StringBuffer sb = new StringBuffer();
		for (int i=toReverse.length()-1;i>=0;i--) {
			sb.append(toReverse.charAt(i));
		}
		return (sb.toString());
	}
}
