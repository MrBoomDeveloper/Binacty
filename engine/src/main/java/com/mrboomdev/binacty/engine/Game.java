package com.mrboomdev.binacty.engine;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mrboomdev.binacty.engine.render.Canvas;
import com.mrboomdev.binacty.engine.render.Renderable;
import com.mrboomdev.binacty.engine.render.ui.UiWidget;

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

		if(renderable instanceof UiWidget widget) {
			widget.setWidth(Gdx.graphics.getWidth());
			widget.setHeight(Gdx.graphics.getHeight());
		}
	}

	@Override
	public void resize(int width, int height) {
		renderable.onResize(width, height);

		if(renderable instanceof UiWidget widget) {
			widget.setWidth(width);
			widget.setHeight(height);
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 0);
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