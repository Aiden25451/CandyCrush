package com.wave3.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.wave3.gameElement.HUD;
import com.wave3.gameElement.Handler;
import com.wave3.main.GameWindow;

public class ExplosionPelletEnemy extends GameObject{
	
	public ExplosionPelletEnemy(Handler handler, float x, float y, float width, float height, int velX, int velY) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
		this.velX = velX;
		this.velY = velY;
	}

	@Override
	public void tick() {
		// Update the position
		x += velX;
		y += velY;

		clamp();
		
		if(hit.get("left") || hit.get("right") || hit.get("up") || hit.get("down")) {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	@Override
	public void collision(ID id) {
		// Temporary code to remove the BasicEnemy if it hits the player
		if(id == ID.PLAYER) {
			HUD.health -= 50;
			handler.removeObject(this);
		}
	}
	
}
