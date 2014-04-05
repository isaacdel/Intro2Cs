/**
 * This class represents a color, defined by its red, green and blue
 * components.
 */
public class RGBColor {
	public static final double EPSILON=1.0E-6;
	/** The max color component value */
	private static final int MAX_VALUE = 255;
	/** The red color component */
	private static final int RED = 0;
	/** The green color component */
	private static final int GREEN = 1;
	/** The blue color component */
	private static final int BLUE = 2;
	/** This pixel's color component values */
	private int[] _color;
	public int compareTo(RGBColor other){
		float grayScale=(Math.abs(this.convertToGrayscale()-other.convertToGrayscale()));
		//		if(this.convertToGrayscale()!=0) {
		//			return grayScale>EPSILON?1:-1;
		//		}
		if(grayScale>EPSILON){
			if(this.convertToGrayscale()>other.convertToGrayscale())
				return 1;
			else
				return -1;
		}
		else  {
			if(this.getRed()!=other.getRed()){
				return this.getRed()>other.getRed()?1:-1;
			}
			else if(this.getGreen()!=other.getGreen()){
				return this.getGreen()>other.getGreen()?1:-1;
			}
			else if(this.getBlue()!=other.getBlue()){
				return this.getBlue()>other.getBlue()?1:-1;
			}
			else{
				return 0;
			}
		}
		

	}
	/**
	 * Construct a new RGBColor with the given color component values.
	 * Assumes the given values are legal (in the range 0-255).     
	 * @param red The red color component value.
	 * @param green The green color component value.
	 * @param blue The blue color component value.
	 */
	public RGBColor(int red, int green, int blue) {
		if (red < 0 || red > MAX_VALUE || green < 0 || green > MAX_VALUE ||
				blue < 0 || blue > MAX_VALUE) {
		}
		_color = new int[3];
		_color[RED] = red;
		_color[GREEN] = green;
		_color[BLUE] = blue;
	}

	/**
	 * Construct a new RGBColor which is a copy of the given color.
	 * Assumes the given color is not null.
	 * @param other The RGBColor to copy.
	 */
	public RGBColor(RGBColor other) {
		this(other._color[RED], other._color[GREEN], other._color[BLUE]);
	}

	/**
	 * Construct a black RGBColor (red = green = blue = 0).
	 */
	public RGBColor() {
		this(0, 0, 0);
	}

	/**
	 * Returns the red color component value of this RGBColor.
	 * @return The red color component value of this RGBColor.
	 */
	public int getRed() {
		return _color[RED];
	}

	/**
	 * Returns the green color component value of this RGBColor.
	 * @return The green color component value of this RGBColor.
	 */
	public int getGreen() {
		return _color[GREEN];
	}

	/**
	 * Returns the blue color component value of this RGBColor.
	 * @return The blue color component value of this RGBColor.
	 */
	public int getBlue() {
		return _color[BLUE];
	}

	/**
	 * Sets the red color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 * @param red The red color component value to set.
	 */
	public void setRed(int red) {
		if (red < 0 || red > MAX_VALUE) {
		}
		_color[RED] = red;
	}

	/**
	 * Sets the green color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 * @param green The green color component value to set.
	 */
	public void setGreen(int green) {
		if (green < 0 || green > MAX_VALUE) {
		}
		_color[GREEN] = green;
	}

	/**
	 * Sets the blue color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 * @param blue The blue color component value to set.
	 */
	public void setBlue(int blue) {
		if (blue < 0 || blue > MAX_VALUE) {
		}
		_color[BLUE] = blue;
	}


	/**
	 * Inverts the color of this RGBColor, by replacing each component value with
	 * its complement relative to 255. 
	 * For example, RGB values of [0,1,2] would be changed to [255,254,253].
	 */
	public void invert() {
		for (int i = 0; i < _color.length; ++i) {
			_color[i] = MAX_VALUE - _color[i];
		}
	}
	/**
	 * Changes this color to be a mix of this and other RGBColors. 
	 * The mixed color is simply the average 
	 * (over the red, green and blue components) of this and other colors.
	 * In case the average is fractional (e.g. 113.5) you should take only the integer part as the new value (e.g. 113).
	 * For examle if this color is red - (255,0,0) and other color is green - (0,255,0) after mix operation this color will be yellow = (127,127,0)
	 * @param other The other color.
	 */
	public void mix(RGBColor other){
		setRed((getRed()+other.getRed())/2);		
		setBlue((getBlue()+other.getBlue())/2);
		setGreen((getGreen()+other.getGreen())/2);
	}	
	/**
	 * Returns the grayscale value of this RGBColor. The grayscale value is defined as
	 * 30% the red value + 59% of the green value and 11% of the blue value.
	 * @return The grayscale value of this RGBColor      
	 */
	public float  convertToGrayscale(){
		return (float)(0.3*_color[RED]+0.59*_color[GREEN]+0.11*_color[BLUE]);
	}  

	/**
	 * Compares this and other color.
	 * Returns true iff this and other are the same RGBcolor,
	 * i.e. have the same red, green amd blue components.
	 * @return true if the RGBColors are equal; false otherwise.
	 */
	public boolean equals(RGBColor other){
		return (this._color[0]==other._color[0] &&
				this._color[1]==other._color[1] &&
				this._color[2]==other._color[2]);                
	}

}
