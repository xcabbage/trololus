package game.core.states;

import game.core.Trololus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FifthState extends BasicState{

	public static int ID = 4;
	float glowF;
	int glow;

	public int getID() {
		return ID;
	}
@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
System.out.println("INIT 4 LOL?");
	//		super.init(gc, game);
		}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();

		if (input.isKeyDown(46)) {
			System.out.println("aldkjasdjsald[source: Main]");
			game.enterState(1);
		}
		if (input.isKeyDown(1)) {
			System.out.println("Shutting Down.. [command: Main]");
			System.exit(0);
		}
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
//			super.render(gc,mainGame,g);
}}