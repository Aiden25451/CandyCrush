package com.wave3.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.wave3.gameElement.Handler;
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
		
		width = 40;
		height = 40;
		
		x = GameWindow.GAMEWIDTH / 2 - width/2;
		y = GameWindow.GAMEHEIGHT / 2 - height/2;
		
		direction = "down";
		getPlayerImage();
		
	}
	
	public void getPlayerImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void tick() {
		//Handle player input
		boolean[] keys = keyboardListener.getKeys();
		//makes sure that the sprite isn't moving when the needed keys aren't being pressed
		if(keys[3] == true || keys[1] == true || keys[0] == true || keys[2] == true) {
			if(!keys[3] || !keys[1]) {
				if(keys[1]) {
					direction = "left";
					velX = -5;
				}
				if(keys[3]) {
					direction = "right";
					velX = 5;
				}
			}
			if(!keys[0] || !keys[2]) {
				if(keys[0]) {
					direction = "up";
					velY = -5;
				}
				if(keys[2]) {
					direction = "down";
					velY = 5;
				}
			}
			if(!keys[3] && !keys[1])
				velX = 0;
			if(!keys[0] && !keys[2])
				velY = 0;
		
			//Update player position
			x += velX;
			y += velY;
			//sprite changes every 12 frames
			spriteCounter++;
			if(spriteCounter> 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
		}

		//Keep player in bounds
		clamp();
		

		//Create trail behind player
		//handler.addObject(new Trail(x, y, Color.white, (int)width, (int)height, 0.1f, handler));
	
	}

	@Override
	public void render(Graphics2D g2d) {
		// TODO Auto-generated method stub
		//g2d.setColor(Color.white);
		//g2d.fillRect((int)x, (int)y, (int)width, (int)height);
		
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2d.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
	}

	@Override
	public void collision(ID id) {
		// TODO Auto-generated method stub
	}

}