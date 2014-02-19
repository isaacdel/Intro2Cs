/**
 * FILE : Special.java
 * DESCRIPTION:
 * this ship is a progressive kind of aggressive ship
 * it also teleports every 100 frames (a few seconds) 
 * attack from all angels it also have limitless amount of shots and shield. 
 * @author isaacdel & roee168
 *
 */
public class Special extends Aggressive {
	private static final int TELEPORTING_FACTOR = 100;

	public void doAction(SpaceWars game){
		super.doAction(game);
		if(frame==0){//teleports every 100 frames.
			teleport();
			frame=Special.TELEPORTING_FACTOR;
		}
		frame--;
		this.energy=ENERGY_STARTING_AMOUNT;
		this.shield=true;
	}
}
