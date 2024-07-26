package com.mrboomdev.binacty.engine.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Canvas {
	private final SpriteBatch spriteBatch = new SpriteBatch();
	private boolean canDraw;

	public void draw(
			Texture texture,
			int x, int y,
			int srcX, int srcY,
			int srcWidth, int srcHeight,
			int width, int height
	) {
		if(!canDraw) {
			throw new IllegalStateException("You didn't call Canvas.begin()!");
		}

		spriteBatch.draw(texture.getGdxTexture(), x, y, srcX, srcY, srcWidth, srcHeight, width, height);
	}

	public void draw(Texture texture, int x, int y, int width, int height) {
		if(!canDraw) {
			throw new IllegalStateException("You didn't call Canvas.begin()!");
		}

		spriteBatch.draw(texture.getGdxTexture(), x, y, width, height);
	}

	public void begin() {
		canDraw = true;
		spriteBatch.begin();
	}

	public void end() {
		canDraw = false;
		spriteBatch.end();
	}

	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}
}