package game.core.parts;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.GameState;

public class Image extends Component {

	static String pepa = "ahoj";
	static int counter = -1;

	public Image(GameState state, GameContainer gc, Graphics g) {
		super(state, gc, g);

	}

	public void init() {
		pepa = "boom! ";

	}

	public void update() {
		if (System.currentTimeMillis() % 32 == 0)
			counter++;

	}

	public void render() {
		g.drawString(pepa + counter, 10, 15);

	}
}