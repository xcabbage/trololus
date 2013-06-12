package game.core.parts;

import game.core.Trololus;
import game.util.MoreColors;
import game.util.Util;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import java.awt.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;

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

	private static final boolean debugTextEnabled = false;

	private int scaling = 0;

	private float scalingXf = 0, scalingYf = 0, scalingW = 0, scalingH = 0;

	private int xOffset = 0, yOffset = 0, posX = 0, posY = 0, posW = 0,
			posH = 0;

	int fixedWidth, fixedHeight;

	private Rectangle container;

	// Constructors
	/**
	 * @param gc
	 *            the AppGameContainer used to initialize this object
	 */
	public ContentPane(AppGameContainer gc) {
		super(gc);
	}

	public ContentPane(AppGameContainer gc, int x, int y, int width, int height) {
		super(gc);
		// this.area = new Rectangle(x, y, width, height);
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		posX = x;
		posY = y;
		posW = width;
		posH = height;
		container = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		rescale();
	}

	public ContentPane(AppGameContainer gc, float x, float y, int width,
			int height) {
		super(gc);
		// this.area = new Rectangle(gc.getWidth() * x, gc.getHeight() * y,
		// width,
		// height);
		scaling = 1;
		scalingXf = x;
		scalingYf = y;
		posW = width;
		posH = height;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		container = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		rescale();
	}

	public ContentPane(AppGameContainer gc, float x, float y, int xOffset,
			int yOffset, int width, int height) {
		super(gc);
		// this.area = new Rectangle(gc.getWidth() * x + xOffset, gc.getHeight()
		// * y + yOffset, width, height);
		scaling = 1;
		scalingXf = x;
		scalingYf = y;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		fixedWidth = width;
		fixedHeight = height;
		posW = width;
		posH = height;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		container = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		rescale();
	}

	public ContentPane(AppGameContainer gc, float x, float y, float width,
			float height) {
		super(gc);
		scalingXf = x;
		scalingYf = y;
		scalingW = width;
		scalingH = height;
		// this.area = new Rectangle(gc.getWidth() * x, gc.getHeight() * y,
		// gc.getWidth() * width, gc.getHeight() * height);
		scaling = 2;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		container = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		rescale();
	}

	public ContentPane(AppGameContainer gc, int x, int y, int width,
			int height, Rectangle area) {
		super(gc);
		// this.area = new Rectangle(x, y, width, height);
		initDefaultColors();
		g = new Graphics();
		posX = x;
		posY = y;
		posW = width;
		posH = height;
		isVisible = true;
		container = area;
		rescale();
	}

	public ContentPane(AppGameContainer gc, float x, float y, int width,
			int height, Rectangle area) {
		super(gc);
		// this.area = new Rectangle(gc.getWidth() * x, gc.getHeight() * y,
		// width,
		// height);
		scaling = 1;
		scalingXf = x;
		scalingYf = y;

		posW = width;
		posH = height;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		container = area;
		rescale();
	}

	public ContentPane(AppGameContainer gc, float x, float y, int xOffset,
			int yOffset, int width, int height, Rectangle area) {
		super(gc);
		// this.area = new Rectangle(gc.getWidth() * x + xOffset, gc.getHeight()
		// * y + yOffset, width, height);
		scaling = 1;
		scalingXf = x;
		scalingYf = y;

		posW = width;
		posH = height;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		container = area;
		rescale();
	}

	public ContentPane(AppGameContainer gc, float x, float y, float width,
			float height, Rectangle area) {
		super(gc);
		scalingXf = x;
		scalingYf = y;
		scalingW = width;
		scalingH = height;

		scaling = 2;
		initDefaultColors();
		g = new Graphics();
		isVisible = true;
		container = area;

		rescale();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.core.parts.StateBuilder#addTextField(int, int, int, int)
	 */
	@Override
	public void addTextField(int x, int y, int width, int height) {

		super.addTextField((int) (x + this.area.getMinX()),
				(int) (y + this.area.getMinY()), width, height);
	}

	@Override
	public void addContentPane(int x, int y, int width, int height) {
		ContentPane pane = new ContentPane(gc, x, y, width, height, area);
		addPanes(pane);
	}

	@Override
	public void addContentPane(float x, float y, int width, int height) {
		fixedWidth = width;
		fixedHeight = height;
		ContentPane pane = new ContentPane(gc, x, y, width, height, area);

		addPanes(pane);
	}

	@Override
	public void addContentPane(float x, float y, float width, float height) {
		ContentPane pane = new ContentPane(gc, x, y, width, height, area);
		addPanes(pane);
	}

	@Override
	public void addContentPane(float x, float y, float width, float height,
			Rectangle area) {
		ContentPane pane = new ContentPane(gc, x, y, width, height, area);
		addPanes(pane);
	}

	@Override
	public void addContentPane(float x, float y, int xOffset, int yOffset,
			int width, int height) {
		ContentPane pane = new ContentPane(gc, x, y, xOffset, yOffset, width,
				height, area);
		addPanes(pane);
	}

	@Override
	public void addButton(int x, int y, String image) {

		try {
			super.addButton((int) (x + this.area.getMinX()),
					(int) (y + this.area.getMinY()), image);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addButton(int x, int y, Image image) {

		try {
			super.addButton((int) (x + this.area.getMinX()),
					(int) (y + this.area.getMinY()), image);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addLabel(int type, float x, float y, String string)
			throws SlickException {
		Label label = new Label(type, x, y, string, area);
		addLabels(label);
	}

	@Override
	public void addLabel(int type, int x, int y, String string)
			throws SlickException {
		Label label = new Label(type, x, y, string, area);
		addLabels(label);
	}

	public void rescaleA() {
		int baseAreaX = (int) area.getMinX(), baseAreaY = (int) area.getMinY();
		switch (scaling) {
		case 0:
			break;
		case 1: {
			this.area = new Rectangle(container.getWidth() * scalingXf
					+ xOffset, container.getHeight() * scalingYf + yOffset,
					area.getWidth(), area.getHeight());
			break;
		}
		case 2: {
			this.area = new Rectangle(container.getWidth() * scalingXf
					+ xOffset, container.getHeight() * scalingYf + yOffset,
					container.getWidth() * scalingW, container.getHeight()
							* scalingH);
			break;
		}
		default:
			Util.print("This shit doesn't really work. ContentPane not properly initialized");
			break;
		}
		if (panes[0] != null) {
			for (ContentPane pane : panes) {
				pane.rescale();

			}
		}

		if (labels[0] != null) {
			for (Label label : labels) {
				label.rescale();
			}
		}
		if (components[0] != null) {
			for (AbstractComponent comp : components) {

				comp.setLocation(
						(int) (area.getMinX() - baseAreaX + comp.getX()),
						(int) (area.getMinY() - baseAreaY + comp.getY()));
				Util.notify("rescaling " + area.getMinX() + xOffset);
			}
		}
	}

	public void scale() {

		switch (scaling) {
		case 0:
			break;
		case 1: {
			this.area = new Rectangle(container.getWidth() * scalingXf
					+ xOffset, container.getHeight() * scalingYf + yOffset,
					area.getWidth(), area.getHeight());
			break;
		}
		case 2: {
			this.area = new Rectangle(container.getWidth() * scalingXf
					+ xOffset, container.getHeight() * scalingYf + yOffset,
					container.getWidth() * scalingW, container.getHeight()
							* scalingH);
			break;
		}
		default:
			Util.print("This shit doesn't really work. ContentPane not properly initialized");
			break;
		}
		int baseAreaX = (int) area.getMinX(), baseAreaY = (int) area.getMinY();
		if (panes[0] != null) {
			for (ContentPane pane : panes) {
				pane.rescale();

			}
		}

		if (labels[0] != null) {
			for (Label label : labels) {
				label.rescale();
			}
		}
		if (components[0] != null) {
			for (AbstractComponent comp : components) {

				comp.setLocation(
						(int) (area.getMinX() - baseAreaX + comp.getX()),
						(int) (area.getMinY() - baseAreaY + comp.getY()));
				Util.notify("rescaling " + area.getMinX() + xOffset);
			}
		}
	}

	// Variable declarations
	Rectangle area;
	Color bgColor, outlineColor, contentColor;
	Image bgImg;
	boolean bgImageSet;
	boolean isVisible;
	Graphics g;

	private boolean backgroundEnabled;

	private boolean backgroundImgEnabled;

	private ContentPosition position;

	private float currW;

	// Variable methods (getters/setters/any other work with variables)
	// visibility
	public void setVisible(boolean visible) {
		isVisible = visible;
	}

	public void toggleVisibility() {
		isVisible = !isVisible;
	}

	public boolean isVisible() {
		return isVisible;
	}

	// background
	public void setBackground(Color fill, Color border) {

		bgColor = fill;
		outlineColor = border;
		backgroundEnabled = true;
	}

	public void setBackground(String path) throws SlickException {

		bgImg = new Image(path);
		bgImg = bgImg.getScaledCopy((int) area.getWidth(),
				(int) area.getHeight());
		backgroundImgEnabled = true;

	}

	void initDefaultColors() {
		this.bgColor = MoreColors.getTrans(Color.black, 0.15f);
		this.outlineColor = Color.white;
		this.contentColor = MoreColors.getTrans(Color.orange.darker(), 0.7f);

	}

	// Draw this ContentPane and all its contents.
	public void render() throws SlickException {
		if (isVisible) {

			if (debugTextEnabled) {
				TrueTypeFont font = new TrueTypeFont(
						new Font("Cambria", 25, 10), true);

				font.drawString(0 + area.getMinX(), 0, ("posX : " + posX));
				font.drawString(0 + area.getMinX(), 25, ("posY : " + posY));
				font.drawString(0 + area.getMinX(), 50, ("posW : " + posW));
				font.drawString(0 + area.getMinX(), 75, ("posH : " + posH));
				font.drawString(0 + area.getMinX(), 100, ("scX : " + scalingXf));
				font.drawString(0 + area.getMinX(), 125, ("scY : " + scalingYf));
				font.drawString(0 + area.getMinX(), 150, ("scW : " + scalingW));
				font.drawString(0 + area.getMinX(), 175, ("scH : " + scalingH));
			}
			// render the Pane itself
			if (backgroundEnabled) {
				g.setColor(outlineColor);
				g.draw(area);
				g.setColor(bgColor);
				g.fill(area);

			} else if (backgroundImgEnabled) {
				bgImg.draw(area.getMinX(), area.getMinY());
			}
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
			if (panes[0] != null)
				for (int a = 0; a < panes.length; a++) {
					panes[a].render();

				}

		}
	}

	/**
	 * @param center
	 */
	public void setPosition(ContentPosition pos) {
		position = pos;
		scaling = 3;
		rescale();
	}

	/**
	 * @param pos
	 *            the ContentPosition of the component (search the enum and/or
	 *            source/jdoc for values)
	 * @param x
	 *            the x offset of the component from the ContentPosition default
	 * @param y
	 *            the Y offset of the component from the ContentPosition default
	 */
	public void setPosition(ContentPosition pos, int x, int y) {
		position = pos;
		scaling = 3;
		xOffset = x;
		yOffset = y;
		rescale();

	}

	@Override
	public void rescale() {

		// if (area == null) {

		area = new Rectangle(
				(int) ((scalingXf * container.getWidth()) + posX + xOffset)
						+ container.getMinX(),
				(int) ((scalingYf * container.getHeight()) + posY + yOffset)
						+ container.getMinY(),
				(int) ((scalingW * container.getWidth()) + posW),
				(int) ((scalingH * container.getHeight()) + posH));
		// }

		int containerW, containerH, x = 0, y = 0;
		float scaleForContainer = 0;
		if (currW == 0.0) {
			currW = Trololus.app.getWidth();
		}
		if (container != null) {

			scaleForContainer = Trololus.app.getWidth() / currW;

			// container = new Rectangle(container.getMinX() *
			// scaleForContainer,
			// container.getMinY() * scaleForContainer,
			// container.getWidth() * scaleForContainer,
			// container.getHeight() * scaleForContainer);

			containerW = (int) container.getWidth();
			containerH = (int) container.getHeight();
		} else {
			containerW = Trololus.app.getWidth();
			containerH = Trololus.app.getHeight();
		}

		switch (scaling) {
		case 0:
			break;
		case 1: {
			x = (int) (containerW * scalingXf);
			y = (int) (containerH * scalingYf);
			break;
		}
		case 2: {

			x = (int) (containerW * scalingXf);
			y = (int) (containerH * scalingYf);

			break;
		}
		case 3: {
			// initialize starting values
			int contentW = 0, contentH = 0;

			if (fixedHeight == 0) {
				contentW = (int) area.getWidth();
				contentH = (int) area.getHeight();
			} else {
				contentW = fixedWidth;
				contentH = fixedHeight;
			}

			// set the actual new X's and Y's
			switch (position) {
			case TopLeft:
				x = 0;
				y = 0;
				break;
			case TopCenter:
				x = containerW / 2 - contentW / 2;
				y = 0;
				break;
			case TopRight:
				x = containerW - contentW;
				y = 0;
				break;
			case CenterLeft:
				x = 0;
				y = (containerH / 2) - (contentH / 2);
				break;
			case Center:
				x = (containerW / 2) - (contentW / 2);
				y = (containerH / 2) - (contentH / 2);
				System.out.println(containerW + " " + contentW);
				break;
			case CenterRight:
				x = containerW - contentW;
				y = (containerH / 2) - (contentH / 2);
				break;
			case BottomLeft:
				x = 0;
				y = containerH - contentH;
				break;
			case BottomCenter:
				x = containerW / 2 - contentW / 2;
				y = containerH - contentH;
				break;
			case BottomRight:
				x = containerW - contentW;
				y = containerH - contentH;
				break;
			default:
				Util.print("Label Position not able to initialize - unknown value passed to the method");
				break;

			}

			break;
		}

		default: {
			Util.print("Label incorrectly initialized - scaling has thus failed");
			break;
		}

		}
		if (container != null) {
			x = (int) (x + container.getMinX());
			y = (int) (y + container.getMinY());
		}
		x = (int) ((x + xOffset) * scaleForContainer);
		y = (int) (y + yOffset * scaleForContainer);
		// area = new Rectangle(x, y, area.getWidth(), area.getHeight());
		currW = Trololus.app.getWidth();
	}

}
