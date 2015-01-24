package ml.derek.ggj2015.logic;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.OrderedMap;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Room
{
	//Background for this room
	private TextureRegion background;

	//Items for this room and their corresponding position
	protected OrderedMap<Item, Vector2> items;

	//The next room
	private Room nextRoom;

	//The item we are carrying
	public Item carrying;

	private boolean finished;

	public Room(TextureRegion background)
	{
		this.background = background;
		items = new OrderedMap<Item, Vector2>();
		finished = false;
	}

	/** Adds an item to the room **/
	public void addItem(Item item, Vector2 position)
	{
		items.put(item, position);
	}

	public TextureRegion getBackground()
	{
		return background;
	}

	public OrderedMap<Item,Vector2> getItems()
	{
		return items;
	}

	public boolean isFinished()
	{
		return finished;
	}

	public void finish()
	{
		finished = true;
	}
}
