// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

/**
 * 
 */
package game.core.states;

import game.core.Trololus;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author David
 * 
 */
public class SecondState extends BasicState {
	public static final int ID = 1;
	float glowF;
	int glow;

	
	public int getID() {
		return ID;
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Second state - Connect to another game";
	}
	
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		if (input.isKeyDown(45)) {
			System.out.println("Entering Main state. [source: Menu]");
			game.enterState(0);
		}
		if (input.isKeyDown(1)) {
			System.out.println("Shutting Down.. [command: Menu]");
			System.exit(0);
		}
		if (input.isKeyDown(47)) {
			System.out.println("Shutting Down.. [command: Menu]");
			;
		}

	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		renderDiffGfx(gc, mainGame, g, stateRes);
super.render(gc,mainGame,g,stateRes);
	}
	
	
}
