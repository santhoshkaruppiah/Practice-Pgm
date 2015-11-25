package com.file;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferCopy extends BaseFileCopier {
	
	/**
	 * NIO using MappedByteBuffer to copy files
	 */
	@Override
	protected boolean _copyFile(File source, File destination) throws IOException {
		boolean status=false;
		try(FileChannel fromChannel = IFileCopy.getChannel(IFileCopy.getRandomAccessFile(source,"r"));
			FileChannel toChannel = IFileCopy.getChannel(IFileCopy.getRandomAccessFile(destination,"rw"));){
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
	
}
