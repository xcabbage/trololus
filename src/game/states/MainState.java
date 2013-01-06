// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

/**
 * 
 */
package game.states;

import java.awt.Dimension;
import java.nio.file.Path;

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
public class MainState extends BasicState {
	public static final int ID = 1;
	
	

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		if (input.isKeyDown(46)) {
			System.out.println("Entering Menu state. [source: Main]");
			game.enterState(2);
		}
		if (input.isKeyDown(1)) {
			System.out.println("Shutting Down.. [command: Main]");
			System.exit(0);
		}
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {

		background.draw(
				0,
				(int) (mainGame.getContainer().getHeight() * .06),
				(float) 1
						/ (((float) 2000.0) / (float) (mainGame
								.getContainer().getWidth())));
		menubar.draw(
				(int) (((mainGame.getContainer().getWidth()) / 2) - ((menubar
						.getWidth() * 0.075))),
				(int) ((mainGame.getContainer().getHeight()) - menubar.getHeight() * .15),
				(float) 0.15);
//		g.drawString(S_title, 320, 20);

	}
}
