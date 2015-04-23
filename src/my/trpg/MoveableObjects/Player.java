package my.trpg.MoveableObjects;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import my.gop.main.Vector2F;
import my.trpg.main.Animator;
import my.trpg.main.Assets;

public class Player implements KeyListener {
	Vector2F pos = new Vector2F();
	private int width = 64;
	private int height = 64;
	private static boolean up, down, left, right, idle;

	private boolean mapMove = true;
	
	private AnimationState state;
	
	private ArrayList<BufferedImage> listUp;
	private ArrayList<BufferedImage> listDown;
	private ArrayList<BufferedImage> listRight;
	private ArrayList<BufferedImage> listLeft;
	
	private Animator ani_up;
	private Animator ani_down;
	private Animator ani_right;
	private Animator ani_left;
	private Animator ani_idle;
	private ArrayList<BufferedImage> listIdle;
	
	/*
	 * 0 = up;
	 * 1 = down;
	 * 2 = right;
	 * 3 = left;
	 * 4 = idle;
	 */

	public Player() {
//		pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height
//				/ 2);
		pos = new Vector2F(64,64);
	}

	public void init() {
		
		listUp = new ArrayList<BufferedImage>();
		listDown = new ArrayList<BufferedImage>();
		listRight = new ArrayList<BufferedImage>();
		listLeft = new ArrayList<BufferedImage>();
		listIdle = new ArrayList<BufferedImage>();
		
		listUp.add(Assets.knight.getTile(0, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*2, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*3, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*4, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*5, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*6, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*7, 576 , 64 , 64));
		listUp.add(Assets.knight.getTile(64*8, 576 , 64 , 64));

		listDown.add(Assets.knight.getTile(0, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*2, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*3, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*4, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*5, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*6, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*7, 704 , 64 , 64));
		listDown.add(Assets.knight.getTile(64*8, 704 , 64 , 64));
		
		listRight.add(Assets.knight.getTile(0, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*2, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*3, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*4, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*5, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*6, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*7, 768 , 64 , 64));
		listRight.add(Assets.knight.getTile(64*8, 768 , 64 , 64));
		
		listLeft.add(Assets.knight.getTile(0, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*2, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*3, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*4, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*5, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*6, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*7, 640 , 64 , 64));
		listLeft.add(Assets.knight.getTile(64*8, 640 , 64 , 64));
		
		listIdle.add(Assets.knight.getTile(0, 704 , 64 , 64));
		listIdle.add(Assets.knight.getTile(64, 704 , 64 , 64));
		
		ani_up = new Animator(listUp);
		ani_up.setSpeed(180);
		ani_up.play();
		
		ani_down = new Animator(listDown);
		ani_down.setSpeed(180);
		ani_down.play();
		
		ani_right = new Animator(listRight);
		ani_right.setSpeed(400);
		ani_right.play();
	
		ani_left = new Animator(listLeft);
		ani_left.setSpeed(180);
		ani_left.play();
		
		ani_idle = new Animator(listIdle);
		ani_idle.setSpeed(180);
		ani_idle.play();
		

	}

	public void tick(double deltaTime) {
		if (up) {
			pos.ypos--;
			state = AnimationState.UP;
		}
		if (down) {
			pos.ypos++;
			state = AnimationState.DOWN;
		}
		if (left) {
			pos.xpos--;
			state = AnimationState.LEFT;
		}
		if (right) {
			pos.xpos++;
			state = AnimationState.RIGHT;
		}
		
		if (!up && !down && !right && !left) {
			state = AnimationState.IDLE;
		}
	}

	public void render(Graphics2D g) {
		
		switch(state){
		
		case UP: 
			g.drawImage(ani_up.sprite, (int)pos.xpos, (int)pos.ypos, width, height, null);
			if(up) {
				ani_up.update(System.currentTimeMillis());
			}
			break;
		case DOWN:
			g.drawImage(ani_down.sprite, (int)pos.xpos, (int)pos.ypos, width, height, null);
			if(down) {
				ani_down.update(System.currentTimeMillis());
			}
			break;
		case RIGHT:
			g.drawImage(ani_right.sprite, (int)pos.xpos, (int)pos.ypos, width, height, null);
			if(right) {
				ani_right.update(System.currentTimeMillis());
			}
			break;
		case LEFT:
			g.drawImage(ani_left.sprite, (int)pos.xpos, (int)pos.ypos, width, height, null);
			if(left) {
				ani_left.update(System.currentTimeMillis());
			}
			break;
		case IDLE:
			g.drawImage(ani_idle.sprite, (int)pos.xpos, (int)pos.ypos, width, height, null);
			ani_idle.update(System.currentTimeMillis());
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = true;
		}
		if (key == KeyEvent.VK_S) {
			down = true;
		}
		if (key == KeyEvent.VK_A) {
			left = true;
		}
		if (key == KeyEvent.VK_D) {
			right = true;
		}
		
		idle = false;

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = false;
		}
		if (key == KeyEvent.VK_S) {
			down = false;
		}
		if (key == KeyEvent.VK_A) {
			left = false;
		}
		if (key == KeyEvent.VK_D) {
			right = false;
		}
		
		idle = true;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public enum AnimationState {
		UP,
		DOWN,
		LEFT,
		RIGHT,
		IDLE
	}

}
