package game.util;

import java.awt.Font;
import java.util.Arrays;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
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

	AbstractComponent[] components = new AbstractComponent[1];
	Label[] labels = new Label[1];
	
	public StateBuilder(AppGameContainer gc) {
		this.gc = gc;

	}

	public void addTextField(int x, int y, int width, int height) {
		TextField field = new TextField((GUIContext) gc, new TrueTypeFont(
				new Font("Garamond", 10, 25), true), x, y, width, height);
		field.setConsumeEvents(true);
		addComponents(field);
	}
	public void addLabel(int x, int y, String string){
		Label label = new Label(x,y,string);
		addLabels(label);
	}

	void addComponents(AbstractComponent... component) {
		int lengthBeginning = components.length;

		// if components array is full, extend the array
		if (components[components.length - 1] != null) {
			components = Arrays.copyOf(components, lengthBeginning
					+ component.length);
		}

		// add the requested components to the array
		for (int a = 0; a < component.length; a++) {

			if (components[0] == null) {
				components[lengthBeginning + a - 1] = component[a];
			} else {
				components[lengthBeginning + a] = component[a];
			}

		}

	}

	void addLabels(Label... label) {
		int lengthBeginning = labels.length;

		// if labels array is full, extend the array
		if (labels[labels.length - 1] != null) {
			labels = Arrays.copyOf(labels, lengthBeginning
					+ label.length);
		}

		// add the requested labels to the array
		for (int a = 0; a < label.length; a++) {

			if (labels[0] == null) {
				labels[lengthBeginning + a - 1] = label[a];
			} else {
				labels[lengthBeginning + a] = label[a];
			}

		}

	}

	public AbstractComponent getComponent(int a){
		return components[a];
	}
	public void drawComponents(Graphics g) throws SlickException {
		if (components[0]!=null)		
		for (int a = 0; a < components.length; a++) {
			components[a].render((GUIContext) gc, g);

		}
		if (labels[0]!=null)		
			for (int a = 0; a < labels.length; a++) {
				labels[a].render();

			}
		
		
	}
}
