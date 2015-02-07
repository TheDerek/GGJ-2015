package ml.derek.ggj2015.collections.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ml.derek.ggj2015.RenderManager;
import ml.derek.ggj2015.collections.items.house.Door;
import ml.derek.ggj2015.collections.items.house.Fire;
import ml.derek.ggj2015.collections.items.house.FireExtinguisher;
import ml.derek.ggj2015.collections.items.house.Key;
import ml.derek.ggj2015.logic.Room;
import ml.derek.ggj2015.logic.RoomSwitcher;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Womb extends Room
{
	public Womb(RoomSwitcher roomSwitcher)
	{
		super(new TextureRegion(new Texture("backgrounds/womb.png")), roomSwitcher);
		float y = RenderManager.HEIGHT - 521;
		items.put(new Key(), new Vector2(251, y));
		items.put(new Fire(), new Vector2(251, y));
		items.put(new FireExtinguisher(), new Vector2(623, RenderManager.HEIGHT - 428));
		items.put(new Door(), new Vector2(728, 408));

		music = Gdx.audio.newMusic(Gdx.files.internal("music/house.mp3"));
	}
}
