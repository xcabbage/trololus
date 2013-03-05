// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

/**
 * 
 */
package game.core.states;

import java.awt.Font;

import game.core.parts.ContentPosition;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author David
 * 
 */
public class SecondState extends BasicState {
	public static final int ID = 1;

	public void createContent() throws SlickException {
		
		sb.addLabel(1, 0.5f,  0.5f, "Connect to a remote Game");
		sb.getLabel(-1).setFont(new TrueTypeFont(new Font("Cambria", 25, 43), true));
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Second state - Connect to another game";

	}

	public int getID() {
		return ID;
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
		super.render(gc, mainGame, g, stateRes);

	}

}
