package com.wave3.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.wave3.listeners.KeyboardListener;
import com.wave3.main.GameWindow;

public class Player extends GameObject{
	
	private KeyboardListener keyboardListener;

	public Player(Handler handler, KeyboardListener keyboardListener) {
		super(handler);
		
		this.keyboardListener = keyboardListener;
		id = ID.PLAYER;
		
		velX = 0;
		velY = 0;
		
		rectangle = new Rectangle(0, 0, 50, 50);
	}

	@Override
	public void tick() {
		//Handle player input
		boolean[] keys = keyboardListener.getKeys();
		if(!keys[3] || !keys[1]) {
			if(keys[1]) 
				velX = -5;
			if(keys[3])
				velX = 5;
		}
		if(!keys[0] || !keys[2]) {
			if(keys[0]) 
				velY = -5;
			if(keys[2])
				velY = 5;
		}
		if(!keys[3] && !keys[1])
			velX = 0;
		if(!keys[0] && !keys[2])
			velY = 0;
	
		//Update player position
		rectangle.setLocation(
			(int)rectangle.getX() + velX, 
			(int)rectangle.getY() + velY
		);
		
		//Keep player in bounds
		clamp();
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
		// TODO Auto-generated method stub
	}

}
