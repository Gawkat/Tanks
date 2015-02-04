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
import com.github.gawkat.tanks.util.Controls;
import com.github.gawkat.tanks.util.Styles;

/**
 * @author Gawkat
 *
 */
public class OptionsMenu {

	public static Stage optionsMenuStage;

	private static OptionsState currentOptionsState;

	public static void createOptionsMenu() {
		optionsMenuStage = new Stage();
		Gdx.input.setInputProcessor(optionsMenuStage);

		setOptionsState(OptionsState.MAIN_OPTIONS);

		// Labels
		Label optionsLabel = new Label("Options", Styles.titleStyle);
		optionsLabel.setX(200);
		optionsLabel.setY(350);
		optionsMenuStage.addActor(optionsLabel);

		// Buttons
		TextButton controlButton = new TextButton("Controls",
				Styles.heading1ButtonStyle);
		controlButton.setX(200);
		controlButton.setY(250);
		controlButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("pressed control options");
				if (ControlOptions.controlOptionsStage == null) {
					ControlOptions.createControlOptions();
				}
				setOptionsState(OptionsState.CONTROL_OPTIONS);
				Gdx.input.setInputProcessor(ControlOptions.controlOptionsStage);
			}
		});
		optionsMenuStage.addActor(controlButton);

		TextButton audioButton = new TextButton("Audio",
				Styles.heading1ButtonStyle);
		audioButton.setX(200);
		audioButton.setY(200);
		audioButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("pressed audio options");
				if (AudioOptions.audioOptionsStage == null) {
					AudioOptions.createAudioOptions();
				}
				setOptionsState(OptionsState.AUDIO_OPTIONS);
				Gdx.input.setInputProcessor(AudioOptions.audioOptionsStage);
			}
		});
		optionsMenuStage.addActor(audioButton);

		TextButton backButton = new TextButton("Back",
				Styles.heading1ButtonStyle);
		backButton.setX(200);
		backButton.setY(150);
		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				TanksGame.setCurrentGameState(GameState.MAIN_MENU);
				Gdx.input.setInputProcessor(MainMenu.mainMenuStage);
			}
		});
		optionsMenuStage.addActor(backButton);
	}

	public static void renderOptionsMenu(Batch batch) {
		switch (getCurrentOptionsState()) {
		case MAIN_OPTIONS:
			optionsMenuStage.draw();
			break;
		case AUDIO_OPTIONS:
			AudioOptions.renderAudioOptions();
			break;
		case CONTROL_OPTIONS:
			ControlOptions.renderControlOptions();
			break;
		}
	}

	private static class AudioOptions {

		private static Stage audioOptionsStage;

		private static void createAudioOptions() {
			audioOptionsStage = new Stage();
			Gdx.input.setInputProcessor(audioOptionsStage);

			setOptionsState(OptionsState.AUDIO_OPTIONS);

			// Labels
			Label audioLabel = new Label("Audio Options", Styles.titleStyle);
			audioLabel.setX(Gdx.graphics.getWidth() / 2 - audioLabel.getWidth()
					/ 2);
			audioLabel.setY(350);
			audioOptionsStage.addActor(audioLabel);

			// Buttons
			TextButton backButton = new TextButton("Back",
					Styles.heading1ButtonStyle);
			backButton.setX(200);
			backButton.setY(150);
			backButton.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					setOptionsState(OptionsState.MAIN_OPTIONS);
					Gdx.input.setInputProcessor(optionsMenuStage);
				}
			});
			audioOptionsStage.addActor(backButton);
		}

		private static void renderAudioOptions() {
			audioOptionsStage.draw();
		}
	}

	private static class ControlOptions {

		private static Stage controlOptionsStage;

		static Controls controls;

		private static void createControlOptions() {
			controlOptionsStage = new Stage();
			Gdx.input.setInputProcessor(controlOptionsStage);

			setOptionsState(OptionsState.CONTROL_OPTIONS);

			controls = new Controls();

			// Labels
			Label controlLabel = new Label("Controls", Styles.titleStyle);
			controlLabel.setX(Gdx.graphics.getWidth() / 2
					- controlLabel.getWidth() / 2);
			controlLabel.setY(Gdx.graphics.getHeight()
					- controlLabel.getHeight());
			controlOptionsStage.addActor(controlLabel);

			// Player 1
			Label player1Label = new Label("Player 1", Styles.heading1Style);
			player1Label.setX(Gdx.graphics.getWidth() / 4
					- player1Label.getWidth() / 2);
			player1Label.setY(controlLabel.getY() - player1Label.getHeight()
					- 20);
			controlOptionsStage.addActor(player1Label);

			TextButton p1F = new TextButton("Forward: " + controls.getP1F(),
					Styles.heading2ButtonStyle);
			p1F.setX(player1Label.getX());
			p1F.setY(player1Label.getY() - p1F.getHeight());
			p1F.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Forward pressed");
				}
			});
			controlOptionsStage.addActor(p1F);

			TextButton p1B = new TextButton("Backward: " + controls.getP1B(),
					Styles.heading2ButtonStyle);
			p1B.setX(player1Label.getX());
			p1B.setY(p1F.getY() - p1B.getHeight());
			p1B.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Backward pressed");
				}
			});
			controlOptionsStage.addActor(p1B);

			TextButton p1L = new TextButton("Left: " + controls.getP1L(),
					Styles.heading2ButtonStyle);
			p1L.setX(player1Label.getX());
			p1L.setY(p1B.getY() - p1F.getHeight());
			p1L.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Left pressed");
				}
			});
			controlOptionsStage.addActor(p1L);

			TextButton p1R = new TextButton("Right: " + controls.getP1R(),
					Styles.heading2ButtonStyle);
			p1R.setX(player1Label.getX());
			p1R.setY(p1L.getY() - p1F.getHeight());
			p1R.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Right pressed");
				}
			});
			controlOptionsStage.addActor(p1R);

			// Player 2
			Label player2Label = new Label("Player 2", Styles.heading1Style);
			player2Label.setX((Gdx.graphics.getWidth() / 4) * 3
					- player2Label.getWidth() / 2);
			player2Label.setY(controlLabel.getY() - player2Label.getHeight()
					- 20);
			controlOptionsStage.addActor(player2Label);

			Label player3Label = new Label("Player 3", Styles.heading1Style);
			player3Label.setX(Gdx.graphics.getWidth() / 4
					- player3Label.getWidth() / 2);
			player3Label.setY(p1R.getY() - player3Label.getHeight() - 30);
			controlOptionsStage.addActor(player3Label);

			Label player4Label = new Label("Player 4", Styles.heading1Style);
			player4Label.setX((Gdx.graphics.getWidth() / 4) * 3
					- player4Label.getWidth() / 2);
			player4Label.setY(controlLabel.getY() - player4Label.getHeight()
					- 400);
			controlOptionsStage.addActor(player4Label);

			// Buttons
			TextButton backButton = new TextButton("Back",
					Styles.heading1ButtonStyle);
			backButton.setX(10);
			backButton.setY(10);
			backButton.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					setOptionsState(OptionsState.MAIN_OPTIONS);
					Gdx.input.setInputProcessor(optionsMenuStage);
				}
			});
			controlOptionsStage.addActor(backButton);

		}

		private static void renderControlOptions() {
			controlOptionsStage.draw();
		}

	}

	private static void setOptionsState(OptionsState state) {
		currentOptionsState = state;
	}

	private static OptionsState getCurrentOptionsState() {
		return currentOptionsState;
	}

	private enum OptionsState {
		MAIN_OPTIONS, AUDIO_OPTIONS, CONTROL_OPTIONS
	}

}
