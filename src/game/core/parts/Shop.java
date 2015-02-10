package game.core.parts;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;

public class Shop extends Component {
	
	static int price = 1000, rot, rotation;
	String nu;
	Image shop, buyButton, cannotbuyButton;
	
	public Shop(GameState state, GameContainer gc, Graphics g) {
		super(state, gc, g);

	}

	public void init(){
		
		shop = new Image("resources/ui/Shop/shop.png");
		buyButton = new Image("");
		cannotbuyButton = new Image("");

		
	}

	public void update() {
		// switch pro obchod

				switch (rot) {
				case 0:
					nu = "1";
					price = 10;

					break;
				case 45:
					nu = "2";
					price = 20;

					break;
				case 90:
					nu = "3";
					price = 30;

					break;
				case 135:
					nu = "4";
					price = 40;

					break;
				case 180:
					nu = "5";
					price = 50;
					break;

				case 225:
					nu = "6";
					price = 60;
					break;

				case 270:
					nu = "7";
					price = 70;
					break;

				case 315:
					nu = "8";
					price = 80;
					break;
				default:
					System.out.println("angle not found");

				}
				System.out.println(nu);
				// konec switch

				
				// handling rotation of the shop
				Input input = gc.getInput();
				
				if (input.isKeyPressed(Input.KEY_F)) {
					rot = rotation + 45;
					shop.setRotation(rot);
					// System.out.println(rot);
					rotation = rot;

				}
				if (input.isKeyPressed(Input.KEY_G)) {
					rot = rotation - 45;
					shop.setRotation(rot);
					rotation = rot;
				}
				if (rot > 360 || rot == 360) {
					rot = rot - 360;

				}
				if (rot < 0) {
					rot = rot + 360;
				}

		
	}

	public void render() {


	}
	public void description(GameContainer gc, Graphics g) {
		if (nu != null) {
			switch (nu) {
			case "1":
				g.drawString("why hello there this is the first weapon", 50, 50);

				break;
			case "2":
				g.drawString("second weapon", 50, 50);

				break;
			case "3":
				g.drawString("third weapon - description", 50, 50);

				break;
			case "4":
				g.drawString("forth weapon - descrption", 50, 50);

				break;
			case "5":
				g.drawString("fifth weapon", 50, 50);
				break;

			case "6":
				g.drawString("sixth weapon", 50, 50);
				break;

			case "7":
				g.drawString("seventh weapon", 50, 50);
				break;

			case "8":
				g.drawString("last weapon", 50, 50);
				break;
			default:
				System.out.println("ERROR NO WEAPON SELECTED");

				// konec switch

			}

		}

	}



}
