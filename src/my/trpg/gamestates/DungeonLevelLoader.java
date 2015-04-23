package my.trpg.gamestates;

import java.awt.Graphics2D;

import my.trpg.gamestate.GameState;
import my.trpg.gamestate.GameStateManager;
import my.trpg.generator.Map;

public class DungeonLevelLoader extends GameState {
	
	Map map;

	public DungeonLevelLoader(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		map = new Map();
		map.init();
	}

	@Override
	public void tick(double deltaTime) {
		map.tick(deltaTime);
	}

	@Override
	public void render(Graphics2D g) {
		map.render(g);
	}

}
