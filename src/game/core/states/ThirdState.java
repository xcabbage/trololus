package game.core.states;

import java.io.IOException;

import game.core.NetworkTest;
import game.core.parts.ContentPane;
import game.core.parts.ContentPosition;
import game.util.MoreColors;
import game.util.Util;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class ThirdState extends BasicState {

	public static int ID = 2;
	float glowF;
	int glow;
	NetworkTest network = new game.core.NetworkTest();
	ContentPane togglePane;
	private ContentPane menuPane;
	private ContentPane[] optionsPanes = new ContentPane[4];

	@Override
	public void createContent(GameContainer gc, StateBasedGame game)
			throws SlickException {
		Image buttonImg = new Image("resources/Splash/UI/IG/IG_fps.png")
				.getScaledCopy(0.15f);

		// title
		sb.addLabel(1, 0.5f, 0.5f, "Create a game - HOST");
		sb.getLabel(-1).setFont(Util.fontGreatHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

		sb.addLabel(1, 0.5f, 0.5f, "Host a game over LAN, IP or hotseat");
		sb.getLabel(-1).setFont(Util.fontNormalHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 100);
		sb.getLabel(-1).setColor(Color.white.darker(0.1f));

		sb.addContentPane(0.5f, 0.5f, -175, -50, 420, 100);
		menuPane = sb.getPane(-1);

		// !!Creation of options Panes!!!

		// WELCOME
		menuPane.addContentPane(0.05f, 0.05f, 0.9f, 0.9f);
		optionsPanes[0] = menuPane.getPane(-1);
		optionsPanes[0].setBackground(MoreColors.getTrans(Color.orange, 120),
				Color.white);
		optionsPanes[0].setPosition(ContentPosition.Center);
		optionsPanes[0].setVisible(false);
		optionsPanes[0].addLabel(1, 0, 0, "Connection box");
		optionsPanes[0].getLabel(-1).setFont(Util.fontText);
		optionsPanes[0].getLabel(-1).setColor(Color.cyan);
		optionsPanes[0].getLabel(-1).setPosition(ContentPosition.TopCenter, 0,
				-40);

		optionsPanes[0].addTextField(20, 10, 300, 25);
		optionsPanes[0].addTextField(20, 60, 300, 25);
		optionsPanes[0].addButton(325, 10, buttonImg);
		optionsPanes[0].getComponent(-1).addListener(new ComponentListener() {

			@Override
			public void componentActivated(AbstractComponent source) {
				Util.notify("Button1 pressed");

			}
		});
		optionsPanes[0].addButton(325, 60, buttonImg);
		optionsPanes[0].getComponent(-1).addListener(new ComponentListener() {

			@Override
			public void componentActivated(AbstractComponent source) {
				Util.notify("Button1 pressed");

			}
		});

		// SOUND
		menuPane.addContentPane(0.1f, 0.3f, 0.8f, 0.6f);
		optionsPanes[1] = menuPane.getPane(-1);
		optionsPanes[1].setBackground(MoreColors.getTrans(Color.blue, 120),
				Color.white);
		optionsPanes[1].setPosition(ContentPosition.Center);
		optionsPanes[1].setVisible(false);

		// Initially show Welcome pane
		switchToPane(0);
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Third State: Host a Game";
	}

	@Override
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {

		super.render(gc, mainGame, g, stateRes);

	}

	public void switchToPane(int a) {
		for (int b = 0; b < 2; b++) {
			if (b == a) {
				optionsPanes[b].setVisible(true);
			} else {

				optionsPanes[b].setVisible(false);
			}
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		TextField field = (TextField) optionsPanes[0].getComponent(0);
		TextField field2 = (TextField) optionsPanes[0].getComponent(1);
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
			break;
		case Input.KEY_F1:
			switchToPane(0);
			break;
		case Input.KEY_F2:
			switchToPane(1);
			break;
		default:
			break;
		}
	}
}