package ml.derek.ggj2015.collections.items.house;

import com.badlogic.gdx.Gdx;
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
public class Door extends Item
{
	private boolean open = false;

	public Door()
	{
		super(new TextureRegion(new Texture("items/house/door.png")));
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		//super.onClick(room, inventory);
		if(open)
		{
			room.finish();
		}
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{
		if(item instanceof Key)
		{
			//Open the door
			Gdx.app.log("input", "attempted door use");
			open = true;
			setTexture(new TextureRegion(new Texture("items/house/door-open.png")));
			item.destory(room, inventory);
		}
	}

}


