package Task_01.Example_03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Example_03 {
	
	// Считывание по 5 символов (буфер)
	public static void readAllByArray(InputStream in) throws IOException {
		byte[] buff = new byte[5];
		
		while(true) {
			int count = in.read(buff);			
			if(count != -1) {
				for (int i = 0; i < buff.length; i++) {
					if(buff[i] == 10) {
						buff[i] = ' ';
					}
				}	
				
				System.out.println("Количество = " + count + ", " 
						+ "buff = " + Arrays.toString(buff)
							+ ", str = " + new String(buff, 0, count, "cp1251")); // UTF-8
			}
			else {
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt";
		InputStream inFile = null;
		
		try {
			inFile = new FileInputStream(fileName);
			readAllByArray(inFile);
		} catch (IOException e) {
			System.out.print("Ошибка: " + e);
		} finally {
			if(inFile != null) {
				try {
					inFile.close();
				} catch (IOException ignore) {
					/*NOP*/
				}
			}	
		}
	}
}
