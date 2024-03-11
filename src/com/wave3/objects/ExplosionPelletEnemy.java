package com.wave3.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.wave3.main.GameWindow;

public class ExplosionPelletEnemy extends GameObject{
	
	public ExplosionPelletEnemy(Handler handler, Rectangle rectangle, int velX, int velY) {
		super(handler, rectangle);
		// TODO Auto-generated constructor stub
		this.velX = velX;
		this.velY = velY;
	}

	@Override
	public void tick() {
		// Update the position
		rectangle.setLocation(
			(int)rectangle.getX() + velX, 
			(int)rectangle.getY() + velY
		);

		clamp();
		
		if(hit.get("left") || hit.get("right") || hit.get("up") || hit.get("down")) {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.white);
		g2d.fillRect(
				(int)rectangle.getX(), 
				(int)rectangle.getY(), 
				(int)rectangle.getWidth(), 
				(int)rectangle.getHeight()
		);
	}

	@Override
	public void collision(ID id) {
		// Temporary code to remove the BasicEnemy if it hits the player
		if(id == ID.PLAYER) {
			handler.removeObject(this);
		}
	}
	
}
