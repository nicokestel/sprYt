package de.inf16_17.spryt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class TaskHandler {
	
	/**
	 * Liest alle Aufgaben aus einer TXT-Datei ein
	 * @param path Pfad zur TXT-Datei
	 * @return Liste mit allen eingelesenen Aufgaben
	 */
	public static ArrayList<Task> readTasks(String path){
		ArrayList<Task> tasks = new ArrayList<Task>();
		try {
			Scanner fileScanner = new Scanner(new File(path)/*Gdx.files.internal(path).file()*/); // Liest die Datei Zeile fuer Zeile ein
			while(fileScanner.hasNext()){
				String line = fileScanner.nextLine();
				System.out.println(line);
				
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
			Gdx.app.exit();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tasks;
	}
	
	/**
	 * Filtert alle eingelesenen Tasks je nach Game-Settings.
	 * Alle Fragen, die mindestens einen Parameter haben, der das angegebene Maximum uebertrifft,
	 * werden nacheinander von den "brauchbaren" Tasks entfernt.
	 * @param tasks Liste aller eingelesenen Tasks
	 * @param consumption Hoechster erwuenschter Wert an "Konsum"
	 * @param physicalContact Hoechster erwuenschter Wert an "Koerperkontakt"
	 * @param activity Hoechster erwuenschter Wert an "Aktivitaet"
	 * @param game Hoechster erwuenschter Wert an "Spiel"
	 */
	public static void filterTasks(ArrayList<Task> tasks, int consumption, int physicalContact, int activity, int game){
		// Filtervorgang wird nur ausgefuehrt, falls das erwuenschte Maximum
		// nicht dem maximalen Wert des jeweiligen Parameters entspricht. (Spart Rechenleistung und Laufzeit)
		if(consumption != Task.GAME_PARAMETER_MAX) filterConsumption(tasks, consumption);
		if(physicalContact != Task.GAME_PARAMETER_MAX) filterPhysicalContact(tasks, physicalContact);
		if(activity != Task.GAME_PARAMETER_MAX) filterActivity(tasks, activity);
		if(game != Task.GAME_PARAMETER_MAX) filterGame(tasks, game);
	}
	
	/**
	 * Filtert die uebergebenen Tasks nach "Konsum"-Wert.
	 * @param tasks uebergebene Tasks
	 * @param value hoechster erwuenschter Wert
	 */
	private static void filterConsumption(ArrayList<Task> tasks, int value){
		for(int i = 0; i < tasks.size(); i++){
			if(tasks.get(i).getConsumption() > value){
				tasks.remove(i);
				i--;
			}
		}
	}

	/**
	 * Filtert die uebergebenen Tasks nach "Koerperkontakt"-Wert.
	 * @param tasks uebergebene Tasks
	 * @param value hoechster erwuenschter Wert
	 */
	private static void filterPhysicalContact(ArrayList<Task> tasks, int value){
		for(int i = 0; i < tasks.size(); i++){
			if(tasks.get(i).getPhysicalContact() > value){
				tasks.remove(i);
				i--;
			}
		}
	}

	/**
	 * Filtert die uebergebenen Tasks nach "Aktivitaet"-Wert.
	 * @param tasks uebergebene Tasks
	 * @param value hoechster erwuenschter Wert
	 */
	private static void filterActivity(ArrayList<Task> tasks, int value){
		for(int i = 0; i < tasks.size(); i++){
			if(tasks.get(i).getActivity() > value){
				tasks.remove(i);
				i--;
			}
		}
	}

	/**
	 * Filtert die uebergebenen Tasks nach "Spiel"-Wert.
	 * @param tasks uebergebene Tasks
	 * @param value hoechster erwuenschter Wert
	 */
	private static void filterGame(ArrayList<Task> tasks, int value){
		for(int i = 0; i < tasks.size(); i++){
			if(tasks.get(i).getGame() > value){
				tasks.remove(i);
				i--;
			}
		}
	}
}
