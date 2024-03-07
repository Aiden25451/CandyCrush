package com.wave3.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import com.wave3.main.GameWindow;

public abstract class GameObject {
	protected Handler handler;
	protected Rectangle rectangle;	
	protected int velX, velY;
	protected ID id;
	protected Map<String, Boolean> hit = new HashMap<String,Boolean>();
	
//	Constructors
	public GameObject(Handler handler, ID id) {
		this.handler = handler;
		this.id = id;
		
		hit.put("up", false);
		hit.put("down", false);
		hit.put("right", false);
		hit.put("left", false);
	}
	public GameObject(Handler handler, ID id, Rectangle rectangle) {
		this(handler, id);
		this.rectangle = rectangle;
	}
	
//	Methods that every GameObject should have
	public abstract void tick();
	public abstract void render(Graphics2D g2d);
	public abstract void collision(ID id);
	
//	Used to stop/indicate when a wall is hit
	public void clamp() {
		if(this.rectangle.getX() < 0) {
			this.rectangle.setLocation(0, (int)this.rectangle.getY());
			hit.put("left", true);
		} else {hit.put("left", false);}
		
		if(this.rectangle.getX() + this.rectangle.getWidth() > GameWindow.GAMEWIDTH) {
			this.rectangle.setLocation(
				GameWindow.GAMEWIDTH - (int)this.rectangle.getWidth(), 
				(int)this.rectangle.getY()
			);
			hit.put("right", true);
		} else {hit.put("right", false);}
		
		if(this.rectangle.getY() < 0) {
			this.rectangle.setLocation((int)this.rectangle.getX(), 0);
			hit.put("up", true);
		} else {hit.put("up", false);}
		
		if(this.rectangle.getY() + this.rectangle.getHeight() > GameWindow.GAMEHEIGHT) {
			this.rectangle.setLocation(
				(int)this.rectangle.getX(),
				GameWindow.GAMEHEIGHT - (int)this.rectangle.getHeight()
			);
			hit.put("down", true);
		} else {hit.put("down", false);}
	}
	
//	Getters and Setters
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	public void setRectangle(Rectangle newRectangle) {
		this.rectangle = newRectangle;
	}
	public int getVelX() {
		return this.velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return this.velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public ID getId() {
		return this.id;
	}
	

}
