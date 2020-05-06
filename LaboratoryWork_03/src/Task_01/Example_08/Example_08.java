package Task_01.Example_08;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Example_08 {
	
	public static void readAllByByte(Reader in) throws IOException { 
		while (true) {
			int oneByte = in.read();
			if (oneByte != -1) {
				System.out.print((char)oneByte);
			} 
			else {
				System.out.print("\n" + " конец ");
				break;
			}
		}
	}

	public static void main(String[] args) {
		try {
			InputStream inFile = new FileInputStream("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt");
			Reader rFile = new InputStreamReader(inFile,"cp1251");
			
			readAllByByte(rFile);
			System.out.print("\n\n\n");
			inFile.close();
			rFile.close();
			
			InputStream inUrl = new URL("http://google.com").openStream();
			Reader rUrl = new InputStreamReader(inUrl, "cp1251");
			
			readAllByByte(rUrl); 
			System.out.print("\n\n\n"); 
			inUrl.close();
			rUrl.close();
			
			InputStream inArray = new ByteArrayInputStream(new byte[] {5, 8, 3, 9, 11}); 
			Reader rArray = new InputStreamReader(inArray,"cp1251"); 
			
			readAllByByte(rArray); System.out.print("\n\n\n"); 
			inArray.close(); 
			rArray.close();	
		} catch (IOException e) {
			System.out.println("Ошибка: "+ e);
		}
		
		/*
		 * В отличие от использования буферизированного ввода-вывода
		 * в Example_07 использование потоков-конвертеров позволяет 
		 * управлять символьной кодировкой при вводе/выводе байтов
		 */

	}

}
