package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DecryptedMessage {
	public static void main(String[] args) {
		String fileName = "";
		String decryptedMessage = "";
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
		}
		try {
			FileReader fr = new FileReader(fileName);
			int c = fr.read();
			while(c != -1){
				decryptedMessage+=(char)(c-3);
				c = fr.read();
				
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(decryptedMessage);
	}
}
