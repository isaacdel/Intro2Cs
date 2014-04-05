import intro.ex9.GameGUI;
import intro.ex9.*;
import javax.print.attribute.standard.MediaSize.Other;
import java.awt.Image;
/**
 *  The API spaceships need to implement for the SpaceWars game.
 It is your decision whether SpaceShip.java will be an interface, an abstract
 class, a base class for the other spaceships or any other option you 
 will chooce.

 */
public class SpaceShip extends intro.ex9.SpaceShipPhysics{
	private static final int SHOOT_ENERGY_COST = 25;
	private static final int FRAME_MIN_SHOOT_TIME = 8;
	private static final int TELEPORT_ENERGY_COST = 150;
	private static final int HEALTH_STARTING_AMOUNT = 10;
	protected static final int ENERGY_STARTING_AMOUNT = 200;
	/**
	 * The position and physics of the ship. 
	 */
	protected SpaceShipPhysics pos; 
	protected boolean shield;
	protected int health;
	protected int direction=1;
	protected int energy;
	protected int frameCount;
	protected static final double FACING_ANGLE = 0.2;
	public SpaceShip(){
		pos = new SpaceShipPhysics();
		this.shield=false;
		this.health=SpaceShip.HEALTH_STARTING_AMOUNT;
		this.energy=SpaceShip.ENERGY_STARTING_AMOUNT;
	}
	/**
	 *  This method is called every time a collision with this ship occurs.

	 */
	public void collidedWithAnotherShip() {
		if(!shield)
			health--;
	}
	/**
	 *  Does the actions of this ship for this round. 
 This is called once per round by the SpaceWars game driver.

	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {

	}
	/**
	 *  Gets the image of this ship. This method should return the image of the
 ship with or without the shield. This will be displayed on the GUI at
 the end of the round.

	 * @return the image of the ship.
	 */
	public Image getImage() {
		if(this.shield){
			if (this instanceof Human)
				return intro.ex9.GameGUI.SPACESHIP_IMAGE_SHIELD;
			else
				return intro.ex9.GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		}
		else{
			if(this instanceof Human)
				return intro.ex9.GameGUI.SPACESHIP_IMAGE;
			else
				return intro.ex9.GameGUI.ENEMY_SPACESHIP_IMAGE;
		}
	}
	/**
	 *  Gets the physics object that controls this ship.

	 * @return the physics object that controls the ship.
	 */
	public SpaceShipPhysics getPhysics() {

		return this.pos;
	}
	/**
	 *  This method is called by the SpaceWars game object when ever this ship
 gets hit by a shot.
	 * a ship can be hit only if shield is off
	 */
	public void gotHit() {
		if(!this.shield){
			this.health--;
		}
	}
	/**
	 *  Checks if this ship is dead.
	 * @return true if the ship is dead. false otherwise.
	 */
	public boolean isDead() {
		if(this.health==0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 *  This method is called whenever a ship has died. It resets the ship's 
 attributes, and starts it at a new random position.
	 */
	public void reset() {
		pos=new SpaceShipPhysics();
		health=SpaceShip.HEALTH_STARTING_AMOUNT;
		energy=SpaceShip.ENERGY_STARTING_AMOUNT;
		shield=false;

	}
	/**
	 * this method teleports the SpaceShip object
	 * teleport makes The spaceship disappear and reappear at a random location.
	 * this method does all checks needed to verify that the spaceship can teleport
	 * and updates the spaceship properties
	 */
	protected void teleport() {
		if(this.energy > SpaceShip.TELEPORT_ENERGY_COST){	//ship is able to teleport
			pos = new SpaceShipPhysics();
			energy -= SpaceShip.TELEPORT_ENERGY_COST;
		}
	}
	/**
	 * this method is called each time the SpaceShip is shooting
	 * this method does all checks needed to verify that the spaceship can shoot
	 * and updates the spaceship properties
	 * @param game the game object to which this ship belongs.
	 * @param frame the frame counter that delays the shooting.
	 */
	protected void shoot(SpaceWars game,int frame){
		if (frameCount>=SpaceShip.FRAME_MIN_SHOOT_TIME){
			if (energy>SpaceShip.SHOOT_ENERGY_COST)
			{
				game.addShot(this.pos);
				energy-=SpaceShip.SHOOT_ENERGY_COST;
				frameCount=0;
			}
		}
	}
}
