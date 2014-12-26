package game.core.parts;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.GameState;

public class Component implements GameComponent {
	GameState state;
	GameContainer gc;
	Graphics g;

	public Component(GameState state, GameContainer gc, Graphics g) {
		this.state = state;
		this.gc = gc;
		this.g = g;
		init();

	}

	@Override
	public void init() {

	}

	@Override
	public void update() {

	}

	@Override
	public void render() {

	}

}
