package com.mrboomdev.binacty2.engine.render;

import androidx.annotation.RestrictTo;

public class Texture {
	private com.badlogic.gdx.graphics.Texture gdxTexture;
	private final String path;

	public Texture(String path) {
		this.path = path;
	}

	@RestrictTo(RestrictTo.Scope.LIBRARY)
	public com.badlogic.gdx.graphics.Texture getGdxTexture() {
		if(gdxTexture == null) {
			gdxTexture = new com.badlogic.gdx.graphics.Texture(path);
		}

		return gdxTexture;
	}
}