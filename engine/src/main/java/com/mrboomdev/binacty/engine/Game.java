package com.mrboomdev.binacty.engine;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mrboomdev.binacty.engine.render.Canvas;
import com.mrboomdev.binacty.engine.render.Renderable;

public class Game implements ApplicationListener {
	private final Renderable renderable;
	private Canvas canvas;

	public Game(Renderable renderable) {
		this.renderable = renderable;
	}

	@Override
	public void create() {
		canvas = new Canvas();
		renderable.onCreate();
	}

	@Override
	public void resize(int width, int height) {
		renderable.onResize(width, height);
	}

	@Override
	public void render() {
		ScreenUtils.clear(1, 0, 0, 0);
		canvas.begin();
		renderable.onDraw(canvas);
		canvas.end();
	}

	@Override
	public void pause() {
		renderable.onPause();
	}

	@Override
	public void resume() {
		renderable.onResume();
	}

	@Override
	public void dispose() {
		renderable.onDispose();
	}
}