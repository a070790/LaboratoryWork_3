package Task_01.Example_01;

import java.io.File;

public class Example_01 {
	
	public static void main(String[] args) {
		try { 
		// Создание файла в текущей папке (где расположен файл Example_01.java)
			File f1 = new File("MyFile1.txt");
			f1.createNewFile(); 
			if (f1.exists()) {
				System.out.println("Файл Создан!!!!");
				System.out.println("Полный путь 1: "+ f1.getAbsolutePath());
			}
			
		// Создание нескольких вложенных папок
			File f2 = new File("C:\\Papka1\\Papka2\\Papka3"); 
			f2.mkdirs();
			if (f2.exists()) {
				System.out.println("Папка создана!!!!");
				System.out.println("Полный путь 2: "+ f2.getAbsolutePath());
			}
			
		// Создание файла на диске C и вывод полного пути 
			File f3 = new File("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt"); 
			f3.createNewFile();
			if (f3.exists()) {
				System.out.println("Файл MyFile2.txt в папке Papka3 создан!!!!");
				System.out.println("Полный путь 3: "+ f2.getAbsolutePath());
			}
		} catch (Exception e) { 
				System.out.println("Ошибка!!! "+e);
			}
	}
}
