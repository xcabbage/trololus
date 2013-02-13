// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Scanner;

import game.core.states.*;
import game.nonstatic.system.Pepta;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Trololus extends StateBasedGame {
	static public boolean drawing = true;
	static public AppGameContainer app;
	static public Dimension res;
	static boolean fullscreen = false;
	static boolean ShowFPS = false;
	static game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	static int width = 1000;
	static int height = 500;
	static int fpslimit = 60;
	static String title = "Trololus NightBuild.0";
	static BasicState activeState;
	static BasicState[] state;
	static BasicState resState;
	static NetworkTest pomocnik = new game.core.NetworkTest();
	static String[] icons = { "resources/Splash/EXEico/trololus_icon16.tga",
			"resources/Splash/EXEico/trololus_icon32.tga",
			"resources/Splash/EXEico/trololus_icon64.tga" };
	Scanner sc = new Scanner(System.in);

	static String MUSIC_PATH_INIT = "resources/Audio/BGM1_a.wav";
	static String MUSIC_PATH_LOOP = "resources/Audio/BGM4.wav";
	static String MUSIC_PATH_END = "resources/Audio/BGM5.wav";
	static float MUSIC_VOLUME = 0.18f;
	static boolean MUSIC_END_REQUESTED;
	
	

	
	// ---------------------------------------------------MainMethod-&-Constructors----------------------------------------------------------------
	public Trololus(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException {
		res = utilGfx.getRes();
		Pepta pepta = new Pepta();
		pepta.createPlayers();
		app = new AppGameContainer(new Trololus(title));
		cleanRes();
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.setVSync(true);
		app.setIcons(icons);
		app.start();

	}

	// -------------------------------------------------------The-Game's-Methods-------------------------------------------------------------------
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		
		resState = new BasicState();
			resState.init(gc, this);
			resState.initVars();
		
		addState(new FirstState());
		addState(new SecondState());
		addState(new ThirdState());
		addState(new FourthState());
		addState(new FifthState());
		addState(new SixthState());
		
		initAfterStates();

	}

	public static void initAfterStates() throws SlickException {
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
				// TODO Auto-generated method stub

			}
		});
		musicLoop.addListener(new MusicListener() {

			@Override
			public void musicEnded(Music music) {
				
				if (!MUSIC_END_REQUESTED) {
					System.out.println("looping?");
					musicLoop.play();
					musicLoop.setVolume(MUSIC_VOLUME);
				} else {
					musicEnd.play();
					musicLoop.setVolume(MUSIC_VOLUME);
				}
				
			}

			@Override
			public void musicSwapped(Music music, Music newMusic) {
				// TODO Auto-generated method stub

			}
		});
		musicEnd.addListener(new MusicListener() {

			@Override
			public void musicEnded(Music music) {
				System.exit(0);
				
			}

			@Override
			public void musicSwapped(Music music, Music newMusic) {
				// TODO Auto-generated method stub

			}
		});
	}

	public static void cleanRes() throws SlickException {
		app.setDisplayMode((int) (res.width * .75), (int) (res.height * .75),
				fullscreen);
	}
	
	public BasicState getResState(){
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
		case Input.KEY_I:
			if (pomocnik.testSocket == null) {
				System.out.println("Waiting for host input");
				String host = sc.nextLine();
				System.out.println("Waiting for port input");
				int port = sc.nextInt();
				pomocnik.connect(host, port);
				break;
			} else {
				try {
					pomocnik.terminate();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		case Input.KEY_O:
			if (pomocnik != null) {
				System.out.println("Waiting for message input");
				String msg = sc.nextLine();
				pomocnik.sendMsg(msg);
				break;
			}
		case Input.KEY_P:
			if (pomocnik != null) {
				pomocnik.setInMsg();
				break;
			}
		default:
			break;
		}
		if (key == Input.KEY_F4) {

			if (app != null) {
				drawing = false;
				try {

					if (!app.isFullscreen()) {

						System.out.println("Entering FullScreen mode.");
						app.setDisplayMode(utilGfx.getRes().width,
								utilGfx.getRes().height, true);

					} else {
						System.out.println("Returning from fullscreen.");
						app.setFullscreen(false);
						cleanRes();

					}
					for (int a = 0; a < this.getStateCount(); a++) {

						activeState = (BasicState) this.getState(a);
						activeState.initRes();
					}
				} catch (SlickException e) {
					e.printStackTrace();
					;
				}
				drawing = true;
			}
		} else if (key == Input.KEY_F5) {
			if (app != null) {
				drawing = false;
				BasicState state = (BasicState) this.getCurrentState();
				try {
					state.initRes();
				} catch (SlickException e) {

					e.printStackTrace();
				}
				drawing = true;
			}

		}

	}

	public void mousePressed(int button, int x, int y) {
		BasicState state = (BasicState) getCurrentState();

		for (int a = 0; a < 7; a++)
			if (state.stateRes.button[a].isMouseOver()) {
				if (a < 6) {
					System.out.println("entering " + a);
					enterState(a);
				} else if (a == 6)
					MUSIC_END_REQUESTED=true;
				else {
					System.out
							.println("There was a really weird error. You clicked on a nonexisting button, "
									+ a + " :O");
				}
			}

	}

	// -----------------------------------------The-Project's-TO-DO-repository-dump!---------------------------------------------------------------
	// TODO HP | Properties
	// TODO DH | Icons for the game
	// TODO DH | Rest of ship models
	// TODO DH | Game map & borders
	// TODO DK | Projectile system
	// TODO DK | Ships rendering img based on their type
	// TODO DK | Sort out the states
	// TODO DK | Fix Sound play order
	// TODO DP | Connection stream for BattleField sync
	// TODO DP | TextAreas (input) to set the IPs outside console?
	// TODO NC | DrawArea panel class for the text and shit
}
