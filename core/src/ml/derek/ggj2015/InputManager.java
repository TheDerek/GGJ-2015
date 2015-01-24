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
		if(Gdx.input.justTouched())
		{
			Vector2 mousePos = Utils.unproject(Gdx.input.getX(), Gdx.input.getY(), camera);

			//Go through items in the room
			for(int x = room.getItems().size - 1; x >= 0; x--)
			{
				Item item = room.getItems().orderedKeys().get(x);
				Vector2 position = room.getItems().get(item);

				//Check if the item is clicked
				if(item.getBoundingBox(position).contains(mousePos))
				{
					Gdx.app.log("input", "Item clicked");
					item.onClick(room, inventory);

					//Can only click once per frame
					return;
				}
			}

			//Go through items in the inventory
			for(Item item : inventory)
			{
				//Check if the item is clicked
				if(item.getBoundingBox(item.inventoryPosition, new Vector2(100, 100)).contains(mousePos))
				{
					Gdx.app.log("input", "Inventory Item clicked");
					item.onInventoryClick(room, inventory);

					//Can only click once per frame
					return;
				}
			}

			//Check to see if the user is placing an item back in the inventory
			if(mousePos.x > 1024 && room.carrying != null)
			{
				inventory.add(room.carrying);
				room.carrying = null;
			}
		}
	}
}
