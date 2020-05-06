package Task_01.Example_09;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Example_09 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null; 
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt"),"cp1251"));
			
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("C:\\Papka1\\Papka2\\Papka3\\MyFile.txt"),"cp1251"));
			
			int lineCount = 0;
			String s;
			while ((s = br.readLine()) != null) { 
				lineCount++; 
				System.out.println(lineCount + ": " + s);
				bw.write(lineCount + ": " + s);
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Ошибка: "+ e);
		}
		finally {
			br.close();
			bw.flush();
			bw.close();
		}

	}

}
