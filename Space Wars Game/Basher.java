/**
 * FILE : Bassher.java
 * DESCRIPTION:
 * 		    This ship attempts to collide with other ships. It will always
 *			accelerate, and turn towards the closest ship. If it gets within a distance
 *			of 0.2 units from another ship, it will turn on its shield.
 * @authors isaacdel & roee168
 *
 */
public class Basher extends Enemy {
	/**
	 *  Does the actions of this ship for this round. 
	 *  This is called once per round by the SpaceWars game driver.
	 * @param game the game object to which this ship belongs.
	 */
	public void doActionBasher(SpaceWars game) {
		super.doAction(game);
		//activate shield when getting close to the opponent, unless it is already active
		if(this.distanceFrom(game.getClosestShipTo(this))<=FACING_ANGLE){
			this.shield=true;
		}
	}
}
