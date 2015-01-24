package ml.derek.ggj2015;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.collections.rooms.Womb;
import ml.derek.ggj2015.logic.Event;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;

import java.util.Queue;

public class Core extends ApplicationAdapter
{
	private RenderManager renderManager;
	private InputManager inputManager;

	private int currentRoom;
	private Array<Room> rooms;
	private Array<Item> inventory;
	private Queue<Event> events;

	@Override
	public void create()
	{
		inventory = new Array<Item>();

		renderManager = new RenderManager(inventory);
		inputManager = new InputManager(inventory, renderManager.getCamera());

		rooms = new Array<Room>();
		rooms.add(new Womb());
		rooms.add(new Womb());

		currentRoom = 0;
	}

	@Override
	public void render()
	{
		if(rooms.get(currentRoom).isFinished())
			currentRoom++;

		inputManager.update(rooms.get(currentRoom));
		renderManager.render(rooms.get(currentRoom));
	}
}
