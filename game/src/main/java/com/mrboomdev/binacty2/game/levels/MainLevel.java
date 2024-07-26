package com.mrboomdev.binacty2.game.levels;

import com.mrboomdev.binacty2.engine.render.Canvas;
import com.mrboomdev.binacty2.engine.render.RenderableList;
import com.mrboomdev.binacty2.engine.world.World;
import com.mrboomdev.binacty2.game.MainPlayer;

public class MainLevel extends RenderableList {
	private final World world = new World();
	private final MainPlayer player = new MainPlayer();

	@Override
	public void onCreate() {
		super.onCreate();
		attachLayer(world);
		world.addObject(player);
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}
}