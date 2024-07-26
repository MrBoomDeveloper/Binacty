package com.mrboomdev.binacty2.engine.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Canvas {
	private final SpriteBatch batch = new SpriteBatch();
	private boolean canDraw;

	public void draw(Texture texture, int x, int y, int width, int height) {
		if(!canDraw) {
			throw new IllegalStateException("You didn't call use()!");
		}

		batch.draw(texture.getGdxTexture(), x, y, width, height);
	}

	public void begin() {
		canDraw = true;
		batch.begin();
	}

	public void end() {
		canDraw = false;
		batch.end();
	}
}