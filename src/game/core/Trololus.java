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
	static boolean ShowFPS = true;
	static game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	static int width = 1000;
	static int height = 500;
	static int fpslimit = 60;
	static String title = "Trololus NightBuild.0";
	static BasicState activeState;
	static BasicState[] state;
	static NetworkTest pomocnik = new game.core.NetworkTest();
	static Image icon;
	Scanner sc = new Scanner(System.in);

	static public void cleanRes() throws SlickException {
		app.setDisplayMode((int) (res.width * .75), (int) (res.height * .75),
				fullscreen);
	}

	public Trololus(String title) {
		super(title);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new FirstState());
		addState(new SecondState());
		addState(new ThirdState());
		addState(new FourthState());
		addState(new FifthState());
		addState(new SixthState());
		initAfterStates();

	}

	public void init() {

	}

	public static void main(String[] args) throws SlickException {
		res = utilGfx.getRes();
		Pepta pepta = new Pepta();
		pepta.createPlayers();
		// try {app.setIcon("/resources/Splash/trololus_icon.png");}
		// catch (SlickException e) { e.printStackTrace();}
		app = new AppGameContainer(new Trololus(title));
		cleanRes();
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.setVSync(true);
		app.start();

		System.out.println("NetworkTest object initiated");
	}

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

	public static void initAfterStates() throws SlickException {
		// init sound

		Music music = new Music("/resources/Audio/BGM1_a.wav");
		music.play();
	}

	public void mousePressed(int button, int x, int y) {
		BasicState state = (BasicState) getCurrentState();

		for (int a = 0; a < 7; a++)
			if (state.button[a].isMouseOver()) {
				if (a < 6) {
					System.out.println("entering " + a);
					enterState(a);
				} else if (a == 6)
					System.exit(0);
				else {
					System.out
							.println("There was a really weird error. You clicked on a nonexisting button, "
									+ a + " :O");
				}
			}

	}
	
//-----------------------------------------The-Project's-TO-DO-repository-dump!---------------------------------------------------------------
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
