package ml.derek.ggj2015.collections.items.sciencefair;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.collections.items.classroom.Rocket;
import ml.derek.ggj2015.logic.ClickableArea;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;

/**
 * Created by Derek Sewell on 07/02/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Table extends ClickableArea
{
	private Item scienceProject;
	private Vector2 scienceProjectPos;

	public Table()
	{
		super();
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		Gdx.app.log("input", "clicked table");
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{
		if(item instanceof Rocket)
		{
			scienceProject = item;
			room.carrying = null;

		}
	}

	@Override
	public void draw(SpriteBatch batch, Vector2 position)
	{
		if(scienceProject != null)
		{
			if(scienceProjectPos == null)
				scienceProjectPos = new Vector2(position.cpy().add(getSize().cpy().scl(0.5f)));

			scienceProject.draw(batch, scienceProjectPos);
		}
	}
}
