package ml.derek.ggj2015.collections.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ml.derek.ggj2015.RenderManager;
import ml.derek.ggj2015.collections.items.Door;
import ml.derek.ggj2015.collections.items.Fire;
import ml.derek.ggj2015.collections.items.FireExtinguisher;
import ml.derek.ggj2015.collections.items.Key;
import ml.derek.ggj2015.logic.Room;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Womb extends Room
{
	public Womb()
	{
		super(new TextureRegion(new Texture("backgrounds/womb.png")));
		float y = RenderManager.HEIGHT - 521;
		items.put(new Key(), new Vector2(251, y));
		items.put(new Fire(), new Vector2(251, y));
		items.put(new FireExtinguisher(), new Vector2(623, RenderManager.HEIGHT - 428));
		items.put(new Door(), new Vector2(728, 408));

	}
}
