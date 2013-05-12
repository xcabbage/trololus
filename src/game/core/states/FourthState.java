package game.core.states;

import game.core.parts.ContentPane;
import game.core.parts.ContentPosition;
import game.util.MoreColors;
import game.util.Util;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;

public class FourthState extends BasicState {
	private static final float menuButtonsScale = 0.7f;

	ContentPane menu;

	public static int ID = 3;

	public void createContent() throws SlickException {
	
//	sb.addLabel(2,-250,-350,"/resources/Splash/pilots/Pilot4a.png");
//	sb.addLabel(1, 550,650, "GIVE ME YOUR CHICKEN, HUMAN!");
//	sb.addLabel(2,680,450,"/resources/Splash/Missing_Icon.png");
//	sb.getLabel(-1).setScale(0.3f);
//	sb.addLabel(2,0,0,"/resources/Splash/pilots/Pilot_Port4.png");
//	sb.getLabel(-1).setScale(0.25f);

		
		sb.addLabel(1, 0.5f, 0.5f, "Profile & Stats");
		sb.getLabel(-1).setFont(Util.fontGreatHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 50);

		sb.addLabel(1, 0.5f, 0.5f, "Customize your profile, track your stats and achievements.");
		sb.getLabel(-1).setFont(Util.fontNormalHeader);
		sb.getLabel(-1).setPosition(ContentPosition.TopCenter, 0, 100);
		sb.getLabel(-1).setColor(Color.white.darker(0.1f));
  	
		sb.addContentPane(0.05f, 0.3f, 0.15f, 0.4f);
	    menu =sb.getPane(-1);
	    menu.setBackground(MoreColors.getTrans(Color.gray.darker(0.15f), 0.1f),Color.red.darker(0.9f));

	    
	    menu.addButton(10, 5, new Image("resources/parts/state4/button0.png").getScaledCopy(menuButtonsScale));
	    menu.getComponent(-1).addListener(new ComponentListener() {
			
			@Override
			public void componentActivated(AbstractComponent source) {
				
			}
		});

	    
	    menu.addButton(10, 50, new Image("resources/parts/state4/button1.png").getScaledCopy(menuButtonsScale));
	    menu.getComponent(-1).addListener(new ComponentListener() {
			
			@Override
			public void componentActivated(AbstractComponent source) {
				
			}
		});

	    menu.addButton(10, 95, new Image("resources/parts/state4/button2.png").getScaledCopy(menuButtonsScale));
	    menu.getComponent(-1).addListener(new ComponentListener() {
			
			@Override
			public void componentActivated(AbstractComponent source) {
				
			}
		});
	    menu.addButton(10, 140, new Image("resources/parts/state4/button3.png").getScaledCopy(menuButtonsScale));
	    menu.getComponent(-1).addListener(new ComponentListener() {
			
			@Override
			public void componentActivated(AbstractComponent source) {
				
			}
		});
	    menu.addButton(10, 185, new Image("resources/parts/state4/button4.png").getScaledCopy(menuButtonsScale));
	    menu.getComponent(-1).addListener(new ComponentListener() {
			
			@Override
			public void componentActivated(AbstractComponent source) {
				
			}
		});

	    
	}

	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		super.init(gc, game);
		StateTitle = "Fourth State - Garage";
	}

	public int getID() {
		return ID;
	}

	public void update(GameContainer gc, StateBasedGame mainGame, int delta)
			throws SlickException {
		super.update(gc, mainGame, delta);
	}

	public void render(GameContainer gc, StateBasedGame mainGame, Graphics g)
			throws SlickException {
		renderDiffGfx(gc, mainGame, g, stateRes);
		super.render(gc, mainGame, g, stateRes);
	}
}