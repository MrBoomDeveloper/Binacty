package com.mrboomdev.binacty.engine.render.ui;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.Renderable;

public class UiWidget implements Renderable {
	public static final int WRAP_CONTENT = -1;
	public static final int FILL_SPACE = -2;
	private final Position position = new Position();
	private int width, height;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position.set(position);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}