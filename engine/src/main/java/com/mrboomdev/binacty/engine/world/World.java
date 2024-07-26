package com.mrboomdev.binacty.engine.world;

import androidx.annotation.NonNull;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mrboomdev.binacty.engine.Position;
import com.mrboomdev.binacty.engine.render.Canvas;
import com.mrboomdev.binacty.engine.render.Renderable;

import java.util.ArrayList;
import java.util.List;

import box2dLight.RayHandler;

public class World implements Renderable {
	private final List<WorldObject> worldObjects = new ArrayList<>();
	private final Position cameraPosition = new Position();
	private final int worldWidth, worldHeight;
	private RayHandler rayHandler;
	private com.badlogic.gdx.physics.box2d.World world;
	private OrthographicCamera camera;
	private Viewport viewport;
	private WorldObject[] cameraTargets;

	public World(int worldWidth, int worldHeight) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
	}

	@Override
	public void onCreate() {
		Box2D.init();

		camera = new OrthographicCamera(worldWidth, worldHeight);
		viewport = new ExtendViewport(worldWidth, worldHeight, camera);

		world = new com.badlogic.gdx.physics.box2d.World(Vector2.Zero, true);

		/*rayHandler = new RayHandler(world);
		rayHandler.setAmbientLight(.5f, .5f, .5f, 1);
		rayHandler.setBlurNum(3);
		rayHandler.setCulling(true);*/
	}

	@Override
	public void onDraw(@NonNull Canvas canvas) {
		canvas.end();

		if(cameraTargets != null && cameraTargets.length > 0) {
			cameraPosition.set(Position.Zero);

			for(var target : cameraTargets) {
				cameraPosition.add(target.getPosition());
				cameraPosition.x += target.getWidth() / 2f;
				cameraPosition.y += target.getHeight() / 2f;
			}

			cameraPosition.div(cameraTargets.length);
		}

		camera.position.set(cameraPosition.x, cameraPosition.y, 0);
		camera.update();
		canvas.getSpriteBatch().setProjectionMatrix(camera.combined);

		canvas.begin();

		for(var object : worldObjects) {
			object.onDraw(canvas);
		}

		//canvas.end();

		/*rayHandler.setCombinedMatrix(camera);
		rayHandler.render();*/

		world.step(1 / 60f, 6, 2);

		//canvas.begin();
	}

	@Override
	public void onResize(int width, int height) {
		viewport.update(width, height);
	}

	public void setCameraTargets(WorldObject... targets) {
		this.cameraTargets = targets;
	}

	public void destroyObject(WorldObject object) {
		worldObjects.remove(object);
	}

	public void addObject(WorldObject object) {
		worldObjects.add(object);
	}

	@Override
	public void onDispose() {
		rayHandler.dispose();
		world.dispose();
	}
}