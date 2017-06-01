package de.inf16_17.spryt.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import de.inf16_17.spryt.SprytMain;

public class GameScreen implements Screen {
	
	private final Game game;
	
	private Stage stage;
	private Table table;
	
	private Label task;
	
	private ImageButton next, back;
	
	private Texture background;
	
	
	public GameScreen(final Game game){
		this.game = game;
		
		stage = new Stage(SprytMain.view);
		Gdx.input.setInputProcessor(stage);
		
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		task = new Label("Ich bin eine sehr sehr sehr sehr sehr sehr sehr sehr sehr sehr sehr sehr lange Frage =D", SprytMain.skin);
		task.setWrap(true);
		task.setAlignment(0);
		task.setFontScale(4);
		task.setWidth(100);
		stage.addActor(task);
		
//		next = new ImageButton(SprytMain.skin);
//		back = new ImageButton(SprytMain.skin);
		
		background = new Texture("bin//badlogic.jpg");
		
		table.debug();
		
		table.center();
		table.add(task).width(SprytMain.width * 0.9f);
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
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SprytMain.batch.begin();
		draw(SprytMain.batch);
		SprytMain.batch.end();
		
		stage.act();
		stage.draw();
	}
	
	private void draw(SpriteBatch batch){
		batch.setColor(0.1f, 0.1f, 0.1f, 0.5f);
		batch.draw(background, 0, 0, SprytMain.width, SprytMain.height);
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
