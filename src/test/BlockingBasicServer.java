package test;

import java.net.*;
import java.io.*;

/**
 * Simple basic blocking server
 * For learning, this is basic server, 
 * Copied from http://stackoverflow.com/questions/2187626/how-to-create-a-basic-java-server 
 *
 */
public class BlockingBasicServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        handle(clientSocket);
        clientSocket.close();
        serverSocket.close();
    }

	private static void handle(Socket clientSocket) throws IOException {
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
             out.println(inputLine);
             if (inputLine.equals("Bye."))
                break;
        }
        out.close();
        in.close();
	}
}