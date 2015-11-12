package test;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.io.*;

/**
 * Simple basic blocking server using NIO
 *
 */
public class NIOBlockingBasicServer {

	public static void main(String... args) throws IOException {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		ssChannel.bind(new InetSocketAddress(4444));
		while(true){
			SocketChannel sc= ssChannel.accept();//blocking never null
			//System.out.println(sc);
			handle(sc);	
		}
	}

	private static void handle(SocketChannel clientSocket) throws IOException {
		ByteBuffer bf = ByteBuffer.allocateDirect(80);
		int data;
		while((data=clientSocket.read(bf)) !=-1){
			bf.flip();
			while(bf.hasRemaining()){
				System.out.println(bf);
			}
			bf.compact();
		}
	}
}