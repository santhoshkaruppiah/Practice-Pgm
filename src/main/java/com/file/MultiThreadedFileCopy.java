package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;

public class MultiThreadedFileCopy extends BaseFileCopier {

	/**
	 * Multi-threaded model, 2 threads, handle read and write correspondingly
	 */
	@Override
	protected boolean _copyFile(File source, File destination) throws IOException {
		 Future<Boolean> futureResult=getReadWorkers().submit(()->{
			final String threadName=Thread.currentThread().getName();
         	Thread.currentThread().setName("READ"+threadName);
			boolean result = copy(source,destination);
			return result;
		 });
		 return (IFileCopy.getFuture(futureResult));
	}

	public boolean copy(File source, File destination) {
		boolean status = false;
		byte[] buffer;
		int read;
		try (FileInputStream input = new FileInputStream(source)) {
			destination.createNewFile();
			System.out.println("File Multi-Threaded approach created?"+destination.isFile());
			try (FileOutputStream output = new FileOutputStream(destination)) {
				buffer = new byte[DefaultBufferSize];
				while ((read = input.read(buffer)) > 0) {
					int readCpy=read;
					Future<Boolean> futureResult=getWriteWorkers().submit(()->{
						final String threadName=Thread.currentThread().getName();
			         	Thread.currentThread().setName("WRITE"+threadName);
						write(buffer, readCpy, output);
						return true;
					});
					status = IFileCopy.getFuture(futureResult);
				}
			} catch (Exception e) {
				status = false;
				e.printStackTrace();
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	void write(byte[] buffer, int read,FileOutputStream output) throws Exception {
		output.write(buffer, 0, read);
	}
	
}
