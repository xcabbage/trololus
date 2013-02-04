package game.nonstatic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.Color;

import game.nonstatic.system.Player;
import game.util.FastGraphics;
import game.util.MoreColors;

/**
 * @author xCabbage [github.com/xcabbage]
 * 
 *         for the Trololus project [github.com/xcabbage/trololus] created
 *         4.2.2013 14:56:16
 */

public class GameInstance {
	FastGraphics gF = new FastGraphics();
	Player [] player;
	Rectangle drawGround = new Rectangle(400, 200, 250, 250);
	Color fillColor;
	// constructor for a new game
	public GameInstance(Player... players) {
		player = new Player[players.length];
		// set up our players (get them from the main frame)
			for (int a = 0; a < players.length; a++) {
			player[a] = players[a];
		
		}

		// initialize the rest of the game

	}

	public GameInstance() {
		;
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.setAntiAlias(true);
		g.setLineWidth(5);
		g.draw(drawGround);
		if (player[0] != null){g.setColor(player[0].getColor());} else System.out.println("playyer 0 is null");
		g.fill(drawGround);
		
		g.drawString("JOSEF", 250, 250);
		
	}

}