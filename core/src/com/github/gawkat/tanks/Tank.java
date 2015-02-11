package com.github.gawkat.tanks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.gawkat.tanks.util.Controls;

/**
 * @author Gawkat
 *
 */
public class Tank {

	private Texture tankTexture;

	private float x, y;

	private int player;

	private float tankSpeed = 1.0f;

	private Controls controls;

	public Tank(Color color, int player, float x, float y) {
		controls = new Controls();
		setX(x);
		setY(y);
		this.player = player;
		// TODO
		tankTexture = new Texture(Gdx.files.internal("textures/tank.bmp"));
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void render(SpriteBatch batch) {
		// TODO
		batch.draw(tankTexture, x, y);
	}

	public void getInput() {
		switch (player) {
		case 1:
			// TODO
			if (Gdx.input.isKeyPressed(controls.getP1F())) {
				setY(getY() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP1B())) {
				setY(getY() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP1L())) {
				setX(getX() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP1R())) {
				setX(getX() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP1S())) {
				System.out.println("BANG1");
			}
			break;
		case 2:
			// TODO
			if (Gdx.input.isKeyPressed(controls.getP2F())) {
				setY(getY() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP2B())) {
				setY(getY() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP2L())) {
				setX(getX() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP2R())) {
				setX(getX() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP2S())) {
				System.out.println("BANG2");
			}
			break;
		case 3:
			// TODO
			if (Gdx.input.isKeyPressed(controls.getP3F())) {
				setY(getY() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP3B())) {
				setY(getY() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP3L())) {
				setX(getX() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP3R())) {
				setX(getX() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP3S())) {
				System.out.println("BANG3");
			}
			break;
		case 4:
			// TODO
			if (Gdx.input.isKeyPressed(controls.getP4F())) {
				setY(getY() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP4B())) {
				setY(getY() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP4L())) {
				setX(getX() - tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP4R())) {
				setX(getX() + tankSpeed);
			}
			if (Gdx.input.isKeyPressed(controls.getP4S())) {
				System.out.println("BANG4");
			}
			break;
		default:
			break;
		}
	}
}
