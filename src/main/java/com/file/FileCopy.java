package com.file;

import java.io.IOException;

/**
 * Test file for FileCopy 
 *
 */
public class FileCopy {


	public static void main(String[] args)  {

		if (IFileCopy.validateRules(args)) {
			invoke(args);
		}else{
			System.out.println("Validation Failed!");
		}
		
	}

	public static void invoke(String[] args) {
//		BaseFileCopier fileCpy = new MultiThreadedFileCopy();
		BaseFileCopier fileCpy = new BaseFileCopier();
//		BaseFileCopier fileCpy = new NIOFileChannelCopy();
		try {
			long startTime = System.currentTimeMillis();
			System.out.println("File Copied?"+fileCpy.copy(args[0],args[1]));
			long endTime = System.currentTimeMillis();
			System.out.println("In " + (endTime - startTime) + " milliseconds");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
