package game.core.states;

import java.awt.Font;

import game.core.parts.ContentPane;
import game.core.parts.ContentPosition;
import game.util.MoreColors;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class SixthState extends BasicState {

	public static int ID = 5;
	private ContentPane optionsPane;

	public void createContent() throws SlickException {
		//create independent content
		sb.addLabel(1, 0.5f, 0.5f, "game options");
		sb.getLabel(-1).setFont(
				new TrueTypeFont(new Font(fontGreatHeader, 25, 43), true));
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);
		
		
		//add & init Options pane
		sb.addContentPane(0.25f, 0.25f, 0.5f, 0.5f);
		optionsPane = sb.getPane(-1);
		optionsPane.setBackground(MoreColors.getTrans(Color.black, 150), Color.cyan);
		
		optionsPane.addLabel(1, 0, 0, "GENERAL");
		optionsPane.getLabel(-1).setPosition(ContentPosition.TopCenter, 0,20);
		optionsPane.getLabel(-1).setFont(new TrueTypeFont(new Font(fontNormalHeader, 50, 30),true));
		optionsPane.getLabel(-1).setColor(Color.white);
		

		optionsPane.addLabel(1, 0, 0, "SOUND");
		optionsPane.getLabel(-1).setPosition(ContentPosition.TopCenter, (int) (optionsPane.getLabel(-2).getBounds().getWidth()+50),12);
		optionsPane.getLabel(-1).setFont(new TrueTypeFont(new Font(fontNormalHeader, 50, 30),true));
		optionsPane.getLabel(-1).setColor(Color.white.darker(0.4f));
		
		optionsPane.addLabel(1, 0, 0, "GRAPHICS");
		optionsPane.getLabel(-1).setPosition(ContentPosition.TopCenter, (int) -(optionsPane.getLabel(-3).getBounds().getWidth()+50),12);
		optionsPane.getLabel(-1).setFont(new TrueTypeFont(new Font(fontNormalHeader, 50, 30),true));
		optionsPane.getLabel(-1).setColor(Color.white.darker(0.4f));

	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Options state";
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
}