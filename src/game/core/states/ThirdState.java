package game.core.states;

import java.io.IOException;

import game.core.NetworkTest;
import game.core.parts.ContentPane;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class ThirdState extends BasicState {

	public static int ID = 2;
	float glowF;
	int glow;
	NetworkTest network = new game.core.NetworkTest();
	ContentPane togglePane;

	public void createContent() throws SlickException {

		sb.addTextField(stateRes.appWidth / 2,
				(int) (stateRes.appHeight * 0.2), 300, 25);
		sb.addTextField(stateRes.appWidth / 2,
				((int) (stateRes.appHeight * 0.2)) + 50, 300, 25);
		sb.addContentPane(50, 150, 100, 100);
		togglePane = sb.getPane(-1);
		sb.addLabel(1, 0.2f, 0.2f, "Hosting - use the U, I, O keys to navigate.");
	}

	public int getID() {
		return ID;
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Third State: Host a Game";
	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		renderDiffGfx(gc, mainGame, g, stateRes);
		super.render(gc, mainGame, g, stateRes);

	}

	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		TextField field = (TextField) sb.getComponent(0);
		TextField field2 = (TextField) sb.getComponent(1);
		switch (key) {

		case Input.KEY_I:
			if (network.testSocket == null) {
				String host = field.getText();
				int port = Integer.parseInt(field2.getText());
				System.out.println("Connecting to " + host + ":" + port);
				network.connect(host, port);

				break;
			} else {
				try {
					network.terminate();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		case Input.KEY_O:
			if (network != null) {

				String msg = field.getText();
				System.out.println("Sending message \"" + msg + "\".");
				network.sendMsg(msg);
				break;
			}
		case Input.KEY_P:
			if (network != null) {
				network.setInMsg();
				break;
			}
		case Input.KEY_NUMPAD5:
			togglePane.toggleVisibility();
		default:
			break;
		}
	}
}