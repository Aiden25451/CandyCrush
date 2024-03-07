package com.candycrush.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener {
	
//	Keys in order of up, right, down, left
	private boolean[] keys = {false, false, false, false};
	
	private KeyAdapter listener;
	
	public KeyboardListener() {
		listener = new KeyAdapter() {
			int keyCode;
//			Update when a key is pressed
			public void keyPressed(KeyEvent e) {
				keyCode = e.getKeyCode();
				
				if(keyCode == KeyEvent.VK_W) {
					keys[0] = true;
				}
				if(keyCode == KeyEvent.VK_A) {
					keys[1] = true;
				}
				if(keyCode == KeyEvent.VK_S) {
					keys[2] = true;
				}
				if(keyCode == KeyEvent.VK_D) {
					keys[3] = true;
				}
				if(keyCode == KeyEvent.VK_ESCAPE) {
					System.exit(1);
				}
			}
//			Update when a key is released
			public void keyReleased(KeyEvent e) {
				keyCode = e.getKeyCode();
				
				if(keyCode == KeyEvent.VK_W) {
					keys[0] = false;
				}
				if(keyCode == KeyEvent.VK_A) {
					keys[1] = false;
				}
				if(keyCode == KeyEvent.VK_S) {
					keys[2] = false;
				}
				if(keyCode == KeyEvent.VK_D) {
					keys[3] = false;
				}
			}
		};
	}
//	get the listener
	public KeyAdapter getListener() {
		return listener;
	}
	
//	get the keys
	public boolean[] getKeys() {
		return keys;
	}
	
}
