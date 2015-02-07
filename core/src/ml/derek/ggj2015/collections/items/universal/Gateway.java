package ml.derek.ggj2015.collections.items.universal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.collections.items.house.Key;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;
import ml.derek.ggj2015.logic.RoomSwitcher;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Gateway extends Item
{
	private Class<? extends Room> roomClass;
	private RoomSwitcher switcher;

	public Gateway(String region, Class<? extends Room> roomClass, RoomSwitcher switcher)
	{
		super(new TextureRegion(new Texture(region)));
		this.roomClass = roomClass;
		this.switcher = switcher;
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		if(room.carrying == null)
			switcher.switchRoom(roomClass);
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{

	}

}


