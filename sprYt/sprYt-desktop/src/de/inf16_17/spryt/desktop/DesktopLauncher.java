package de.inf16_17.spryt.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

import de.inf16_17.spryt.SprytMain;

public class DesktopLauncher {
	
	private static boolean rebuildAtlas = true;
	private static boolean drawDebugOutline = true;
	
	public static void main (String[] arg) {
		
		if (rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 1024*2;
			settings.maxHeight = 1024*2;
			settings.debug = drawDebugOutline;
			TexturePacker2.process(settings, "assets-raw/images",
					"../sprYt-android/assets/images",
					"buttons.pack");
		}
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 480;
		config.height = 800;
		new LwjglApplication(new SprytMain(), config);
	}
}