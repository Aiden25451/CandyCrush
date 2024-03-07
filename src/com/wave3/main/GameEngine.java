package com.wave3.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.wave3.gbc.GBC;
import com.wave3.listeners.KeyboardListener;
import com.wave3.objects.BasicEnemy;
import com.wave3.objects.Handler;
import com.wave3.objects.ID;
import com.wave3.objects.Player;

public class GameEngine implements Runnable{
	
	private int x = 50;
	
	private Thread thread;
	
	private BufferStrategy bufferStrategy;
	private GameCanvas gameCanvas;
	private GameWindow gameWindow;
	private Handler handler;
	private Random random;
	private KeyboardListener keyboardListener;
	
	public GameEngine() {
//		this.handler = handler;
		keyboardListener = new KeyboardListener();
		random = new Random();
		gameWindow  = new GameWindow();
		gameCanvas = new GameCanvas();
		gameCanvas.addKeyListener(keyboardListener.getListener());
		handler = new Handler(keyboardListener, random);
		
		
		
		
		handler.addObject(new Player(handler, ID.PLAYER, keyboardListener));
		for(int i = 0; i < 10; i++)
			handler.addObject(new BasicEnemy(handler, ID.BASICENEMY, new Rectangle(300, 300, 25, 25)));

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
//				I MADE A SMALL CHANGE
				render();
				framesCounter++;
//				END OF SMALL CHANGE
			}

/*          Moving the comment below up
//			render();
//			framesCounter++;
 */

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println("Updates per second: " + updatesCounter + ", Frames per second: " + framesCounter);
				updatesCounter = 0;
				framesCounter = 0;
			}
		}
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		Graphics2D g2d = (Graphics2D) bufferStrategy.getDrawGraphics();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, GameWindow.GAMEWIDTH, GameWindow.GAMEHEIGHT);
		
		handler.render(g2d);
		
		g2d.dispose();
		bufferStrategy.show();
		
	}
	
}
