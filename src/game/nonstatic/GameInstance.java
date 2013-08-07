package game.nonstatic;

import java.util.Arrays;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Color;

import game.core.Trololus;
import game.core.states.BasicState;
import game.nonstatic.entities.controllables.Ship;
import game.nonstatic.system.Player;
import game.util.FastGraphics;

/**
 * The GameInstance class that holds each instance of the actual game.
 * Responsible for drawing the situation and holding all the variables.
 * 
 * @author xCabbage [github.com/xcabbage]
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       4.2.2013 14:56:16
 */

public class GameInstance {
	FastGraphics gF = new FastGraphics();
	Player[] player;
	Rectangle drawGround = new Rectangle(400, 200, 250, 250);
	Color fillColor;
	BattleField field;
	public Image[] ship = new Image[1];
	BasicState state;
	Trololus game;
	int rotation2[] = new int[1];

	// creation of a new game
	void init() throws SlickException {
		field = new BattleField(this);

	}

	@SuppressWarnings("static-access")
	public void addShip(Ship ship) throws SlickException {

		// If ship model array is full, make new one
		if (this.ship[this.ship.length - 1] != null) {
			this.ship = Arrays.copyOf(this.ship, this.ship.length + 1);
		}

		this.ship[this.ship.length - 1] = new Image(ship.getType().getImgPath())
				.getScaledCopy(game.ShipScale);

	}

	public BattleField getField() {
		return field;
	}

	public GameInstance(BasicState state, StateBasedGame game,
			Player... players) throws SlickException {
		this.state = state;
		this.game = (Trololus) game;
		player = new Player[players.length];
		// set up our players (get them from the main frame)
		for (int a = 0; a < players.length; a++) {
			player[a] = players[a];

		}

		// initialize the rest of the game
		init();
	}

	public GameInstance() throws SlickException {
		player = new Player[1];
		player[0] = new Player();
		init();
	}

	public void draw(Graphics g) {
		// initial graphics stuff
		g.setAntiAlias(true);
		if (player[0] != null) {
			g.setColor(player[0].getColor());
		} else
			System.out.println("Player 0 is null, can't draw stuff!");

		field.drawShips();
		field.drawProjectiles();
		g.setColor(Color.white);
	}

	public void centerShip(int id) {
		field.setShipX(500, id);
		field.setShipY(300, id);
		field.setRotation(0, id);

	}

}