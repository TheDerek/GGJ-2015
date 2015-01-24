package ml.derek.ggj2015.collections.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
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
		super(new TextureRegion(new Texture("backgrounds/womb.jpg")));
		items.put(new Key(), new Vector2(40, 40));
	}
}
