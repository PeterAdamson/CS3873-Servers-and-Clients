#!/usr/bin/env python

#original source code obtained from section 2.7.2 of the slides for Ch. 2 for 5th Ed of Kurose and K. Ross, Computer Networking, A Top-Down Approach, Addison Wesley
#code was slightly modified to suit lab purposes

from socket import *
serverPort = 12000
serverSocket = socket(AF_INET,SOCK_STREAM)
serverSocket.bind(("",serverPort))
serverSocket.listen(1)
print "The server is ready to receive"
while 1:
	connectionSocket, addr = serverSocket.accept()
	sentence = connectionSocket.recv(1024)
	capitalizedSentence = sentence.upper()
	connectionSocket.send(capitalizedSentence)
	connectionSocket.close()
