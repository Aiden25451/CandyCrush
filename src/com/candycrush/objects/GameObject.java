package com.candycrush.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	protected Handler handler;
	
	public GameObject(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics2D g2d);
}
