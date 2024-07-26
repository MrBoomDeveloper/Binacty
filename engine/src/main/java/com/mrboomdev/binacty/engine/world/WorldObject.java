package com.mrboomdev.binacty.engine.world;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.Canvas;

public interface WorldObject {

	Position getPosition();

	void setPosition(Position position);

	int getWidth();

	int getHeight();

	default void destroy(boolean now) {
		var world = getWorld();
		if(world == null) return;

		world.destroyObject(this);
	}

	default void onDraw(Canvas canvas) {}

	void onCreate(World world);

	default void onDestroy() {}

	World getWorld();
}