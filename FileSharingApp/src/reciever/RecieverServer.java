package reciever;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RecieverServer {
	public static void runAsServer() throws IOException, ClassNotFoundException
	{
		int port = (int) (Math.random()*1000+2000);
		System.out.println("port ="+port);
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		File file = (File) ois.readObject();
		storeFile(file);
	}
	
	private static void storeFile(File file) throws IOException {
		File newfile = new File(file.getName()+"_new");
		FileOutputStream br = new FileOutputStream(newfile);
		FileInputStream fis = new FileInputStream(file);
		int ch;
		while((ch=fis.read())>0)
		{
			br.write(ch);
		}
	}
}
