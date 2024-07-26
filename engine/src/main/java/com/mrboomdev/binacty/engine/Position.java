package com.mrboomdev.binacty.engine;

import androidx.annotation.NonNull;

public class Position {
	public static final Position Zero = new Position();
	public float x, y;

	public Position(@NonNull Position original) {
		this(original.x, original.y);
	}

	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Position() {}

	public void set(@NonNull Position newPosition) {
		this.x = newPosition.x;
		this.y = newPosition.y;
	}

	public void add(@NonNull Position position) {
		this.x += position.x;
		this.y += position.y;
	}

	public void scl(float scale) {
		this.x *= scale;
		this.y *= scale;
	}

	public void div(float scale) {
		this.x /= scale;
		this.y /= scale;
	}

	public void sub(@NonNull Position position) {
		this.x -= position.x;
		this.y -= position.y;
	}

	public Position copy() {
		return new Position(this);
	}
}