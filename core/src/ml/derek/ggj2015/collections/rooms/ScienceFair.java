package ml.derek.ggj2015.collections.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.collections.items.sciencefair.Judge;
import ml.derek.ggj2015.collections.items.sciencefair.Table;
import ml.derek.ggj2015.collections.items.universal.GatewayArea;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;
import ml.derek.ggj2015.logic.RoomSwitcher;

/**
 * Created by Derek Sewell on 06/02/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class ScienceFair extends Room
{
	public ScienceFair(RoomSwitcher roomSwitcher)
	{
		super(new TextureRegion(new Texture("backgrounds/sciencefair.png")), roomSwitcher);
		putArea(new Table(), new Vector2(218, 373), new Vector2(625, 648));
		putAreaSize(new GatewayArea(ClassRoom.class, roomSwitcher), new Vector2(109, 0), new Vector2(227, 280));
		putAreaSize(new Judge(), new Vector2(352, 0), new Vector2(193, 383));
	}

}
