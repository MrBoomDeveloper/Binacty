package com.mrboomdev.binacty.game.tiles;

import androidx.annotation.NonNull;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.Canvas;
import com.mrboomdev.binacty.engine.render.Texture;
import com.mrboomdev.binacty.engine.world.Tile;

public class WallTile extends Tile {
	private static final Texture texture = new Texture("wall.png");

	public WallTile(@NonNull Position position) {
		super(position);
	}

	@Override
	public void onDraw(@NonNull Canvas canvas) {
		canvas.draw(texture, (int) getPosition().x, (int) getPosition().y, getWidth(), getHeight());
	}

	@Override
	public int getWidth() {
		return 40;
	}

	@Override
	public int getHeight() {
		return 60;
	}
}