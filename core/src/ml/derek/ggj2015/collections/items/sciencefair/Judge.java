package ml.derek.ggj2015.collections.items.sciencefair;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import ml.derek.ggj2015.collections.items.classroom.Cash;
import ml.derek.ggj2015.collections.items.classroom.Rocket;
import ml.derek.ggj2015.logic.ClickableArea;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;

/**
 * Created by Derek Sewell on 07/02/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Judge extends ClickableArea
{
	private Item scienceProject;
	private Vector2 scienceProjectPos;

	public Judge()
	{
		super();
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{

	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{
		if(item instanceof Cash)
		{
			Table table = null;

			for(ObjectMap.Entry<Item, Vector2> pair : room.getItems())
			{
				Item roomItem = pair.key;
				if(roomItem instanceof Table)
				{
					table = (Table) roomItem;
				}
			}

			if(table != null && table.scienceProject != null)
			{
				table.scienceProject.setFirstPlace();
				//finally destroy the cash
				item.destory(room, inventory);
			}

		}
	}

	@Override
	public void draw(SpriteBatch batch, Vector2 position)
	{

	}
}
