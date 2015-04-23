package my.trpg.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.gop.main.LoadImage;
import my.gop.main.Vector2F;
import my.trpg.MoveableObjects.Player;
import my.trpg.generator.Block.BlockType;
import my.trpg.main.Main;

public class Map {

	private static final int MAP_WIDTH = 120;
	private static final int MAP_HEIGHT = 68;
	private static final int BLOCK_SIZE = Block.BLOCK_SIZE;

	TileManager tiles = new TileManager();
	Player player = new Player();

	public Map() {
		// TODO Auto-generated constructor stub
	}

	public void init() {
		
		player.init();
		
		BufferedImage map = null;

		try {
			map = LoadImage.loadImageFrom(Main.class, "map2.png");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int x = 0; x < MAP_WIDTH; x++) {
			for (int y = 0; y < MAP_HEIGHT; y++) {
				int color = map.getRGB(x, y);
				switch (color & 0xFFFFFF) {
				case 0x808080: // gray - stone
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.STONE_1));
					break;
				case 0x0000ff: // WATER
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.WATER_1));
					break;
				case 0x00007f: // WATER LEFT SIDE
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.WATER_1L));
					break;
				case 0x00ffff: // WATER RIGHT SIDE
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.WATER_1R));
					break;
				case 0x00ff00: // green - grass
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.GRASS_1));
					break;
					
				case 0xffff00: // yellow - sand
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.SAND_1));
					break;
					
				case 0xffffff: // white - path
					tiles.blocks.add(new Block(new Vector2F(x * BLOCK_SIZE, y * BLOCK_SIZE), BlockType.PATH_1));
					break;

				}
			}
		}
	}

	public void tick(double deltaTime) {
		tiles.tick(deltaTime);
		player.tick(deltaTime);
	}

	public void render(Graphics2D g) {
		tiles.render(g);
		player.render(g);
	}

}
