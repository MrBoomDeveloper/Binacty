package com.mrboomdev.binacty.engine.render;

public interface Renderable {
	default void onDraw(Canvas canvas) {}
	default void onCreate() {}
	default void onPause() {}
	default void onResume() {}
	default void onDispose() {}
	default void onResize(int width, int height) {}
}