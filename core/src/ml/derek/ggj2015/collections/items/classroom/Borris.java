package ml.derek.ggj2015.collections.items.classroom;

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
public class Borris extends Item
{
	private boolean happy = false;

	public Borris()
	{
		super(new TextureRegion(new Texture("items/classroom/borris-unhappy.png")));
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		//super.onClick(room, inventory);
		if(happy)
		{

		}
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{
		if(item instanceof Paper)
		{
			//Open the door
			Gdx.app.log("input", "attempted door use");
			happy = true;
			setTexture(new TextureRegion(new Texture("items/classroom/borris-happy.png")));
			item.destory(room, inventory);

			//Give the user some fat stacks
			room.carrying = new Cash();
		}
	}

}


