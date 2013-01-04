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
public class MenuState extends BasicGameState {
	public static final int ID = 2;

	private StateBasedGame game;

	public int getID() {
		return ID;
	}

	String menu1, menu2, menu3;
	String S_ingame, S_loading, S_title, S_postgame;
	public Image background;
	public boolean init = false;

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		background = new Image("/resources/Splash/UI/menu2.png");
		this.game = game;

		// initialize strings
		menu1 = "MENU1";
		S_ingame = "INGAME";
		S_loading = "The Game is loading! woooo";
		S_title = "TROLOLUS NIGHTLY BUILD 0,0";
		S_postgame = "The after game lobby.";
		System.out.println("Init formula for MenuState ran and done.");
		init = true;
		
	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		if (input.isKeyDown(45)){System.out.println("Entering Main state. [source: Menu]");game.enterState(1);}
		if (input.isKeyDown(1)){System.out.println("Shutting Down.. [command: Menu]");System.exit(0);}
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {

//		if (!init) init(gc, game);
		background.draw(0, 0, (float) 0.5);
		
		g.drawString(menu1, 320, 20);
		;

	}
}
