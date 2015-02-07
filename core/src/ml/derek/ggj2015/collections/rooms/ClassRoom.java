package ml.derek.ggj2015.collections.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ml.derek.ggj2015.RenderManager;
import ml.derek.ggj2015.collections.items.classroom.*;
import ml.derek.ggj2015.collections.items.universal.Gateway;
import ml.derek.ggj2015.logic.Room;
import ml.derek.ggj2015.logic.RoomSwitcher;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class ClassRoom extends Room
{
	public ClassRoom(RoomSwitcher roomSwitcher)
	{
		super(new TextureRegion(new Texture("backgrounds/classroom.png")), roomSwitcher);
		items.put(new Paper(), new Vector2(444, RenderManager.HEIGHT - 745));
		items.put(new Borris(), new Vector2(410, RenderManager.HEIGHT - 420));
		items.put(new RocketEngine(), new Vector2(50, RenderManager.HEIGHT - 759));
		items.put(new RocketBody(), new Vector2(890, RenderManager.HEIGHT - 148));
		items.put(new Gateway("items/classroom/door.png", ScienceFair.class, roomSwitcher), new Vector2(37, RenderManager.HEIGHT - 317));
		putAreaSize(new Teacher(), new Vector2(397, 1), new Vector2(279, 201));

		music = Gdx.audio.newMusic(Gdx.files.internal("music/classroom.mp3"));
	}
}
