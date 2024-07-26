package com.mrboomdev.binacty2.game;

import androidx.annotation.NonNull;

import com.mrboomdev.binacty2.engine.render.Canvas;
import com.mrboomdev.binacty2.engine.render.Texture;
import com.mrboomdev.binacty2.engine.world.Entity;

public class MainPlayer extends Entity {
	private final Texture texture = new Texture("freddy.png");
	private int pos;

	@Override
	public void onDraw(@NonNull Canvas canvas) {
		canvas.draw(texture, pos, pos, 200, 200);
		pos += 1;
	}
}