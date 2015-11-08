package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Simple basic blocking threaded server
 * 
 */
public class BasicServerThreaded {

	public static void main(String... args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4444);
		ExecutorService execSvc = Executors.newFixedThreadPool(1000);

		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println(clientSocket);
				execSvc.submit(() -> {
					try {
						handle(clientSocket);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
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
		try (
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
				true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()))) {
			String inputLine, outputLine;

			while ((inputLine = in.readLine()) != null) {
				out.println(inputLine);
				if (inputLine.equals("Bye."))
					break;
			}
		}
	}
}