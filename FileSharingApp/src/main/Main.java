package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import reciever.RecieverServer;
import sender.SenderClient;
//always press 2 and then 1
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException {
		
		System.out.println("Press 1 to send and 2 to recieve");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		int i = Integer.parseInt(br.readLine());
		if(i==1)
			SenderClient.runAsClient(br);
		else
			RecieverServer.runAsServer();
	}


}
