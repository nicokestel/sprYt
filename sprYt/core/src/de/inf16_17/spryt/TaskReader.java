package de.inf16_17.spryt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TaskReader {
	
	// Liest die Aufgaben aus einer Datei ein
	public static List<Task> readTasks(String path){
		List<Task> tasks = new ArrayList<Task>();
		
		try {
			Scanner s = new Scanner(new File(path));
			
			while(s.hasNext()){
				String line = s.nextLine();
				
				Scanner scanner = new Scanner(line);
				StringReader reader = new StringReader(line);
				
				int startIndex = 1, endIndex = 1;
				reader.read();
				while(reader.read() != '"'){
					endIndex++;
				}
				String taskText = line.substring(startIndex, endIndex);
				
				startIndex = endIndex + 3;
				endIndex = startIndex;
				reader.read();
				reader.read();
				while(reader.read() != '"'){
					endIndex++;
				}
				String msg = line.substring(startIndex, endIndex);
				
				scanner.skip("\"" + taskText + "\" \"" + msg + "\"");
				
				int consumption = scanner.nextInt();
				int physicalContact = scanner.nextInt();
				int activity = scanner.nextInt();
				int game = scanner.nextInt();
				int validity = scanner.nextInt();
				boolean protection = scanner.nextInt() == 1;
				
				Task task = new Task(taskText, msg, consumption, physicalContact, activity, game, validity, protection);
				tasks.add(task);
				
				scanner.close();
				reader.close();
			}
			
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tasks;
	}
}
