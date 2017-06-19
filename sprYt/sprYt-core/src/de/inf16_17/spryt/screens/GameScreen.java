package de.inf16_17.spryt.screens;

import java.util.ArrayList;
import java.util.Random;

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
import de.inf16_17.spryt.Task;

public class GameScreen implements Screen {
	
	private final Game game;
	
	private Stage stage;
	private Table table;
	
	private Label task;
	
	private ImageButton next, back;
	
	private Texture background;
	
	private Random random;
	
	
	public GameScreen(final Game game){
		this.game = game;
		
		stage = new Stage(SprytMain.view);
		Gdx.input.setInputProcessor(stage);
		
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		task = new Label("Ich bin eine Frage =D", SprytMain.skin);
		task.setWrap(true);
		task.setAlignment(0);
		task.setFontScale(4);
		task.setWidth(100);
		stage.addActor(task);
		
//		next = new ImageButton(SprytMain.skin);
//		back = new ImageButton(SprytMain.skin);
		
		background = new Texture("bin//badlogic.jpg");
		
		random = new Random();
		
		
		setTask();
		
		
		table.debug();
		
		table.center();
		table.add(task).width(SprytMain.width * 0.9f);
	}
	
	
	private void update(float delta){
		if(Gdx.input.justTouched()){
			setTask();
		}
	}
	
	private void setTask(){
		ArrayList<Task> tasks = ((SprytMain) game).getTasks();
		if(tasks.size() == 0){
			
			//TODO Spiel beenden !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		
		int index = random.nextInt(tasks.size());
		Task t = tasks.get(index);
		task.setText(t.getTask());
		tasks.remove(index);
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
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		update(delta);
		stage.act();
		
		SprytMain.batch.begin();
		draw(SprytMain.batch);
		SprytMain.batch.end();
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
