package com.mrboomdev.binacty2.engine.world;

import static java.util.Objects.requireNonNull;

import com.badlogic.gdx.math.Vector2;

public class Entity implements WorldObject {
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

	public void move(Vector2 power) {
		// TODO: 7/25/2024 Move an entity
		requireNonNull(getWorld());
	}

	@Override
	public World getWorld() {
		return world;
	}
}