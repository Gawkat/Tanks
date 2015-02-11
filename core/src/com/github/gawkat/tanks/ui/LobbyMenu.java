package com.github.gawkat.tanks.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.github.gawkat.tanks.TanksGame;
import com.github.gawkat.tanks.TanksGame.GameState;
import com.github.gawkat.tanks.util.Styles;

/**
 * @author Gawkat
 *
 */
public class LobbyMenu {

	public static Stage lobbyMenuStage;

	public static void createLobbyMenu() {
		lobbyMenuStage = new Stage();
		Gdx.input.setInputProcessor(lobbyMenuStage);

		// test
		Label testLabel = new Label("Lobby", Styles.titleStyle);
		testLabel.setX(Gdx.graphics.getWidth() / 2 - testLabel.getWidth() / 2);
		testLabel.setY(Gdx.graphics.getHeight() - testLabel.getHeight());
		lobbyMenuStage.addActor(testLabel);

		// Buttons
		TextButton backButton = new TextButton("Back",
				Styles.heading1ButtonStyle);
		backButton.setX(200);
		backButton.setY(200);
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				TanksGame.setCurrentGameState(GameState.MAIN_MENU);
				Gdx.input.setInputProcessor(MainMenu.mainMenuStage);
			}
		});
		lobbyMenuStage.addActor(backButton);

		TextButton playButton = new TextButton("Play",
				Styles.heading1ButtonStyle);
		playButton.setX(Gdx.graphics.getWidth() - playButton.getWidth());
		playButton.setY(0);
		playButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				TanksGame.setCurrentGameState(GameState.INGAME);
				Gdx.input.setInputProcessor(TanksGame.input);
				TanksGame.loadGame("dm_testmap", 1.0f);
			}
		});
		lobbyMenuStage.addActor(playButton);
	}

	public static void renderLobbyMenu(Batch batch) {
		lobbyMenuStage.draw();
	}

}
