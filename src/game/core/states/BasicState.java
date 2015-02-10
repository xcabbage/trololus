package game.core.states;

import game.core.Trololus;
import game.core.parts.Component;
import game.core.parts.MouseOverAreaDav;
import game.core.parts.StateBuilder;
import game.util.PropertiesHandler;
import game.util.Util;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * The BasicState.java class defining the base state of the game's UI and logic.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       6.2.2013 9:55:02
 */
public class BasicState extends BasicGameState {
	// CONSTANTS

	public static String fontGreatHeader = "Basica v.2012";
	public static String fontNormalHeader = "Cambria";
	public static String fontEntry = "Complex";
	public static String fontText = "Orena";
	public static String fontButton = "Calibri";

	// declare globals
	public static StateBasedGame game;
	static game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	static Dimension res;
	static GameContainer app;
	public StateBuilder sb;
	static Input input;
	public static Circle[] buttonHoverCircle = new Circle[10];
	public static MouseOverAreaDav[] button = new MouseOverAreaDav[10];
	public static BasicState stateRes;
	boolean base_UI_disabled = false;

	static Music music;

	// declare graphics
	static Image arrow, menubar, buttonSpriteSheet, background;
	public Image backgroundBack;
	public String StateTitle;
	public static SpriteSheet menuButtons, menuButtonsScaled, menuButtonsDown,
			controllerSpriteSheet;
	public int ID;
	boolean inited;

	// declare gFx variables
	public static boolean gFxInited = false;
	public float menuScale, backgroundScale;
	public static int menuBarWidth, menuBarHeight, appWidth, appHeight,
			menuOffset, menuX, menuY, buttonsX, buttonsY, buttonsOffset,
			backgroundY, buttonDist, buttonRadius, buttonsGetY, buttonsSafeY;
	private boolean stateTitleEnabled;
	public boolean driftRequested;

	// COMPONENTS PART
	// Components (unique to each state
	List<Component> components;

	// Component register code
	public void addComponent(Component component) {

		components.add(component);

	}

	public static void drawControllers() {
		/*
		 * controllerSpriteSheet for (int a = 0; a < 9; a++) {
		 * controllerSpriteSheet.getSprite(a, 0).draw(50, 50+(100*a)); }
		 */
	}

