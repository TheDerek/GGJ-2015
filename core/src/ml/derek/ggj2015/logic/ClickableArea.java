package ml.derek.ggj2015.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Derek Sewell on 07/02/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class ClickableArea extends Item
{
	/** Must set the size of the area later to avoid a null pointer error*/
	public ClickableArea()
	{
		super(null, null);
	}

	@Override
	public void onClick(Room room, Array<Item> inventory)
	{

	}


	@Override
	public void draw(SpriteBatch batch, Vector2 area)
	{

	}

}
