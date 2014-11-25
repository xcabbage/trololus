package game.core.states;

import org.newdawn.slick.Color;

import game.core.parts.ContentPosition;
import game.nonstatic.BattleField;
import game.nonstatic.GameInstance;
import game.nonstatic.entities.controllables.Ship;
import game.nonstatic.entities.controllables.ShipType;
import game.nonstatic.system.Player;
import game.util.Util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FifthState extends BasicState {

	public static final int ID = 4;

	FifthState state = this;

	@Override
	public void createContent() throws SlickException {

		sb.addLabel(1, 0.5f, 0.5f, "News & Friends");
		sb.getLabel(-1).setFont(Util.fontGreatHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

		sb.addLabel(1, 0.5f, 0.5f,
				"Track your friends' progress, online state and ongoing games.");
		sb.getLabel(-1).setFont(Util.fontNormalHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 100);
		sb.getLabel(-1).setColor(Color.white.darker(0.1f));

	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "State 5 - Game - GfX test! (once to be Player Profile)";

	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);

	}

	@Override
	void renderDiffGfx(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) {
		try {
			super.renderDiffGfx(gc, mainGame, g, state);
		} catch (SlickException e) {

			e.printStackTrace();
		}

	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {

		super.render(gc, mainGame, g, stateRes);
		renderDiffGfx(gc, mainGame, g, stateRes);
	}

}