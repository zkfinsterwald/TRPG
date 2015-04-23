package my.trpg.main;

import java.awt.image.BufferedImage;

import my.gop.main.LoadImage;
import my.gop.main.SpriteSheet;

public class Assets {

	SpriteSheet blocks = new SpriteSheet();
	public static SpriteSheet knight = new SpriteSheet();

	public static BufferedImage grass_1;
	public static BufferedImage water_1;
	public static BufferedImage water_1l;
	public static BufferedImage water_1r;
	public static BufferedImage stone_1;
	public static BufferedImage sand_1;
	public static BufferedImage path_1;

	public void init() {
		blocks.setSpriteSheet(LoadImage.loadImageFrom(Main.class,
				"map_sprites.png"));
		
		knight.setSpriteSheet(LoadImage.loadImageFrom(Main.class, "Knight.png"));
		
		// BLOCKS
		grass_1 = blocks.getTile(0, 0, 16, 16);
		water_1 = blocks.getTile(16, 0, 16, 16);
		water_1l = blocks.getTile(16, 16, 16, 16);
		water_1r = blocks.getTile(16, 32, 16, 16);
		stone_1 = blocks.getTile(32, 0, 16, 16);
		sand_1 = blocks.getTile(48, 0, 16, 16);
		path_1 = blocks.getTile(64, 0, 16, 16);
	}

	public Assets() {
		// TODO Auto-generated constructor stub
	}

	/* BLOCK GETTERS */
	public static BufferedImage getGrass_1() {
		return grass_1;
	}

	public static BufferedImage getWater_1() {
		return water_1;
	}

	public static BufferedImage getStone_1() {
		return stone_1;
	}

	public static BufferedImage getSand_1() {
		return sand_1;
	}

	public static BufferedImage getPath_1() {
		return path_1;
	}

	public static BufferedImage getWater_1l() {
		return water_1l;
	}

	public static BufferedImage getWater_1r() {
		return water_1r;
	}
}
