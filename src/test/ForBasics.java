package test;

public class ForBasics {

	public static void forLoopOrder(){
//		for(for1Block(0);
//			i++,System.out.println("Increment block")
//			){
//			System.out.println("i="+i);
//		}
	}
	
	public static int for1Block(int i){
		System.out.println("Init. Block, i="+i);
		return i;
	}
	
	public static boolean for2Block(int leftVar,int rightVar,int conditionCode){
		if (rightVar<0){rightVar=10;}
		System.out.println("Cond. Check Block, leftVar="+leftVar+" ,rightVar="+rightVar+" ,conditionCode="+conditionCode);
		if (conditionCode==1) {
			return (leftVar<rightVar);
		} else if (conditionCode==2){
			return (leftVar>rightVar);
		} else if (conditionCode==3){
			return (leftVar==rightVar);
		}
		return (false);
	}
	
	public static int for3Block(int i,int conditionCode){
		if (conditionCode==1) {
			i++;
			return (i);
		} else if (conditionCode==2) {
			i--;
			return (i);
		}
		return (i);
	}
}
