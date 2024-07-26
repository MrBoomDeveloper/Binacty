package com.mrboomdev.binacty2.engine.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
public interface Renderable {
	default void onDraw(Canvas canvas) {}
	default void onCreate() {}
	default void onPause() {}
	default void onResume() {}
	default void onDispose() {}

	default int getWidth() {
		return Gdx.graphics.getWidth();
	}

	default int getHeight() {
		return Gdx.graphics.getHeight();
	}

	default Vector2 getPosition() {
		return Vector2.Zero;
	}
}