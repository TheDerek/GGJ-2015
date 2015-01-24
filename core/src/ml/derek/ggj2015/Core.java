package ml.derek.ggj2015;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.collections.rooms.Womb;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;

public class Core extends ApplicationAdapter
{
	private RenderManager renderManager;
	private Room currentRoom;
	private Array<Room> rooms;
	private Array<Item> inventory;

	@Override
	public void create()
	{
		renderManager = new RenderManager();
		inventory = new Array<Item>();

		rooms = new Array<Room>();
		rooms.add(new Womb());
		currentRoom = rooms.first();
	}

	@Override
	public void render()
	{
		renderManager.render(currentRoom);
	}
}