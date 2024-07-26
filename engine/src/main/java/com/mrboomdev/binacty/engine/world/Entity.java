package com.mrboomdev.binacty.engine.world;

import static java.util.Objects.requireNonNull;

import com.mrboomdev.binacty.engine.Position;

public abstract class Entity implements WorldObject {
	private World world;

	@Override
	public void onCreate(World world) {
		this.world = world;
	}

	public void move(Position power) {
		// TODO: 7/25/2024 Move an entity
		requireNonNull(getWorld());
	}

	@Override
	public World getWorld() {
		return world;
	}
}