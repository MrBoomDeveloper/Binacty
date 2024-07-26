package com.mrboomdev.binacty.game;

import androidx.annotation.NonNull;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.Canvas;

public class MainPlayer extends Character {

	public MainPlayer(@NonNull Position position) {
		super(position.copy());
	}

	@Override
	public void onDraw(@NonNull Canvas canvas) {
		var position = getPosition();
		position.x++;
		position.y++;
		super.onDraw(canvas);
	}
}