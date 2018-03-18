package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

public class CopyrightNotice {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/CopyrightNotice.java", true); 
			fw.write("\ncopyright @elena");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
