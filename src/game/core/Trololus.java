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
	static int width = 1000;
	static int height = 500;
	
	
	public Trololus(String title)	{super(title);
	}

	
	@Override
	public void init(GameContainer gc) throws SlickException{
		background = new Image("resources/UI/menu.png");
		
	} 
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		background.draw(0,0, (float)0.5);
		String pepa = new String("rofl lol");
		g.drawString(pepa, 100, 100);
	}
	
	public static void main(String[] args) throws SlickException {
		System.out.println("pepa");
		Pepta pepta = new Pepta();
		pepta.Pozdrav();
		
		AppGameContainer app = new AppGameContainer(new Trololus(title));
		app.setDisplayMode(width, height, fullscreen);
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.start();
		
}}

