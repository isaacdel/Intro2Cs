/**
 * FILE : Aggressive.java
 * DESCRIPTION:
 * 		This ship pursues other ships and tries to fire at them. It
 *		will always accelerate, and turn towards the nearest ship. If its angle from
 *		the nearest ship is 0.2 radians or less (in any direction) then it will open fire.
 * @authors isaacdel & roee168
 *
 */
public class Aggressive extends Enemy{
	protected int frame=100;
	/**
	 *  Does the actions of this ship for this round. 
	 *  This is called once per round by the SpaceWars game driver.
	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game){
		super.doAction(game);
		if (angle<=Aggressive.FACING_ANGLE){//shoots enemy if he facing him.
			shoot(game,frameCount);
		}
		this.energy+=1;
	}
}