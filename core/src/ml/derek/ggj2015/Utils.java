package ml.derek.ggj2015;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public abstract class Utils
{
	private Utils()
	{

	}

	public static Vector2 unproject(int x, int y, OrthographicCamera camera)
	{
		Vector3 vector = camera.unproject(new Vector3((float)x, (float)y, 0f));
		return new Vector2(vector.x, vector.y);
	}
}
