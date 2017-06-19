package de.inf16_17.spryt;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.inf16_17.spryt.screens.GameScreen;

public class SprytMain extends Game {
	
	public static Skin skin;
	public static SpriteBatch batch;
	public static Viewport view;
	public static float width, height;
	
	private static ArrayList<Player> players;
	private static ArrayList<Task> tasks;
	
	
	
	@Override
	public void create () {
		
		skin = new Skin(Gdx.files.internal("images-ui//skin.json"),
				new TextureAtlas(Gdx.files.internal("images-ui//uiskin.atlas")));
		batch = new SpriteBatch();
		view = new ScreenViewport();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		init();
		this.setScreen(new GameScreen(this));
	}

	private void init() {
		
//		// ArrayList initialisieren
//		players = new ArrayList<Player>();
//		// Spieler hinzufuegen
//		players.add(0, new Player("Nico Kestel", Gender.MALE, Sex.HETERO, true));
//		players.add(1, new Player("Malik Geiger", Gender.MALE, Sex.HETERO, true));
//		players.add(2, new Player("Matthias M�ller", Gender.MALE, Sex.HETERO, false));
//		
//		// Alle Spieler der Reihe nach ausgeben
//		for (int i = 0; i < players.size(); i++) {
//			Player player = players.get(i);
//			System.out.println(player.getName() + " " + player.getGender() + " " + player.getSex() + " " + player.isInRelationship());
//		}
		

		tasks = TaskHandler.readTasks("src/testTasks.txt");
		System.out.println(tasks.size());
		TaskHandler.filterTasks(tasks, 3, 3, 3, 3);
		System.out.println(tasks.size());
	}
	
	@Override
	public void render () {
		
		super.render();
	}
	
	@Override
	public void dispose () {

	}
	
	public ArrayList<Task> getTasks(){
		return tasks;
	}
}