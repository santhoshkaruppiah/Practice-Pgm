package test;

public class TryBinarySearch {

	public static boolean binarySearch(int[] iArr, int iToSearch){
		int startIdx=0;
		int endIdx=iArr.length-1;
		while (startIdx<=endIdx) {
			if (iToSearch==iArr[startIdx]) return true;
			if (iToSearch==iArr[endIdx]) return true;
			int midIdx=(startIdx+endIdx)/2;
			if (iArr[midIdx]==iToSearch) return true;
			if (iToSearch<iArr[midIdx]){
				endIdx=midIdx-1;
			}else if (iToSearch>iArr[midIdx]){
				startIdx=midIdx+1;
			}
		}
		return false;
	}

	public static boolean binarySearchRecurse(int[] iArr, int iToSearch, int lowIdx, int highIdx) {
		
		boolean result = false;
		
		if(lowIdx>highIdx) return false;
		
		int midIdx=(lowIdx+highIdx)/2;
		
		if (iArr[lowIdx] == iToSearch || iArr[highIdx] == iToSearch || iArr[midIdx] == iToSearch) {
			return true;
		}
		
		if (iArr[midIdx]<iToSearch) {
			result = binarySearchRecurse(iArr,iToSearch,midIdx+1,highIdx);
		}else {
			result = binarySearchRecurse(iArr,iToSearch,lowIdx, midIdx-1);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] toSearch=new int[]{5,6,9,12,18,19,32,36,39};
		System.out.println(binarySearch(toSearch, 32));
		int[] toSearch2=new int[]{5,6,9,12,18,19,32,36,39};
		System.out.println(binarySearchRecurse(toSearch2,12, 0, toSearch2.length-1));
	}
}
