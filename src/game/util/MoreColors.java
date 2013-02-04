package game.util;

import java.awt.Color;

/**
 * @author David
 * 
 */
@SuppressWarnings("serial")
public class MoreColors extends java.awt.Color {

	static public Color transBlack = new Color(0, 0, 0, 100);
	static public Color transWhite = new Color(255, 255, 255, 100);
	static public Color transRed = new Color(255, 0, 0, 100);
	static public Color transBlue = new Color(0, 0, 255, 100);
	static public Color transGreen = new Color(0, 255, 0, 100);
	static public Color transYellow = new Color(255, 255, 0, 100);
	static public Color transOrange = new Color(255, 128, 0, 100);
	static public Color transCyan = new Color(0, 255, 255, 100);
	static public Color transPurple = new Color(255, 0, 255, 100);

	public Color getTrans(Color c) {
		return new Color(c.getRed(), c.getGreen(), c.getBlue(), 100);

	}

	public Color getTrans(Color c, int alpha) {
		return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);

	}

	public MoreColors() {
		super(0);
	}
}
