package com.file.transfer;

public class DataChunks {

	private byte[] chunks;
	private boolean isStreamComplete;
	private int length;
	
	public byte[] getChunks() {
		return chunks;
	}
	public void setChunks(byte[] chunks) {
		this.chunks = chunks;
	}
	public boolean isStreamComplete() {
		return isStreamComplete;
	}
	public void setStreamComplete(boolean isStreamComplete) {
		this.isStreamComplete = isStreamComplete;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
}
