package ml.derek.ggj2015.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ml.derek.ggj2015.Core;
import ml.derek.ggj2015.RenderManager;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = RenderManager.WIDTH;
		config.height = RenderManager.HEIGHT;
		new LwjglApplication(new Core(), config);
	}
}
