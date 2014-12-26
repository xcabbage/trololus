package game.core.parts;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.GameState;

public class Timer extends Component {

	static int cas = 0;

	public Timer(GameState state, GameContainer gc, Graphics g) {
		super(state, gc, g);

	}

	public void init() {
		cas = 5;
	}

	public void update() {
		if (System.currentTimeMillis() % 100 == 0)
			cas++;
	}

	public void render() {
		g.drawString(cas + " je Dušanova máma", 50, 50);

	}

}
