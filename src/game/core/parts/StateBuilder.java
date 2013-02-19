package game.core.parts;

import java.awt.Font;
import java.util.Arrays;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
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

	// declare the container and the three arrays
	AppGameContainer gc;
	AbstractComponent[] components = new AbstractComponent[1];
	Label[] labels = new Label[1];
	ContentPane[] panes = new ContentPane[1];

	// constructor
	public StateBuilder(AppGameContainer gc) {
		this.gc = gc;

	}

	// interface methods to create the new objects and queue their addition to
	// the arrays
	public void addTextField(int x, int y, int width, int height) {
		TextField field = new TextField((GUIContext) gc, new TrueTypeFont(
				new Font("Garamond", 10, 25), true), x, y, width, height);
		field.setConsumeEvents(true);
		addComponents(field);
	}
	public void addLabel(int type, int x, int y,String string) throws SlickException {
		Label label = new Label(type, x, y, string);
		addLabels(label);
	}
	public void addContentPane(int x, int y, int width, int height) {
		ContentPane pane = new ContentPane(gc, x,y,width,height);
		addPanes(pane);
	}

	// internal methods extending the arrays
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
	void addPanes(ContentPane... pane) {
		int lengthBeginning = panes.length;

		// if panes array is full, extend the array
		if (panes[panes.length - 1] != null) {
			panes = Arrays.copyOf(panes, lengthBeginning + pane.length);
		}

		// add the requested panes to the array
		for (int a = 0; a < pane.length; a++) {

			if (panes[0] == null) {
				panes[lengthBeginning + a - 1] = pane[a];
			} else {
				panes[lengthBeginning + a] = pane[a];
			}

		}

	}
	void addLabels(Label... label) {
		int lengthBeginning = labels.length;

		// if labels array is full, extend the array
		if (labels[labels.length - 1] != null) {
			labels = Arrays.copyOf(labels, lengthBeginning + label.length);
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

	// interface methods returning any of the stored variables
	public AbstractComponent getComponent(int a) {
		return components[a];
	}
	public Label getLabel(int a) {
		return labels[a];
	}
	public ContentPane getPane(int a) {
		if (a == -1) return panes[panes.length-1]; else
		return panes[a];
	}

	// drawing of the current situation
	public void drawComponents(Graphics g) throws SlickException {
		if (panes[0] != null)
			for (int a = 0; a < panes.length; a++) {
				panes[a].render();

			}
		if (components[0] != null)
			for (int a = 0; a < components.length; a++) {
				components[a].render((GUIContext) gc, g);

			}

		if (labels[0] != null)
			for (int a = 0; a < labels.length; a++) {
				labels[a].render();

			}

	}
}
