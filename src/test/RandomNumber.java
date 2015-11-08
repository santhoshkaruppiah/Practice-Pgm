package test;

import java.util.Date;

public class RandomNumber {
	
	
	public static int GetTimestamp()
	{
	    // 10m ticks in a second, so 50m in 5 seconds
	    int ticksIn5Seconds = 50000000;
	    System.out.println("tick"+(new Date().getTime() / ticksIn5Seconds));
	    System.out.println("ticks/mil"+(new Date().getTime() / ticksIn5Seconds) % 1000000);
	    return (int)((new Date().getTime() / ticksIn5Seconds) % 1000000);
	}
	
	
	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(GetTimestamp());
//		}
		int num=123456789;
		int mod=100000;
		System.out.println(num%mod);
		for (int i = 0; i < 100; i++) {
			System.out.println(System.currentTimeMillis()%mod);
		}
	}

}
