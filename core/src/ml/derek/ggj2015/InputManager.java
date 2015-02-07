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
	private Array<Item> combineSpace;
	private OrthographicCamera camera;

	public static final Vector2 ITEM_SIZE = new Vector2(100, 100);

	public InputManager(Array<Item> inventory, Array<Item> combineSpace, OrthographicCamera camera)
	{
		this.inventory = inventory;
		this.combineSpace = combineSpace;
		this.camera = camera;
	}

	public void update(Room room)
	{
		if(Gdx.input.justTouched())
		{
			Vector2 mousePos = Utils.unproject(Gdx.input.getX(), Gdx.input.getY(), camera);

			//Check to see if the user is placing an item back in the inventory
			if(mousePos.x > RenderManager.WIDTH - 100 && room.carrying != null)
			{
				if(mousePos.y > 200)
				{
					inventory.add(room.carrying);
					room.carrying = null;
					return;
				} else if (combineSpace.size < 2)
				{
					combineSpace.add(room.carrying);
					Item item = room.carrying;
					room.carrying = null;

					//Check if another item is already there and if so combine!
					if(combineSpace.size == 2)
					{
						Gdx.app.log("input", "Attempting combine");
						item.onCombine(room, combineSpace.first(), combineSpace, inventory);

						//Size will change if combined, we can ignore what happens next
						if(combineSpace.size == 2)
							combineSpace.first().onCombine(room, item, combineSpace, inventory);
					}

					return;
				}
			}

			//Go through items in the room
			for(int x = room.getItems().size - 1; x >= 0; x--)
			{
				Item item = room.getItems().orderedKeys().get(x);
				Vector2 position = room.getItems().get(item);

				//Check if the item is clicked
				if(item.getBoundingBox(position).contains(mousePos))
				{

					if(room.carrying != null)
					{
						Gdx.app.log("input", "Item used");
						item.onUse(room.carrying, room, inventory);
					} else
					{
						Gdx.app.log("input", "Item clicked");
						item.onClick(room, inventory);
					}

					//Can only click once per frame
					return;
				}
			}

			//Can't interact with the inventory if we are carrying something
			if(room.carrying == null)
			{
				//Go through items in the inventory
				for (Item item : inventory)
				{
					//Check if the item is clicked
					if (item.getBoundingBox(item.inventoryPosition, ITEM_SIZE).contains(mousePos))
					{
						Gdx.app.log("input", "Inventory Item clicked");
						item.onInventoryClick(room, inventory);

						//Can only click once per frame
						return;
					}
				}

				//Go through items in the combine space
				for (Item item : combineSpace)
				{
					//Check if the item is clicked
					if (item.getBoundingBox(item.inventoryPosition, ITEM_SIZE).contains(mousePos))
					{
						Gdx.app.log("input", "Inventory Item clicked");
						item.onCombineSpaceClick(room, combineSpace);


						//Can only click once per frame
						return;
					}
				}
			}

		}
	}
}
