package com.mrboomdev.binacty.engine.world;

public abstract class Tile implements WorldObject {
	private World world;

	@Override
	public void onCreate(World world) {
		this.world = world;
	}

	@Override
	public World getWorld() {
		return world;
	}
}