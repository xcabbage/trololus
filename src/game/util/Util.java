package game.util;

import game.core.Trololus;
import game.core.parts.ContentPosition;
import game.core.parts.Label;
import game.core.parts.StateBuilder;
import game.core.states.BasicState;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The Util.java class containing various methods providing utitity for the game
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       7.2.2013 17:55:46
 */
public class Util {

	// Options, mainly debug constants, not to clog other classes.

	/*
	 * BOOLEAN - whether State 6 outputs debug text showing the state of Y axis
	 */
	public static final boolean debugAxisSoutEnabled = false;

	static Object[] prolongedArray;
	// public static Trololus game = Trololus;
	private static Trololus game;
	public static TrueTypeFont fontGreatHeader, fontEntry, fontNormalHeader,
			fontText, fontButton;

	public static void init(StateBasedGame game) throws SlickException {

		// init globals
		Util.game = (Trololus) game;
	}

	public static void prolongArray(int length, int[]... objects) {
		for (int a = 0; a < objects.length; a++)
			objects[a] = Arrays.copyOf(objects[a], objects[a].length + length);
	}

	public static void prolongArray(int length, Object[]... objects) {
		for (int a = 0; a < objects.length; a++) {
			objects[a] = Arrays.copyOf(objects[a], objects[a].length + length);
		}
		System.out.println("prolonged arrays for " + length);
	}

	public static void prolongArray(int length, Object[] array) {
		// broken and doesn't do anything. the one up above probably too
		prolongedArray = array;
		prolongedArray = Arrays.copyOf(array, array.length + length);
		System.out.println("Copied. New array length: " + array.length + ".");

	}

	public static void print(String string) {
		System.out.println("[UPrint] " + string);
		BasicState state = (BasicState) game.getCurrentState();
		try {
			StateBuilder builder = state.sb;
			System.out.println(builder);
			System.out.println(state);
			builder.addLabel(1, 0.5f, 0.5f, string);
			final Label notification = state.sb.getLabel(-1);
			notification.setColor(Color.blue);
			notification.setPosition(ContentPosition.Center);

			notification.fadeIn(1000);

			Timer time = new Timer();
			time.schedule(new TimerTask() {

				@Override
				public void run() {
					notification.fadeOut(1000);

				}
			}, 3000);

		} catch (SlickException e) {
			printDebug("Error with Util.print(): " + string);
		}
	}

	public static void printDebug(String string) {
		System.out.println("[UDebug] " + string);
	}

	/**
	 * @param string
	 */
	public static void printErr(String string) {
		System.out.println("[UErr] " + string);
		BasicState state = (BasicState) game.getCurrentState();
		try {
			state.sb.addLabel(1, 0.5f, 0.6f, string);
			final Label notification = state.sb.getLabel(-1);
			notification.setColor(Color.red);
			notification.setPosition(ContentPosition.Center, 0, 200);
			notification.setBackground("resources/splash/ui/ps/Lore_Frame.png");
			notification.setAlpha(0f);
			notification.fadeIn(1000);

			Timer time = new Timer();
			time.schedule(new TimerTask() {

				@Override
				public void run() {
					notification.fadeOut(1000);

				}
			}, 3000);

		} catch (SlickException e) {
			printDebug("Error with Util.print(): " + string);
		}

	}

	public static void notify(String string) {
		System.out.println("[UNoti] " + string);
		BasicState state = (BasicState) game.getCurrentState();
		try {
			state.sb.addLabel(1, 0.5f, 0.6f, string);
			final Label notification = state.sb.getLabel(-1);
			notification.setColor(Color.blue);
			notification.setPosition(ContentPosition.Center, 0, 100);
			notification.setBackground(Color.black, Color.blue.darker());
			notification.setAlpha(0f);
			notification.fadeIn(1000);

			Timer time = new Timer();
			time.schedule(new TimerTask() {

				@Override
				public void run() {
					notification.fadeOut(1000);

				}
			}, 3000);

		} catch (SlickException e) {
			printDebug("Error with Util.print(): " + string);
		}

	}

	public static void initFonts() {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(java.awt.Font.createFont(
					java.awt.Font.TRUETYPE_FONT, new File(
							"resources/fonts/orena.ttf")));
			ge.registerFont(java.awt.Font.createFont(
					java.awt.Font.TRUETYPE_FONT, new File(
							"resources/fonts/basica.ttf")));
			ge.registerFont(java.awt.Font.createFont(
					java.awt.Font.TRUETYPE_FONT, new File(
							"resources/fonts/moiser.ttf")));
			ge.registerFont(java.awt.Font.createFont(
					java.awt.Font.TRUETYPE_FONT, new File(
							"resources/fonts/complex.ttf")));
			ge.registerFont(java.awt.Font.createFont(
					java.awt.Font.TRUETYPE_FONT, new File(
							"resources/fonts/freedom.ttf")));

			fontGreatHeader = new TrueTypeFont(new Font(
					BasicState.fontGreatHeader, 25, 43), true);
			fontNormalHeader = new TrueTypeFont(new Font(
					BasicState.fontNormalHeader, 10, 20), true);
			fontEntry = new TrueTypeFont(
					new Font(BasicState.fontEntry, 10, 25), true);
			fontText = new TrueTypeFont(new Font(BasicState.fontText, 25, 25),
					true);
			fontButton = new TrueTypeFont(new Font(BasicState.fontButton, 10,
					25), true);

		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public static Trololus getGame() {

		return game;
	}

}
