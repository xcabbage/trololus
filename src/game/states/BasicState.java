package game.states;

import java.awt.Dimension;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BasicState extends BasicGameState {
	//declare globals
	StateBasedGame game;
	game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	Dimension res;
	GameContainer app;
	
	//declare graphics
	Image background, menubar, buttonSpriteSheet;
	String S_ingame, S_loading, S_title, S_postgame,menu1, menu2, menu3;
	SpriteSheet menuButtons, menuButtonsScaled;
	
	//declare gFx constants
	float menuScale;
	int menuBarWidth, menuBarHeight, appWidth, appHeight, menuOffset, menuX, menuY; 
	
	
	
	public void initRes() throws SlickException{
		buttonSpriteSheet= new Image("resources/Splash/UI/Menubar_Spritesheet.png");
		appWidth = app.getWidth();
		appHeight = app.getHeight();
		menuScale =(float) ((appWidth/(float)buttonSpriteSheet.getWidth())*.75);
		menuBarWidth = (int) (menubar.getWidth()*menuScale);
		menuBarHeight = (int)(menubar.getHeight()*menuScale);
		menuOffset = (appWidth-menuBarWidth)/2;
		menuX = appWidth-menuBarWidth-menuOffset;
		menuY = appHeight-menuBarHeight;
		
	}
	
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		
		//init globals
		this.game = game;
		app = gc;
		
		//init images and spritesheets
		background = new Image("/resources/Splash/UI/menu.png");
		menubar = new Image("resources/Splash/UI/Menubar_Back.png");
		
		
		//init scaling
		initRes();
		
		//scaled images
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
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}
	
//TODO move the variables and computations into init. optimalization :)
	public void drawMenu(int hover, Graphics g) {
			menubar.draw(menuX, menuY, menuScale);
System.out.println(menuX + "| " + menuY + "| " + menuScale);
			for (int a = 0; a < 7; a++) {
				if (a != hover){
			menuButtons.getSprite(a, 2).drawCentered(400+(65*a), (int) (game.getContainer().getHeight() * .86));
				} else {
			menuButtons.getSprite(a, 1).drawCentered(400+(65*a), (int) (game.getContainer().getHeight() * .86));
				}
			

			}
		}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
