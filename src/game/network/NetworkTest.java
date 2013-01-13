package game.network;
import java.io.*;
import java.net.*;
public class NetworkTest 
{
	PrintStream outStream = null;
	BufferedReader inStream = null;
	Socket testSocket = null;
	public String inMsg = null;
	public void connect(String server, int port)
	{
		try 
			{
				if(testSocket == null)
				{
					testSocket = new Socket(server, port);
					System.out.println("Just connected to "+ testSocket.getRemoteSocketAddress());
					outStream = new PrintStream(testSocket.getOutputStream()) ;
					inStream = new BufferedReader (new InputStreamReader(testSocket.getInputStream()));
					System.out.println("Streams connected");
				}
				else
				{
					System.out.println("You should be alreade connected to "+ testSocket.getRemoteSocketAddress());
				}
			}
		catch (UnknownHostException e)
			{
			System.err.println("Don't know about host: " + server);
			} 
		catch (IOException e) 
			{
			System.err.println("Some kind of IO error occured. That stinks, doesnt it?");
			e.printStackTrace();
			}
	}
	public void sendMsg(String msg)
	{
		if(outStream != null)
		{
			outStream.println(msg);
			System.out.println("Sent the message "+msg+" to server");
		}
		else
		{
			System.err.println("Your outStream hasnt been connected yet");
		}
	}
	
	public void setInMsg() 
	{
		if(inStream != null)
		{
			try 
			{
				inMsg = inStream.readLine();
				System.out.println("Received the message "+inMsg+" from server");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.err.println("Your inStream hasnt been connected yet");
		}
	}
}