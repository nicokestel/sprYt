package de.inf16_17.spryt.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen {
	
	private final Game game;
	
	private Stage stage;
	
	
	public GameScreen(final Game game){
		this.game = game;
		
		
	}
	
	
	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void render(float arg0) {
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void show() {
		
	}
	
}
