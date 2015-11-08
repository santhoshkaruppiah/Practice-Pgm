package test;

import java.util.HashMap;
import java.util.Map;

public class ForBreak {

	public static void main(String[] args) {
		for (int i=0;i<3;i++){
			System.out.println(i);
			if (i==1) break;
			System.out.println("After Break");
		}
		
		Map<String,String> tmp=new HashMap<String,String>();
		Map<String,String> r=new HashMap<String,String>();
		r.put("a", "A");
		//if (tmp!=null && tmp.size()>0)
		r.putAll(tmp);
		System.out.println(r);
	}
}
