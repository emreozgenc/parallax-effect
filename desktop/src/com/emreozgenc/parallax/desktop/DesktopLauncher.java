package com.emreozgenc.parallax.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.emreozgenc.parallax.Parallax;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Parallax.WIDTH;
		config.height = Parallax.HEIGHT;
		new LwjglApplication(new Parallax(), config);
	}
}
