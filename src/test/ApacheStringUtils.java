package test;

import org.apache.commons.lang.StringUtils;

public class ApacheStringUtils {

	public static void main(String[] args) {
		String test1="";
		String test2=null;
		String test3=" ";
		System.out.println(StringUtils.isNotBlank(test1));
		System.out.println(StringUtils.isNotBlank(test2));
		System.out.println(StringUtils.isNotBlank(test3));
	}
}
