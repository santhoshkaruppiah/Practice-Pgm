package test;

public class StringTest {

	public static void main(String[] args) {
		String v=null;
		System.out.println(v==null);
		v="sd";
		System.out.println(v==null);
		System.out.println(reverseNaive("s"));
		System.out.println(reverseNaive("sa"));
		System.out.println(reverseNaive("santhosh"));
	}
	
	public static String reverseNaive(String toReverse) {
		StringBuffer sb = new StringBuffer();
		for(int idx=toReverse.length()-1;idx>=0;idx--) {
			sb.append(toReverse.charAt(idx));
		}
		return sb.toString();
	}
}
