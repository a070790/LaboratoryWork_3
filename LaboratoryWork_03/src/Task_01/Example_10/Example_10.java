package Task_01.Example_10;

import java.io.BufferedReader; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Example_10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		PrintWriter out = null;
		
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt"),"cp1251"));
			
			out = new PrintWriter("C:\\Papka1\\Papka2\\Papka3\\MyFile.txt","cp1251");
			
			int lineCount = 0; 
			String s;
			while ((s = br.readLine()) != null) { 
				lineCount++; 
				out.println(lineCount + ": " + s);
			}
		} catch (IOException e) {
			System.out.println("Ошибка: "+ e);
		}
		finally{ 
			br.close();
			out.flush();
			out.close();
		}

	}

}
