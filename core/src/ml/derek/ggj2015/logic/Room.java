package ml.derek.ggj2015.logic;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.OrderedMap;
import ml.derek.ggj2015.RenderManager;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Room
{
	//Background for this room
	private TextureRegion background;
	private RoomSwitcher switcher;

	//Items for this room and their corresponding position
	protected OrderedMap<Item, Vector2> items;

	//The next room (Not implemented)
	private Room nextRoom;

	//The item we are carrying
	public Item carrying;

	//Theme tune for the room that will play when we are in the room
	public Music music;

	private boolean finished;

	//Global Room switcher

	public Room(TextureRegion background, RoomSwitcher switcher)
	{
		this.background = background;
		this.switcher = switcher;
		items = new OrderedMap<Item, Vector2>();
		finished = false;
	}

	/** Puts an item into the room with the top left position on the room being (0, 0) **/
	public void putY(Item item, Vector2 position)
	{
		items.put(item, new Vector2(position.x, RenderManager.HEIGHT - position.y));
	}

	/** Puts an item into the room with the top left position on the room being (0, 0) **/
	public void putArea(ClickableArea area, Vector2 topLeft, Vector2 bottomRight)
	{
		items.put(area, new Vector2(topLeft.x, RenderManager.HEIGHT - bottomRight.y));
		area.setSize(bottomRight.x - topLeft.x, bottomRight.y - topLeft.y);
	}

	public void putAreaSize(ClickableArea area, Vector2 topLeft, Vector2 size)
	{
		items.put(area, new Vector2(topLeft.x, RenderManager.HEIGHT - topLeft.y - size.y));
		area.setSize(size.x, size.y);
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
