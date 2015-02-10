package game.core.parts;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.GameState;

import core.nic.cc.Cloud;


public class Clouds extends Component {
	
	Cloud cl[];
	double a[];
	Image image;
	SpriteSheet cloudbrush;
	
	public Clouds(GameState state, GameContainer gc, Graphics g){
		super(state, gc, g);
		
	}
	public void init() {
		
		//images
		image = new Image("core/nic/cc/nic/podklad.png");
		cloudbrush = new SpriteSheet("core/nic/cc/nic/cloudbrush.png", 340, 340);
		
		//cloud creation
		cl = new Cloud[22];
		for(int g = 0; g<4;g++){
		cl[g] = new Cloud(this, cloudbrush, gc, 100,50);
		}
		
		//accelerations
		a = new double[22];
		Random ac = new Random();
		
		for(int l=0;l<4;l++){
			float acc = ac.nextFloat();
			a[l] = acc;
		}
		
		
	}

	public void update() {
		
	}

	public void render() {


	}


}
