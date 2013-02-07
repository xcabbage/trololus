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
	
	
	@SuppressWarnings("rawtypes")
	public static void prolongArray(int length, Array[]... objects) {
		for (int a = 0; a < objects.length; a++) 
			objects[a] = Arrays.copyOf(objects[a], objects[a].length+ length);
		}


}
