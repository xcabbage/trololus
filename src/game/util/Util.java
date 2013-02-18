package game.util;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.sun.org.apache.xpath.internal.operations.Variable;

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
	public static void prolongArray(int length, int[]... objects) {
		for (int a = 0; a < objects.length; a++)
			objects[a] = Arrays.copyOf(objects[a], objects[a].length + length);
	}

	public static void prolongArray(int length, Object[]... objects) {
		for (int a = 0; a < objects.length; a++) {
			objects[a] = Arrays.copyOf(objects[a], objects[a].length + length);
		}
		System.out.println("prolonged arrays for "+ length);
	}

	public static void prolongArray(int length, Object[] array) {
	//broken and doesn't do anything. the one up above probably too
		prolongedArray = array;
		prolongedArray = Arrays.copyOf(array, array.length + length);
		System.out.println("Copied. New array length: "+  array.length+ ".");

	}
}
