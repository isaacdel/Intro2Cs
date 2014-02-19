import intro.ex9.*;
/**
 * FILE : Enemy.java
 * DESCRIPTION:
 * this class control all the pursuing enemies by defining where they should go 
 * according to the user ship advancement
 * @authors isaacdel & roee168
 *
 */
public class Enemy extends SpaceShip{
	protected double angle;
	protected boolean acceleration;
	/**
	 * the pursuing ship will turn in a specific direction depending on the relative
	 *  angle between the two ships. 
	 *  @param game the game object to which this ship belongs. 
	 */
	public void doAction(SpaceWars game){
		angle=this.pos.angleTo(game.getClosestShipTo(this).getPhysics());
		if (angle>0){
			direction=1;//turn right
			acceleration=true;
		}
		if(angle<0){
			direction=-1;//turn left
			acceleration=true;
		}
		else {
			acceleration=false;
		}
		this.pos.move(acceleration, direction);
		frameCount++;
	}
}



