package Task_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task_02 {

	public static void main(String[] args) throws IOException {
		DataOutputStream dOut = null;
		DataInputStream dIn = null; 
		
		try {
			File dir = new File("C:\\Labwork");
			dir.mkdir();
			
			dOut = new DataOutputStream(
						new FileOutputStream(dir.getAbsolutePath() + "\\input.txt"));
			
			dOut.writeUTF("It's the first line \n");
			dOut.writeUTF("It's the second line \n");
			dOut.writeDouble(3.145);
			dOut.writeDouble(5.56);
			dOut.writeDouble(-56.899);
			dOut.writeDouble(4.88);
			dOut.writeDouble(-1232.125);
			
			dOut.flush();
			dOut.close();
			
			dOut = new DataOutputStream(
					new FileOutputStream(dir.getAbsolutePath() + "\\output.txt"));
			
			dIn = new DataInputStream(
					new FileInputStream(dir.getAbsolutePath() + "\\input.txt"));
			
			int lineCount = 0;
			
			while(true) {
				lineCount++;
				if(lineCount < 2) {
					dIn.readUTF();
				}
				else {
					dOut.writeUTF(dIn.readUTF());
					break;
				}
			}
			
			int numCount = 0;
			double num = 0;
			
			while(true) {
				numCount++;
				if(numCount <= 5) {
					num = dIn.readDouble();
					if(num < 0) {
						dOut.writeDouble(num);
					}
				}
				else {
					break;
				}			
			}	
			
			dIn.close();
			dOut.flush();
			dOut.close();
			
			dIn = new DataInputStream(
					new FileInputStream(dir.getAbsolutePath() + "\\output.txt"));
			System.out.print(dIn.readUTF());
			try {
				while(true) {
					System.out.println(dIn.readDouble());
				}
			} catch(IOException e) {}
			
		} catch (IOException e) {
			System.out.println("Îøèáêà: " + e);
		}
		finally {
			dIn.close();
			dOut.flush();
			dOut.close();
		}

	}

}
