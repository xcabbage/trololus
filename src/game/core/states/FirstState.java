// Class created by xCabbage [github.com/xcabbage] 
// for the trololus project [github.com/xcabbage/trololus]

package game.core.states;

import game.core.parts.ContentPosition;
import game.util.Util;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author xCabbage
 * 
 */
public class FirstState extends BasicState {

	public static int ID = 0;

	@Override
	public void createContent() throws SlickException {

		System.out.println("sb in createContent: " + sb);
		sb.addLabel(1, 0.5f, 0.5f, "Trololus ");
		sb.getLabel(-1).setFont(Util.fontGreatHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

		sb.addLabel(1, 0.5f, 0.5f, "Title screen");
		sb.getLabel(-1).setFont(Util.fontNormalHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 100);
		sb.getLabel(-1).setColor(Color.white.darker(0.1f));

	}

	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Main State for trololus 0.1 Alpha - Welcome Screen";
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);

		// if(driftRequested){
		// sb.driftComponentContinue(this);
		// }
		//
		//
		// if(input.isMousePressed(0)){
		// sb.driftComponentTo(input.getMouseX(), input.getMouseY(),
		// sb.getComponent(-1));
		// driftRequested = true;
		//
		// }

	}

	@Override
	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		renderDiffGfx(gc, mainGame, g, stateRes);
		super.render(gc, mainGame, g, stateRes);

	}

	@Override
	public void mousePressed(int button, int x, int y) {

	}
}
