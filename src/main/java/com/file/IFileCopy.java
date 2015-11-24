package com.file;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface IFileCopy {

	public boolean copy(String source, String destination) throws IOException;

	/**
	 * Validate fileName array length
	 * @param fileNames
	 * @return
	 */
	public static boolean validateArg(final String... fileNames) {
		if (fileNames.length != 2) {
			System.out.println("Usage: JavaCopy <src file> <dst file>");
			return (false);
		}
		return (true);
	}

	/**
	 * Validate if srcFile exist
	 * @param srcFile
	 * @return
	 */
	public static boolean validateFile(File srcFile) {
		boolean status = (srcFile.exists() && srcFile.isFile());
		if (!status)
			System.out.println(srcFile + "--Exist?" + status);
		return status;
	}

	/**
	 * Validate arg length and source file
	 * @param fileNames
	 * @return boolean result if rules are validated
	 */
	public static boolean validateRules(final String... fileNames) {
		if (validateArg(fileNames))
			return validateFile(new File(fileNames[0]));
		return false;
	}

	/**
	 * Generic method to getFuture
	 * @param futureValue
	 * @return
	 */
	public static <T> T getFuture(final Future<T> futureValue) {
	     try {
	         return futureValue.get(100, TimeUnit.MILLISECONDS);
	     } catch (final InterruptedException e) {
	         futureValue.cancel(false);
	         throw new RuntimeException("Interrupted waiting for value", e);
	     } catch (final ExecutionException e) {
	         futureValue.cancel(false);
	         throw new RuntimeException("Exception waiting for value", e);
	     } catch (final TimeoutException e) {
	         futureValue.cancel(false);
	         throw new RuntimeException("Timeout waiting for value", e);
	     }
	 }
}
