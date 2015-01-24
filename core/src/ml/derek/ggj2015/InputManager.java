package ml.derek.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
public class InputManager
{
	private Array<Item> inventory;
	private OrthographicCamera camera;

	public InputManager(Array<Item> inventory, OrthographicCamera camera)
	{
		this.inventory = inventory;
		this.camera = camera;
	}

	public void update(Room room)
	{
		if(Gdx.input.isTouched())
		{
			Vector2 mousePos = Utils.unproject(Gdx.input.getX(), Gdx.input.getY(), camera);

			for(ObjectMap.Entry<Item, Vector2> entry : room.getItems())
			{
				Item item = entry.key;
				Vector2 position = entry.value;

				//Check if the item is clicked
				if(item.getBoundingBox(position).contains(mousePos))
				{
					Gdx.app.log("input", "Item clicked");
				}
			}
		}
	}
}
