import intro.ex9.GameGUI;
import intro.ex9.SpaceShipPhysics;

import java.awt.Image;
import intro.ex9.*;
import javax.print.attribute.standard.MediaSize.Other;
import javax.print.attribute.standard.SheetCollate;
/**
 * FILE : Human.java
 * DESCRIPTION:
 * 		This spaceship is controlled by the user. The keys
 * 		used to control the spaceship are: left-arrow, right-arrow, up-arrow to turn
 * 		left,right and accelerate. "s" to fire a shot. "d" to turn on the shield. "t" to
 * 		teleport.
 * @authors isaacdel & roee168
 *
 */
public class Human extends SpaceShip{
	private static final int SHIELD_ENERGY_COST = 3;
	/**
	 *  Does the actions of this ship for this round. 
 This is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		direction=0;
		this.shield=false;
		if(game.getGUI().isTPressed()){//teleport
			teleport();
		}
		if(game.getGUI().isLeftPressed())//left
			direction=1;
		if(game.getGUI().isRightPressed())//right
			direction=-1;   
		this.pos.move(game.getGUI().isUpPressed(),direction);
		if(game.getGUI().isDPressed()&& this.energy>=3){//will turn on shield if possible and asked
			this.shield=true;
			this.energy-=Human.SHIELD_ENERGY_COST;
		}
		if(game.getGUI().isSPressed()){
			shoot(game,frameCount);
		}
		this.energy++;
		this.frameCount++;
	}
//	/**
//	 *  Gets the image of this ship. This method should return the image of the
// ship with or without the shield. This will be displayed on the GUI at
// the end of the round.
//
//	 * @return the image of the ship.
//	 */
//	public Image getImage() {
//		if(this.shield){
//			return GameGUI.SPACESHIP_IMAGE_SHIELD;
//		}
//
//		else{
//			return GameGUI.SPACESHIP_IMAGE;
//		}
//	}
}

