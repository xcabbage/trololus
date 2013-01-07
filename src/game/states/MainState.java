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

	public static int ID = 1;

	public int getID() {
		return ID;
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		background = new Image("/resources/Splash/UI/menu2.png");
	}
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		//boolean ButtonHoverRender[x] normalne false vsechno.
		//For - If loop, projede lokace kde by ta mys mela bejt aby nad necim hoverovala, pokud nekde tam bude, nastavi ten boolean na true
		//vsechny ostatni da zase false
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
		//for loop kterej projede jestli nekterej z tech booleanu je True, pokud jo, vyrenderuje ten hover na jeho miste.
		//je v tom docela dost matiky s pozicema, hodne stesti! :D
		background.draw(
				0,
				(int) (game.getContainer().getHeight() * .06),
				(float) 1
						/ (((float) background.getWidth()) / (float) (game
								.getContainer().getWidth())));
		drawMenu(1,g);
		g.drawString(S_title, 320, 20);

	}
}
