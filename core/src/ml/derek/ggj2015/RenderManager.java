package ml.derek.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class RenderManager
{
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;

	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;

	public RenderManager()
	{
		batch = new SpriteBatch();
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		camera.translate(WIDTH/2, HEIGHT/2);
		img = new Texture("badlogic.jpg");
	}


	public void render(Room room)
	{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		{
			batch.draw(room.getBackground(), 0, 0);
			for(ObjectMap.Entry<Item, Vector2> itemPair : room.getItems())
			{
				Item item = itemPair.key;
				Vector2 position = itemPair.value;
				batch.draw(item.getTexture(), position.x, position.y);
			}
		}
		batch.end();
	}
}
