/**
 * @author Isaac Delarosa, isaac.delarosa@mail.huji.ac.il
This class Tests that the RGBColor class is working.
 components.
 *Exercise 4

 */
import java.util.Random;

public class TestRGBColor {
	/**
	 *sets all the constants that are used in this class
	 */
	private static final int EQUALS__VALUE_CHANGER = 5;
	private static final int EQUALS_CHECKING_TIMES = 20;
	private static final int FOURTH_TESTING_COLOR_VLAUE = 8;
	private static final int THIRD_TESTING_COLOR_VLAUE = 4;
	private static final int SECOND_TESTING_COLOR_VALUE = 100;
	private static final int MIX_DIVIDE_VALUE = 2;
	private static final int TESTING_COLOR_VALUE = 200;
	private static final int MAX_COLOR_VALUE = 255;
	/**
	 * this method tests the RGBColor Constructor 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void RGBColorTest(){
		RGBColor firstColor=new RGBColor();
		RGBColor secondColor=new RGBColor(0,TestRGBColor.MAX_COLOR_VALUE,0);
		int firstConditionValue=firstColor.getRed(),secondConditionValue=firstColor.getGreen(),thirdConditionValue=firstColor.getBlue();
		int fifthConditionValue=secondColor.getRed(),sixthConditionValue=secondColor.getGreen(),seventhConditionValue=secondColor.getBlue();
		if (firstConditionValue!=0||secondConditionValue!=0||thirdConditionValue!=0){
			System.out.println("basic Color input test Failed");
		}
		if (fifthConditionValue!=0||sixthConditionValue!=TestRGBColor.MAX_COLOR_VALUE||seventhConditionValue!=0){
			System.out.println("basic Color input test Failed");
		}
	}
	/**
	 * this method tests the RGBColor copy Constructor 
	 *sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void RGBColorCopyTest(){
		RGBColor firstColor=new RGBColor(0,1,0);
		RGBColor firstColortwo=new RGBColor(firstColor);
		int firstConditionValue=firstColortwo.getRed(),y=firstColortwo.getGreen(),z=firstColortwo.getBlue();
		if(firstConditionValue!=0||y!=1||z!=0){
			System.out.println("basic copy constructor failed");
		}
	}
	/**
	 * this method tests the getRed method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void getRedTest(){
		RGBColor firstColor=new RGBColor(0,0,0);
		if(firstColor.getRed()!=0||firstColor.getGreen()!=0||firstColor.getBlue()!=0){
			System.out.println("basic getred failed");
		}
	}
	/**
	 * this method tests the getGreen method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void getGreenTest(){
		RGBColor firstColor=new RGBColor(0,0,0);
		if(firstColor.getRed()!=0||firstColor.getGreen()!=0||firstColor.getBlue()!=0){
			System.out.println("basic getgreen failed");
		}
	}
	/**
	 * this method tests the getBlue method  
	 * sets specific values,calculates options by itself than compares to method output.  
	 */
	public static void getBlueTest(){
		RGBColor firstColor=new RGBColor(0,0,0);
		if(firstColor.getRed()!=0||firstColor.getGreen()!=0||firstColor.getBlue()!=0){
			System.out.println("basic getblue failed");
		}
	}
	/**
	 * this method tests the setRed method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void setRedTest(){
		RGBColor secondColor=new RGBColor(TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE);
		secondColor.setRed(TestRGBColor.TESTING_COLOR_VALUE);
		int firstConditionValue=secondColor.getRed();
		if (firstConditionValue!=TestRGBColor.TESTING_COLOR_VALUE){
			System.out.println("basic red set test Failed");
		}
	}
	/**
	 * this method tests the setGreen method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void setGreenTest(){
		RGBColor secondColor=new RGBColor(TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE);
		secondColor.setGreen(TestRGBColor.TESTING_COLOR_VALUE);
		int firstConditionValue=secondColor.getGreen();
		if (firstConditionValue!=TestRGBColor.TESTING_COLOR_VALUE){
			System.out.println("basic green set test Failed");
		}	
	}
	/**
	 * this method tests the setBlue method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void setBlueTest(){
		RGBColor secondColor=new RGBColor(TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE);
		secondColor.setBlue(TestRGBColor.TESTING_COLOR_VALUE);
		int firstConditionValue=secondColor.getBlue();
		if (firstConditionValue!=TestRGBColor.TESTING_COLOR_VALUE){
			System.out.println("basic blue set test Failed");
		}
	}
	/**
	 * this method tests the invert method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void invertTest(){
		RGBColor firstColor=new RGBColor(TestRGBColor.MAX_COLOR_VALUE,0,TestRGBColor.MAX_COLOR_VALUE);
		RGBColor secondColor=new RGBColor();
		int firstConditionValue=(TestRGBColor.MAX_COLOR_VALUE-(secondColor.getRed())),y=(TestRGBColor.MAX_COLOR_VALUE-(secondColor.getGreen())),z=(TestRGBColor.MAX_COLOR_VALUE-(secondColor.getBlue()));

		secondColor.invert();
		firstColor.invert();
		if (firstConditionValue!=secondColor.getRed()||y!=secondColor.getGreen()||secondColor.getBlue()!=TestRGBColor.MAX_COLOR_VALUE){
			System.out.println("basic invert set test Failed");
		}
	}
	/**
	 * this method tests the mix method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void mixTest(){
		RGBColor firstColor=new RGBColor(TestRGBColor.MAX_COLOR_VALUE,TestRGBColor.MAX_COLOR_VALUE,TestRGBColor.MAX_COLOR_VALUE);
		RGBColor secondColor=new RGBColor(TestRGBColor.MAX_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE);
		RGBColor otherColor = new RGBColor (TestRGBColor.SECOND_TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE);
		RGBColor thirdColor=new RGBColor(TestRGBColor.MIX_DIVIDE_VALUE,TestRGBColor.THIRD_TESTING_COLOR_VLAUE,TestRGBColor.FOURTH_TESTING_COLOR_VLAUE);
		RGBColor fourColor=new RGBColor(TestRGBColor.FOURTH_TESTING_COLOR_VLAUE,TestRGBColor.MIX_DIVIDE_VALUE,TestRGBColor.THIRD_TESTING_COLOR_VLAUE);
		int firstConditionValue=((secondColor.getRed()+otherColor.getRed())/TestRGBColor.MIX_DIVIDE_VALUE),y=((secondColor.getGreen()+otherColor.getGreen())/TestRGBColor.MIX_DIVIDE_VALUE),z=((secondColor.getBlue()+otherColor.getBlue())/TestRGBColor.MIX_DIVIDE_VALUE);
		int a=firstColor.getRed();
		int b=firstColor.getGreen();
		int c=firstColor.getBlue();
		thirdColor.mix(fourColor);
		secondColor.mix(otherColor);
		firstColor.mix(firstColor);
		otherColor.mix(otherColor);

		if(firstConditionValue!=secondColor.getRed()||y!=secondColor.getGreen()||z!=secondColor.getBlue()
				||otherColor.getRed()!=TestRGBColor.SECOND_TESTING_COLOR_VALUE||otherColor.getGreen()!=TestRGBColor.TESTING_COLOR_VALUE||otherColor.getBlue()!=TestRGBColor.TESTING_COLOR_VALUE
				||firstColor.getRed()!=a||firstColor.getGreen()!=b||firstColor.getBlue()!=c
				||thirdColor.getRed()!=TestRGBColor.EQUALS__VALUE_CHANGER||thirdColor.getGreen()!=3||thirdColor.getBlue()!=6){
			System.out.println("mix test Failed");
		}
	}
	/**
	 * this method tests the greyScale method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void greyScaleTest(){
		RGBColor firstColor=new RGBColor();
		RGBColor secondColor=new RGBColor(TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE,TestRGBColor.TESTING_COLOR_VALUE);
		float firstConditionValue=secondColor.convertToGrayscale();
		float a=firstColor.convertToGrayscale();
		if(firstConditionValue!=TestRGBColor.TESTING_COLOR_VALUE||a!=0){
			System.out.println("Greyscale test Failed");
		}
	}
	/**
	 * this method tests the equals method 
	 * sets specific values,calculates options by itself than compares to method output. 
	 */
	public static void equalsTest(int redRandomValue,int greenRandomValue,int blueRandomValue){
		RGBColor firstColor=new RGBColor(redRandomValue,greenRandomValue,blueRandomValue);
		RGBColor secondColor=new RGBColor(redRandomValue,greenRandomValue,blueRandomValue);
		RGBColor thirdColor=new RGBColor(redRandomValue+TestRGBColor.EQUALS__VALUE_CHANGER,greenRandomValue,blueRandomValue);

		if(secondColor.equals(firstColor)!=true||firstColor.equals(thirdColor)==true){
			System.out.println("equals test Failed");
		}
	}
	/**
* this main method checks the RGBColor class
*  it print a Fail message if there is a problem with the class
* does not print if there is no problem
*/
	public static void main(String args[]){
		RGBColorTest();
		RGBColorCopyTest();
		setRedTest();
		setGreenTest();
		setBlueTest();
		invertTest();
		mixTest();
		greyScaleTest();
		Random equaltest=new Random();
		int redRandomValue=0;
		int greenRandomValue=0;
		int blueRandomValue=0;

		for(int counter=0;counter<TestRGBColor.EQUALS_CHECKING_TIMES;counter++){

			redRandomValue=equaltest.nextInt(TestRGBColor.MAX_COLOR_VALUE);
			greenRandomValue=equaltest.nextInt(TestRGBColor.MAX_COLOR_VALUE);
			blueRandomValue=equaltest.nextInt(TestRGBColor.MAX_COLOR_VALUE);
			equalsTest(redRandomValue,greenRandomValue,blueRandomValue);
		}
	}
}




