package sender;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SenderClient {
	public static void runAsClient(BufferedReader br) throws NumberFormatException, IOException
	{
		System.out.println("port please");
		int port = Integer.parseInt(br.readLine());
		Socket socket = new Socket("localhost",port);
		System.out.println("Enter the file name");
		String fileName = br.readLine();
		File file = new File(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(file);
		socket.close();
	}
}
