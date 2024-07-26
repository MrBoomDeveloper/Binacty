package com.mrboomdev.binacty.game.levels;

import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.RenderableList;
import com.mrboomdev.binacty.engine.render.ui.UiPanel;
import com.mrboomdev.binacty.engine.world.World;
import com.mrboomdev.binacty.game.Character;
import com.mrboomdev.binacty.game.tiles.FloorTile;
import com.mrboomdev.binacty.game.tiles.WallTile;

public class MainLevel extends RenderableList {
	private final World world = new World(100, 100);
	private final UiPanel ui = new UiPanel(UiPanel.VERTICAL);
	private final Character player = new Character(Position.Zero);

	@Override
	public void onCreate() {
		super.onCreate();

		attachLayer(world);
		world.setCameraTargets(player);

		for(int i = -5; i < 5; i++) {
			world.addObject(new WallTile(new Position(40 * i, 25)));
		}

		for(int i = -5; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				world.addObject(new FloorTile(new Position(40 * i, -15 + 40 * -j)));
			}
		}

		world.addObject(player);

		attachLayer(ui);

		// TODO: 7/26/2024 Implement joystick
		/*var joystick = new UiJoystick();
		joystick.setHeight(100);
		joystick.setWidth(100);
		ui.addWidget(joystick);*/
	}
}