package com.mrboomdev.binacty.game.levels;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.RenderableList;
import com.mrboomdev.binacty.engine.world.World;
import com.mrboomdev.binacty.game.MainPlayer;

public class MainLevel extends RenderableList {
	private final World world = new World(100, 100);
	private final MainPlayer player = new MainPlayer(Position.Zero);

	@Override
	public void onCreate() {
		super.onCreate();
		attachLayer(world);
		world.addObject(player);
		world.setCameraTargets(player);
	}
}