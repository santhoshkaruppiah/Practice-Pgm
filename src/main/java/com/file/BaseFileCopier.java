package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class BaseFileCopier implements IFileCopy {
	
	protected static final int DefaultBufferSize = 65536;//2^16
	public static final String NoSpaceLeftOnDeviceMessage = "No space left on device";

	private static final ThreadFactory THREAD_FACTORY = (r) -> {
		final String name = "_WORKER_THREAD";
		final Thread thread = new Thread(r, name);
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.setDaemon(true);
		return (thread);
	};

	private static final ExecutorService READ_WORKERS = (Executors.newSingleThreadExecutor(THREAD_FACTORY));

	private static final ExecutorService WRITE_WORKERS = (Executors.newSingleThreadExecutor(THREAD_FACTORY));

	public static ExecutorService getReadWorkers() {
		return READ_WORKERS;
	}

	public static ExecutorService getWriteWorkers() {
		return WRITE_WORKERS;
	}
	
	public boolean copy(String source, String destination) throws IOException {
		boolean result = copy(new File(source), new File(destination));
//		shutdownAndAwaitTermination(getReadWorkers());
//		shutdownAndAwaitTermination(getWriteWorkers());
		return result;
	}
	
	private boolean copy(File source, File destination) throws IOException {
		return _copyFile(source, destination);
	}
	
	/**
	 * Default, single threaded impl
	 * @param source
	 * @param destination
	 * @return
	 * @throws IOException
	 */
	protected boolean _copyFile(File source, File destination) throws IOException {
		boolean status = false;
		byte[] buffer;
		int read;
		try (FileInputStream input = new FileInputStream(source)) {
			destination.createNewFile();
			try (FileOutputStream output = new FileOutputStream(destination)) {
				buffer = new byte[DefaultBufferSize];
				while ((read = input.read(buffer)) > 0) {
					try {
						output.write(buffer, 0, read);
						status = true;
					} catch (Exception exception) {
						// System.err.printf("message: %s\n",exception.getMessage());
						System.out.println(exception.getMessage());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	/**
	 * ShutDown Exec Svc
	 */
	private final void shutdownAndAwaitTermination(ExecutorService excSvc) {
		excSvc.shutdown();//NOTE: shutdown throw exception
		try {
			if (!excSvc.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				excSvc.shutdownNow(); 
				if (!excSvc.awaitTermination(100, TimeUnit.MILLISECONDS))
				   System.out.println("");
			} 
		}catch (InterruptedException ie) {
			excSvc.shutdownNow();
		}
	}
}
