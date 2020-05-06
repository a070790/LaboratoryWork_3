package Task_01.Example_01;

import java.io.File;

public class Example_01 {
	
	public static void main(String[] args) {
		try { 
		// �������� ����� � ������� ����� (��� ���������� ���� Example_01.java)
			File f1 = new File("MyFile1.txt");
			f1.createNewFile(); 
			if (f1.exists()) {
				System.out.println("���� ������!!!!");
				System.out.println("������ ���� 1: "+ f1.getAbsolutePath());
			}
			
		// �������� ���������� ��������� �����
			File f2 = new File("C:\\Papka1\\Papka2\\Papka3"); 
			f2.mkdirs();
			if (f2.exists()) {
				System.out.println("����� �������!!!!");
				System.out.println("������ ���� 2: "+ f2.getAbsolutePath());
			}
			
		// �������� ����� �� ����� C � ����� ������� ���� 
			File f3 = new File("C:\\Papka1\\Papka2\\Papka3\\MyFile2.txt"); 
			f3.createNewFile();
			if (f3.exists()) {
				System.out.println("���� MyFile2.txt � ����� Papka3 ������!!!!");
				System.out.println("������ ���� 3: "+ f2.getAbsolutePath());
			}
		} catch (Exception e) { 
				System.out.println("������!!! "+e);
			}
	}
}
