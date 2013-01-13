package game.network;
import java.io.*;
import java.net.*;
@SuppressWarnings("deprecation")
public class NetworkTest 
{
	PrintStream outStream = null;
	DataInputStream inStream = null;
	Socket testSocket = null;
	public void connect(String server, int port)
	{
		try 
			{
			testSocket = new Socket(server, port);
			System.out.println("Just connected to "+ testSocket.getRemoteSocketAddress());
			outStream = new PrintStream(testSocket.getOutputStream()) ;
			inStream = new DataInputStream(testSocket.getInputStream());
			System.out.println("Streams connected");
			}
		catch (UnknownHostException e)
			{
			System.err.println("Don't know about host: " + server);
			} 
		catch (IOException e) 
			{
			System.err.println("Some kind of IO error occured. That stinks, doesnt it?");
			}
	}
	public void sendMsg(String msg)
	{
		outStream.println(msg);
		System.out.println("Sent the message "+msg+" to server");
	}
	public String retrieve;
	{
		try {
			retrieve = inStream.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}