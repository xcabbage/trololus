package game.core.states;

import game.core.Trololus;
import game.core.parts.StateBuilder;

import java.awt.Dimension;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The BasicState.java class defining the base state of the game's UI.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       6.2.2013 9:55:02
 */
public class BasicState extends BasicGameState {
	// declare globals
	public StateBasedGame game;
	game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	Dimension res;
	GameContainer app;
	public	StateBuilder sb;
	Input input;
	public Circle[] buttonHoverCircle = new Circle[10];
	public MouseOverArea[] button = new MouseOverArea[10];
	public BasicState stateRes;

	Music music;
	// declare graphics
	public Image backgroundBack, menubar, buttonSpriteSheet, background;
	public String S_ingame, S_loading, S_title, S_postgame, menu1, menu2,
			menu3, StateTitle;
	public SpriteSheet menuButtons, menuButtonsScaled, menuButtonsDown;
	public int ID;

	// declare gFx constants
	public boolean gFxInited = false;
	public float menuScale, backgroundScale;
	public int menuBarWidth, menuBarHeight, appWidth, appHeight, menuOffset,
			menuX, menuY, buttonsX, buttonsY, buttonsOffset, backgroundY,
			buttonDist, buttonRadius, buttonsGetY, buttonsSafeY;
	private boolean stateTitleEnabled;
	public boolean driftRequested;

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
			button[a] = new MouseOverArea(app, menuButtons.getSprite(a, 0),
					(buttonsX + buttonsOffset * a) - buttonRadius * 2 + 5,
					buttonsY - buttonRadius * 2 + 5);
			button[a].setMouseOverImage(menuButtons.getSprite(a, 1));
			button[a].setMouseDownImage(menuButtons.getSprite(a, 2));
			button[a].setMouseOverSound(new Sound(
					"resources/Audio/UI/mouseover_click.wav"));
			button[a].setMouseDownSound(new Sound(
					"resources/Audio/UI/hard_click.wav"));

		}
		gFxInited = true;
		System.out.println("Graphics successfully (re)initiated for state ID "
				+ this.getID());
	}

	public void createContent() throws SlickException{
		
	}
	
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {

		// init globals
		this.game = game;
		app = gc;
		if (this.getID() >= 0)
			stateRes = ((Trololus) game).getResState();
		sb = new StateBuilder((AppGameContainer) gc);
		initDiffGfx();
		System.out.println("Init formula for state ID " + this.getID()
				+ " completed and stateRes set.");
		createContent();

	}

	void initDiffGfx() throws SlickException {
		String bgPath = "resources/Splash/UI/BG_Split/Menu_"
				+ (this.getID() + 1) + ".png";
		backgroundBack = new Image(bgPath);
	}

	void renderDiffGfx(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) throws SlickException {
		sb.drawComponents(g);
	}

	public void initVars() throws SlickException {
		// init images and spritesheets

		background = new Image("/resources/Splash/UI/BG_Split/Menu_Front.png");

		menubar = new Image("resources/Splash/UI/Menubar_Back.png");
		buttonSpriteSheet = new Image(
				"resources/Splash/UI/Menubar_Spritesheet.png");
		menuButtons = new SpriteSheet(buttonSpriteSheet, (int) (500),
				(int) (500));

		// init scaling
		initRes();

		// initialize strings
		StateTitle = "A Newly created state :)";
		menu1 = "the MENU phase";
		S_ingame = "INGAME";
		S_loading = "The Game is loading! woooo";
		S_title = "TROLOLUS NIGHTLY BUILD 0,0";
		S_postgame = "The after game lobby.";
	}

	@Override
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		input = gc.getInput();

		if (input.isKeyDown(1)) {
			System.out.println("Shutting Down.. [command: " + ID + ".]");
			System.exit(0);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		if (gFxInited) {
			if (Trololus.drawing) {

				backgroundBack.draw(0, backgroundY, backgroundScale);
				background.draw(0, backgroundY, backgroundScale);
				if (stateTitleEnabled) g.drawString(StateTitle, 320, 20);
				drawMenu(g);
			}
		} else {

			render(gc, mainGame, g);
		}

	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g, BasicState state)
			throws SlickException {

		if (Trololus.drawing) {
			backgroundBack.draw(0, state.backgroundY, state.backgroundScale);
			state.background.draw(0, state.backgroundY, state.backgroundScale);
			if (stateTitleEnabled) g.drawString(StateTitle, 320, 20);
			drawMenu(g, state);
			renderDiffGfx(gc, mainGame, g, stateRes);
		}

	}

	public void drawMenu(Graphics g, BasicState state) {
		state.menubar.draw(state.menuX, state.menuY, state.menuScale);

		for (int a = 0; a < 7; a++) {
			state.button[a].render(app, g);

		}

	}

	public void drawMenu(Graphics g) {
		this.menubar.draw(menuX, menuY, menuScale);

		for (int a = 0; a < 7; a++) {
			button[a].render(app, g);

		}

	}

	public void rescale(){
		sb.rescale();
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
