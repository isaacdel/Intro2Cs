
import intro.ex5.*;
/**
 * 
    This class represents a 2D color image, composed of RGB pixels.
     The row and column numbering start from the upper-left corner.
     The image is represented by a 2D array of RGBColor objects.

 */
public class RGBImage {
	private static final int CELL_SIZE_VALUE = 3;
	private static final int THIRD_CELL = 2;
	/**
	 * Construct a new black RGBImage with the given number of rows and columns.
     All pixels in the image should be black (red = green = blue = 0).
     Raises an error if the given rows or cols are not positive.

	 * @param rows The height of the new image.
	 * @param cols The width of the new image.
	 */
	private RGBColor[][] pixelMap;//constructs the main screen that pixels will get into.
	public RGBImage(int rows, int cols) {
		if(rows<=0||cols<=0){//checks if value wanted is legal.
			ErrorPrinter.error("only positive values");
		}
		pixelMap = new RGBColor[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				pixelMap[i][j]=new RGBColor();
			}
		}
	}
	/**
	 * Construct a new RGBImage identical to the given array of pixels.
     Assumes the given array is legal.

	 * @param pixels The pixels of the new image.
	 */
	public RGBImage(intro.ex5.RGBColor[][] pixels) {

		pixelMap = new RGBColor[pixels.length][pixels[0].length];
		for (int i=0;i<getHeight();i++) {
			for (int j=0;j<getWidth();j++) {
				pixelMap[i][j]=new RGBColor(pixels[i][j]);
			}
		}
	}
	/**
	 * Construct a new RGBImage which is a copy of the given image.
     Assumes the given image is not null.

	 * @param other The image to copy.
	 */
	public RGBImage(RGBImage other) {
		pixelMap=new RGBColor[other.getHeight()][other.getWidth()];
		for(int i=0;i<getHeight();i++){
			for(int j=0;j<getWidth();j++){
				pixelMap[i][j]=new RGBColor(other.getPixel(i, j));
			}
		}
	}
	/**
	 * Gets an array of the pixels in this image.

	 * @return An array of the pixels in this image.
	 */
	public intro.ex5.RGBColor[][] toRGBColorArray() {
		RGBColor[][] pixelMapNew=new RGBColor[getHeight()][getWidth()];
		for (int i=0;i<getHeight();i++){
			for(int j=0;j<getWidth();j++){
				pixelMapNew[i][j]=new RGBColor (pixelMap[i][j]);//passes the wanted pixel to other place
			}
		}
		return pixelMapNew;
	}
	/**
	 * Returns the grayscale representation of the image.
     The grayscale reperesentation of each pixel is calculated as defined in
     the API of RGBColor

	 * @return A 2d array of floats representing the image in grayscale values.
	 */
	public float[][] toGrayscaleArray() {
		float [][] grayScaled=new float [getHeight()][getWidth()];
		for (int i=0;i<getHeight();i++){
			for(int j=0;j<getWidth();j++){
				grayScaled[i][j] = pixelMap[i][j].convertToGrayscale();//uses the converting tool from rgbcolor class
			}
		}
		return grayScaled;
	}
	/**
	 * Inverts the color of all pixels in this image, by replacing each 
     RGB value with its complement to 255. For example, RGB values of [0,1,2] would be
     changed to [255,254,253].

	 */
	public void invertColors() {
		for (int i=0;i<getHeight();i++){
			for(int j=0;j<getWidth();j++){
				this.pixelMap[i][j].invert();//uses the invert method from rgbcolor class
			}
		}
	}
	/**
	 * Shifts the image down or up, according to the given offset.
     Row 0 is moved into row offset, row 1 is moved into row offset+1, etc. 
     offset may be negative (or 0).
     Any row that is shifted in from outside the image should be all black.

	 * @param offset Offset to shift the image by.
	 */
	public void shiftRow(int offset) {
		RGBColor[][] shiftedCopy=new RGBColor[getHeight()][getWidth()];
			for (int i=0;i<getHeight();i++){
				for (int j=0;j<getWidth();j++){	
					if (i-offset >= 0 && i-offset < getHeight()) {//checks that its moving each only once.
						shiftedCopy[i][j]=new RGBColor(pixelMap[i-offset][j]);
					} else {
						shiftedCopy[i][j]=new RGBColor();//inserts the wanted to a new copy
					}
				}
			}
			for (int i=0;i<getHeight();i++){
				for (int j=0;j<getWidth();j++){
					pixelMap[i][j] = new RGBColor(shiftedCopy[i][j]);//builds the complete new shifted array
				}
			}
	}
	/**
	 * Shifts the image left or right, according to the given offset.
     Column 0 is moved into column offset, column 1 is moved into column 
     offset+1, etc. offset may be negative (or 0).
     Any column that is shifted in from outside the image should be all black.

	 * @param offset Offset to shift the image by.
	 */
	public void shiftCol(int offset) {
		RGBColor[][] shiftedCopy=new RGBColor[getHeight()][getWidth()];
		for (int i=0;i<getHeight();i++){
			for (int j=0;j<getWidth();j++){	//checks that its moving each only once.
				if (j-offset >= 0 && j-offset < getWidth()) {
					shiftedCopy[i][j]=new RGBColor(pixelMap[i][j-offset]);
				} else {
					shiftedCopy[i][j]=new RGBColor();
				}
			}
		}
		for (int i=0;i<getHeight();i++){
			for (int j=0;j<getWidth();j++){
				pixelMap[i][j] = new RGBColor(shiftedCopy[i][j]);//builds the complete new shifted array
			}
		}
	}
	/**
	 * Gets the pixel at the given coordinates.
     Returns a black RGBColor if the given coordinates are outside the image

	 * @param row The row of the pixel to get.
	 * @param col The column of the pixel to get.

	 * @return The pixel at the given coordinates.
	 */
	public intro.ex5.RGBColor getPixel(int row, int col) {
		if(col>=getWidth()||row>=getHeight()||row<0||col<0){//checks if pixel exist if not return a black one
			RGBColor black=new RGBColor();
			return black;
		}
		else{
			return new RGBColor(pixelMap[row][col]);//returns the pixel if exist
		}
	}
	/**
	 * Sets the pixel at the given coordinates.
     Raises an error if the given coordinates are outside the image.

	 * @param row The row of the pixel to set.
	 * @param col The column of the pixel to set.
	 * @param pixel Contains the RGB values to set at the given coordinates.
	 */
	public void setPixel(int row, int col, intro.ex5.RGBColor pixel) {
		if((getHeight()<=row)||(getWidth()<=col)||(row<0)||(col<0)){//checks if pixel exist
			ErrorPrinter.error("only values inside image");
		}
		else{
			pixelMap[row][col]=new RGBColor(pixel); //sets the wanted color to place
		}
	}
	/**
	 * Gets the height of the image in pixels.

	 * @return The height of the image.
	 */
	public int getHeight() {
		return pixelMap.length;//number of rows
	}
	/**
	 * Gets the width of the image in pixels.
     The width is the number of columns.

	 * @return The width of the image.
	 */
	public int getWidth() {
		return pixelMap[0].length;//number  of cols 
	}
	/**
	 * Flips the image around the vertical axis.  The first column becomes the
     last column, The second becomes second to last, etc.

	 */
	public void flipHorizontal() {
		RGBColor[][] flippedArray=new RGBColor[getHeight()][getWidth()];
		for(int i=0;i<getHeight();i++){
			for(int j=0;j<getWidth();j++){
				flippedArray[i][j] = new RGBColor(pixelMap[getHeight() - 1 - i][j]);//flips until middle
			}
		}
		for (int i=0;i<getHeight();i++){
			for (int j=0;j<getWidth();j++){
				pixelMap[i][j] = new RGBColor(flippedArray[i][j]);//returns flipped array.
			}
		}
	}
	/**
	 * Flips the image around the horizontal axis.  The first row becomes the
     last row, The second becomes second to last, etc.

	 */
	public void flipVertical() {
		RGBColor[][] flippedArray=new RGBColor[getHeight()][getWidth()];
		for(int i=0;i<getHeight();i++){
			for(int j=0;j<getWidth();j++){
				flippedArray[i][j] = new RGBColor(pixelMap[i][getWidth() - 1 - j]);//flips until middle
			}
		}
		for (int i=0;i<getHeight();i++){
			for (int j=0;j<getWidth();j++){
				pixelMap[i][j] = new RGBColor(flippedArray[i][j]);//returns flipped array.
			}
		}   
	}
	/**
	 * Rotates the image 90 degrees clockwise.  
     Note that this may change the dimensions of the image.

	 */
	public void rotateCounterClockwise() {
		RGBColor[][] rotatedArray=new RGBColor[getWidth()][getHeight()];
		for(int i=0;i<getWidth();i++){
			for(int j=0;j<getHeight();j++){
				rotatedArray[i][j] = new RGBColor(pixelMap[j][getWidth() - 1 - i]);//moves the array around
			}
		}
		pixelMap = new RGBColor[pixelMap[0].length][pixelMap.length];
		for (int i=0;i<pixelMap.length;i++){//fixes rotated array
			for (int j=0;j<pixelMap[0].length;j++){
				pixelMap[i][j] = new RGBColor(rotatedArray[i][j]);
			}
		} 
	}
	/**
	 * Rotates the image 90 degrees counter-clockwise.  
     Note that this may change the dimensions of the image.

	 */
	public void rotateClockwise() {
		for(int i=0;i<3;i++){//rotated array to opposite side 3 times 
		rotateCounterClockwise();
		}
	}
	private intro.ex5.RGBColor meanAroundPixel
	(int i, int j,int radius) {//calculates the average of pixels around the given point in given radius.
		int di, dj,sumG=0,sumB=0,sumR=0 , neighbors = 0;
		for (di = -radius; di <= radius; di++)//the radius of checking
			for (dj = -radius; dj <= radius; dj++)
				if (inBound(i+di, j+dj)) {//build average to each RGB color in the pixel
					sumR += pixelMap[i+di][j+dj].getRed();
					sumG += pixelMap[i+di][j+dj].getGreen();
					sumB += pixelMap[i+di][j+dj].getBlue();
					neighbors++;
				} else
				{
					neighbors++;//includes black pixels in average.
				}
		RGBColor average = new RGBColor(sumR / neighbors,sumG / neighbors,sumB / neighbors);//calcs the sum
		return average;
	}
	// check if given pixel is within the boundary of this picture
	private boolean inBound (int i, int j) {
		return i >= 0 && i < getHeight() &&
				j >= 0 && j < getWidth();
	}
	/**
	 * Blurs the image.


	 * @param radius Radius of averaging.
	 */
	public void blurImage(int radius) {
		if(radius==0||radius<0){//checks if wanted blurred point is in the screen
			ErrorPrinter.error("only positive vlaues");
		}
		else{//uses the average around method to build and return the blurred pic.
			RGBColor newBlurredImage[][]=new RGBColor[getHeight()][getWidth()];	
			for(int i=0;i<getHeight();i++){
				for(int j=0;j<getWidth();j++){
					newBlurredImage[i][j]=new RGBColor(meanAroundPixel(i, j, radius));
				}
			}
			for (int i=0;i<getHeight();i++) {//blurs the pic 
				for (int j=0;j<getWidth();j++) {
					pixelMap[i][j] = new RGBColor(newBlurredImage[i][j]);
				}
			}
		}
	}
	/**
	 * Gets an array of the color component values of this image's pixels.
     The first index denotes
     the row, the second index denotes the column, and the third index
     denotes the color component (red=0, green=1, blue=2).

	 * @return An array containing the color component values of this image's
     pixels.
	 */
	public int[][][] toIntArray() {
		int [][][] pixelAtPoint=new int [getHeight()][getWidth()][RGBImage.CELL_SIZE_VALUE];
		for (int i=0;i<getHeight();i++){
			for (int j=0;j<getWidth();j++){
				pixelAtPoint[i][j][0]= pixelMap[i][j].getRed(); //gets the red component at wanted pixel   
				pixelAtPoint[i][j][1]= pixelMap[i][j].getGreen();   //gets the green component at wanted pixel  
				pixelAtPoint[i][j][RGBImage.THIRD_CELL]= pixelMap[i][j].getBlue(); //gets the blue component at wanted pixel    
			}
		}
		return pixelAtPoint;
	}
	/**
	 * Return true iff the images are equal, that is they have the same height and width, and for each
     i and j in the legal ranges, the Color in row i column j are equal.

	 * @return true iff the images are equal
	 */
	public boolean equals(RGBImage other) {
		if(other.getWidth() != getWidth() || other.getHeight()!= getHeight())//checks if outside the pic
			return false;
		for(int i = 0 ; i<getHeight() ; i++)
			for(int j=0 ; j<getWidth() ; j++)
				if ( !pixelMap[i][j].equals(other.pixelMap[i][j]) )//uses the equals method from rgb class
					return false;
		return true;
	}
}


