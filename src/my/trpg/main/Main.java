package my.trpg.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import my.gop.main.GameWindow;
import my.gop.main.SpriteSheet;
import my.trpg.MoveableObjects.Player;
import my.trpg.gameloop.GameLoop;


public class Main {
	
	static SpriteSheet blocks = new SpriteSheet();
	
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight();
	
	public static void main(String[] args) {
		GameWindow frame = new GameWindow("CSC-335 TRPG Final Project", width, height);
		frame.setFullscreen(2);
		frame.addKeyListener(new Player());
		frame.add(new GameLoop(width, height));
		frame.setVisible(true);
	}

}