	public void initRes() throws SlickException {
		Util.initFonts();
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
		controllerSpriteSheet = new SpriteSheet(
				new Image("resources/parts/game/controllerIconSpritesheet.png")
						.getScaledCopy(menuScale),
				(int) (322 * menuScale), (int) (322 * menuScale));

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

		arrow = new Image("resources/Splash/UI/pointerArrow.png");

		for (int a = 0; a < menuButtons.getHorizontalCount(); a++) {
			button[a] = new MouseOverAreaDav(app, menuButtons.getSprite(a, 0),
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

	public void createContent(GameContainer gc, StateBasedGame game)
			throws SlickException {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {

		// init globals
		components = new ArrayList<Component>();
		BasicState.game = game;
		app = gc;
		if (this.getID() >= 0)
			stateRes = ((Trololus) game).getResState();
		sb = new StateBuilder((AppGameContainer) gc);
		input = Trololus.app.getInput();
		System.out.println("Init formula for state ID " + this.getID()
				+ " completed and stateRes set.");
		reloadProperties();

	}

	@Override
	public void enter(GameContainer gc, StateBasedGame game) {

		if (!inited)
			try {
				initDiffGfx();
				createContent(gc, game);
				inited = true;
			} catch (SlickException e) {

				e.printStackTrace();
			}

	}

	void reloadProperties() {
		if (Trololus.optionsEnabled) {
			// load from properties
			fontGreatHeader = PropertiesHandler.getProperty("fontGreatHeader");
			fontNormalHeader = PropertiesHandler
					.getProperty("fontNormalHeader");
			fontEntry = PropertiesHandler.getProperty("fontEntry");
			fontText = PropertiesHandler.getProperty("fontText");
		}

	}

	void initDiffGfx() throws SlickException {
		String bgPath = "resources/Splash/UI/BG_Split/Menu_"
				+ (this.getID() + 1) + ".png";
		backgroundBack = new Image(bgPath);
	}

	void renderDiffGfx(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) throws SlickException {
		sb.drawComponents(g);

		// Draw components
		for (Component c : components) {
			c.render();
		}
	}

	public void initVars() throws SlickException {
		// init images and spritesheets

		background = new Image("/resources/Splash/UI/BG_Split/Menu_Front.png");

		menubar = new Image("resources/Splash/UI/Menubar_Back.png");
		buttonSpriteSheet = new Image(
				"resources/Splash/UI/Menubar_Spritesheet.png");
		menuButtons = new SpriteSheet(buttonSpriteSheet, (500), (500));

		// init scaling
		initRes();

		// initialize strings
		StateTitle = "A Newly created state :)";
	}

	@Override
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		input = gc.getInput();

		if (input.isKeyDown(1)) {
			System.out.println("Shutting Down.. [command: " + ID + ".]");
			System.exit(0);

		}

		// Update components
		for (Component c : components) {
			c.update();
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		if (gFxInited) {
			if (Trololus.drawing) {

				backgroundBack.draw(0, backgroundY, backgroundScale);
				background.draw(0, backgroundY, backgroundScale);
				if (stateTitleEnabled)
					g.drawString(StateTitle, 320, 20);
				drawMenu(g);
				drawControllers();

			}
		} else {

			render(gc, mainGame, g);
		}

	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) throws SlickException {

		if (Trololus.drawing) {
			backgroundBack.draw(0, BasicState.backgroundY,
					state.backgroundScale);
			BasicState.background.draw(0, BasicState.backgroundY,
					state.backgroundScale);
			if (stateTitleEnabled)
				g.drawString(StateTitle, 320, 20);
			if (!this.base_UI_disabled) {
				drawMenu(g, state);
			}
			renderDiffGfx(gc, mainGame, g, stateRes);
			drawControllers();
		}

	}

	public static void drawMenu(Graphics g, BasicState state) {
		BasicState.menubar.draw(BasicState.menuX, BasicState.menuY,
				state.menuScale);

		for (int a = 0; a < 7; a++) {
			BasicState.button[a].render(app, g);

		}

		Trololus.arrowXdest = BasicState.buttonsX + buttonsOffset
				* (game.getCurrentStateID()) - (buttonRadius / 2 + 7);

		Trololus.arrowX = Trololus.arrowX
				- (Trololus.arrowX - Trololus.arrowXdest) / 7;

		Trololus.arrowY = BasicState.buttonsY - (buttonRadius * 2 + 20);

		arrow.draw(Trololus.arrowX, Trololus.arrowY);
		/*
		 * BasicState.buttonsX + buttonsOffset (game.getCurrentStateID()) -
		 * (buttonRadius / 2 + 7), BasicState.buttonsY - (buttonRadius * 2 +
		 * 20));
		 */

	}

	public void drawMenu(Graphics g) {
		BasicState.menubar.draw(menuX, menuY, menuScale);

		for (int a = 0; a < 7; a++) {
			button[a].render(app, g);

		}

	}

	public void rescale() {
		sb.rescale();
		System.out.println("rescaled successfully " + this.ID);
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

	// STATE SWITCHING BASED ON KEY PRESSES
	@Override
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		switch (key) {

		case Input.KEY_1:
		case Input.KEY_NUMPAD1: {
			try {
				game.getState(0).enter(app, game);
			} catch (SlickException e) {

				e.printStackTrace();
			}
			game.enterState(0, new FadeOutTransition(Color.black, 600),
					new FadeInTransition(Color.black, 600));

			break;
		}
		case Input.KEY_2:
		case Input.KEY_NUMPAD2: {
			try {
				game.getState(1).enter(app, game);
			} catch (SlickException e) {

				e.printStackTrace();
			}
			game.enterState(1, new FadeOutTransition(Color.black, 600),
					new FadeInTransition(Color.black, 600));

			break;
		}
		case Input.KEY_3:
		case Input.KEY_NUMPAD3: {
			try {
				game.getState(2).enter(app, game);
			} catch (SlickException e) {

				e.printStackTrace();
			}
			game.enterState(2, new FadeOutTransition(Color.black, 600),
					new FadeInTransition(Color.black, 600));

			break;
		}
		case Input.KEY_4:
		case Input.KEY_NUMPAD4: {
			try {
				game.getState(3).enter(app, game);
			} catch (SlickException e) {

				e.printStackTrace();
			}
			game.enterState(3, new FadeOutTransition(Color.black, 600),
					new FadeInTransition(Color.black, 600));

			break;
		}
		case Input.KEY_5:
		case Input.KEY_NUMPAD5: {
			try {
				game.getState(4).enter(app, game);
			} catch (SlickException e) {

				e.printStackTrace();
			}
			game.enterState(4, new FadeOutTransition(Color.black, 600),
					new FadeInTransition(Color.black, 600));

			break;
		}
		case Input.KEY_6:
		case Input.KEY_NUMPAD6: {
			try {
				game.getState(5).enter(app, game);
			} catch (SlickException e) {

				e.printStackTrace();
			}
			game.enterState(5, new FadeOutTransition(Color.black, 600),
					new FadeInTransition(Color.black, 600));

			break;
		}

		default: {
			break;
		}
		}

	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		for (Component c : components) {
			c.mouseClicked(button, x, y, clickCount);
		}
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		for (Component c : components) {
			c.mousePressed(button, x, y);
		}
	}
}