package game.util;

import java.awt.Font;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

/**
 * The Label.java class responsible for
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

	public Label(int x, int y, String string, FontType type) {

	}
}
