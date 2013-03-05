package game.util;

import game.core.Trololus;
import game.core.parts.ContentPosition;
import game.core.parts.Label;
import game.core.states.BasicState;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
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
	static Object[] prolongedArray;
	// public static Trololus game = Trololus;
	private static Trololus game;

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
			state.sb.addLabel(1, 0.5f, 0.5f, string);
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
			notification.setBackground(Color.black,Color.blue.darker());
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

	
	
}
