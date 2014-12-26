package game.core.parts;

import org.newdawn.slick.state.GameState;

public abstract interface GameComponent {

	public void init();

	public void update();

	public void render();
}