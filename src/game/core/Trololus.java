// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]



/**
 * 
 */
package game.core;

/**
 * @author David
 *
 */
import org.newdawn.slick.*;

public class Trololus extends BasicGame {
	static boolean fullscreen = false;
	static boolean ShowFPS = true;
	public Image background;
	static int fpslimit = 60;
	static String title = "Trololus NightBuild.0";
	static int width = 500;
	static int height = 500;
	
	
	public Trololus(String title)	{super(title);
	}

	
	@Override
	public void init(GameContainer gc) throws SlickException{
		background = new Image("resources/background.png");
		
	} 
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		background.draw(100,100,1);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Trololus(title));
		app.setDisplayMode(width, height, fullscreen);
		app.setSmoothDeltas(true);
		app.setTargetFrameRate(fpslimit);
		app.start();
		System.out.println("pepa");

}}

