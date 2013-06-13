// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Scanner;

import game.core.states.*;
import game.nonstatic.system.Pepta;
import game.util.PropertiesHandler;
import game.util.Util;

import org.lwjgl.input.Controllers;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Trololus extends StateBasedGame {
	// OVERRIDE SWITCH
	private static final boolean constantOverrideEnabled = true;
	// constants

	public static boolean optionsEnabled = false;
	private static boolean isVSyncEnabled = false;
	private static boolean ShowFPS = false;
	private static boolean DECORATED = false;

	private static float MUSIC_VOLUME = 0.05f;
	private static final String title = "Trololus NightBuild.0";

	public static float ShipScale = 0.1f;

	static public boolean drawing = true;
	static public AppGameContainer app;
	static public Dimension res;
	static boolean fullscreen = false;

	static game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	static BasicState activeState;
	static BasicState[] state;
	static BasicState resState;
	static NetworkTest pomocnik = new game.core.NetworkTest();
	static String[] icons = { "resources/Splash/EXEico/trololus_icon16.tga",
			"resources/Splash/EXEico/trololus_icon32.tga",
			"resources/Splash/EXEico/trololus_icon64.tga" };
	static Image cursor;
	static Input input;

	Scanner sc = new Scanner(System.in);

	// CONSTANTS
	static int width = 1000;
	static int height = 500;
	static int fpslimit = 30;

	static String MUSIC_PATH_INIT = "resources/Audio/BGM1_a.wav";
	static String MUSIC_PATH_LOOP = "resources/Audio/BGM4.wav";
	static String MUSIC_PATH_END = "resources/Audio/BGM5.wav";

	static boolean MUSIC_END_REQUESTED;

	// by Xargo
	// Useless crap I need to access from all states, dunno where else to put
	// diz
	public static float arrowX;
	public static float arrowY;
	public static float arrowXdest;

	// not by Xargo

	// ---------------------------------------------------MainMethod-&-Constructors----------------------------------------------------------------
	public Trololus(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException {

		try {
			loadProperties();

		} catch (IOException e) {
			System.out.println("Couldn't properly load properties");
			e.printStackTrace();
		}

		if (!DECORATED) {
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		}
		res = utilGfx.getRes();
		Pepta pepta = new Pepta();
		pepta.createPlayers();
		app = new AppGameContainer(new Trololus(title));
		cleanRes();
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.setVSync(isVSyncEnabled);
		app.setIcons(icons);
		app.setVerbose(false);
		app.setShowFPS(ShowFPS);

		// app.setMouseCursor(cursor, 5, 5);
		app.start();

	}

	// -------------------------------------------------------The-Game's-Methods-------------------------------------------------------------------

	private static void loadProperties() throws IOException {
		if (!constantOverrideEnabled) {
			PropertiesHandler.init();
			System.out.println("Properties handler initiated...");

			MUSIC_VOLUME = Float.parseFloat(PropertiesHandler
					.getProperty("musicvolume"));

			optionsEnabled = Boolean.parseBoolean(PropertiesHandler
					.getProperty("optionsEnabled"));
			isVSyncEnabled = Boolean.parseBoolean(PropertiesHandler
					.getProperty("vsyncEnabled"));
			ShowFPS = Boolean.parseBoolean(PropertiesHandler
					.getProperty("fpsEnabled"));
			DECORATED = Boolean.parseBoolean(PropertiesHandler
					.getProperty("windowDecorated"));
			ShipScale = Float.parseFloat(PropertiesHandler
					.getProperty("shipScale"));

			System.out.println("Properties successfully loaded.");
		} else {
			System.out
					.println("Manual override from source constants enabled. Disregarding properties.");
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		resState = new BasicState();
		resState.init(gc, this);
		resState.initVars();
		Util.init(BasicState.game);

		addState(new FirstState());
		addState(new SecondState());
		addState(new ThirdState());
		addState(new FourthState());
		addState(new FifthState());
		addState(new SixthState());

		initAfterStates();

	}

	static void initControllers() throws SlickException {
		input.initControllers();
		if (input.getControllerCount() > 0) {
			input.addControllerListener(new ControllerListener() {

				@Override
				public void setInput(Input input) {

				}

				@Override
				public boolean isAcceptingInput() {

					return false;
				}

				@Override
				public void inputStarted() {

				}

				@Override
				public void inputEnded() {

				}

				@Override
				public void controllerUpReleased(int controller) {

				}

				@Override
				public void controllerUpPressed(int controller) {
					System.out.println("Controller up pressed");

				}

				@Override
				public void controllerRightReleased(int controller) {

				}

				@Override
				public void controllerRightPressed(int controller) {

				}

				@Override
				public void controllerLeftReleased(int controller) {

				}

				@Override
				public void controllerLeftPressed(int controller) {

				}

				@Override
				public void controllerDownReleased(int controller) {

				}

				@Override
				public void controllerDownPressed(int controller) {

				}

				@Override
				public void controllerButtonReleased(int controller, int button) {

				}

				@Override
				public void controllerButtonPressed(int controller, int button) {
					System.out.println("button pressed");

				}
			});

			System.out.println(input.getControllerCount());
			System.out.println(Controllers.getController(0).getName());
			System.out.println(Controllers.getController(1).getName());
			System.out.println(Controllers.getController(2).getName());
			System.out.println(Controllers.getController(3).getName());
		} else
			System.out.println("No controllers found!");

	}

	void init() throws SlickException {
		cursor = new Image("resources/Splash/UI/mouse.png");
	}

	public static void initAfterStates() throws SlickException {

		// init sound;
		input = app.getInput();
		initControllers();
		Music musicStart = new Music(MUSIC_PATH_INIT);
		final Music musicLoop = new Music(MUSIC_PATH_LOOP);
		final Music musicEnd = new Music(MUSIC_PATH_END);
		musicStart.play();
		musicStart.setVolume(MUSIC_VOLUME);
		musicStart.addListener(new MusicListener() {

			@Override
			public void musicEnded(Music music) {
				musicLoop.play();
				musicLoop.setVolume(MUSIC_VOLUME);

			}

			@Override
			public void musicSwapped(Music music, Music newMusic) {
			}
		});
		musicLoop.addListener(new MusicListener() {

			@Override
			public void musicEnded(Music music) {

				if (!MUSIC_END_REQUESTED) {
					musicLoop.play();
					musicLoop.setVolume(MUSIC_VOLUME);
				} else {
					musicEnd.play();
					musicEnd.setVolume(MUSIC_VOLUME);
				}

			}

			@Override
			public void musicSwapped(Music music, Music newMusic) {
			}
		});
		musicEnd.addListener(new MusicListener() {

			@Override
			public void musicEnded(Music music) {
				System.exit(0);

			}

			@Override
			public void musicSwapped(Music music, Music newMusic) {
			}
		});
	}

	public static void cleanRes() throws SlickException {
		app.setDisplayMode((int) (res.width * .75), (int) (res.height * .75),
				fullscreen);
	}

	public BasicState getResState() {
		return resState;
	}

	// ---------------------------------------------------Keyboard-&-Mouse-Listeners---------------------------------------------------------------
	@Override
	/**
	 * @see org.newdawn.slick.state.StateBasedGame#keyPressed(int, char)
	 */
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);
		switch (key) {

		case Input.KEY_F4: {

			try {

				drawing = false;

				if (!app.isFullscreen()) {

					Util.printDebug("Entering FullScreen mode.");
					app.setDisplayMode(utilGfx.getRes().width,
							utilGfx.getRes().height, true);

				} else {
					Util.printDebug("Returning from fullscreen.");
					app.setFullscreen(false);
					cleanRes();

				}

				resState.initRes();
				for (int a = 0; a < getStateCount(); a++) {
					((BasicState) getState(a)).rescale();
				}

				drawing = true;
			} catch (SlickException e) {
				e.printStackTrace();
			}
			break;
		}

		case Input.KEY_LALT: {
			Util.printErr("debug Error");
			break;
		}

		}
	}

	@SuppressWarnings("unused")
	@Override
	public void mousePressed(int button, int x, int y) {
		BasicState state = (BasicState) getCurrentState();

		for (int a = 0; a < 7; a++)
			if (BasicState.button[a].isMouseOver()) {
				if (a < 6) {
					Util.printDebug("Entering " + a);
					try {
						getState(a).enter(app, this);
					} catch (SlickException e) {

						e.printStackTrace();
					}
					enterState(a, new FadeOutTransition(Color.black, 600),
							new FadeInTransition(Color.black, 600));

				} else if (a == 6)
					MUSIC_END_REQUESTED = true;
				else {
					System.out
							.println("There was a really weird error. You clicked on a nonexisting button, "
									+ a + " :O");
				}
			}

	}

	// -----------------------------------------The-Project's-TO-DO-repository-dump!---------------------------------------------------------------
	// TODO HP | Properties

	// TODO DH | Rest of ship models

	// TODO DK | Projectile system

	// TODO DP | Connection stream for BattleField sync
	// TODO DP | TextAreas (input) to set the IPs outside console?

	// TODO NC | DrawArea panel class for the text and shit
}
