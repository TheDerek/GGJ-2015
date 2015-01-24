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
public class Fire extends Item
{
	public Fire()
	{
		super(new TextureRegion(new Texture("items/fire.png")));
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		super.onClick(room, inventory);
		destory(room, inventory);
	}
}


