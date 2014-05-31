import intro.ex9.*;
/**
 * FILE : Runner.java
 * DESCRIPTION:
 * 			This spaceship attempts to run away from the fight. It will
 *			constantly accelerate,and turn away from the ship that is closest. The
 *			runner has the spying ability and will attempt spying on each round. It
 *			will try to get the nearest ship cannon angle from himself. if that angle
 *			is smaller than 0.2 radians (in any direction) and the distance from the
 *			nearest ship is smaller than 0.2 units, the runner will try to teleport.
 * @authors isaacdel & roee168
 *
 */
public class Runner extends SpaceShip {
	private double angle;
	protected boolean acceleration;
	/**
	 *  Does the actions of this ship for this round. 
	 *  This is called once per round by the SpaceWars game driver.
	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		angle=this.pos.angleTo(game.getClosestShipTo(this).getPhysics());
		if((Math.abs(angle)<=0.2)){
			direction=direction;
			acceleration=true;
		}
		if(angle<0 && 
				angle>-Math.PI){
			direction=direction;
			acceleration=true;
		}
		if(angle>=0 &&
				angle<Math.PI)
			direction=-direction;
		acceleration=true;
		this.pos.move(acceleration, direction);
		if(pos.distanceFrom(game.getClosestShipTo(this).getPhysics())<FACING_ANGLE){
			teleport();//if runner is in danger zone - teleport
		}
	}
}

