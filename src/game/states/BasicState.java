package game.states;

import java.awt.Dimension;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BasicState extends BasicGameState {
	public StateBasedGame game;
	game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	Dimension res;
	public static final int ID = 0;
	public int getID() {
		return ID;
}

	public Image background, menubar;
	String menu1, menu2, menu3;
	String S_ingame, S_loading, S_title, S_postgame;
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		background = new Image("/resources/Splash/UI/menu.png");
		menubar = new Image("resources/Splash/UI/Menubar_Placeholder.png");
		this.game = game;

		// initialize strings
		menu1 = "the MENU phase";
		S_ingame = "INGAME";
		S_loading = "The Game is loading! woooo";
		S_title = "TROLOLUS NIGHTLY BUILD 0,0";
		S_postgame = "The after game lobby.";
		System.out.println("Init formula for MenuState ran and done.");

		
	}


	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	 
	 
}
