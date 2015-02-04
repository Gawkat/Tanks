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
		Fonts.bodyFont = generator.generateFont(parameter);
		Fonts.bodyFont.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}

	public void loadTitleFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(TanksGame.fontName));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 54;
		Fonts.titleFont = generator.generateFont(parameter);
		Fonts.titleFont.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}

	public void loadHeading1Font() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(TanksGame.fontName));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 42;
		Fonts.heading1Font = generator.generateFont(parameter);
		Fonts.heading1Font.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}
	
	public void loadHeading2Font() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(TanksGame.fontName));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 32;
		Fonts.heading2Font = generator.generateFont(parameter);
		Fonts.heading2Font.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose();
	}

}
