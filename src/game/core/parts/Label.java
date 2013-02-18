package game.core.parts;

import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

/**
 * The Label.java class representing a single text label (entry) in the game.
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
	}

	public Label(int x, int y, String string) {
		super();
		this.x = x;
		this.y = y;
		this.string = string;
		this.font = new TrueTypeFont(new Font("Garamond", 10, 25), true);
	}

	public void render() {
		font.drawString(x, y, string);

	}

	public void render(Rectangle rect) {
		font.drawString(x+rect.getMinX(), y+rect.getMinY(), string);
	}

	public Label(int x, int y, String string, FontType type) {

	}
}
