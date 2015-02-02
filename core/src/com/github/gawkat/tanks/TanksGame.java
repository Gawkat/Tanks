package com.github.gawkat.tanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class TanksGame extends ApplicationAdapter {
	SpriteBatch batch;

	BitmapFont font12;

	Music backgroundMusic;

	@Override
	public void create() {
		batch = new SpriteBatch();

		// Text Test
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal("font.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		font12 = generator.generateFont(parameter); // font size 12
													// pixels
		font12.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose(); // don't forget to dispose to avoid memory leaks!

		// Background music
		backgroundMusic = Gdx.audio
				.newMusic(Gdx.files.internal("deadmau5.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		font12.draw(batch, "Version 0.1a", 10, Gdx.graphics.getHeight() - 10);

		batch.end();
	}
}
