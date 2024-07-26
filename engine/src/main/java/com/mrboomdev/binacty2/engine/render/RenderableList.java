package com.mrboomdev.binacty2.engine.render;

import java.util.ArrayList;
import java.util.List;

public class RenderableList implements Renderable {
	private final List<Renderable> layers = new ArrayList<>();
	private boolean didCreate, isPaused, didDispose;

	public void attachLayer(Renderable renderable) {
		attachLayer(renderable, layers.size());
	}

	public void attachLayer(Renderable renderable, int index) {
		layers.add(index, renderable);

		if(didCreate) {
			renderable.onCreate();
		}

		if(didDispose) {
			renderable.onDispose();
		}

		if(isPaused) {
			renderable.onPause();
		}
	}

	public void dettachLayer(Renderable renderable) {
		layers.remove(renderable);

		if(didCreate) {
			renderable.onDispose();
		}
	}

	@Override
	public void onCreate() {
		didCreate = true;

		for(var layer : layers) {
			layer.onCreate();
		}
	}

	/**
	 * Draws all layers in the creation order.
	 */
	@Override
	public void onDraw(Canvas canvas) {
		for(var layer : layers) {
			layer.onDraw(canvas);
		}
	}

	@Override
	public void onPause() {
		this.isPaused = true;

		for(var layer : layers) {
			layer.onPause();
		}
	}

	@Override
	public void onResume() {
		this.isPaused = false;

		for(var layer : layers) {
			layer.onResume();
		}
	}

	@Override
	public void onDispose() {
		didDispose = true;
		didCreate = false;

		for(var layer : layers) {
			layer.onDispose();
		}
	}
}