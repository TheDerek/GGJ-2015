package ml.derek.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
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
	public static final int WIDTH = 1124;
	public static final int HEIGHT = 768;

	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;

	private Texture img;
	private OrthographicCamera camera;
	private Array<Item> inventory;

	public RenderManager(Array<Item> inventory)
	{
		this.inventory = inventory;
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		camera.translate(WIDTH / 2, HEIGHT / 2);
		//camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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

			//Draw the items in the room
			for(ObjectMap.Entry<Item, Vector2> itemPair : room.getItems())
			{
				Item item = itemPair.key;
				Vector2 position = itemPair.value;
				batch.draw(item.getTexture(), position.x, position.y);
			}

			//Draw the inventory
			float x = WIDTH - 100;
			float y = HEIGHT - 100;
			for(Item item : inventory)
			{
				batch.draw(item.getTexture(), x + 5, y + 5, 90, 90);
				if(item.inventoryPosition == null)
					item.inventoryPosition = new Vector2(x, y);
				else
					item.inventoryPosition.set(x, y);

				y -= 100;
			}

			//Draw the item being carried
			{
				if(room.carrying != null)
				{
					Vector2 mousePos = Utils.unproject(Gdx.input.getX(), Gdx.input.getY(), camera);
					batch.draw(room.carrying.getTexture(), mousePos.x - room.carrying.getSize().x/2, mousePos.y - room.carrying.getSize().y/2);
					//Gdx.input.setCursorCatched(true);
				}


			}
		}
		batch.end();

	}

	public OrthographicCamera getCamera()
	{
		return camera;
	}
}
