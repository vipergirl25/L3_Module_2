package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class EncryptedMessage {
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Enter a message: ");
		String encryptedMessage = "";
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
				c+=3;
				encryptedMessage+=(char)c;
		}
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/encryptedmessage.txt", true);
			fw.write(encryptedMessage);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
