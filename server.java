//Original source code obtained from section 2.7.2 of the slides for Ch. 2 for 5th Ed of Kurose and K. Ross, Computer Networking, A Top-Down Approach, Addison Wesley.  Specifically, slides 104 and 105.  The code was then slightly modified to suit lab purposes.

import java.io.*;
import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception
	{
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true) 
		{
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new
			InputStreamReader(connectionSocket.getInputStream())); 
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			capitalizedSentence = clientSentence + '\n';
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}
