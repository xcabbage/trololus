package game.core.parts;

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

	public Label(int type,int x, int y,  String content) throws SlickException {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		System.out.println("type is " + type);
		if (type == 2){
			this.img = new Image(content);}
		else if (type == 1) {
			this.string = content;
			this.font = new TrueTypeFont(new Font("Garamond", 10, 25), true);
		} else
			Util.print("Wrong Label type initialized: Type " + type
					+ "; Content: " + content);

	}

	public void render() {
		switch (type) {
		case 1: {
			font.drawString(x , y , string);
			break;
		}
		case 2: {
			img.draw(x , y);
			break;
		}
		default:
			Util.print("Label " + string + "can't be drawn; Wrong label type.");
			break;
		}
	}

	public void render(Rectangle rect) {
		switch (type) {
		case 1: {
			font.drawString(x + rect.getMinX(), y + rect.getMinY(), string);
			break;
		}
		case 2: {
			img.draw(x + rect.getMinX(), y+rect.getMinY());
			break;
		}
		default:
			Util.print("Label " + string + "can't be drawn; Wrong label type.");
			break;
		}
	}

	public Label(int x, int y, String string, FontType type) {

	}
}