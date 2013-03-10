// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core.states;

import java.awt.Font;

import game.core.parts.ContentPosition;
import game.util.Util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author xCabbage
 * 
 */
public class FirstState extends BasicState {

	public static int ID = 0;
	

	public void createContent() throws SlickException {

		
	
		
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Main State for trololus 0.1 Alpha - Welcome Screen";
	}

	public int getID() {
		return ID;
	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);
		Input input = gc.getInput();
	
		
//		if(driftRequested){
//			sb.driftComponentContinue(this);	
//		}
//		
//		
//		if(input.isMousePressed(0)){
//			sb.driftComponentTo(input.getMouseX(), input.getMouseY(), sb.getComponent(-1));	
//			driftRequested = true;
//			
//		}
		
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		renderDiffGfx(gc, mainGame, g, stateRes);
		super.render(gc, mainGame, g, stateRes);

	}
	
	public void mousePressed(int button, int x, int y) {
		



	}
}
