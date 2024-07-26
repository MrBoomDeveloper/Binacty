package com.mrboomdev.binacty.game;

import androidx.annotation.NonNull;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.Canvas;
import com.mrboomdev.binacty.engine.render.Texture;
import com.mrboomdev.binacty.engine.world.Entity;

public class Character extends Entity {
	private final Texture texture = new Texture("freddy.png");
	private final Position position;

	public Character(@NonNull Position position) {
		this.position = position.copy();
	}

	public Texture getTexture() {
		return texture;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void setPosition(Position position) {
		this.position.set(position);
	}

	@Override
	public int getWidth() {
		return 50;
	}

	@Override
	public int getHeight() {
		return 50;
	}

	@Override
	public void onDraw(@NonNull Canvas canvas) {
		canvas.draw(texture, (int) getPosition().x, (int) getPosition().y, getWidth(), getHeight());
	}
}