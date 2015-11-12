package test;

import java.net.*;
import java.io.*;

/**
 * Simple basic blocking threaded server
 * 
 */
public class BlockingBasicServerThreaded {

	public static void main(String... args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4444);
		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println(clientSocket);
				new Thread( () -> {
						try {
							handle(clientSocket);
						} catch (IOException e) {
							e.printStackTrace();
						}
				}).start();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			} finally {
				//
				// serverSocket.close();
			}

			// serverSocket.close();
		}

	}

	private static void handle(Socket clientSocket) throws IOException {

		try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
				true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));) {
			String inputLine, outputLine;

			while ((inputLine = in.readLine()) != null) {
				out.println(inputLine);
				if (inputLine.equals("Bye."))
					break;
			}
		}
	}
}