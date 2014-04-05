/** FILE : TestFactory.java
 * DESCRIPTION:
 * this method test the SpaceShipFactory
 */
public class TestFactory {
	private static final String HUMAN ="h";
	private static final String RUNNER ="r";
	private static final String FLOATER ="f";
	private static final String BASHER ="b";
	private static final String AGGRESSIVE ="a";
	private static final String SPECIAL ="s";
	private static final String CRAZYHUMAN ="c";
	public static void factoryTest(){
		String[] factory=new String[7];
		SpaceShip[] create;
		factory[0]=AGGRESSIVE;
		factory[1]=BASHER;
		factory[2]=CRAZYHUMAN;
		factory[3]=FLOATER;
		factory[4]=HUMAN;
		factory[5]=RUNNER;
		factory[6]=SPECIAL;
		create =SpaceShipFactory.createSpaceShips(factory);
		if(!(create[0] instanceof Aggressive ))
			System.out.println("aggressive creation failed");
		if(!(create[1] instanceof Basher))
			System.out.println("Basher creation failed");
		if(!(create[2] instanceof CrazyHuman))
			System.out.println("CrazyHuman creation failed");
		if(!(create[3] instanceof Floater))
			System.out.println("Floater creation failed");
		if(!(create[4] instanceof Human))
			System.out.println("Human creation failed");
		if(!(create[5] instanceof Runner))
			System.out.println("Runner creation failed");
		if(!(create[6] instanceof Special))
			System.out.println("Special creation failed");
	}

	public static void main(String[] args) {
		factoryTest();
	}
}
