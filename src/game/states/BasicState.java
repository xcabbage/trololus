package game.states;

import java.awt.Dimension;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BasicState extends BasicGameState {
	public StateBasedGame game;
	game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	Dimension res;

	Image background, menubar, buttonSpriteSheet;
	String menu1, menu2, menu3;
	String S_ingame, S_loading, S_title, S_postgame;
	SpriteSheet menuButtons, menuButtonsScaled;
	float menuScale = 1;

	public void drawMenu(int hover, Graphics g) {
		for (int a = 0; a < 6; a++) {
		menuButtons.drawCentered(a, a);

		
//		menuButtonsScaled.drawCentered(a, a);
		}
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		this.game = game;
		
		
		//init images and spritesheets
		background = new Image("/resources/Splash/UI/menu.png");
		menubar = new Image("resources/Splash/UI/Menubar_Back.png");
		
		buttonSpriteSheet= new Image("resources/Splash/UI/Menubar_Spritesheet.png");
		
		menuScale =(float) ((game.getContainer().getWidth()/(float)buttonSpriteSheet.getWidth())*.75);
		
		buttonSpriteSheet= buttonSpriteSheet.getScaledCopy(menuScale);	
		System.out.println(500*menuScale);
		menuButtons = new SpriteSheet(buttonSpriteSheet,(int) (500*menuScale), (int) (500*menuScale));
		
		// initialize strings
		menu1 = "the MENU phase";
		S_ingame = "INGAME";
		S_loading = "The Game is loading! woooo";
		S_title = "TROLOLUS NIGHTLY BUILD 0,0";
		S_postgame = "The after game lobby.";

		
		System.out.println("Init formula for state ID " + this.getID()
				+ " completed.");

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

	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
