package ml.derek.ggj2015.collections.items.universal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.logic.ClickableArea;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;
import ml.derek.ggj2015.logic.RoomSwitcher;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class GatewayArea extends ClickableArea
{
	private Class<? extends Room> roomClass;
	private RoomSwitcher switcher;

	public GatewayArea(Class<? extends Room> roomClass, RoomSwitcher switcher)
	{

		this.roomClass = roomClass;
		this.switcher = switcher;
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{
		Gdx.app.log("input", "Gateway area clicked");
		if(room.carrying == null)
			switcher.switchRoom(roomClass);
	}

	@Override
	public void onUse(Item item, Room room, Array<Item> inventory)
	{

	}

}


