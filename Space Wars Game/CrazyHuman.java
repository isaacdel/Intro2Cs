/**
 * FILE : CrazyHuman.java
 * DESCRIPTION:
 * 		This spaceship is controlled by the user. The keys
 * 		used to control the spaceship are: left-arrow, right-arrow, up-arrow to turn
 * 		left,right and accelerate. "s" to fire a shot. "d" to turn on the shield. "t" to
 * 		teleport.
 * 		in addition there is a 2 percent chance this ship will teleport itself,
 * 	 	if it has enough energy.
 * @authors isaacdel & roee168
 *
 */
public class CrazyHuman extends Human  {
	private static final int CHANCE_FACTOR = 50;

	/**
	 *  Does the actions of this ship for this round. 
	 *  This is called once per round by the SpaceWars game driver.
	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game){
		super.doAction(game);
		int random = (int)Math.random()*CrazyHuman.CHANCE_FACTOR;//crazy has 2% to teleport every turn
		if(random==1)
			teleport();	
	}
}
