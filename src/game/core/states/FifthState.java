package game.core.states;

import org.newdawn.slick.Color;

import game.core.Trololus;
import game.nonstatic.BattleField;
import game.nonstatic.GameInstance;
import game.nonstatic.entities.controllables.Ship;
import game.nonstatic.entities.controllables.ShipType;
import game.nonstatic.system.Player;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class FifthState extends BasicState{

	BasicState stateRes;
	public static int ID = 4;
	float glowF;
	int glow;
	GameInstance instance;
	Player player = new Player("Davefinek", Color.white);
	boolean gameRunning = false;
	FifthState state = this;
	BattleField field;
	int SPEED = 5;
	Ship controlledShip;
	
	
	
	public int getID() {
		return ID;
	}
		
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
			super.init(gc, game);
			instance = new GameInstance((BasicState) state, player);
			field = instance.getField();
			controlledShip = new Ship(ShipType.Striker);
			field.placeEntity(controlledShip);
			instance.centerShip(controlledShip.getID());
			gameRunning = true;
			StateTitle = "State 5 - Game - GfX test! (once to be Player Profile)";
			
		}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();

		
		//state switching 
		if (input.isKeyPressed(46)) {
			System.out.println("switching Player color");
			player.setColor(Color.orange);
		}
		
		if (input.isKeyPressed(47)) {
			System.out.println("switching Player color");
			player.setColor(Color.magenta);
		}
		
		if (input.isKeyDown(1)) {
			System.out.println("Shutting Down.. [command: Main]");
			System.exit(0);
		}
		
		
		//ship movement
		if (gameRunning){
		
			//rotation
		if (input.isKeyDown(30)){
			field.setRotation(field.getRotation(controlledShip.getID())-SPEED, controlledShip.getID());
					}

		if (input.isKeyDown(32)){
			field.setRotation(field.getRotation(controlledShip.getID())+SPEED,controlledShip.getID());
		}
		
			//movement
		if (input.isKeyDown(17)){
			field.moveShipForwards(controlledShip.getID());
								}
		if (input.isKeyDown(31)){
			field.moveShipBackwards(controlledShip.getID());
					}
		
			//reset ship coords
		if (input.isKeyDown(29)){
			field.setShipX(500,controlledShip.getID());
			field.setShipY(300,controlledShip.getID());
			field.setRotation(0, controlledShip.getID());
		}
		}
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
			super.render(gc,mainGame,g,stateRes);
			instance.draw(g);
			}
	
	
	
	
	
	
	
	
	
	
	}