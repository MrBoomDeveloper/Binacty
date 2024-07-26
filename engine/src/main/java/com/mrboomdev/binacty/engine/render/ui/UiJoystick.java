package com.mrboomdev.binacty.engine.render.ui;

import androidx.annotation.NonNull;

import com.mrboomdev.binacty.engine.render.Canvas;
import com.mrboomdev.binacty.engine.render.Texture;

public class UiJoystick extends UiWidget {
	private final Texture background, stick;

	public UiJoystick(Texture backgroundTexture, Texture stickTexture) {
		this.background = backgroundTexture;
		this.stick = stickTexture;
	}

	@Override
	public void onDraw(@NonNull Canvas canvas) {
		var position = getPosition();
		canvas.draw(background, (int) position.x, (int) position.y, getWidth(), getHeight());
	}
}