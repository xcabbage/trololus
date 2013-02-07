package game.util;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;

/**
 * The StateBuilder.java class responsible for adding all the different drawable
 * elements into the game's states.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       7.2.2013 15:50:28
 */
public class StateBuilder {
	AppGameContainer gc;

	AbstractComponent[] components = new AbstractComponent[10];

	public StateBuilder(AppGameContainer gc, GUIContext g) {
		this.gc = gc;

	}

	public void addTextField() {
		TextField field = new TextField((GUIContext) gc,
				(org.newdawn.slick.Font) new Font("Arial", 50, 50), 50, 50,
				250, 100);

	}

	public void drawComponents(Graphics g) throws SlickException {
		for (int a = 0; a < components.length; a++) {
			components[a].render((GUIContext) gc, g);
		}
	}
}
