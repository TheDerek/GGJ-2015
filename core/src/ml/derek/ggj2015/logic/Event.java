package ml.derek.ggj2015.logic;

/**
 * Created by Derek Sewell on 24/01/15.
 * Copyright © 2015 Derek Sewell.
 * All rights reserved.
 */
public interface Event
{
	public void update();
	public void draw();
	public boolean isFinished();
}
