package com.wave3.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.wave3.main.GameWindow;

public class ExplosionEnemy extends GameObject{
	
	private int spawn_timer = 60;
	private int speed = 2;

	public ExplosionEnemy(Handler handler, Rectangle rectangle) {
		super(handler, rectangle);
		// TODO Auto-generated constructor stub
		id = ID.WAITINGENEMY;
		
	}

	@Override
	public void tick() {
		if(spawn_timer > 0) {
			spawn_timer--;
			return;
		}
		if(spawn_timer == 0) {
			this.velX = (handler.getRandom().nextInt(2) * 2 - 1) * 3;
			this.velY = (handler.getRandom().nextInt(2) * 2 - 1) * 3;
			id = ID.EXPLOSIONENEMY;
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
		g2d.setColor(Color.red);
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
		if(id == ID.EXPLOSIONENEMY && spawn_timer == -1) {
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, 0, -speed));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, speed, -speed));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, speed, 0));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, speed, speed));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, 0, speed));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, -speed, speed));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, -speed, 0));
			handler.addObject(new ExplosionPelletEnemy(handler, 
					new Rectangle(
							(int)this.rectangle.getX(), 
							(int)this.rectangle.getY(),
							20,
							20)
					, -speed, -speed));
			handler.removeObject(this);
		}
	}
	
}
