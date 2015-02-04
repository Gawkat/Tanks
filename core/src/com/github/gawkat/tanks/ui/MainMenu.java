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
public class MainMenu {

	public static Stage mainMenuStage;

	Label versionLabel;

	public void createMainMenu() {
		mainMenuStage = new Stage();
		Gdx.input.setInputProcessor(mainMenuStage);

		// Create version label
		versionLabel = new Label("Version 0.1a", Styles.bodyStyle);
		versionLabel.setX(5);
		versionLabel.setY(Gdx.graphics.getHeight() - 20);
		mainMenuStage.addActor(versionLabel);

		// Test
		Label titleLabel = new Label("This is a title", Styles.titleStyle);
		titleLabel.setX(10);
		titleLabel.setY(10);
		mainMenuStage.addActor(titleLabel);
		Label headingLabel = new Label("This is a heading", Styles.heading1Style);
		headingLabel.setX(10);
		headingLabel.setY(10 + titleLabel.getHeight());
		mainMenuStage.addActor(headingLabel);
		Label bodyLabel = new Label("This is a body", Styles.bodyStyle);
		bodyLabel.setX(10);
		bodyLabel.setY(10 + titleLabel.getHeight() + headingLabel.getHeight());
		mainMenuStage.addActor(bodyLabel);

		// Buttons
		TextButton playButton = new TextButton("Play",
				Styles.heading1ButtonStyle);
		playButton.setX(200);
		playButton.setY(300);
		playButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Play Pressed");
				if (LobbyMenu.lobbyMenuStage == null) {
					LobbyMenu.createLobbyMenu();
				}
				TanksGame.setCurrentGameState(GameState.LOBBY_MENU);
				Gdx.input.setInputProcessor(LobbyMenu.lobbyMenuStage);
			}
		});
		mainMenuStage.addActor(playButton);

		TextButton optionsButton = new TextButton("Options",
				Styles.heading1ButtonStyle);
		optionsButton.setX(200);
		optionsButton.setY(250);
		optionsButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if (OptionsMenu.optionsMenuStage == null) {
					OptionsMenu.createOptionsMenu();
				}
				TanksGame.setCurrentGameState(GameState.OPTIONS_MENU);
				Gdx.input.setInputProcessor(OptionsMenu.optionsMenuStage);
			}
		});
		mainMenuStage.addActor(optionsButton);

		TextButton exitButton = new TextButton("Exit",
				Styles.heading1ButtonStyle);
		exitButton.setX(200);
		exitButton.setY(200);
		exitButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
		mainMenuStage.addActor(exitButton);
	}

	public void renderMainMenu(Batch batch) {
		mainMenuStage.draw();
	}
}
