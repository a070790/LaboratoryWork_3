package Task_01.Example_06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Example_06 {

	public static void main(String[] args) throws IOException {
		Reader in = null;
		Writer out = null;
		
		try {
			in = new FileReader("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt");
			out = new FileWriter("C:\\Papka1\\Papka2\\Papka3\\MyFile.txt", true);
			
			int oneByte;
			while((oneByte = in.read()) != -1) {
				out.append((char)oneByte);
				System.out.print((char)oneByte);
			}
		} catch (IOException e) {
			System.out.println("Ошибка!!!! ");
		}
		finally {
			in.close();
			out.flush();
			out.close();
		}
	}
}
