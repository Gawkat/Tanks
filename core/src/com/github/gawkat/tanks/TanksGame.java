package com.github.gawkat.tanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.gawkat.tanks.ui.LobbyMenu;
import com.github.gawkat.tanks.ui.MainMenu;
import com.github.gawkat.tanks.ui.OptionsMenu;
import com.github.gawkat.tanks.util.FontLoader;
import com.github.gawkat.tanks.util.Styles;

public class TanksGame extends ApplicationAdapter {

	SpriteBatch batch;

	FontLoader fontLoader;

	public static String fontName = "visitor.ttf";

	Music backgroundMusic;

	private static GameState currentGameState;

	MainMenu mainMenu = new MainMenu();

	@Override
	public void create() {
		batch = new SpriteBatch();

		// Set game state
		setCurrentGameState(GameState.MAIN_MENU);

		// Load fonts
		fontLoader = new FontLoader();
		fontLoader.loadBodyFont();
		fontLoader.loadTitleFont();
		fontLoader.loadHeading1Font();
		fontLoader.loadHeading2Font();

		// Load styles
		Styles.createStyles();

		// Background music
		backgroundMusic = Gdx.audio.newMusic(Gdx.files
				.internal("music/deadmau5.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.setVolume(0.1f);
		backgroundMusic.play();

		mainMenu.createMainMenu();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		switch (getCurrentGameState()) {
		case MAIN_MENU:
			mainMenu.renderMainMenu(batch);
			break;
		case OPTIONS_MENU:
			OptionsMenu.renderOptionsMenu(batch);
			break;
		case LOBBY_MENU:
			LobbyMenu.renderLobbyMenu(batch);
			break;
		case INGAME:
			// TODO
			renderGame();
			break;
		}

		batch.end();
	}

	private void renderGame() {

	}

	public static GameState getCurrentGameState() {
		return currentGameState;

	}

	public static void setCurrentGameState(GameState newGameState) {
		currentGameState = newGameState;
	}

	public enum GameState {
		MAIN_MENU, OPTIONS_MENU, INGAME, LOBBY_MENU
	}

}
