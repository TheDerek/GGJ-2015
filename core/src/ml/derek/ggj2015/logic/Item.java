package ml.derek.ggj2015.logic;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public class Item
{
	private TextureRegion texture;
	private Vector2 size;
	private Rectangle boundingBox;

	public Item(TextureRegion texture, Vector2 size)
	{
		this.texture = texture;
		this.size = size;
		this.boundingBox = new Rectangle(0, 0, size.x, size.y);
	}

	public Item(TextureRegion texture)
	{
		this(texture, new Vector2(texture.getRegionWidth(), texture.getRegionHeight()));
	}

	public Rectangle getBoundingBox(Vector2 position)
	{
		boundingBox.setPosition(position);
		return boundingBox;
	}

	public void onMouseHover()
	{

	}

	public void onClick(Room room, Array<Item> inventory)
	{

	}

	public TextureRegion getTexture()
	{
		return texture;
	}

	public Vector2 getSize()
	{
		return size;
	}

	public void destory(Room room, Array<Item> inventory)
	{
		room.getItems().remove(this);
		inventory.removeValue(this, false);
		this.texture.getTexture().dispose();
		this.texture = null;
	}
}
