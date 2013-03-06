package game.core.states;

import java.awt.Font;
import java.io.IOException;

import game.core.NetworkTest;
import game.core.parts.ContentPane;
import game.core.parts.ContentPosition;
import game.util.Util;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;
import game.core.parts.*;

public class ThirdState extends BasicState {

	public static int ID = 2;
	float glowF;
	int glow;
	NetworkTest network = new game.core.NetworkTest();
	ContentPane togglePane;
	private ContentPane menuPane;

	public void createContent() throws SlickException {
		Image buttonImg = new Image("resources/Splash/UI/IG/IG_fps.png")
				.getScaledCopy(0.15f);

		sb.addContentPane(0.5f, 0.5f, -175, -50, 420, 100);
		menuPane = sb.getPane(-1);
		menuPane.addTextField(20, 10, 300, 25);
		menuPane.addTextField(20, 60, 300, 25);
		menuPane.addButton(325, 10, buttonImg);
		menuPane.getComponent(-1).addListener(new ComponentListener() {

			@Override
			public void componentActivated(AbstractComponent source) {
				Util.notify("Button1 pressed");

			}
		});
		menuPane.addButton(325, 60, buttonImg);
		menuPane.getComponent(-1).addListener(new ComponentListener() {

			@Override
			public void componentActivated(AbstractComponent source) {
				Util.notify("Button1 pressed");

			}
		});
		
		menuPane.addLabel(1, 0, 0, "Create a game - HOST");
		menuPane.getLabel(-1).setFont(
				new TrueTypeFont(new Font("Cambria", 25, 20), true));
		menuPane.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, -13);
		
		
		sb.addLabel(1, 0.5f, 0.5f, "Create a game - HOST");
		sb.getLabel(-1).setFont(
				new TrueTypeFont(new Font("Cambria", 25, 43), true));
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

		sb.addLabel(1, 0.5f, 0.5f, "Host a game over LAN, IP or hotseat");
		sb.getLabel(-1).setFont(
				new TrueTypeFont(new Font("Cambria", 25, 25), true));
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 100);
		sb.getLabel(-1).setColor(Color.white.darker(0.1f));

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
		TextField field = (TextField) menuPane.getComponent(0);
		TextField field2 = (TextField) menuPane.getComponent(1);
		switch (key) {

		case Input.KEY_I:
			if (network.testSocket == null) {
				String host = field.getText();
				int port = 0;
				try {
					port = Integer.parseInt(field2.getText());
				} catch (Exception e) {
					Util.printErr(e.getLocalizedMessage());
				}
				Util.notify("Connecting to " + host + ":" + port);
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
				Util.print("Sending message \"" + msg + "\".");
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