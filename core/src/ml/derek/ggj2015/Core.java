package ml.derek.ggj2015;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import ml.derek.ggj2015.collections.rooms.ClassRoom;
import ml.derek.ggj2015.collections.rooms.ScienceFair;
import ml.derek.ggj2015.collections.rooms.Womb;
import ml.derek.ggj2015.logic.Event;
import ml.derek.ggj2015.logic.Item;
import ml.derek.ggj2015.logic.Room;
import ml.derek.ggj2015.logic.RoomSwitcher;

import java.util.Queue;

public class Core extends ApplicationAdapter
{
	private RenderManager renderManager;
	private InputManager inputManager;

	private int currentRoom;
	private Array<Room> rooms;
	private Array<Item> inventory;
	private Array<Item> combineSpace;
	private Queue<Event> events;

	private RoomSwitcher roomSwitcher;

	private Music currentMusic;

	@Override
	public void create()
	{
		inventory = new Array<Item>();
		combineSpace = new Array<Item>();

		renderManager = new RenderManager(inventory, combineSpace);
		inputManager = new InputManager(inventory, combineSpace, renderManager.getCamera());

		roomSwitcher = new RoomSwitcher()
		{
			@Override
			public void switchRoom(Class desiredRoom)
			{
				for(Room room : rooms)
				{
					if(room.getClass().equals(desiredRoom))
					{
						switchRooms(rooms.indexOf(room, false));
					}
				}
			}
		};

		rooms = new Array<Room>();
		rooms.add(new Womb(roomSwitcher));
		rooms.add(new ClassRoom(roomSwitcher));
		rooms.add(new ScienceFair(roomSwitcher));

		switchRooms(0);
	}

	@Override
	public void render()
	{
		Room room = rooms.get(currentRoom);
		if(room.music != null && !room.music.isPlaying())
			room.music.play();

		if(room.isFinished())
		{
			switchRooms(currentRoom+1);
		}

		inputManager.update(rooms.get(currentRoom));
		renderManager.render(rooms.get(currentRoom));
	}

	private void switchRooms(int newRoom)
	{
		Room room = rooms.get(currentRoom);

		if(rooms.get(newRoom).music != null && !rooms.get(newRoom).music.equals(currentMusic))
		{
			if(currentMusic != null)
				currentMusic.stop();

			currentMusic = rooms.get(newRoom).music;
			currentMusic.play();
		}

		currentRoom = newRoom;
	}
}
