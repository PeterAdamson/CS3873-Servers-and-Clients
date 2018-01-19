//Original source code obtained from section 2.7.2 of the slides for Ch. 2 for 5th Ed of Kurose and K. Ross, Computer Networking, A Top-Down Approach, Addison Wesley.  Specifically, slides 104 and 105.  The code was then slightly modified to suit lab purposes.

//Information about getting server name and server IP found at: https://stackoverflow.com/questions/13448790/how-to-get-the-ip-address-for-remote-host-using-java?rq=1

//Information about getting local name and local IP found at: http://crunchify.com/how-to-get-server-ip-address-and-hostname-in-java/

import java.io.*;
import java.net.*;

class TCPClient {
	public static void main(String argv[]) throws Exception
	{
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		InetAddress host = InetAddress.getByName("localhost");
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		InetAddress localIP = InetAddress.getLocalHost();
		String localName = localIP.getHostName();
		InetAddress serverName = InetAddress.getByName("localHost");
		String serverIP = serverName.getHostAddress();
		System.out.println("FROM SERVER: " + modifiedSentence);
		System.out.println("Local hostname and IP: " + localIP);
		System.out.println("server name: " + host.getHostName());
		System.out.println("server IP: " + serverIP);
		clientSocket.close();
	}
}
