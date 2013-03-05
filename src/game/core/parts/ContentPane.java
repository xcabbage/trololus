package game.core.parts;

import game.core.Trololus;
import game.util.MoreColors;
import game.util.Util;

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

	private int scaling = 0;


	private float scalingXf,scalingYf, scalingW,scalingH;


	private int xOffset;


	private int yOffset;
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
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
	}
	
	void initDefaultColors(){
		this.bgColor = MoreColors.getTrans(Color.black, 0.15f);
		this.outlineColor = Color.white;
		this.contentColor = MoreColors.getTrans(Color.orange.darker(), 0.7f);
		
	}
	public ContentPane(AppGameContainer gc, float x, float y, int width, int height) {
		super(gc);
		this.area = new Rectangle(gc.getWidth()*x, gc.getHeight()*y, width, height);
		scaling = 1;
		scalingXf = x;
		scalingYf = y;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
	}
	
	public ContentPane(AppGameContainer gc, float x, float y, int xOffset, int yOffset, int width, int height) {
		super(gc);
		this.area = new Rectangle(gc.getWidth()*x+xOffset, gc.getHeight()*y+yOffset, width, height);
		scaling = 1;
		scalingXf = x;
		scalingYf = y;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
	}
	public ContentPane(AppGameContainer gc, float x, float y, float width, float height) {
		super(gc);
		scalingXf = x;
		scalingYf = y;
		scalingW = width;
		scalingH = height;
		this.area = new Rectangle(gc.getWidth()*x, gc.getHeight()*y, gc.getWidth()*width, gc.getHeight()*height);
		scaling = 2;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
	}
	
	
	
	
/* (non-Javadoc)
	 * @see game.core.parts.StateBuilder#addTextField(int, int, int, int)
	 */
	@Override
	public void addTextField(int x, int y, int width, int height) {
		
		super.addTextField((int)(x+this.area.getMinX()), (int)(y+this.area.getMinY()), width, height);
	}
public void addButton(int x, int y, String image) {
		
		try {
			super.addButton((int)(x+this.area.getMinX()), (int)(y+this.area.getMinY()), image);
		} catch (SlickException e) {
		e.printStackTrace();
		}
	}
public void addButton(int x, int y, Image image) {
	
	try {
		super.addButton((int)(x+this.area.getMinX()), (int)(y+this.area.getMinY()), image);
	} catch (SlickException e) {
	e.printStackTrace();
	}
}
	

public void rescale(){
	int baseAreaX=(int) area.getMinX(),baseAreaY = (int) area.getMinY();
	switch (scaling){
	case 0:
		break;
	case 1:{
		this.area = new Rectangle(gc.getWidth()*scalingXf+xOffset, gc.getHeight()*scalingYf+yOffset, area.getWidth(), area.getHeight());
		break;}
	case 2:{
		this.area = new Rectangle(gc.getWidth()*scalingXf+xOffset, gc.getHeight()*scalingYf+yOffset, gc.getWidth()*scalingW, gc.getHeight()*scalingH);
		break;}
	default:
		Util.print("This shit doesn't really work. ContentPane not properly initialized");
		break;
	}
	for (ContentPane pane : panes) {
//		if (pane !=null) pane.rescale(); else Util.print("A pane attempted to be rescaled is null.");
	}
	
	for (Label label : labels) {
//		label.rescale();
	}
	for (AbstractComponent comp : components) {
//		if (comp.getClass().equals(MouseOverAreaDav.class)) ;
		
		comp.setLocation((int) (area.getMinX()-baseAreaX+comp.getX()), (int) (area.getMinY()-baseAreaY+comp.getY()));
	Util.notify("rescaling " + area.getMinX()+xOffset); 
	}
}
	
	//Variable declarations
	Rectangle area;
	Color bgColor, outlineColor, contentColor;
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
			g.setColor(contentColor);
			if (components[0] != null)
				for (int a = 0; a < components.length; a++) {
					components[a].render(Trololus.app, g);

				}

			if (labels[0] != null)
				for (int a = 0; a < labels.length; a++) {
					labels[a].render(area);

				}
		}
	}
	

}
