package com.candycrush.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.candycrush.gbc.GBC;
import com.candycrush.objects.Handler;

public class GameEngine implements Runnable{
	
	private int x = 50;
	
	private Thread thread;
	
	private BufferStrategy bufferStrategy;
	private GameCanvas gameCanvas;
	private GameWindow gameWindow;
	private Handler handler;
	
	public GameEngine() {
//		this.handler = handler;
		gameWindow  = new GameWindow();
		gameCanvas = new GameCanvas();
		handler = new Handler();
	}
	
	public void start() {
		gameWindow.add(gameCanvas, new GBC(0, 0).setFill(GBC.BOTH).setWeight(1, 1));
		gameCanvas.createBufferStrategy();
		this.bufferStrategy = this.gameCanvas.getBufferStrategy();
		
		
		thread = new Thread(this, "Game");
		thread.start();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		int updatesCounter = 0; // for counting the updates
		int framesCounter = 0; // for counting the frames

		// Updates per second cap
		final int UPS_CAP = 60;

		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / (double) (1000000000 / UPS_CAP);
			lastTime = now;

			while (delta >= 1) {
				tick();
				updatesCounter++;
				delta--;
			}

			render();
			framesCounter++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Updates per second: " + updatesCounter + ", Frames per second: " + framesCounter);
				updatesCounter = 0;
				framesCounter = 0;
			}
		}
	}
	
	private void tick() {
		
	}
	
	private void render() {
		Graphics2D g2d = (Graphics2D) bufferStrategy.getDrawGraphics();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, GameWindow.GAMEWIDTH, GameWindow.GAMEHEIGHT);
		
		g2d.dispose();
		bufferStrategy.show();
		
	}
	
}
