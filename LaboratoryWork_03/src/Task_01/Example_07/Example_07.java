package Task_01.Example_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example_07 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		BufferedWriter out = null;
		
		try {
			br = new BufferedReader(new FileReader("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt"), 1024);
			out = new BufferedWriter(new FileWriter("C:\\Papka1\\Papka2\\Papka3\\MyFile.txt"));
			
			int lineCount = 0;
			String s;
			
			while((s = br.readLine()) != null) {
				lineCount++;
				System.out.println(lineCount + ": " + s);
				out.write(s);
				out.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			br.close();
			out.flush();
			out.close();
		}
	}
}
