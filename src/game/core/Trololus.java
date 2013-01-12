// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core;

import java.awt.Dimension;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import game.states.*;

public class Trololus extends StateBasedGame {
	static public boolean drawing = true;
	static boolean fullscreen = false;
	static boolean ShowFPS = true;
	static game.util.FastGraphics utilGfx = new game.util.FastGraphics();
	static int width = 1000;
	static int height = 500;
	static int fpslimit = 60;
	static String title = "Trololus NightBuild.0";
	static public Dimension res;
	static BasicState activeState;
	static BasicState[] state;
	
	static public void cleanRes() throws SlickException{
		app.setDisplayMode((int) (res.width*.75), (int)(res.height*.75), fullscreen);
	}
	public Trololus(String title) {
		super(title);
	}

	public static AppGameContainer app;

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MainState());
		addState(new MenuState());
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
		app.start();

	}

	@Override
	/**
	 * @see org.newdawn.slick.state.StateBasedGame#keyPressed(int, char)
	 */
	public void keyPressed(int key, char c) {
		super.keyPressed(key, c);

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
					for (int a = 0;a<=1;a++ ){
					
					activeState = (BasicState) this.getState(a); 
					activeState.initRes();
					}
				} catch (SlickException e) {
					e.printStackTrace();
					;
				}drawing = true;
			}
		} else if (key == Input.KEY_F5){
			if (app!=null){drawing = false;
				BasicState state = (BasicState) this.getCurrentState();
				try {
					state.initRes();
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			drawing = true;}
		

	}

}

	public void mousePressed(int button, int x, int y) {
//		int state =(((BasicState) getCurrentState()).isOverButton(x, y)); 
//		if (state !=11)
//			System.out.println("entering " + (state-1) + " through mouse");
//			
//		enterState(state-1);
		BasicState state = (BasicState) getCurrentState();
		
		for(int a = 0;a<7;a++)
		if (state.button[a].isMouseOver()){
			if (a<getStateCount()){
			System.out.println("entering " +a);
			enterState(a);} else {System.out.println("this state isn't created yet, sorry :(");}
		}
		
	}



}
