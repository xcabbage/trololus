// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core;

import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import game.core.states.*;
import game.nonstatic.system.Pepta;
import game.util.PropertiesHandler;
import game.util.Util;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Trololus extends StateBasedGame {

	
	public static final boolean optionsEnabled = false;
	
	
	
	
	
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
	Scanner sc = new Scanner(System.in);

	// CONSTANTS
	static int width = 1000;
	static int height = 500;
	static int fpslimit = 30;
	static boolean ShowFPS = false;

	public static final float ShipScale = 0.1f;

	static String title = "Trololus NightBuild.0";
	static String MUSIC_PATH_INIT = "resources/Audio/BGM1_a.wav";
	static String MUSIC_PATH_LOOP = "resources/Audio/BGM4.wav";
	static String MUSIC_PATH_END = "resources/Audio/BGM5.wav";
	static float MUSIC_VOLUME = 0.05f;
	static boolean MUSIC_END_REQUESTED;

	// ---------------------------------------------------MainMethod-&-Constructors----------------------------------------------------------------
	public Trololus(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException {
		
/*		try {
			PropertiesHandler.init();
			MUSIC_VOLUME = Float.parseFloat(PropertiesHandler.getProperty("musicvolume"));
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}*/
	
		res = utilGfx.getRes();
		Pepta pepta = new Pepta();
		pepta.createPlayers();
		app = new AppGameContainer(new Trololus(title));
		cleanRes();
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.setVSync(false);
		app.setIcons(icons);
		app.setVerbose(false);
		app.setShowFPS(ShowFPS);
		// app.setMouseCursor(cursor, 5, 5);
		app.start();

	}

	// -------------------------------------------------------The-Game's-Methods-------------------------------------------------------------------
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {

		resState = new BasicState();
		resState.init(gc, this);
		resState.initVars();
		Util.init(resState.game);

		addState(new FirstState());
		addState(new SecondState());
		addState(new ThirdState());
		addState(new FourthState());
		addState(new FifthState());
		addState(new SixthState());

		initAfterStates();

	}

	void init() throws SlickException {
		cursor = new Image("resources/Splash/UI/mouse.png");
	}

	public static void initAfterStates() throws SlickException {
		// init the utility class

		// init sound;

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

	public void mousePressed(int button, int x, int y) {
		BasicState state = (BasicState) getCurrentState();

		for (int a = 0; a < 7; a++)
			if (state.stateRes.button[a].isMouseOver()) {
				if (a < 6) {
					Util.printDebug("entering " + a);

			        enterState(a, new FadeOutTransition(Color.black, 600), new FadeInTransition(Color.black, 600) );
					
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
	// TODO DK | Ships rendering img based on their type

	// TODO DP | Connection stream for BattleField sync
	// TODO DP | TextAreas (input) to set the IPs outside console?

	// TODO NC | DrawArea panel class for the text and shit
}
