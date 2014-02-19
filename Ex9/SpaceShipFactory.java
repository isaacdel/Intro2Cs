import java.awt.Image;
import intro.ex9.*;


/**
 * This class contains a single static method that is used to create spaceships
 * of the requested type in the game. You should implement it accordingly.
 */
public class SpaceShipFactory {
	public static final String HUMAN ="h";
	public static final String RUNNER ="r";
	public static final String FLOATER ="f";
	public static final String BASHER ="b";
	public static final String AGGRESSIVE ="a";
	public static final String SPECIAL ="s";
	public static final String CRAZYHUMAN ="c";
	/**
	 * Creates the spaceships in the game according to the passed array of 
	 * spaceships names (h,r,f,s,...).
	 * See how it is used in SpaceWars.java main method.
	 * @param spaceships the command line arguments of SpaceWars 
	 * (e.g. spaceships={"h","r","f"}).
	 * @return the array of spaceships.
	 */
	public static SpaceShip[] createSpaceShips(String[] spaceships) {
		SpaceShip[] spaceShipsType=new SpaceShip[spaceships.length];    	
		for(int i=0;i<spaceships.length;i++){
			switch (spaceships[i]){
			case (HUMAN):
				spaceShipsType[i]=new Human();
			break;
			case (RUNNER):
				spaceShipsType[i]=new Runner();
			break;
			case(FLOATER):
				spaceShipsType[i]=new Floater();
			break;
			case(BASHER):
				spaceShipsType[i]=new Basher();
			break;
			case (AGGRESSIVE):
				spaceShipsType[i]=new Aggressive();
			break;
			case (SPECIAL):
				spaceShipsType[i]=new Special();
			break;
			case (CRAZYHUMAN):
				spaceShipsType[i]=new CrazyHuman();
			}
		}
		return spaceShipsType;
	}
}