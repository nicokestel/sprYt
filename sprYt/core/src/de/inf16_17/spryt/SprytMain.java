package de.inf16_17.spryt;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class SprytMain extends Game {
	
	SpriteBatch batch;
	Sprite img;
	
	float rot;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		img = new Sprite(new Texture("badlogic.jpg"));
		img.setOrigin(img.getWidth() / 2, img.getHeight() / 2);
		img.setPosition(Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(1 - img.getRotation() / 30, 1, img.getRotation() / 30, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		img.draw(batch);
		batch.end();
		
		float degreesPerSecond = 10.0f;
		rot = (rot + Gdx.graphics.getDeltaTime() * degreesPerSecond) % 360;
		
		float shakeAmplitudeInDegrees = 30.0f;
		float shake = MathUtils.sin(rot) * shakeAmplitudeInDegrees;
		
		img.setRotation(shake);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
