package com.candycrush.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Handler {
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public Handler() {
		
	}
	
	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).tick();
		}
	}
	
	public void render(Graphics2D g2d) {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g2d);
		}
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		objects.remove(object);
	}
	
	public void removeAll() {
		objects.removeAll(objects);
	}
	
	public ArrayList<GameObject> getObjects() {
		return objects;
	}
}
