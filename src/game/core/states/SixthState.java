package game.core.states;

import java.awt.Font;

import game.core.parts.ContentPane;
import game.core.parts.ContentPosition;
import game.util.MoreColors;
import game.util.Util;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class SixthState extends BasicState {

	public static int ID = 5;
	private ContentPane optionsPane;
	private ContentPane[] optionsPanes = new ContentPane[4];
	int openPane = -1;

	public void createContent() throws SlickException {
		// create independent content
		sb.addLabel(1, 0.5f, 0.5f, "game options");
		sb.getLabel(-1).setFont(Util.fontGreatHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

		// add & init Options pane
		sb.addContentPane(0.25f, 0.25f, 0.5f, 0.5f);
		optionsPane = sb.getPane(-1);
		optionsPane.setBackground(MoreColors.getTrans(Color.black, 150),
				Color.cyan);

		optionsPane.addLabel(1, 0, 0, "GENERAL");
		optionsPane.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 20);
		optionsPane.getLabel(-1).setFont(Util.fontNormalHeader);
		optionsPane.getLabel(-1).setColor(Color.white);

		optionsPane.addLabel(1, 0, 0, "SOUND");
		optionsPane.getLabel(-1).setPosition(ContentPosition.TopCenter,
				(int) (optionsPane.getLabel(-2).getBounds().getWidth() + 50),
				12);
		optionsPane.getLabel(-1).setFont(Util.fontNormalHeader);
		optionsPane.getLabel(-1).setColor(Color.white.darker(0.4f));

		optionsPane.addLabel(1, 0, 0, "GRAPHICS");
		optionsPane.getLabel(-1).setPosition(ContentPosition.TopCenter,
				(int) -(optionsPane.getLabel(-3).getBounds().getWidth() + 50),
				12);
		optionsPane.getLabel(-1).setFont(Util.fontNormalHeader);
		optionsPane.getLabel(-1).setColor(Color.white.darker(0.4f));

		// !!Menu Settings Panes!!!

		// GENERAL
		optionsPane.addContentPane(0.1f, 0.3f, 0.8f, 0.6f);
		optionsPanes[0] = optionsPane.getPane(-1);
		optionsPanes[0].setBackground(MoreColors.getTrans(Color.orange, 120),
				Color.white);
		optionsPanes[0].setPosition(ContentPosition.Center);
		optionsPanes[0].setVisible(false);

		// SOUND
		optionsPane.addContentPane(0.1f, 0.3f, 0.8f, 0.6f);
		optionsPanes[1] = optionsPane.getPane(-1);
		optionsPanes[1].setBackground(MoreColors.getTrans(Color.blue, 120),
				Color.white);
		optionsPanes[1].setPosition(ContentPosition.Center);
		optionsPanes[1].setVisible(false);

		// GRAPHICS
		optionsPane.addContentPane(0.1f, 0.3f, 0.8f, 0.6f);
		optionsPanes[2] = optionsPane.getPane(-1);
		optionsPanes[2].setBackground(MoreColors.getTrans(Color.red, 120),
				Color.white);
		optionsPanes[2].setPosition(ContentPosition.Center);
		optionsPanes[2].setVisible(false);

		// GAMEPLAY
		optionsPane.addContentPane(0.1f, 0.3f, 0.8f, 0.6f);
		optionsPanes[3] = optionsPane.getPane(-1);
		optionsPanes[3].setBackground(MoreColors.getTrans(Color.pink, 120),
				Color.white);
		optionsPanes[3].setPosition(ContentPosition.Center);
		optionsPanes[3].setVisible(false);
	}

	public void switchToPane(int a) {
		openPane = a;
		for (int b = 0; b < 4; b++) {
			if (b == a) {
				System.out.println(b + "visible");
				optionsPanes[b].setVisible(true);
			} else {
				System.out.println(b + "invisible");
				optionsPanes[b].setVisible(false);
			}
			sb.driftComponentTo((300 + (100 * a)), 250,
					optionsPane.getLabel(-1));
		}
	}

	void paneLeft() {
		if (openPane > 0)
			switchToPane(openPane - 1);
		else
			switchToPane(3);
	}	

	void paneRight() {
		if (openPane < 3)
			switchToPane(openPane + 1);
		else
			switchToPane(0);

	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Options state";
		input.initControllers();
		Util.print("Number of controllers: " + input.getControllerCount());
	}

	public int getID() {
		return ID;
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

		switch (key) {

		case Input.KEY_Q:
			switchToPane(0);
			break;
		case Input.KEY_W:
			switchToPane(1);
			break;
		case Input.KEY_E:
			switchToPane(2);
			break;
		case Input.KEY_R:
			switchToPane(3);
			break;
		/* case Input.ANY_CONTROLLER: */
		case Input.KEY_X:
			paneLeft();
			break;
		case Input.KEY_C:
			paneRight();
			break;
		case Input.ANY_CONTROLLER:
			if (input.isControllerLeft(1)) {
				paneLeft();
			} else if (input.isControllerRight(1)) {
				paneRight();
			}

			break;

		}

	}
}