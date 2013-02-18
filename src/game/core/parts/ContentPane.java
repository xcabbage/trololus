package game.core.parts;

import java.awt.Dimension;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 * The ContentPane.java class responsible for managing and drawing a Content
 * pane and its contents.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       18.2.2013 18:05:30
 */
public class ContentPane extends StateBuilder {

	//Constructors
	/**
	 * @param gc
	 *            the AppGameContainer used to initialize this object
	 */
	public ContentPane(AppGameContainer gc) {
		super(gc);
	}
	public ContentPane(AppGameContainer gc, int x, int y, int width, int height) {
		super(gc);
		this.area = new Rectangle(x, y, width, height);
		this.bgColor = Color.green;
		this.outlineColor = Color.white;
		g = new Graphics();
		isVisible = true;
	}

	
	//Variable declarations
	Rectangle area;
	Color bgColor, outlineColor;
	Image bgImg;
	boolean bgImageSet;
	boolean isVisible;
	Graphics g;

	//Variable methods (getters/setters/any other work with variables) 
	public void setVisible(boolean visible){
		isVisible = visible;
	}
	
	public void toggleVisibility(){
		isVisible = !isVisible;
	}
	
	public boolean isVisible(){
		return isVisible;
	}
	
	
	//Draw this ContentPane and all its contents.
	public void render() throws SlickException {
		if (isVisible) {
			// render the Pane itself
			g.setColor(outlineColor);
			g.draw(area);
			g.setColor(bgColor);
			g.fill(area);

			// render the individual components
			if (components[0] != null)
				for (int a = 0; a < components.length; a++) {
					components[a].render((GUIContext) area, g);

				}

			if (labels[0] != null)
				for (int a = 0; a < labels.length; a++) {
					labels[a].render(area);

				}
		}
	}
	

}
