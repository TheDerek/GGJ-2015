package ml.derek.ggj2015.collections.items.classroom;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ml.derek.ggj2015.logic.Item;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Rocket extends Item
{
	public boolean first = false;
	public Rocket()
	{
		super(new TextureRegion(new Texture("items/classroom/rocket.png")));
	}

	public void setFirstPlace()
	{
		first = true;
		getTexture().getTexture().dispose();
		setTexture(new TextureRegion(new Texture("items/classroom/rocket-first-place.png")));
	}


}
