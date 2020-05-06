package Task_01.Example_02;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;

public class Example_02 {
	
	// ����� ��� ������ ������ �� ������ �� ������ � �������
	public static void readAllByByte(InputStream in) throws IOException {
		while(true) {
			int oneByte = in.read();
			if(oneByte != -1) {
				System.out.print((char)oneByte);
			}
			else {
				System.out.print("\n" + "end");
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		try {
			// ���������� �����
				String str1 = "Hello world",
					   str2 = "Thank you";
				Writer outFile = 
						new BufferedWriter(
								new FileWriter("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt"));
				outFile.write(str1 + "\n");
				outFile.write(str2);
				
				outFile.flush();
				outFile.close();
				
			
			// � ������� ������ ����
				InputStream inFile = 
						new FileInputStream("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt");
				readAllByByte(inFile);
				System.out.print("\n\n\n");
				inFile.close();
				
			// � ������� ������� ��������-��������
				InputStream inURL = new URL("http://google.com").openStream();
				readAllByByte(inURL);
				System.out.print("\n\n\n");
				inURL.close();
				
			// � ������� ������ ������ ���� byte
				InputStream inArray = new ByteArrayInputStream(new byte[] {7,9,3,4,6,9});
				readAllByByte(inArray);
				System.out.print("\n\n\n");
				inArray.close();
		} catch(IOException e) {
			System.out.print("������: " + e);
		}
	}
}
