// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core.states;

import java.awt.Font;

import game.core.parts.ContentPosition;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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

		sb.addLabel(0.5f, 0.5f, "/resources/Splash/Tlogo.png", 0.25f);
		sb.getLabel(-1).setPosition(ContentPosition.Center);
		sb.getLabel(-1).scaleToHeight(0.1f);
		
		sb.addLabel(1, 0.5f,  0.5f, "Trololus MainScreen");
		sb.getLabel(-1).setFont(new TrueTypeFont(new Font("Cambria", 25, 43), true));
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);
		
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
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		renderDiffGfx(gc, mainGame, g, stateRes);
		super.render(gc, mainGame, g, stateRes);

	}
}
