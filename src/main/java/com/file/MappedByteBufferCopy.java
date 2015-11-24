package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferCopy extends BaseFileCopier {
	
	/**
	 * NIO using MappedByteBuffer to copy files
	 */
	@Override
	protected boolean _copyFile(File source, File destination) throws IOException {
		boolean status=false;
		try(FileChannel fromChannel = getChannel(source,"r");
			FileChannel toChannel = getChannel(destination,"rw");){
			MappedByteBuffer buffer = fromChannel.map(FileChannel.MapMode.READ_ONLY, 0, fromChannel.size());
	        buffer.load();
	        toChannel.write(buffer);
	        buffer.clear();
	        status=true;
		}catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;	
	}
	
	private FileChannel getChannel(File source,String mode) throws FileNotFoundException {
		//return (new RandomAccessFile(source, mode).getChannel());
		FileChannel FileChannel=(new RandomAccessFile(source, mode).getChannel());
		return (FileChannel);
	}

}
