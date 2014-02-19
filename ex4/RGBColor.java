/**
 * @author Isaac Delarosa, isaac.delarosa@mail.huji.ac.il
This class represents a color, defined by its red, green and blue
 components.
 *Exercise 4

 */
public class RGBColor {
	/**
	 * Construct a new RGBColor with the given color component values.
	 Assumes the given values are legal (in the range 0-255).
	 
	 * @param red The red color component value.
	 * @param green The green color component value.
	 * @param blue The blue color component value.
	 */
	private static final double GREAYSCALE_BLUE_MULTIPLY = 0.11;
	private static final double GREAYSCALE_GREEN_MULTIPLY = 0.59;
	private static final double GREAYSCALE_RED_MULTIPLY = 0.3;
	private static final int MIX_DIVIDE_VALUE = 2;
	private static final int MAX_COLOR_VALUE = 255;
	private int redValue;
	private int greenValue;
	private int blueValue;
	public RGBColor (int red,int green,int blue){
		redValue=red;
		greenValue=green;
		blueValue=blue;	
	}
	/**
	 * Construct a new RGBColor which is a copy of the given color.
 Assumes the given color is not null.

	 * @param other The RGBColor to copy.
	 */

	public RGBColor (RGBColor other){
		redValue=other.redValue;
		greenValue=other.greenValue;
		blueValue=other.blueValue;
	}
	/**
	 * Construct a black RGBColor (red = green = blue = 0).

	 */
	public RGBColor(){
		redValue=0;
		greenValue=0;
		blueValue=0;
	}
	/**
	 * Returns the red color component value of this RGBColor.

	 * @return The red color component value of this RGBColor.
	 */
	public int getRed(){
		return redValue;
	}
	/**
	 * Returns the green color component value of this RGBColor.

	 * @return The green color component value of this RGBColor.
	 */
	public int getGreen(){
		return greenValue;
	}
	/**
	 * Returns the blue color component value of this RGBColor.

	 * @return The blue color component value of this RGBColor.
	 */
	public int getBlue(){
		return blueValue;
	}
	/**
	 * Sets the red color component value of this RGBColor.
	 Assumes the given value is legal (in the range 0-255).

	 * @param red The red color component value to set.
	 */
	public void setRed (int red){
		redValue=red;
	}
	/**
	 * Sets the green color component value of this RGBColor.
	 Assumes the given value is legal (in the range 0-255).

	 * @param green The green color component value to set.
	 */
	public void setGreen (int green){
		greenValue=green;
	}
	/**
	 * Sets the blue color component value of this RGBColor.
 Assumes the given value is legal (in the range 0-255).

	 * @param blue The blue color component value to set.
	 */
	public void setBlue (int blue){
		blueValue=blue;
	}
	/**
	 * Inverts the color of this RGBColor, by replacing each component value with
	 its complement relative to 255. 
	 For example, RGB values of [0,1,2] would be changed to [255,254,253].

	 */
	public void invert(){
		redValue=RGBColor.MAX_COLOR_VALUE-redValue;
		greenValue=RGBColor.MAX_COLOR_VALUE-greenValue;
		blueValue=RGBColor.MAX_COLOR_VALUE-blueValue;
	}
	/**
	 * Changes this color to be a mix of this and other RGBColors. 
	 The mixed color is simply the average 
	 (over the red, green and blue components) of this and other colors.
	 In case the average is fractional (e.g. 113.5) you should take only the integer part as the new value (e.g. 113).
	 For examle if this color is red - (255,0,0) and other color is green - (0,255,0) after mix operation this color will be yellow = (127,127,0)

	 * @param other The other color.
	 */
	public void mix(RGBColor other){
		redValue=(redValue+other.redValue)/RGBColor.MIX_DIVIDE_VALUE;
		greenValue=(greenValue+other.greenValue)/RGBColor.MIX_DIVIDE_VALUE;
		blueValue=(blueValue+other.blueValue)/RGBColor.MIX_DIVIDE_VALUE;		
	}
	/**
	 * Returns the grayscale value of this RGBColor. The grayscale value is defined as
 30% the red value + 59% of the green value and 11% of the blue value.

	 * @return The grayscale value of this RGBColor
	 */
	public float convertToGrayscale(){
		float redGrey=(float)RGBColor.GREAYSCALE_RED_MULTIPLY*redValue;
		float greenGrey=(float)RGBColor.GREAYSCALE_GREEN_MULTIPLY*greenValue;
		float blueGrey=(float)RGBColor.GREAYSCALE_BLUE_MULTIPLY*blueValue;
		float greyScale=redGrey+greenGrey+blueGrey;
		return greyScale;		
	}
	/**
	 * Compares this and other color.
 Returns true iff this and other are the same RGBcolor,
 i.e. have the same red, green and blue components.

	 * @param other The other RGBColor to compare.

	 * @return true if the RGBColors are equal; false otherwise.
	 */
	public boolean equals(RGBColor other){
		if (redValue==other.redValue&&greenValue==other.greenValue&&blueValue==other.blueValue){
			return true;	
		}
		else{
			return false;
		}
	}


}



