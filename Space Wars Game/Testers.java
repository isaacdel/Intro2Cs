/** FILE : Testers.java
 * DESCRIPTION:
 * this class test some spaceSip methods.
 */
public class Testers {
	private static final int TELEPORT_COST = 150;
	private static final int ENERGY_STARTS_AMOUNT = 200;
	private static final int HELTH_START_AMOUNT = 10;
	/**
	 * this method test the spaceShip ctor.
	 */
	public static void spaceShipTester(){//ctor tester
		SpaceShip ship=new SpaceShip();
		if(ship.health!=Testers.HELTH_START_AMOUNT||ship.energy!=Testers.ENERGY_STARTS_AMOUNT||ship.shield==true){
			System.out.println("basic constructor test failed!");
		}
	}
	/**
	 * this method test the implication of collision 
	 */
	public static void collideTester(){
		SpaceShip ship=new SpaceShip();
		ship.shield=true;
		ship.collidedWithAnotherShip();
		
			if(ship.health!=ship.health)
				System.out.println("collide error");
		}
	/**
	 * this method test to see what happen once you got shot.
	 */
	public static void gotHitTester(){
		SpaceShip ship=new SpaceShip();
		ship.gotHit();
		if(ship.health!=ship.health-1)
			System.out.println("hit tester failed");
	}
	/**
	 * this method test if is dead is activated as it should.
	 */
	public static void isDeadTester(){
		SpaceShip ship=new SpaceShip();
		ship.health=0;
		if(!ship.isDead()){
			System.out.println("dead tester failed");
		}
	}
	/**
	 * see if its generate new ship as its should.
	 */
	public static void resetTester(){
		SpaceShip ship=new SpaceShip();
		ship.reset();
		if(ship.health!=Testers.HELTH_START_AMOUNT&&ship.energy!=ENERGY_STARTS_AMOUNT &&ship.shield!=false){
			System.out.println("reset tester error");
		}
	}
	/**
	 * see if teleports.
	 */
	public static void teleportTester(){
		SpaceShip ship=new SpaceShip();
		int x=ship.energy;
		ship.teleport();
		
		if(x-Testers.TELEPORT_COST!=ship.energy-Testers.TELEPORT_COST){
			System.out.println("teleport error");
		}
		
		
	}
	public static void main(String[] args) {
		spaceShipTester();
		collideTester();
		gotHitTester();
		isDeadTester();
		resetTester();
		teleportTester();
	}
//	public static void shootTester(){
//		SpaceShip ship=new SpaceShip();
//		SpaceShip otherShip=new SpaceShip();
//		shoot(ship,);
//
//		if (ship.energy!=ship.energy-8){
//			System.out.println("shoot error");
//		}
//	}
}
