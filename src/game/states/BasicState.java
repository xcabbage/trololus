package game.states;

//import game.util.MouseOverAreaDav;

import java.awt.Dimension;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.math.*;

public class BasicState extends BasicGameState {
	// declare globals
	StateBasedGame game;
	game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	Dimension res;
	GameContainer app;
	public Circle[] buttonHoverCircle = new Circle[10];
	public MouseOverArea[] button = new MouseOverArea[10];

	// declare graphics
	Image background, menubar, buttonSpriteSheet;
	String S_ingame, S_loading, S_title, S_postgame, menu1, menu2, menu3;
	SpriteSheet menuButtons, menuButtonsScaled;

	// declare gFx constants
	float menuScale, backgroundScale;
	int menuBarWidth, menuBarHeight, appWidth, appHeight, menuOffset, menuX,
			menuY, buttonsX, buttonsY, buttonsOffset, backgroundY, buttonDist,
			buttonRadius, buttonsGetY, buttonsSafeY;

	public void initRes() throws SlickException {
		buttonSpriteSheet = new Image(
				"resources/Splash/UI/Menubar_Spritesheet.png");
		appWidth = app.getWidth();
		appHeight = app.getHeight();
		menuScale = (float) ((appWidth / (float) buttonSpriteSheet.getWidth()) * .75);
		menuBarWidth = (int) (menubar.getWidth() * menuScale);
		menuBarHeight = (int) (menubar.getHeight() * menuScale);
		menuOffset = (appWidth - menuBarWidth) / 2;
		buttonSpriteSheet = buttonSpriteSheet.getScaledCopy(menuScale);
		menuButtons = new SpriteSheet(buttonSpriteSheet,
				(int) (500 * menuScale), (int) (500 * menuScale));
		menuX = appWidth - menuBarWidth - menuOffset;
		menuY = appHeight - menuBarHeight;
		buttonsX = (int) (menuX + 600 * menuScale);
		buttonsY = (int) (((appHeight - (120 * menuScale) - 135 * menuScale)));
		buttonRadius = (int) (135 * menuScale);
		buttonsGetY = appHeight - (buttonsY - buttonRadius);
		buttonsOffset = (int) (500 * menuScale);
		backgroundY = (int) (appHeight * .06);
		backgroundScale = (float) appWidth / background.getWidth();
		buttonsSafeY = appHeight / 2;

		for (int a = 0; a < menuButtons.getHorizontalCount(); a++) {
			button[a] = new MouseOverArea(app, menuButtons.getSprite(a, 0),(buttonsX + buttonsOffset * a) - buttonRadius * 2 + 5,buttonsY - buttonRadius * 2 + 5);
//			buttonHoverCircle[a] = new Circle(buttonsX + buttonsOffset * a, buttonsY, buttonRadius);
//			button[a] = new MouseOverArea(app, menuButtons.getSprite(a, 0), buttonHoverCircle[a]);
			button[a].setMouseOverImage(menuButtons.getSprite(a, 1));
			System.out.println("registering " + a + " done.");
		}

		System.out.println("Graphics successfully (re)initiated for state ID "
				+ this.getID());
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {

		// init globals
		this.game = game;
		app = gc;

		// init images and spritesheets
		background = new Image("/resources/Splash/UI/menu.png");
		menubar = new Image("resources/Splash/UI/Menubar_Back.png");
		buttonSpriteSheet = new Image(
				"resources/Splash/UI/Menubar_Spritesheet.png");
		menuButtons = new SpriteSheet(buttonSpriteSheet, (int) (500),
				(int) (500));

		// init scaling
		initRes();

		// scaled images

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
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	public void drawMenu(int hover, Graphics g) {
		menubar.draw(menuX, menuY, menuScale);

		for (int a = 0; a < 7; a++) {
//			g.draw(buttonHoverCircle[a]);
			
			button[a].render(app, g);

		}
		//
		// }
	}

	public int isOverButton(int x, int y) {
		int returnButton = 0;
		y = y + (buttonsGetY / 2);

		for (int a = -1; a <= menuButtons.getHorizontalCount(); a++) {
			int square_dist = (x - (buttonsX + (buttonsOffset * (a + 1))))
					* (x - (buttonsX + (buttonsOffset * (a + 1))))
					+ (y - buttonsGetY) * (y - buttonsGetY);
			if (square_dist <= (buttonRadius * buttonRadius)) {
				if (y < buttonsSafeY) {

					returnButton = a;

				}

			}

		}

		returnButton++;
		return returnButton;

	}

	@Override
	public int getID() {

		return 0;
	}

}
