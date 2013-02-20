package game.core;

import java.io.*;
import java.net.*;

public class NetworkTest {
	PrintStream outStream = null;
	BufferedReader inStream = null;
	public Socket testSocket = null;
	public String inMsg = null;

	public void connect(String server, int port) {
		try {
			if (testSocket == null) {
				testSocket = new Socket(server, port);
				System.out.println("Just connected to "
						+ testSocket.getRemoteSocketAddress());
				outStream = new PrintStream(testSocket.getOutputStream());
				inStream = new BufferedReader(new InputStreamReader(
						testSocket.getInputStream()));
				System.out.println("Streams connected");
			} else {
				System.out.println("You should be already connected to "
						+ testSocket.getRemoteSocketAddress() + ".");
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + server);
		} catch (IOException e) {
			System.err
					.println("Some kind of network I/O error occured. That stinks, doesn't it?");
			e.printStackTrace();
		}
	}

	public void sendMsg(String msg) {
		if (outStream != null) {
			outStream.println(msg);
			System.out.println("Sent message " + msg + " to the server.");
		} else {
			System.err.println("Your outStream hasn't been connected yet.");
		}
	}

	public void setInMsg() {
		if (inStream != null) {
			try {
				inMsg = inStream.readLine();
				System.out.println("Received message " + inMsg
						+ " from the server.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Your inStream hasn't been connected yet");
		}
	}

	public void terminate() throws IOException {
		outStream.close();
		System.out.println("outStream closed.");
		inStream.close();
		System.out.println("inStream closed.");
		testSocket.close();
		System.out.println("testSocket closed.");
	}
}