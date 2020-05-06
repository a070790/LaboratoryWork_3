package Task_01.Example_04;

import java.util.Scanner; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

public class Example_04 {
	
	public static void main(String[] args) {
		try {
			// создание исходного файла numIsh.txt
			File dir = new File("C:\\Papka1\\LabExample04");
			dir.mkdir();
			File file = new File("C:\\Papka1\\LabExample04\\numIsh.txt");
			file.createNewFile();
			
			Scanner sc = new Scanner(System.in);
			
			DataOutputStream wr = 
					new DataOutputStream(new FileOutputStream(file.getAbsolutePath()));
			
			System.out.println("Сколько вещественных чисел записать в файл?");
			int count = sc.nextInt();	
			
			System.out.println("Введите числа:");
			for (int i = 0; i < count; i++) {
				wr.writeFloat(sc.nextFloat());
			}
			wr.flush();
			wr.close();
			
			// Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
			File file2 = new File("C:\\Papka1\\LabExample04\\numRez.txt");
			file2.createNewFile();
			
			DataInputStream rd = 
					new DataInputStream(new FileInputStream(file.getAbsoluteFile()));
			
			wr = new DataOutputStream(new FileOutputStream(file2.getAbsoluteFile()));
			
			try {
				while(true) {
					float number = rd.readFloat();
					wr.writeFloat(number);
					System.out.println("Число " + (float)number);
				}
			} catch (EOFException e) {}

			wr.flush();
			wr.close();	
			rd.close();
		} catch (IOException e) {
			System.out.println("End of file");
		}
	}

}
