package com.mrboomdev.binacty2.engine.world;

import com.badlogic.gdx.math.Vector2;
import com.mrboomdev.binacty2.engine.render.Canvas;

public interface WorldObject {

	Vector2 getPosition();

	void setPosition(Vector2 position);

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