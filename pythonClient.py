#!/usr/bin/env python

#original source code obtained from section 2.7.2 of the slides for Ch. 2 for 5th Ed of Kurose and K. Ross, Computer Networking, A Top-Down Approach, Addison Wesley
#code was slightly modified to suit lab purposes

#gethostbyname and gethostname information found at:
#https://stackoverflow.com/questions/166506/finding-local-ip-addresses-using-pythons-stdlib

#gethostbyaddr information found at:
#https://stackoverflow.com/questions/10748959/get-hostname-from-ip-address

from socket import *
serverName = "localhost"
serverPort = 12000
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName,serverPort))
sentence = raw_input("Input lowercase sentence:")
clientSocket.send(sentence)
clientIP = gethostbyname(getfqdn())
clientName = gethostbyaddr(clientIP)
serverIP = gethostbyname(serverName)
serverName = gethostbyaddr(serverIP)
modifiedSentence = clientSocket.recv(1024)
print "From Server:", modifiedSentence
print "Local Name and IP:", clientName
print "server name and IP:", serverName
clientSocket.close()
