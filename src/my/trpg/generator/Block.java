package my.trpg.generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.gop.main.Vector2F;
import my.trpg.main.Assets;

public class Block extends Rectangle {
	
	private BufferedImage block;
	public Vector2F pos = new Vector2F();
	public static final int BLOCK_SIZE = 16;
	private BlockType type;
	private boolean isSolid;

	public Block(Vector2F pos, BlockType type) {
		this.pos = pos;
		this.type = type;
		init();
	}
	
	
	public void init() {
		switch(type) {
		case GRASS_1:
			block = Assets.getGrass_1();
			isSolid = false;
			break;
		case WATER_1:
			block = Assets.getWater_1();
			isSolid = true;
			break;
		case WATER_1L:
			block = Assets.getWater_1l();
			isSolid = true;
			break;
		case WATER_1R:
			block = Assets.getWater_1r();
			isSolid = true;
			break;
		case STONE_1:
			block = Assets.getStone_1();
			isSolid = true;
			break;
		case SAND_1:
			block = Assets.getSand_1();
			isSolid = false;
			break;
		case PATH_1:
			block = Assets.getPath_1();
			isSolid = false;
			break;
		}
	}

	public void tick(double deltaTime) {
		setBounds((int)pos.xpos, (int)pos.ypos, BLOCK_SIZE, BLOCK_SIZE);
	}

	public void render(Graphics2D g) {
		//g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BLOCK_SIZE, BLOCK_SIZE);
		g.drawImage(block, (int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BLOCK_SIZE, BLOCK_SIZE, null);
	}
	
	public enum BlockType{
		STONE_1,
		WATER_1,
		WATER_1L,
		WATER_1R,
		GRASS_1,
		SAND_1,
		PATH_1
	}

	public boolean isSolid() {
		// TODO Auto-generated method stub
		return isSolid;
	}
}
