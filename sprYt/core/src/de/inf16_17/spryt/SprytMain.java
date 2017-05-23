package de.inf16_17.spryt;

import java.util.ArrayList;

import com.badlogic.gdx.Game;

public class SprytMain extends Game {
	
	private ArrayList<Player> players;
	
	@Override
	public void create () {
//		this.setScreen(new GameScreen(this));
		init();
	}

	private void init() {
		
		// ArrayList initialisieren
		players = new ArrayList<Player>();
		// Spieler hinzufuegen
		players.add(0, new Player("Nico Kestel", Gender.MALE, Sex.HETERO, true));
		players.add(1, new Player("Malik Geiger", Gender.MALE, Sex.HETERO, true));
		players.add(2, new Player("Matthias Müller", Gender.MALE, Sex.HETERO, false));
		
		// Alle Spieler der Reihe nach ausgeben
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			System.out.println(player.getName() + " " + player.getGender() + " " + player.getSex() + " " + player.isInRelationship());
		}
	}
	
	@Override
	public void render () {
		
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}