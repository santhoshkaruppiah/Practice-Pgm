package com.file.transfer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MultiThreadedUploader {

	private static final Queue<DataChunks> streamBuffer= new ConcurrentLinkedQueue<DataChunks>();
	
	public static void readStream(InputStream iStream,int bufferSize) throws Exception{
		int length=0;
		byte[] buffer = new byte[bufferSize];
		while ((length=iStream.read(buffer)) >= 0){
			DataChunks dataChunks=new DataChunks();
			dataChunks.setChunks(buffer);
			dataChunks.setStreamComplete(true);
			dataChunks.setLength(length);
			streamBuffer.add(dataChunks);
		}
	}
	
	public static void writeStream(OutputStream oStream) throws Exception{
		if (!streamBuffer.poll().isStreamComplete()){
			return;
		}
		DataChunks peekChunk=streamBuffer.peek();
		oStream.write(modifyByteArrays(peekChunk.getChunks()), 0, peekChunk.getLength());
	}
	
	private static byte[] modifyByteArrays(byte[] byteArray) throws Exception{
		//return searchAndReplace(byteArray,UPLOAD_FILE_ORIGINAL_DELIMITER.getBytes(UPLOAD_FILE_ENCODING),UPLOAD_FILE_REPLACE_DELIMITER.getBytes(UPLOAD_FILE_ENCODING));
		return searchAndReplace(byteArray,",".getBytes("UTF-8"),"^".getBytes("UTF-8"));
	}
	
	private static byte[] searchAndReplace(byte[] sourceArray, byte[] searchArray, byte[] replaceArray) {//Unsorted array, linear search
        if (searchArray.length != replaceArray.length)
            return sourceArray;
        for (int i = 0; i < sourceArray.length; i++) {
			if (sourceArray[i]==searchArray[0]){
				sourceArray[i]=replaceArray[0];
			}
		}
       return sourceArray;
    }
}

