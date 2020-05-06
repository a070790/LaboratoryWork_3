package Task_03;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Task_03 {

	public static void main(String[] args) throws IOException {
		char[] vowels = {'а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я',
				'А', 'О', 'И', 'Е', 'Ё', 'Э', 'Ы', 'У', 'Ю', 'Я'};
		BufferedReader br = null; 
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("verse.txt"),"cp1251"));
			
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream("resFile.txt"),"cp1251"));
			
			int lineCount = 0;
			int wordCount = 0;
			String verseLine;
			
			while ((verseLine = br.readLine()) != null) { 
				lineCount++; 
				String[] words = verseLine.split("[\\s,.!]+");
				
				for(String str: words) {
					if(str.length() > 1) {
						for(char ch: vowels) {
							if(str.charAt(0) != ch) {
								ch++;
							}
							else {
								wordCount++;
								bw.write("Cтрока " + lineCount + "-я, слово: " + str);
								bw.newLine();
								break;
							}
						}
					}
				}
				
				bw.write("Итого в строке " + lineCount + "-й выбрано слов: " + wordCount + "\n\n");
				wordCount = 0;
			}
			
			System.out.print("Программа успешно завершена!");
			
			
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
