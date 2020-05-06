package Task_01.Example_05;

import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example_05 {

	public static void main(String[] args) {
		DataOutputStream dOut = null;
		DataInputStream dIn = null;
		
		Scanner sc = new Scanner(System.in); 
		System.out.print("Введите имя файла => "); 
		String fname = sc.nextLine();
		
		try {
			File f1 = new File(fname); 
			f1.createNewFile();
			System.out.println("Полный путь файла: "+ f1.getAbsolutePath());
		
			System.out.print("Введите количество строк для записи в файл => ");
			int n = sc.nextInt();
		
			dOut = new DataOutputStream(new FileOutputStream(f1));
			sc.nextLine();
		
			for (int i = 0; i < n; i++) {
				System.out.print("Введите строку для записи в файл => "); 
				String s = sc.nextLine();
				dOut.writeUTF(s);
				System.out.println(); 
			}
		
			dOut.flush();
			dOut.close();
			
			dIn = new DataInputStream(new FileInputStream(f1));
			while(true) {
				System.out.println(dIn.readUTF());
			}
			
		} catch(Exception e1) {
			System.out.println("" + e1);
		} finally {
			if(dIn != null) {
				try {
					dIn.close();
				} catch (IOException e2) {
					System.out.println("" + e2);
				}
			}
		}
	}
}
