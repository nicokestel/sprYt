package de.inf16_17.spryt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskReader {
	
	// Loeschen!!!!
	public static void main(String[] args) {
		ArrayList<Task> tasks = readTasks("src/testTask.txt");
		for (Task task : tasks)
			task.print();
	}
	
	/**
	 * Liest alle Aufgaben aus einer TXT-Datei ein
	 * @param path Pfad zur TXT-Datei
	 * @return Liste mit allen eingelesenen Aufgaben
	 */
	public static ArrayList<Task> readTasks(String path){
		ArrayList<Task> tasks = new ArrayList<Task>();
		try {
			Scanner fileScanner = new Scanner(new File(path)); // Liest die Datei Zeile fuer Zeile ein
			while(fileScanner.hasNext()){
				String line = fileScanner.nextLine();
				
				StringReader stringReader = new StringReader(line); // Liest Aufgabe und Message ein
				Scanner parameterScanner = new Scanner(line); // Liest Parameter ein
				
				int startIndex = 1, endIndex = 1;
				stringReader.read();
				while(stringReader.read() != '"'){
					endIndex++;
				}
				// Aufgabe
				String taskText = line.substring(startIndex, endIndex);
				
				startIndex = endIndex + 3;
				endIndex = startIndex;
				stringReader.read();
				stringReader.read();
				while(stringReader.read() != '"'){
					endIndex++;
				}
				// Message
				String msg = line.substring(startIndex, endIndex);
				
				// Aufgabe und Message ueberspringen; Springen zu Parameter
				parameterScanner.skip("\"" + taskText + "\" \"" + msg + "\"");
				
				// Parameter
				int consumption = parameterScanner.nextInt();
				int physicalContact = parameterScanner.nextInt();
				int activity = parameterScanner.nextInt();
				int game = parameterScanner.nextInt();
				int validity = parameterScanner.nextInt();
				boolean protection = parameterScanner.nextInt() == 1;
				
				Task task = new Task(taskText, msg, consumption, physicalContact, activity, game, validity, protection);
				tasks.add(task);
				
				parameterScanner.close();
				stringReader.close();
			}
			
			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tasks;
	}
}
