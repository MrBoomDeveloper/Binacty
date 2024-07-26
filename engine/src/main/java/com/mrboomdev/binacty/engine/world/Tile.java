package com.mrboomdev.binacty.engine.world;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import com.mrboomdev.binacty.engine.Position;

public abstract class Tile implements WorldObject {
	private final Position position;
	private World world;

	public Tile(@NonNull Position position) {
		this.position = position.copy();
	}

	@CallSuper
	@Override
	public void onCreate(World world) {
		this.world = world;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position.set(position);
	}
}