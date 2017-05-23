package de.inf16_17.spryt.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameScreen implements Screen {
	
	private final Game game;
	
	private Skin skin;
	
	private Stage stage;
	private TextButton btn;
	
	public GameScreen(final Game game){
		this.game = game;
		
		skin = new Skin();
		skin.addRegions(new TextureAtlas("assets/images-ui/uiskin.atlas"));
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		btn = new TextButton("Ich bin ein TextButton!", skin);
		stage.addActor(btn);
		btn.addListener(new EventListener() {
			
			@Override
			public boolean handle(Event event) {
				Gdx.app.debug("", "CLICKED");
				return false;
			}
		});
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
		
		Gdx.gl.glClearColor(0.5f, 0.1f, 0.8f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
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
