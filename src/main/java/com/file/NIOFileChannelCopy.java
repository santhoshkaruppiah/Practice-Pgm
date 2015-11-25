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
		try(FileChannel fromChannel = IFileCopy.getChannel(IFileCopy.getRandomAccessFile(source,"r"));
			FileChannel toChannel = IFileCopy.getChannel(IFileCopy.getRandomAccessFile(destination,"rw"));){
			ByteBuffer buff = ByteBuffer.allocateDirect(DefaultBufferSize);
			while (fromChannel.read(buff) > 0) {
			      buff.flip();
			      toChannel.write(buff);
			      buff.clear();
			}
			status=true;
		}catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
				
		return status;	
	}

	void useTransferTo(FileChannel fromChannel, FileChannel toChannel) throws IOException {
		long position = 0;
		long count = fromChannel.size();
		fromChannel.transferTo(position, count, toChannel);
	}

}
