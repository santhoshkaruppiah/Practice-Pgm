package test;

import java.net.Socket;
import java.net.UnknownHostException;


public class SocketClient {

	public static void main(String[] args) throws InterruptedException {
		Socket[] socketArray = new Socket[30000];
		for (int i = 0; i < socketArray.length; i++) {
			try {
				socketArray[i] = new Socket("localhost", 4444);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		Thread.sleep(100000);
	}
}
