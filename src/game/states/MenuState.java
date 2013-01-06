// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

/**
 * 
 */
package game.states;

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
public class MenuState extends BasicState {
	public static final int ID = 2;

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		if (input.isKeyDown(45)){System.out.println("Entering Main state. [source: Menu]");game.enterState(1);}
		if (input.isKeyDown(1)){System.out.println("Shutting Down.. [command: Menu]");System.exit(0);}
		if (input.isKeyDown(47)){System.out.println("Shutting Down.. [command: Menu]");;}

	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {


//		background.draw(0, (int) (game.getContainer().getHeight()*.06),(float) 1/( ((float) background.getWidth())/(float) (game.getContainer().getWidth())));
//		
//		menubar.draw ((int)(((game.getContainer().getWidth())/2)-((menubar.getWidth()*0.125))),(int) ((game.getContainer().getHeight())-menubar.getHeight()*.25),(float)0.25);
//		g.drawString(menu1, 320, 20);
		;

	}
}
