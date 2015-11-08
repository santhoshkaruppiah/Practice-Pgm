package test;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void stringToBigDecimal(String bigDecimalString) {
		BigDecimal bigDecimalFromString = new BigDecimal(bigDecimalString);
		System.out.println("Converted Value="+bigDecimalFromString);
	}
	
	public static void stringToBigDecimal_Case1() {
		String toBigDecimal_Case1 = "abc";
		stringToBigDecimal(toBigDecimal_Case1);
	}
	
	public static void stringToBigDecimal_Case2() {
		String toBigDecimal_Case2 = "-23434";
		stringToBigDecimal(toBigDecimal_Case2);
	}
	
	public static void stringToBigDecimal_Case3() {
		String toBigDecimal_Case3 = "32343";
		stringToBigDecimal(toBigDecimal_Case3);
	}
	
	public static void stringToBigDecimal_Case4() {
		String toBigDecimal_Case4 = "122e";
		stringToBigDecimal(toBigDecimal_Case4);
	}
	
	public static void stringToBigDecimal_Case5() {
		String toBigDecimal_Case3 = "329.49";
		stringToBigDecimal(toBigDecimal_Case3);
	}
	
	public static void stringToBigDecimal_Case6() {
		String toBigDecimal_Case3 = "329.50";
		stringToBigDecimal(toBigDecimal_Case3);
	}
	
	public static void stringToBigDecimal_Case7() {
		String toBigDecimal_Case3 = "329.51";
		stringToBigDecimal(toBigDecimal_Case3);
	}
	
	public static void stringToBigDecimal_Case8() {
		String toBigDecimal_Case3 = "329.5111111";
		stringToBigDecimal(toBigDecimal_Case3);
	}
	
	public static void bigDecimalPrecision_Test1(String value){
		BigDecimal  discount = new BigDecimal(value); 
		discount.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("Value="+value+",Converted Value="+discount);
	}
	
	public static void bigDecimalPrecision_Test1(BigDecimal value){
		BigDecimal  discount = value; 
		//discount.setScale(16, java.math.RoundingMode.HALF_UP);
		discount.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("Value="+value+",Converted Value="+discount);
	}
	
	public static void main(String[] args) {
//		try{
//			stringToBigDecimal_Case1();
//		} catch(Exception e){e.printStackTrace();}
//		try{
//			stringToBigDecimal_Case2();
//		} catch(Exception e){e.printStackTrace();}
//		try {
//			stringToBigDecimal_Case3();
//		}catch(Exception e){e.printStackTrace();}
//		try {
//			stringToBigDecimal_Case4();
//		} catch(Exception e){e.printStackTrace();}
//		try {
//			stringToBigDecimal_Case5();
//		} catch(Exception e){e.printStackTrace();}
//		try {
//			stringToBigDecimal_Case6();
//		} catch(Exception e){e.printStackTrace();}
//		try {
//			stringToBigDecimal_Case7();
//		} catch(Exception e){e.printStackTrace();}
//		try {
//			stringToBigDecimal_Case8();
//		} catch(Exception e){e.printStackTrace();}
		System.out.println("String version");
		bigDecimalPrecision_Test1("49.49");
		bigDecimalPrecision_Test1("49.50");
		bigDecimalPrecision_Test1("49.51");
		
		System.out.println("BigD version");
		bigDecimalPrecision_Test1(new BigDecimal(49.49));
		bigDecimalPrecision_Test1(new BigDecimal(49.50));
		bigDecimalPrecision_Test1(new BigDecimal(49.51));
		
		System.out.println("Anonymous version="+new BigDecimal(49.49).setScale(0,BigDecimal.ROUND_HALF_UP));
		System.out.println("Anonymous version="+new BigDecimal(49.50).setScale(0,BigDecimal.ROUND_HALF_UP));
		System.out.println("Anonymous version="+new BigDecimal(49.51).setScale(0,BigDecimal.ROUND_HALF_UP));
	}
}
