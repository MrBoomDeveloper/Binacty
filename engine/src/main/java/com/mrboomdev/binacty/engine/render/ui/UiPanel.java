package com.mrboomdev.binacty.engine.render.ui;

import androidx.annotation.IntDef;

import com.mrboomdev.binacty.engine.render.Canvas;

import java.util.ArrayList;
import java.util.List;

public class UiPanel extends UiWidget {
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	private final List<UiWidget> widgets = new ArrayList<>();
	private int orientation, width, height;

	@IntDef({ HORIZONTAL, VERTICAL })
	public @interface Orientation {}

	public UiPanel(@Orientation int orientation) {
		setOrientation(orientation);
	}

	@Override
	public void onDraw(Canvas canvas) {
		width = 0;
		height = 0;

		for(var widget : widgets) {
			if(orientation == HORIZONTAL) {
				widget.getPosition().set(width, 0);

				var widgetWidth = widget.getWidth();
				width += widgetWidth;

				if(widgetWidth > width) {
					width = widgetWidth;
				}
			} else {
				widget.getPosition().set(0, height);

				var widgetHeight = widget.getHeight();
				height += widgetHeight;

				if(widgetHeight > height) {
					height = widgetHeight;
				}
			}
		}
	}

	@Override
	public int getWidth() {
		var real = super.getWidth();
		if(real == WRAP_CONTENT) return width;
		return real;
	}

	@Override
	public int getHeight() {
		var real = super.getHeight();
		if(real == WRAP_CONTENT) return height;
		return real;
	}

	public void setOrientation(@Orientation int orientation) {
		if(orientation != HORIZONTAL && orientation != VERTICAL) {
			throw new IllegalArgumentException("Unknown orientation! " + orientation);
		}

		this.orientation = orientation;
	}

	public int getOrientation() {
		return orientation;
	}

	public void addWidget(UiWidget widget) {
		widgets.add(widget);
	}

	public void removeWidget(UiWidget widget) {
		widgets.remove(widget);
	}
}