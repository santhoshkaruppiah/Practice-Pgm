package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannelCopy extends BaseFileCopier {
	
	@Override
	protected boolean _copyFile(File source, File destination) throws IOException {
		boolean status=false;
		try(FileChannel fromChannel = getChannel(source,"r");
			FileChannel toChannel = getChannel(destination,"rw");){
			ByteBuffer buff = ByteBuffer.allocateDirect(DefaultBufferSize);
			while (fromChannel.read(buff) > 0) {
			      buff.flip();
			      toChannel.write(buff);
			      buff.clear();
			}
			status=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		return status;	
	}

	void useTransferTo(FileChannel fromChannel, FileChannel toChannel) throws IOException {
		long position = 0;
		long count = fromChannel.size();
		fromChannel.transferTo(position, count, toChannel);
	}

	private FileChannel getChannel(File source,String mode) throws FileNotFoundException {
		//return (new RandomAccessFile(source, mode).getChannel());
		FileChannel FileChannel=(new RandomAccessFile(source, mode).getChannel());
		return (FileChannel);
	}
}
