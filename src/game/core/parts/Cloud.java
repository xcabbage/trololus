package game.core.parts;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Cloud {
	
	Clouds clouds;
	Image podklad;

	public Cloud(Clouds c, SpriteSheet images, GameContainer gc,int x,int y) {

		clouds = c;

		try {
			podklad = new Image("core/nic/cc/nic/podklad.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		
		
		Graphics podklad1 = null;																		
		try {
			
			
			podklad1 = podklad.getGraphics();
			podklad1.copyArea(podklad, 0, 0);

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}

		Random k = new Random();
		Random kx = new Random();
		Random ky = new Random();
		int time = 0;
		Input input = gc.getInput();

		for (int j = 0; j < 4; j++) {

			int randomNumber = k.nextInt(3);
			int randomX = kx.nextInt(4);
			int randomY = kx.nextInt(3);
			podklad1.setBackground(new Color(0,0,0,0));
			podklad1.setColor(Color.magenta);
			podklad1.setColor(Color.cyan);
			switch (randomNumber) {
			case 0:	
				 images.getSubImage(randomX,randomY).draw(x+1,y+1);
				break;
			 case 1: 
				 images.getSubImage(randomX,randomY).draw(x-1, y+1);
			 break;
			 case 2: 
				 images.getSubImage(randomX, randomY).draw(x-1, y-1);
			 break;
			 case 3: 
				 images.getSubImage(randomX,randomY).draw(x+1, y-1);
			 break;
			 default:
			 System.out.println("ERROR has occured when generating randomnumber");
			 break;
			}	
			podklad1.flush();
		
		}
		
		
		

	}

	public Image returnCloud(SpriteSheet images){ 

			return podklad;
			



	}


}
