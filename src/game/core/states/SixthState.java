package game.core.states;

import game.core.parts.ContentPosition;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SixthState extends BasicState {

	public static int ID = 5;

	public void createContent() throws SlickException {
	    //FPS
		sb.addLabel(2,0,0,"/resources/Splash/UI/IG/IG_fps.png");
		sb.getLabel(-1).setScale(0.525f);
		sb.getLabel(-1).setPosition(ContentPosition.TopRight);
		//MAP
	    sb.addLabel(2,0,0,"/resources/Splash/UI/IG/IG_map.png");
	    sb.getLabel(-1).setScale(0.525f);
		sb.getLabel(-1).setPosition(ContentPosition.TopLeft);
	    //HUD
	    sb.addLabel(2,0,0,"/resources/Splash/UI/IG/IG_sta.png");
	    sb.getLabel(-1).setScale(0.525f);
		sb.getLabel(-1).setPosition(ContentPosition.BottomCenter);
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Options state";
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