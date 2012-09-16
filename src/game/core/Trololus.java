// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import game.states.*;

public class Trololus extends StateBasedGame {

	static boolean fullscreen = false;
	static boolean ShowFPS = true;

	static int width = 1000;
	static int height = 500;
	static int fpslimit = 60;
	static String title = "Trololus NightBuild.0";

	public Trololus(String title) {
		super(title);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MainState());
		addState(new MenuState());
	}

	public static void main(String[] args) throws SlickException {
		System.out.println("pepa");
		Pepta pepta = new Pepta();
		pepta.createPlayers();

		AppGameContainer app = new AppGameContainer(new Trololus(title));
		app.setDisplayMode(width, height, fullscreen);
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.setVSync(true);
		app.start();

	}
}
