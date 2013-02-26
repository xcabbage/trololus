package game.core.parts;

import game.core.Trololus;
import game.util.Util;

import java.awt.Font;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

/**
 * The Label.java class representing a single label (text entry or image) in the
 * game.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       18.2.2013 15:41:29
 */
public class Label {
	int x, y;
	String string;
	TrueTypeFont font;
	Rectangle gui;
	Image img;
	int type;

	private int scaling = 0;
	private float scalingX;
	private float scalingY;
	private float scale;
	private boolean inited = false;
	private ContentPosition position;
	private boolean centering;

	/**
	 * @param x
	 * @param y
	 * @param string
	 * @param font
	 */
	public Label(int x, int y, String string, TrueTypeFont font) {
		super();
		this.x = x;
		this.y = y;
		this.string = string;
		this.font = font;
		this.type = 1;
	}

	public Label(int type, int x, int y, String content) throws SlickException {
		super();
		this.x = x;
		this.y = y;
		this.type = type;

		if (type == 2) {
			this.img = new Image(content);
		} else if (type == 1) {
			this.string = content;
			this.font = new TrueTypeFont(new Font("Garamond", 10, 25), true);
		} else
			Util.print("Wrong Label type initialized: Type " + type
					+ "; Content: " + content);

	}

	public void setPosition(ContentPosition pos) {
		position = pos;
		scaling = 3;
		rescale();
	}

	public Label(float x, float y, String content, float scale)
			throws SlickException {
		super();

		scaling = 1;

		scalingX = x;
		scalingY = y;
		type = 2;
		this.scale = scale;
		this.img = new Image(content);
		img = img.getScaledCopy(scale);
		rescale();

	}

	public Label(int type, float x, float y, String content)
			throws SlickException {
		super();

		scaling = 1;

		scalingX = x;
		scalingY = y;
		rescale();

		this.type = type;

		if (type == 2) {
			this.img = new Image(content);

		} else if (type == 1) {
			this.string = content;
			this.font = new TrueTypeFont(new Font("Garamond", 10, 25), true);
		} else
			Util.print("Wrong Label type initialized: Type " + type
					+ "; Content: " + content);

	}

	public void rescale() {

		switch (scaling) {
		case 0:
			break;
		case 1: {
			x = (int) (Trololus.app.getWidth() * scalingX);
			y = (int) (Trololus.app.getHeight() * scalingY);
			break;
		}
		case 2: {
			int scale = x;
			x = (int) (Trololus.app.getWidth() * scalingX);
			y = (int) (Trololus.app.getHeight() * scalingY);

			if (inited)
				img.getScaledCopy(scale / x);
			else
				inited = true;
			break;
		}
		case 3: {
			// initialize starting values
			int contentW = 0, contentH = 0, appW, appH;
			if (type == 1) {
				contentW = font.getWidth(string);
				contentH = font.getHeight();
			} else if (type == 2) {
				contentH = img.getHeight();
				contentW = img.getWidth();
			} else
				Util.print("An error occured in a label : type not properly initialized");

			appW = Trololus.app.getWidth();
			appH = Trololus.app.getHeight();
			
			//set the actual new X's and Y's
			switch (position) {
			case TopLeft:
				x = 0;
				y = 0;
				break;
			case TopCenter:
				x = appW / 2 - contentW / 2;
				y = 0;
				break;
			case TopRight:
				x = appW - contentW;
				y = 0;
				break;
			case CenterLeft:
				x = 0;
				y = (appH / 2) - (contentH / 2);
				break;
			case Center:
				x = (appW / 2) - (contentW / 2);
				y = (appH / 2) - (contentH / 2);
				break;
			case CenterRight:
				x = appW - contentW;
				y = (appH / 2) - (contentH / 2);
				break;
			case BottomLeft:
				x = 0;
				y = appH - contentH;
				break;
			case BottomCenter:
				x = appW / 2 - contentW / 2;
				y = appH - contentH;
				break;
			case BottomRight:
				x = appW - contentW;
				y = appH - contentH;
				break;
			default:
				Util.print("Label Position fucked up - unknown value passed to the method");
				break;
			
			}
			break;
		}

		default: {
			Util.print("Label incorrectly initialized - scaling has fucked up");
			break;
		}
		
		}
		
	}

	public void render() {
		if (!centering) {
			switch (type) {
			case 1: {
				font.drawString(x, y, string);
				break;
			}
			case 2: {
				img.draw(x, y);
				break;
			}
			default:
				Util.print("Label " + string
						+ "can't be drawn; Wrong label type.");
				break;
			}
		} else {
			switch (type) {
			case 1: {
				font.drawString(x - font.getWidth(string),
						y - font.getHeight(), string);
				break;
			}
			case 2: {
				img.draw(x - (img.getWidth() / 2), y - (img.getHeight() / 2));
				break;
			}
			default:
				Util.print("Label " + string
						+ "can't be drawn; Wrong label type.");
				break;
			}

		}
	}

	public void render(Rectangle rect) {

		switch (type) {
		case 1: {
			font.drawString(x + rect.getMinX(), y + rect.getMinY(), string);
			break;
		}
		case 2: {
			img.draw(x + rect.getMinX(), y + rect.getMinY());
			break;
		}
		default:
			Util.print("Label " + string + "can't be drawn; Wrong label type.");
			break;
		}

	}

	public void setScale(float scale) {
		img = img.getScaledCopy(scale);
	}

	/**
	 * @param b
	 */
	public void setCentering(boolean b) {
		centering = b;

	}

}