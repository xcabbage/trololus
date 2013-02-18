package game.core.states;

import game.core.Trololus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FourthState extends BasicState {

	public static int ID = 3;
	float glowF;
	int glow;

	public int getID() {
		return ID;
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Fourth State - Garage";
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