package ml.derek.ggj2015.collections.items.house;

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
public class Key extends Item
{
	public Key()
	{
		super(new TextureRegion(new Texture("items/house/key.png")));
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{

	}

}


