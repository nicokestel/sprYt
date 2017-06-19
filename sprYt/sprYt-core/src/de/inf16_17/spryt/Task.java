package de.inf16_17.spryt;
public class Task {

	public static final int GAME_PARAMETER_MAX = 3;
	
	private String task, msg; // Task = Aufgabe , msg = Nachricht bei Ende
	private int consumption, physicalContact, activity, game, validity; // consuption, physicalContact, activity, game = Parameter fuer Frage , valadity = Gueltigkeit der Frage
	private boolean protection; // Beziehungsschutz
	
	
	public Task(String task, String msg, int consumption, int physicalContact,
			int activity, int game, int validity, boolean protection) {
		this.task = task;
		this.msg = msg;
		this.consumption = consumption;
		this.physicalContact = physicalContact;
		this.activity = activity;
		this.game = game;
		this.validity = validity;
		this.protection = protection;
	}
	
	
	public String getTask() {
		return task;
	}


	public String getMsg() {
		return msg;
	}


	public int getConsumption() {
		return consumption;
	}


	public int getPhysicalContact() {
		return physicalContact;
	}


	public int getActivity() {
		return activity;
	}


	public int getGame() {
		return game;
	}


	public int getValidity() {
		return validity;
	}


	public boolean isProtection() {
		return protection;
	}

	
	
}
