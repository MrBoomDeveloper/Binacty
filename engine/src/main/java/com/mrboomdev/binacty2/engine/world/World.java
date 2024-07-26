package com.mrboomdev.binacty2.engine.world;

import com.mrboomdev.binacty2.engine.render.Canvas;
import com.mrboomdev.binacty2.engine.render.Renderable;

import java.util.ArrayList;
import java.util.List;

public class World implements Renderable {
	private final List<WorldObject> worldObjects = new ArrayList<>();

	@Override
	public void onDraw(Canvas canvas) {
		for(var object : worldObjects) {
			object.onDraw(canvas);
		}
	}

	public void destroyObject(WorldObject object) {
		worldObjects.remove(object);
	}

	public void addObject(WorldObject object) {
		worldObjects.add(object);
	}
}