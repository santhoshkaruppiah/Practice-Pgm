package com.pblm;

public class SMaxSubArr {

	public static RangeCapsule findMaxCrossingSubArr(int[] numberArr,int lowIdx, int midIdx, int highIdx){
		assert lowIdx==0 && highIdx==0:"low and high are zero";
		int leftMaxSum = Integer.MIN_VALUE;
		int leftSum = 0;
		int leftMaxIdx = 0;
		for (int leftIdx = midIdx; leftIdx >= lowIdx; leftIdx--) {
			leftSum = leftSum + numberArr[leftIdx];
			if (leftSum>leftMaxSum){
				leftMaxSum = leftSum;
				leftMaxIdx=leftIdx;
			}
		}
		
		int rightMaxSum = Integer.MIN_VALUE;
		int rightSum = 0;
		int rightMaxIdx = 0;
		for (int rightIdx = midIdx+1; rightIdx <= highIdx; rightIdx++) {
			rightSum = leftSum + numberArr[rightIdx];
			if (rightSum>rightMaxSum){
				rightMaxSum = rightSum;
				rightMaxIdx=rightIdx;
			}
		}
		
		return new RangeCapsule(leftMaxIdx, rightMaxIdx, leftMaxSum+rightMaxSum);
	}
	
	public static RangeCapsule findMaxSubArr(int[] numberArr,int lowIdx,int highIdx){
		//assert (lowIdx==0 && highIdx==0):"low and high are zero";
		if (lowIdx > highIdx) {
			return null;
		}
		if (lowIdx==0 && highIdx==0){return new RangeCapsule(lowIdx, highIdx,numberArr[lowIdx]);}
		/*else if (lowIdx==0 && highIdx==1){
			return new RangeCapsule(lowIdx, highIdx,numberArr[lowIdx]+numberArr[highIdx]);
		}*/else{
			if (lowIdx+highIdx==0) return null;
			//int midIdx=(int)Math.ceil((lowIdx+highIdx)/2)==0?1:(int)Math.ceil((lowIdx+highIdx)/2);
			int midIdx=(int)Math.ceil((lowIdx+highIdx)/2);
			System.out.println("midIdx="+midIdx+",lowIdx"+lowIdx+",highIdx"+highIdx);
			RangeCapsule leftCapsule=findMaxSubArr(numberArr, lowIdx, midIdx);
			System.out.println("left call return");
			RangeCapsule rightCapsule=findMaxSubArr(numberArr, midIdx+1, highIdx);
			System.out.println("right call return");
			RangeCapsule midCapsule=findMaxCrossingSubArr(numberArr,lowIdx, midIdx, highIdx);
			System.out.println("mid call return");
			if (leftCapsule.getSum()>=rightCapsule.getSum() && leftCapsule.getSum()>=midCapsule.getSum()){
				return new RangeCapsule(leftCapsule.getLow(), leftCapsule.getHigh(), leftCapsule.getSum());
			}else if (rightCapsule.getSum()>=leftCapsule.getSum() && rightCapsule.getSum()>=midCapsule.getSum()){
				return new RangeCapsule(rightCapsule.getLow(), rightCapsule.getHigh(), rightCapsule.getSum());
			}else{
				return (new RangeCapsule(midCapsule.getLow(),midCapsule.getHigh(),midCapsule.getSum()));
			}
		}
	}
	
	
	public static void cubicAlgorithm(int[] numArr){
		int maxSoFar = 0;
		int lowIdx=-1,highIdx=-1;
		for (int i = 0; i < numArr.length; i++) {
			for (int j = 0; j < numArr.length; j++) {
				int sum=0;
				for (int k = i; k < j; k++) {
					sum+=numArr[k];
					int tempMaxSoFar=maxSoFar;
					maxSoFar = Math.max(maxSoFar, sum);
					if (tempMaxSoFar!=maxSoFar){
						lowIdx = i;
						highIdx = k;
					}
				}
			}
			
		}
		
		System.out.println("Cubic Algo::Max Value is="+maxSoFar+",lowidx="+lowIdx+",highIdx="+highIdx);
	}
	
	public static void quadAlgorithm(int[] numArr){
		int maxSoFar = 0;
		for (int i = 0; i < numArr.length; i++) {
			int sum=0;
			for (int j = i; j < numArr.length; j++) {
				sum+=numArr[j];
				maxSoFar = Math.max(maxSoFar, sum);
			}
			
		}
		
		System.out.println("Quoad Algo::Max Value is="+maxSoFar);
	}
	public static int divideConquerAlgorith(int[] numArray,int startIdx,int endIdx){
		if (startIdx>endIdx) return 0;
		if (startIdx==endIdx) return Math.max(0, numArray[startIdx]);
		int midIdx = (startIdx+endIdx)/2;
		int leftMax =0,lsum=0;
		for(int i=midIdx;i>=0;i--){
			lsum+=numArray[i];
			leftMax = Math.max(leftMax, lsum);
		}
		int rightMax =0,rsum=0;
		for(int i=midIdx+1;i<=endIdx;i++){
			rsum+=numArray[i];
			rightMax = Math.max(rightMax, rsum);
		}
		return max(leftMax+rightMax,divideConquerAlgorith(numArray, startIdx, midIdx),divideConquerAlgorith(numArray, midIdx+1, endIdx));
	}
	
	public static int max(int a, int b,int c){
		if (a>b && a>c){return a;}
		if (b>a && b>c){return b;}
		if (c>a && c>b){return c;}
		return 0;
	}
	
	public static int naiveMaxSubArr(int[] numArray){
		int maxSoFar=0;
		for (int i = 0; i < numArray.length-1; i++) {
			int sum=0;
			for (int j = i; j < numArray.length-1; j++) {
				sum+=numArray[j];
				if (sum>maxSoFar){
					maxSoFar=sum;
				}
			}
		}
		return maxSoFar;
	}
	
	private static int linearMaxSubArr(int[] numArray){
		int maxSoFar=0,maxEndingHere=0;
		for (int i = 0; i < numArray.length; i++) {
			maxEndingHere=(maxEndingHere+numArray[i])>0?(maxEndingHere+numArray[i]):0;
			if(maxEndingHere>maxSoFar) 
				maxSoFar=maxEndingHere;
		}
		return maxSoFar;
	}
	
	public static void main(String[] s){
		System.out.println("Max Sub Array Problem");
//		int[] numArr={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int[] numArr={31,-41,59,26,-53,58,97,-93,-23,84};
//		System.out.println(numArr.length);
//		System.out.println(Math.ceil(1));
//		RangeCapsule resultCapsule=findMaxSubArr(numArr,0,numArr.length-1);
//		System.out.println("High="+resultCapsule.getHigh()+",Low="+resultCapsule.getLow()+",Sum="+resultCapsule.getSum());
//		cubicAlgorithm(numArr);
//		quadAlgorithm(numArr);
//		System.out.println(divideConquerAlgorith(numArr,0,numArr.length-1));
		//System.out.println(naiveMaxSubArr(numArr));
		System.out.println(linearMaxSubArr(numArr));
	}
	
}

class RangeCapsule{
	private int low,high,sum;
	RangeCapsule(int low,int high,int sum){
		this.high=high;
		this.low=low;
		this.sum=sum;
	}
	
	public int getLow() {
		return low;
	}
	
	public int getHigh() {
		return high;
	}
	
	public int getSum() {
		return sum;
	}
}