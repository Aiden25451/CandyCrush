package com.wave3.gameElement;

import com.wave3.main.GameWindow;
import com.wave3.main.Gamestate;
import com.wave3.objects.BasicEnemy;
import com.wave3.objects.ExplosionEnemy;
import com.wave3.objects.FastEnemy;
import com.wave3.objects.Player;
import com.wave3.objects.SmartEnemy;

public class Spawner {
	
	private Handler handler;
	
	public Spawner(Handler handler) {
		this.handler = handler;
	}
	
	public void nextLevel() {
//		if(Gamestate.level == 1) {
//			handler.addObject(new BasicEnemy(handler));
//			handler.addObject(new BasicEnemy(handler));
//			handler.addObject(new BasicEnemy(handler));
//			handler.addObject(new BasicEnemy(handler));
//		}
		if(Gamestate.level == 1) {
			handler.addObject(new Player(handler, handler.getKeyboardListener()));
			handler.addObject(new BasicEnemy(handler));
		}
		else if(Gamestate.level == 2) {
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
		}
		else if(Gamestate.level == 3) {
			handler.removeEnemies();
			
			handler.addObject(new FastEnemy(handler));
		}
		else if(Gamestate.level == 4) {
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
		}
		else if(Gamestate.level == 5) {
			handler.removeEnemies();
			
			handler.addObject(new SmartEnemy(handler));
		}
		else if(Gamestate.level == 6) {
			handler.addObject(new ExplosionEnemy(handler, 100, getRandomY()));
			handler.addObject(new ExplosionEnemy(handler, GameWindow.GAMEWIDTH- 200, getRandomY()));
		}
		else if(Gamestate.level == 7) {
			handler.addObject(new ExplosionEnemy(handler, 25, getRandomY()));
			handler.addObject(new ExplosionEnemy(handler, 175, getRandomY()));
			handler.addObject(new ExplosionEnemy(handler, 325, getRandomY()));
			handler.addObject(new ExplosionEnemy(handler, 475, getRandomY()));
		}
		else if(Gamestate.level == 8) {
			handler.removeEnemies();
		}
		else if(Gamestate.level == 9) {
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new FastEnemy(handler));
			handler.addObject(new SmartEnemy(handler));
			handler.addObject(new SmartEnemy(handler));
			handler.addObject(new SmartEnemy(handler));
			handler.addObject(new SmartEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
			handler.addObject(new BasicEnemy(handler));
		}
		
	}
	
	public int getRandomX() {
		return handler.getRandom().nextInt(GameWindow.GAMEWIDTH - 200) + 100;
	}
	
	public int getRandomY() {
		return handler.getRandom().nextInt(GameWindow.GAMEHEIGHT - 200) + 100;
	}
}	
