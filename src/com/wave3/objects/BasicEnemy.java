package com.wave3.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.wave3.main.GameWindow;

public class BasicEnemy extends GameObject{
	
	private int spawn_timer = 60;

	public BasicEnemy(Handler handler, Rectangle rectangle) {
		super(handler, rectangle);
		// TODO Auto-generated constructor stub
		id = ID.BASICENEMY;
	}

	@Override
	public void tick() {
		if(spawn_timer > 0) {
			spawn_timer--;
			return;
		}
		if(spawn_timer == 0) {
			this.velX = (handler.getRandom().nextInt(2) * 2 - 1) * 5;
			this.velY = (handler.getRandom().nextInt(2) * 2 - 1) * 5;
			id = ID.BASICENEMY;
			spawn_timer--;
		}
		// Update the position
		rectangle.setLocation(
			(int)rectangle.getX() + velX, 
			(int)rectangle.getY() + velY
		);

		clamp();
		
		if(hit.get("left") || hit.get("right")) velX *= -1;
		if(hit.get("up") || hit.get("down")) velY *= -1;
	}

	@Override
	public void render(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.blue);
		if(spawn_timer > 0) {
			g2d.drawRect(
				(int)rectangle.getX(), 
				(int)rectangle.getY(), 
				(int)rectangle.getWidth(), 
				(int)rectangle.getHeight()
			);
		}
		else {
			g2d.fillRect(
				(int)rectangle.getX(), 
				(int)rectangle.getY(), 
				(int)rectangle.getWidth(), 
				(int)rectangle.getHeight()
			);
		}
	}

	@Override
	public void collision(ID id) {
		// Temporary code to remove the BasicEnemy if it hits the player
		if(id == ID.PLAYER && spawn_timer == -1) {
			handler.removeObject(this);
		}
	}
	
}
