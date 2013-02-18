// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

/**
 * 
 */
package game.core.states;

import game.core.Trololus;
import game.util.StateBuilder;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author David
 * 
 */
public class SecondState extends BasicState {
	public static final int ID = 1;
	float glowF;
	int glow;
	
	
	public int getID() {
		return ID;
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Second state - Connect to another game";
		sb.addTextField(50,50,250,25);
		sb.addTextField(50,100,250,25);
	}
	
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);
	}

	
	
		@Override
	void renderDiffGfx(GameContainer gc, StateBasedGame mainGame, Graphics g,
			BasicState state) throws SlickException {
			super.renderDiffGfx(gc, mainGame, g, state);
			
			
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		super.render(gc,mainGame,g,stateRes);
		
	}
	
	
}
