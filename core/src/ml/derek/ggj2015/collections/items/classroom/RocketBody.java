package ml.derek.ggj2015.collections.items.classroom;

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
public class RocketBody extends Item
{
	public RocketBody()
	{
		super(new TextureRegion(new Texture("items/classroom/rocket-body.png")));
	}

	@Override
	public void onCombine(Room room, Item combinedWith, Array<Item> combineSpace, Array<Item> inventory)
	{
		if(combinedWith instanceof RocketEngine)
		{
			//Destroy the previous two items
			destory(room, inventory, combineSpace);
			combinedWith.destory(room ,inventory, combineSpace);

			//Create the new rocket
			Rocket rocket = new Rocket();
			inventory.add(rocket);
		}
	}

}
