package test;

public class ORTest {

	public static void main(String[] args) {
		
		//printORTruth();
		System.out.println((cond1(1,1)||cond2(1,1)));
		
		System.out.println("Next-TC");
		System.out.println((cond1(1,2)||cond2(1,1)));
		
	}

	private static void printORTruth() {
		System.out.println((true||true));
		System.out.println((true||false));
		System.out.println((true||true));
		System.out.println((false||false));
	}
	
	public static boolean cond1(int val1,int val2){
		System.out.println("Eval- method cond1");
		return (val1==val2);
	}
	
	public static boolean cond2(int val1,int val2){
		System.out.println("Eval- method cond2");
		return (val1==val2);
	}
}
