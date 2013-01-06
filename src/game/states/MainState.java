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
	


	String menu1, menu2, menu3;
	String S_ingame, S_loading, S_title, S_postgame;
	public Image background, menubar;

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		menubar = new Image("resources/Splash/UI/Menubar_Placeholder.png");
		background = new Image("/resources/Splash/UI/menu2.png");		 
		this.game = game;

		// initialize strings
		menu1 = "MENU1";
		S_ingame = "INGAME";
		S_loading = "The Game is loading! woooo";
		S_title = "TROLOLUS NIGHTLY BUILD 0.001/2 :D - Main state";
		
		System.out.println("Init formula for MainState ran and done.");
	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)throws SlickException {
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		if (input.isKeyDown(46)){System.out.println("Entering Menu state. [source: Main]");game.enterState(2);}
		if (input.isKeyDown(1)){System.out.println("Shutting Down.. [command: Main]");System.exit(0);}	
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {


		background.draw(0, (int) (game.getContainer().getHeight()*.06),(float) 1/( ((float) background.getWidth())/(float) (game.getContainer().getWidth())));
		menubar.draw ((int)(((game.getContainer().getWidth())/2)-((menubar.getWidth()*0.075))),(int) ((game.getContainer().getHeight())-menubar.getHeight()*.15),(float)0.15);
		g.drawString(S_title, 320, 20);
		

	}
}
