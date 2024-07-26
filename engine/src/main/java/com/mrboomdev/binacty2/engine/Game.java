package com.mrboomdev.binacty2.engine;

import com.badlogic.gdx.ApplicationListener;
import com.mrboomdev.binacty2.engine.render.Canvas;
import com.mrboomdev.binacty2.engine.render.Renderable;

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
	public void resize(int width, int height) {}

	@Override
	public void render() {
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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