package ml.derek.ggj2015.collections.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class FireExtinguisher extends Item
{
	public FireExtinguisher()
	{
		super(new TextureRegion(new Texture("items/fire-extinguisher.png")));
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		super.onClick(room, inventory);
		room.getItems().remove(this);
		//inventory.add(this);
		room.carrying = this;
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{

	}

	public void onInventoryClick(Room room, Array<Item> inventory)
	{
		room.carrying = this;
		inventory.removeValue(this, false);
	}
}


