// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core;

import org.newdawn.slick.*;

public class Trololus extends BasicGame {
	static boolean fullscreen = false;
	static boolean ShowFPS = true;
	public Image background;
	static int fpslimit = 60;
	static String title = "Trololus NightBuild.0";
	String menu1, menu2, menu3;
	String S_ingame, S_loading, S_title, S_postgame;
	static int width = 1000;
	static int height = 500;
	GameState state;

	public Trololus(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		background = new Image("resources/Splash/UI/menu.png");
		state = GameState.INIT;


	//initialize strings 
		menu1 = "MENU1";
		S_ingame = "INGAME";
		S_loading = "The Game is loading! woooo";
		S_title = "TROLOLUS NIGHTLY BUILD 0,0";
		S_postgame = "The after game lobby.";
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		background.draw(0,0, (float)0.5);
		
		switch (state) {
	
		case INIT:
			g.drawString(menu1, 100, 100);
			break;
		case LOADING:
			g.drawString(S_loading, 100, 100);
			break;
		case INGAME:
			g.drawString(S_ingame, 100, 100);
			break;
		case POSTGAME:
			g.drawString(S_postgame, 100, 100);
			break;
		default:
			
		
	}}

	public static void main(String[] args) throws SlickException {
		System.out.println("pepa");
		Pepta pepta = new Pepta();
		pepta.createPlayers();

		AppGameContainer app = new AppGameContainer(new Trololus(title));
		app.setDisplayMode(width, height, fullscreen);
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.start();

	}
}
