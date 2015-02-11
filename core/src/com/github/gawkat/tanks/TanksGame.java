package com.github.gawkat.tanks;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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

	static TiledMap map;
	static OrthogonalTiledMapRenderer renderer;
	static OrthographicCamera camera;

	static ArrayList<Tank> tanks = new ArrayList<Tank>();

	public static Input input = new Input();

	@Override
	public void create() {
		batch = new SpriteBatch();

		// Set game state
		setCurrentGameState(GameState.MAIN_MENU);

		// Load fonts
		fontLoader = new FontLoader();
		fontLoader.loadFonts();

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
			updateGame();
			renderGame();
			break;
		}

		batch.end();
	}

	private void updateGame() {
		// TODO update
		for (Tank t : tanks) {
			t.getInput();
		}
	}

	private void renderGame() {
		camera.update();
		renderer.setView(camera);
		// renderer.render();

		// TODO render
		for (Tank t : tanks) {
			t.render(batch);
		}
	}

	public static void loadGame(String mapName, float scale) {
		map = new TmxMapLoader().load("maps/" + mapName + ".tmx");
		loadTanks();
		renderer = new OrthogonalTiledMapRenderer(map, 1);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, scale * 800, scale * 600);
		camera.update();
	}

	private static void loadTanks() {
		// Tank testTank = new Tank(Color.BLUE, 1, 50, 50);
		// tanks.add(testTank);
		// Test
		for (int i = 0; i < 4; i++) {
			tanks.add(new Tank(Color.BLUE, i, 400, 300));
		}
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
