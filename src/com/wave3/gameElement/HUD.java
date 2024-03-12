package com.wave3.gameElement;

import java.awt.Color;
import java.awt.Graphics2D;

import com.wave3.main.GameWindow;

public class HUD {
	public static float health = 1000;
	private float ratio;
	private Handler handler;
	
	
	
	public HUD(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		ratio = health/1000;
		
		if(health <= 0) {
			handler.removeAll();
			health = 1000;
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.green);
		g.fillRect(25, 25, (int) (GameWindow.GAMEWIDTH/2 * ratio), 50);
		g.setColor(Color.white);
		g.drawRect(25, 25, GameWindow.GAMEWIDTH/2, 50);
		
	}
}
