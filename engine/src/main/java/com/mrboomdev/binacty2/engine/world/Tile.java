package com.mrboomdev.binacty2.engine.world;

import com.badlogic.gdx.math.Vector2;

public class Tile implements WorldObject {
	private final Vector2 position = new Vector2();
	private World world;

	@Override
	public Vector2 getPosition() {
		return position;
	}

	@Override
	public void setPosition(Vector2 position) {
		this.position.set(position);
	}

	@Override
	public void onCreate(World world) {
		this.world = world;
	}

	@Override
	public World getWorld() {
		return world;
	}
}