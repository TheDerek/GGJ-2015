package ml.derek.ggj2015.collections.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ml.derek.ggj2015.logic.Item;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Key extends Item
{
	public Key()
	{
		super(new TextureRegion(new Texture("items/key.png")));
	}
}
