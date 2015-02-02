package com.github.gawkat.tanks.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.gawkat.tanks.TanksGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Tanks";
		config.width = 800;
		config.height = 600;
		config.resizable = false;

		new LwjglApplication(new TanksGame(), config);
	}
}
