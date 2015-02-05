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
			audioLabel.setY(Gdx.graphics.getHeight() - audioLabel.getHeight());
			audioOptionsStage.addActor(audioLabel);

			// Master volume
			Label masterAudioLabel = new Label("Master volume",
					Styles.heading1Style);
			masterAudioLabel.setX(audioLabel.getX());
			masterAudioLabel.setY(audioLabel.getY()
					- masterAudioLabel.getHeight() - 10);
			audioOptionsStage.addActor(masterAudioLabel);

			Label soundAudioLabel = new Label("Sound volume",
					Styles.heading1Style);
			soundAudioLabel.setX(audioLabel.getX());
			soundAudioLabel.setY(masterAudioLabel.getY()
					- soundAudioLabel.getHeight());
			audioOptionsStage.addActor(soundAudioLabel);

			Label musicAudioLabel = new Label("Music volume",
					Styles.heading1Style);
			musicAudioLabel.setX(audioLabel.getX());
			musicAudioLabel.setY(soundAudioLabel.getY()
					- musicAudioLabel.getHeight());
			audioOptionsStage.addActor(musicAudioLabel);

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
			p1F.setY(player1Label.getY() - p1F.getHeight() - 10);
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
			p1L.setY(p1B.getY() - p1L.getHeight());
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
			p1R.setY(p1L.getY() - p1R.getHeight());
			p1R.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Right pressed");
				}
			});
			controlOptionsStage.addActor(p1R);

			TextButton p1S = new TextButton("Shoot: " + controls.getP1S(),
					Styles.heading2ButtonStyle);
			p1S.setX(player1Label.getX());
			p1S.setY(p1R.getY() - p1S.getHeight());
			p1S.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Shoot pressed");
				}
			});
			controlOptionsStage.addActor(p1S);

			// Player 2
			Label player2Label = new Label("Player 2", Styles.heading1Style);
			player2Label.setX((Gdx.graphics.getWidth() / 4) * 3
					- player2Label.getWidth() / 2);
			player2Label.setY(controlLabel.getY() - player2Label.getHeight()
					- 20);
			controlOptionsStage.addActor(player2Label);

			TextButton p2F = new TextButton("Forward: " + controls.getP2F(),
					Styles.heading2ButtonStyle);
			p2F.setX(player2Label.getX());
			p2F.setY(player2Label.getY() - p2F.getHeight() - 10);
			p2F.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Forward pressed");
				}
			});
			controlOptionsStage.addActor(p2F);

			TextButton p2B = new TextButton("Backward: " + controls.getP2B(),
					Styles.heading2ButtonStyle);
			p2B.setX(player2Label.getX());
			p2B.setY(p2F.getY() - p2B.getHeight());
			p2B.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Backward pressed");
				}
			});
			controlOptionsStage.addActor(p2B);

			TextButton p2L = new TextButton("Left: " + controls.getP2L(),
					Styles.heading2ButtonStyle);
			p2L.setX(player2Label.getX());
			p2L.setY(p2B.getY() - p2L.getHeight());
			p2L.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Left pressed");
				}
			});
			controlOptionsStage.addActor(p2L);

			TextButton p2R = new TextButton("Right: " + controls.getP2R(),
					Styles.heading2ButtonStyle);
			p2R.setX(player2Label.getX());
			p2R.setY(p2L.getY() - p2R.getHeight());
			p2R.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Right pressed");
				}
			});
			controlOptionsStage.addActor(p2R);

			TextButton p2S = new TextButton("Shoot: " + controls.getP2S(),
					Styles.heading2ButtonStyle);
			p2S.setX(player2Label.getX());
			p2S.setY(p2R.getY() - p2S.getHeight());
			p2S.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Shoot pressed");
				}
			});
			controlOptionsStage.addActor(p2S);

			// Player 3
			Label player3Label = new Label("Player 3", Styles.heading1Style);
			player3Label.setX(Gdx.graphics.getWidth() / 4
					- player3Label.getWidth() / 2);
			player3Label.setY(p1S.getY() - player3Label.getHeight() - 30);
			controlOptionsStage.addActor(player3Label);

			TextButton p3F = new TextButton("Forward: " + controls.getP3F(),
					Styles.heading2ButtonStyle);
			p3F.setX(player3Label.getX());
			p3F.setY(player3Label.getY() - p3F.getHeight() - 10);
			p3F.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Forward pressed");
				}
			});
			controlOptionsStage.addActor(p3F);

			TextButton p3B = new TextButton("Backward: " + controls.getP3B(),
					Styles.heading2ButtonStyle);
			p3B.setX(player3Label.getX());
			p3B.setY(p3F.getY() - p3B.getHeight());
			p3B.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Backward pressed");
				}
			});
			controlOptionsStage.addActor(p3B);

			TextButton p3L = new TextButton("Left: " + controls.getP3L(),
					Styles.heading2ButtonStyle);
			p3L.setX(player3Label.getX());
			p3L.setY(p3B.getY() - p3L.getHeight());
			p3L.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Left pressed");
				}
			});
			controlOptionsStage.addActor(p3L);

			TextButton p3R = new TextButton("Right: " + controls.getP3R(),
					Styles.heading2ButtonStyle);
			p3R.setX(player3Label.getX());
			p3R.setY(p3L.getY() - p3R.getHeight());
			p3R.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Right pressed");
				}
			});
			controlOptionsStage.addActor(p3R);

			TextButton p3S = new TextButton("Shoot: " + controls.getP3S(),
					Styles.heading2ButtonStyle);
			p3S.setX(player3Label.getX());
			p3S.setY(p3R.getY() - p3S.getHeight());
			p3S.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Shoot pressed");
				}
			});
			controlOptionsStage.addActor(p3S);

			// Player 4
			Label player4Label = new Label("Player 4", Styles.heading1Style);
			player4Label.setX((Gdx.graphics.getWidth() / 4) * 3
					- player4Label.getWidth() / 2);
			player4Label.setY(p2S.getY() - player4Label.getHeight() - 30);
			controlOptionsStage.addActor(player4Label);

			TextButton p4F = new TextButton("Forward: " + controls.getP4F(),
					Styles.heading2ButtonStyle);
			p4F.setX(player4Label.getX());
			p4F.setY(player4Label.getY() - p4F.getHeight() - 10);
			p4F.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Forward pressed");
				}
			});
			controlOptionsStage.addActor(p4F);

			TextButton p4B = new TextButton("Backward: " + controls.getP4B(),
					Styles.heading2ButtonStyle);
			p4B.setX(player4Label.getX());
			p4B.setY(p4F.getY() - p4B.getHeight());
			p4B.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Backward pressed");
				}
			});
			controlOptionsStage.addActor(p4B);

			TextButton p4L = new TextButton("Left: " + controls.getP4L(),
					Styles.heading2ButtonStyle);
			p4L.setX(player4Label.getX());
			p4L.setY(p4B.getY() - p4L.getHeight());
			p4L.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Left pressed");
				}
			});
			controlOptionsStage.addActor(p4L);

			TextButton p4R = new TextButton("Right: " + controls.getP4R(),
					Styles.heading2ButtonStyle);
			p4R.setX(player4Label.getX());
			p4R.setY(p4L.getY() - p4R.getHeight());
			p4R.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Right pressed");
				}
			});
			controlOptionsStage.addActor(p4R);

			TextButton p4S = new TextButton("Shoot: " + controls.getP4S(),
					Styles.heading2ButtonStyle);
			p4S.setX(player4Label.getX());
			p4S.setY(p4R.getY() - p4S.getHeight());
			p4S.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					// TODO Auto-generated method stub
					System.out.println("Shoot pressed");
				}
			});
			controlOptionsStage.addActor(p4S);

			// Buttons
			TextButton backButton = new TextButton("Back",
					Styles.heading1ButtonStyle);
			backButton.setX(10);
			backButton.setY(0);
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
