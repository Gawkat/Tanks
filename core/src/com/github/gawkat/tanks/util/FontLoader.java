package com.github.gawkat.tanks.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.github.gawkat.tanks.TanksGame;

/**
 * @author Gawkat
 *
 */
public class FontLoader {

	public void loadBodyFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(TanksGame.fontName));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 20;
		TanksGame.bodyFont = generator.generateFont(parameter);
		TanksGame.bodyFont.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}

	public void loadTitleFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(TanksGame.fontName));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 54;
		TanksGame.titleFont = generator.generateFont(parameter);
		TanksGame.titleFont.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}

	public void loadHeadingFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(TanksGame.fontName));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 42;
		TanksGame.headingFont = generator.generateFont(parameter);
		TanksGame.headingFont.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}

}
