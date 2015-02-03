package com.github.gawkat.tanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.github.gawkat.tanks.util.FontLoader;

public class TanksGame extends ApplicationAdapter {

	SpriteBatch batch;

	Stage mainMenuStage;

	Label versionLabel;

	FontLoader fontLoader;

	public static BitmapFont bodyFont, titleFont, headingFont;

	public static String fontName = "visitor.ttf";

	Music backgroundMusic;

	private static GameState currentGameState;

	@Override
	public void create() {
		batch = new SpriteBatch();

		// Set game state
		setCurrentGameState(GameState.MAIN_MENU);

		// load fonts
		fontLoader = new FontLoader();
		fontLoader.loadBodyFont();
		fontLoader.loadTitleFont();
		fontLoader.loadHeadingFont();

		// Create version label
		LabelStyle versionStyle = new LabelStyle();
		versionStyle.font = bodyFont;
		versionLabel = new Label("Version 0.1a", versionStyle);
		versionLabel.setX(5);
		versionLabel.setY(Gdx.graphics.getHeight() - 20);

		// Background music
		backgroundMusic = Gdx.audio.newMusic(Gdx.files
				.internal("music/deadmau5.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.setVolume(0.1f);
		backgroundMusic.play();

		createMainMenu();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		switch (getCurrentGameState()) {
		case MAIN_MENU:
			// TODO
			renderMainMenu();
			break;
		case OPTIONS_MENU:
			// TODO
			renderOptionsMenu();
			break;
		case LOBBY_MENU:
			// TODO
			renderLobbyMenu();
			break;
		case INGAME:
			// TODO
			renderGame();
			break;
		}

		batch.end();
	}

	private void renderMainMenu() {
		mainMenuStage.draw();
	}

	private void renderOptionsMenu() {

	}

	private void renderLobbyMenu() {

	}

	private void renderGame() {

	}

	public static GameState getCurrentGameState() {
		return currentGameState;

	}

	private void createMainMenu() {
		mainMenuStage = new Stage();
		Gdx.input.setInputProcessor(mainMenuStage);

		TextButtonStyle buttonStyle = new TextButtonStyle();
		buttonStyle.font = headingFont;

		TextButton playButton = new TextButton("Play", buttonStyle);
		playButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Play Pressed");
				setCurrentGameState(GameState.LOBBY_MENU);
			}
		});

		mainMenuStage.addActor(playButton);
		mainMenuStage.addActor(versionLabel);
	}

	private static void setCurrentGameState(GameState newGameState) {
		currentGameState = newGameState;
	}

	public enum GameState {
		MAIN_MENU, OPTIONS_MENU, INGAME, LOBBY_MENU
	}

}
