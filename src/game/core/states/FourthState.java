package game.core.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FourthState extends BasicState {

	public static int ID = 3;

	public void createContent() throws SlickException {
	
	sb.addLabel(2,-250,-350,"/resources/Splash/pilots/Pilot4a.png");
	sb.addLabel(1, 550,650, "GIVE ME YOUR CHICKEN, HUMAN!");
		
  	}


	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Fourth State - Garage";
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