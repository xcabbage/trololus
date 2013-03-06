package game.core.parts;
/**
 * For moving objects that slow down as they aproach their location
 * 
 * @author Xargo
 * 
 * @info for the Trololus project [github.com/xcabbage/trololus] created
 *       6.3.2013 18:33
 */

public class DriftArt {
	int targetX;
	int targetY;
	int posX;
	int posY;
	int speed;
	{
		while ( (targetX-posX) * (targetX-posX) + (targetY - posY) * (targetY - posY) > 0 ) {
			posX = posX + ((targetX-posX) / speed);
			posY = posY + ((targetY-posY) / speed);
			
				if ( (targetX-posX) * (targetX-posX) + (targetY - posY) * (targetY - posY) < 1.2 ) {
					posX = targetX;
					posY = targetY;
				}
	
		}
	
}	
	
}