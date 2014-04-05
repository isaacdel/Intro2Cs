/**
 * @author Isaac Delarosa, isaac.delarosa@mail.huji.ac.il
This class Tests that the Complex class is working.
 components.
 *Exercise 4

 */
public class TestComplex {
	/**
	 *sets all the constants that are used in this class
	 */
	private static final int ESCAPETIME_FORTH_RANDOM = 7;
	private static final int ESCAPETIME_THIRD_RANDOM = 5;
	private static final int ESCAPETIME_SECOND_RANDOM = 25;
	private static final int ESCAPETIME_RANDOM = 26;
	private static final int MINUS_LOOP_COUNTER = 10;
	private static final double SECOND_EQUALS_TEST_RANDOM = 1.000000002;
	private static final double EQUALS_TEST_RANDOM = 1.000000001;
	private static final int THIRD_RANDOM_VALUE = 50;
	private static final int RANDOM_LOOP_COUNTER = 100;
	private static final int SECOND_RANDOM_VALUE = 2;
	private static final int RANDOM_VALUE = 4;
	private static final int CONSTRUCTOR_MULT_VALUE = 3;
	private static final double ANGLE_VALUE_CHECK = -1.3;
	public static final double EPSILON=1.0E-6;

	/**
	 * this method tests the Complex Constructor 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void complexTest(){
		for (int i=0;i<TestComplex.RANDOM_LOOP_COUNTER;i++){
			double realTest=Math.random()*TestComplex.RANDOM_VALUE;
			double imgTest=Math.random()*TestComplex.CONSTRUCTOR_MULT_VALUE;
			if(i<TestComplex.THIRD_RANDOM_VALUE){
				realTest=-1*(Math.random()*TestComplex.RANDOM_VALUE);
				imgTest=-1*(Math.random()*TestComplex.RANDOM_VALUE);
			}
			if(i==1){
				realTest=0;
				imgTest=0;
			}

			else{

				Complex complexNumber=new Complex(TestComplex.SECOND_RANDOM_VALUE,TestComplex.RANDOM_VALUE);
				double x=complexNumber.getReal(),y=complexNumber.getImg();
				if(x!=TestComplex.SECOND_RANDOM_VALUE||y!=TestComplex.RANDOM_VALUE){
					System.out.println("basic Complex input test Failed");
				}
			}
		}
	}
	/**
	 * this method tests the getReal method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void getRealTest(){
		Complex complexNumber=new Complex(1,1);
		if(complexNumber.getReal()!=1||complexNumber.getImg()!=1){
			System.out.println("basic getreal input test Failed");
		}
	}
	/**
	 * this method tests the getImg method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void getImgTest(){
		Complex complexNumber=new Complex(1,1);
		if(complexNumber.getReal()!=1||complexNumber.getImg()!=1){
			System.out.println("basic getimg input test Failed");
		}
	}
	/**
	 * this method tests the getAbs method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void getAbsTest(){
		for (int i=0;i<TestComplex.RANDOM_LOOP_COUNTER;i++){
			double realTest=Math.random()*TestComplex.RANDOM_VALUE;
			double imgTest=Math.random()*TestComplex.CONSTRUCTOR_MULT_VALUE;
			if(i<TestComplex.THIRD_RANDOM_VALUE){
				realTest=-1*(Math.random()*TestComplex.RANDOM_VALUE);
				imgTest=-1*(Math.random()*TestComplex.RANDOM_VALUE);
			}
			if(i==1){
				realTest=0;
				imgTest=0;
			}

			else{

				Complex complexNumber=new Complex(realTest,imgTest);
				double x=Math.sqrt(Math.pow(realTest, TestComplex.SECOND_RANDOM_VALUE)+Math.pow(imgTest, TestComplex.SECOND_RANDOM_VALUE));
				if(Math.abs(x-(complexNumber.getAbsValue()))>EPSILON){
					System.out.println("Abs test Failed");
				}
			}
		}

	}
	/**
	 * this method tests the getAngle method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void getAngleTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(-1,1);
		Complex complexNumberthree=new Complex(0,-1);
		Complex complexNumberfour=new Complex(-1,-1);
		Complex complexNumberfive=new Complex(0,0);
		Complex complexNumbersix=new Complex(0,1);
		Complex complexNumberseven=new Complex(TestComplex.ANGLE_VALUE_CHECK,1);
		Complex complexNumbereight=new Complex(0,1);
		if (Math.atan((complexNumber.getImg()/complexNumber.getReal()))!=complexNumber.getAngle()){
			System.out.println("angle test failed");

		}
		if (((Math.atan((complexNumbertwo.getImg()/complexNumbertwo.getReal())))+Math.PI)
				!=complexNumbertwo.getAngle()){
			System.out.println("angle test failed");

		}
		if ((-1*((Math.PI)/TestComplex.SECOND_RANDOM_VALUE))
				!=complexNumberthree.getAngle()){
			System.out.println("angle test failed");

		}
		if (((Math.atan((complexNumberfour.getImg()/complexNumberfour.getReal())))-Math.PI)
				!=complexNumberfour.getAngle()){
			System.out.println("angle test failed");

		}
		if (0!=(complexNumberfive.getAngle())){
			System.out.println("angle test failed");

		}
		if (((Math.PI)/TestComplex.SECOND_RANDOM_VALUE)
				!=complexNumbersix.getAngle()){
			System.out.println("angle test failed");

		}
		if (((Math.atan((complexNumberseven.getImg()/complexNumberseven.getReal())))+Math.PI)
				!=complexNumberseven.getAngle()){
			System.out.println("angle test failed");

		}
		if (((Math.PI)/TestComplex.SECOND_RANDOM_VALUE)
				!=complexNumbereight.getAngle()){
			System.out.println("angle test failed");

		}
	}
	/**
	 * this method tests the equals method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void equalsTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(1,1);
		Complex complexNumberthree=null;
		Complex complexNumberfour=new Complex(TestComplex.EQUALS_TEST_RANDOM,1);
		Complex complexNumberfive=new Complex(TestComplex.SECOND_EQUALS_TEST_RANDOM,1);
		if(complexNumber.equals(complexNumbertwo)!=true){
			System.out.println("equals test failed");
		}
		if(!complexNumberfour.equals(complexNumberfive)){
			System.out.println("equals test failed");
		}
		if (complexNumber.equals(complexNumberthree)){
			System.out.println("equals test failed");
		}
	}
	/**
	 * this method tests the plus method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void plusTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(1,1);
		Complex complexNumberthree=null;
		Complex testPlus =(complexNumber.plus(complexNumbertwo));
		if (!testPlus.equals(new Complex (TestComplex.SECOND_RANDOM_VALUE,TestComplex.SECOND_RANDOM_VALUE))){
			System.out.println("plus test failed");
		}
		if (complexNumber.plus(complexNumberthree)!=null){
			System.out.println("plus test failed");
		}
	}
	/**
	 * this method tests the minus method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void minusTest(){
		for(int i=0;i<TestComplex.MINUS_LOOP_COUNTER;i++){
			double a=Math.random();
			double b=Math.random();
			double c=Math.random();
			double d=Math.random();
			Complex complexNumber=new Complex(a,b);
			Complex complexNumbertwo=new Complex(c,d);
			Complex complexNumberthree=null;
			Complex testMinus = (complexNumber.minus(complexNumbertwo));
			if (!testMinus.equals(new Complex (a-c,b-d))){
				System.out.println("minus test failed");
			}

			if (complexNumber.minus(complexNumberthree)!=null){
				System.out.println("minus test failed");
			}
		}
	}
	/**
	 * this method tests the mult method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void multTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(1,1);
		Complex complexNumberthree=null;
		Complex testMult =(complexNumber.mult(complexNumbertwo));
		if (!testMult.equals(new Complex (0,TestComplex.SECOND_RANDOM_VALUE))){
			System.out.println("mult test failed");
		}
		if (complexNumber.mult(complexNumberthree)!=null){
			System.out.println("mult test failed");
		}
	}
	/**
	 * this method tests the square method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void squareTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(1,1);
		Complex testSquare =(complexNumber.mult(complexNumbertwo));
		if (!testSquare.equals(new Complex (0,TestComplex.SECOND_RANDOM_VALUE))){
			System.out.println("square test failed");
		}
	}
	/**
	 * this method tests the div method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void divTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(1,1);
		Complex complexNumberthree=null;
		Complex testDiv =(complexNumber.div(complexNumbertwo));
		if (!testDiv.equals(new Complex (1,0))){
			System.out.println("div test failed");
		}
		if (complexNumber.div(complexNumberthree)!=null){
			System.out.println("div test failed");
		}
	}
	/**
	 * this method tests the conjugate method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void conjugateTest(){
		Complex complexNumber=new Complex(1,1);
		Complex complexNumbertwo=new Complex(1,-1);
		Complex testConj =(complexNumber.conjugate());
		Complex testConjtwo=(complexNumbertwo.conjugate());
		if (!testConj.equals(new Complex (1,-1))){
			System.out.println("conjugate test failed");
		}
		if (!testConjtwo.equals(new Complex (1,1))){
			System.out.println("conjugate test failed");
		}
	}
	/**
	 * this method tests the escapeTime method
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void escapeTimeTest(){
		Complex complexNumber=new Complex(1,0);
		Complex complexNumbertwo=new Complex(0,1);
		Complex complexNumberthree=new Complex(0,0);
		Complex complexNumberfour=new Complex(TestComplex.SECOND_RANDOM_VALUE,0);
		int x=complexNumber.escapeTime(TestComplex.ESCAPETIME_RANDOM, TestComplex.THIRD_RANDOM_VALUE);
		int y=complexNumber.escapeTime(TestComplex.ESCAPETIME_RANDOM, TestComplex.SECOND_RANDOM_VALUE);
		int a=complexNumbertwo.escapeTime(TestComplex.ESCAPETIME_SECOND_RANDOM, TestComplex.THIRD_RANDOM_VALUE);
		int b=complexNumbertwo.escapeTime(1,TestComplex.RANDOM_VALUE);
		int c=complexNumberthree.escapeTime(0, TestComplex.THIRD_RANDOM_VALUE);
		int d=complexNumberfour.escapeTime(TestComplex.ESCAPETIME_THIRD_RANDOM, TestComplex.SECOND_RANDOM_VALUE);
		int e=complexNumberfour.escapeTime(TestComplex.ESCAPETIME_FORTH_RANDOM, TestComplex.SECOND_RANDOM_VALUE);
		if ((x!=TestComplex.ESCAPETIME_THIRD_RANDOM)&&(y!=-1)){
			System.out.println("escapeTime Test failed");
		}
		if ((a!=(-1))&&(b!=TestComplex.SECOND_RANDOM_VALUE)){
			System.out.println("escapeTime Test failed");
		}
		if (c!=1){
			System.out.println("escapeTime Test failed");
		}
		if(d!=TestComplex.SECOND_RANDOM_VALUE||e!=-1){
			System.out.println("escapeTime Test failed");
		}
	}
	/**
* this main method checks the Complex class
*  it print a Fail message if there is a problem with the class
* does not print if there is no problem
*/
	public static void main(String args[]){
		complexTest();
		getAbsTest();
		getAngleTest();
		equalsTest();
		plusTest();
		minusTest();
		multTest();
		squareTest();
		divTest();
		conjugateTest();
		escapeTimeTest();
	}
}
