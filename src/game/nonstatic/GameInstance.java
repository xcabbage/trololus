package game.nonstatic;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.Color;

import game.core.states.BasicState;
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
	Player[] player;
	Rectangle drawGround = new Rectangle(400, 200, 250, 250);
	Color fillColor;
	BattleField field;
	Image ship;
	BasicState state;
	int rotation2;
	// constructor for a new game
	
	void init(){
		field = new BattleField();
		
		//load images and stuff
		try {
			ship = new Image("resources/Splash/Imperial/Striker/Imperial_Striker_Hull.png");
			ship = ship.getScaledCopy((float)0.1);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public BattleField getField() {
		return field;
	}
	
	public GameInstance(BasicState state, Player... players) {
		this.state = state; 
		player = new Player[players.length];
		// set up our players (get them from the main frame)
		for (int a = 0; a < players.length; a++) {
			player[a] = players[a];

		}

		// initialize the rest of the game
		init();
	}

	public GameInstance() {
		player = new Player[1];
		player[0] = new Player();
		init();
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.setAntiAlias(true);
		g.setLineWidth(5);
		g.draw(drawGround);
		
		if (player[0] != null) {
			g.setColor(player[0].getColor());
		} else
			System.out.println("playyer 0 is null");
		g.fill(drawGround);
		
		for (int a = 0; a <field.getEntitiesCount(); a++){
		ship.rotate(field.getRotation(a)-rotation2);
		rotation2 = field.getRotation(a);
		ship.drawCentered((float)field.getShipX(a), (float)field.getShipY(a)); 
		}
		g.drawString("JOSEF", 250, 250);

	}

	public void centerShip(int id) {
		field.setShipX(500, id);field.setShipY(300,id);
		
	}

}