package de.inf16_17.spryt;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class SprytMain extends Game {
	
	SpriteBatch batch;
	Sprite img;
	
	float rot;
	
	Color color;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		img = new Sprite(new Texture("badlogic.jpg"));
		img.setOrigin(img.getWidth() / 2, img.getHeight() / 2);
		img.setPosition(Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
		color = new Color(1, 1, 1, 1);
	}

	@Override
	public void render () {
		
		update(Gdx.graphics.getDeltaTime());
		
		Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		img.draw(batch);
		batch.end();
	}
	
	private void update(float deltaTime) {
		
		if (Gdx.input.justTouched()) {
			img.setPosition(Gdx.input.getX() - img.getWidth() / 2, -Gdx.input.getY() + Gdx.graphics.getHeight() -  img.getHeight() / 2);
			System.out.println(Gdx.input.getX() + " : " + Gdx.input.getY());
			color.r = MathUtils.random();
			color.g = MathUtils.random();
			color.b = MathUtils.random();
			color.a = MathUtils.random();
		}else if (Gdx.input.isTouched()) {
			img.setPosition(Gdx.input.getX() - img.getWidth() / 2, -Gdx.input.getY() + Gdx.graphics.getHeight() -  img.getHeight() / 2);
			float degreesPerSecond = 50.0f;
			rot = (rot + Gdx.graphics.getDeltaTime() * degreesPerSecond) % 360;
			float shakeAmplitudeInDegrees = 10.0f;
			float shake = MathUtils.sin(rot) * shakeAmplitudeInDegrees;
			img.setRotation(shake);
			Gdx.input.vibrate(10);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
