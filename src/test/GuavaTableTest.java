package test;

import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class GuavaTableTest {

	public static void main(String[] args) {
		testTable();
	}
	
	public static void testTable(){
		Table<Integer, String, String> commitVersionTable = HashBasedTable.create();
		commitVersionTable.put(1, "P1", "V1");
		commitVersionTable.put(1, "P11", "V11");
		commitVersionTable.put(1, "P12", "V12");
		commitVersionTable.put(1, "P13", "V13");
		commitVersionTable.put(2, "P2", "V2");
		commitVersionTable.put(3, "P3", "V3");
		commitVersionTable.put(4, "P4", "V4");
		commitVersionTable.put(5, "P5", "V5");
		commitVersionTable.put(6, "P6", "V6");
		commitVersionTable.put(7, "P7", "V7");
		Map<String,String> batchMap = commitVersionTable.row(1);
		System.out.println(batchMap.size());
		System.out.println(commitVersionTable.row(1));
	}
}
