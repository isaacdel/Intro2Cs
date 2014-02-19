import intro.ex9.GameGUI;
import java.awt.Image;
import intro.ex9.*;
/**
 * FILE : Floater.java
 * DESCRIPTION:
 * 		    This spaceship does no actions at all. It floats around at a
 * 			constant initial speed and does not turn nor accelerate.
 * @authors isaacdel & roee168
 *
 */
public class Floater extends SpaceShip {
	/**
	 *  Does the actions of this ship for this round. 
	 *  This is called once per round by the SpaceWars game driver.
	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		this.pos.move(true, 0);//keeps floating in the same direction
	}

}
