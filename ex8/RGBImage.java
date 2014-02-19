import intro.ex5.ErrorPrinter;
import java.util.Arrays;

/**
 * This class represents a 2D color image, composed of RGB pixels.
 * The row and column numbering start from the upper-left corner.
 * The image is represented by a 2D array of RGBColor objects.
 */
public class RGBImage {


	/** The array of pixels composing this image */
	private RGBColor[][] _pixels;


	private static void updatePixel(RGBColor color,int red,int green,int blue) {
		color.setRed(red);
		color.setGreen(green);
		color.setBlue(blue);
	}

	/**
	 * Clone the given array.
	 * @param pixels Array to clone
	 * @return A clone of the given array
	 */
	private static RGBColor[][] clone(RGBColor[][] pixels) {
		RGBColor[][] copy = new RGBColor[pixels.length][pixels[0].length];
		for (int i = 0; i < copy.length; ++i) {
			for (int j = 0; j < copy[i].length; ++j) {
				copy[i][j] = new RGBColor(pixels[i][j]);
			}
		}
		return copy;
	}

	/**
	 * Construct a new black RGBImage with the given number of rows and columns.
	 * All pixels in the image should be black (red = green = blue = 0).
	 * Raises an error if the given rows or cols are not positive.
	 * @param rows The height of the new image.
	 * @param cols The width of the new image.
	 */
	public RGBImage(int rows, int cols) {
		if (rows <= 0 || cols <= 0) {
			ErrorPrinter.error("Non-positive dimension");
		}
		_pixels = new RGBColor[rows][cols];
		for (int i = 0; i < _pixels.length; ++i) {
			for (int j = 0; j < _pixels[i].length; ++j) {
				_pixels[i][j] = new RGBColor();
			}
		}
	}

	/**
	 * Construct a new RGBImage identical to the given array of pixels.
	 * Assumes the given array is legal.
	 * @param pixels The pixels of the new image.
	 */
	public RGBImage(RGBColor[][] pixels) {
		int width=pixels[0].length;
		if(width==0) ErrorPrinter.error("Illegal array");
		for (int i = 0; i < pixels.length; ++i) {
			if(pixels[i].length != width) ErrorPrinter.error("Illegal array");
		}	
		_pixels = clone(pixels);
	}

	/**
	 * Construct a new RGBImage which is a copy of the given image.
	 * Assumes the given image is not null.
	 * @param other The image to copy.
	 */
	public RGBImage(RGBImage other) {
		_pixels = clone(other._pixels);
	}

	/**
	 * Gets an array of the pixels in this image.
	 * @return An array of the pixels in this image.
	 */
	public RGBColor[][] toRGBColorArray() {
		return clone(_pixels);
	}

	/**
	 * Returns the grayscale representation of the image.
	 * The grayscale reperesentation of each pixel is calculated as defined in
	 * the API of RGBColor
	 * @return A 2d array of floats representing the image in grayscale values.
	 */ 
	public float[][] toGrayscaleArray(){
		float[][] result = new  float[_pixels.length][_pixels[0].length];
		for (int i = 0; i < _pixels.length; i++){
			for (int j = 0; j < _pixels[0].length; j++){
				result[i][j] = _pixels[i][j].convertToGrayscale();
			}
		}
		return result;
	}

	/**
	 * Inverts the color of all pixels in this image, by replacing each 
	 * RGB value with its complement to 255. For example, RGB values of [0,1,2] would be
	 * changed to [255,254,253].
	 */
	public void invertColors() {
		for (int row = 0; row < _pixels.length; ++row) {
			for (int col = 0; col < _pixels[row].length; ++col) {
				_pixels[row][col].invert();
			}
		}
	}    


	/**
	 * Shifts the image down or up, according to the given offset.
	 * Row 0 is moved into row offset, row 1 is moved into row offset+1, etc. 
	 * offset may be negative (or 0).
	 * Any row that is shifted in from outside the image should be all black.
	 * @param offset Offset to shift the image by.  
	 */
	public void shiftRow(int offset) {
		//The code is a bit messy because we do the shift in-place to avoid
		//allocating memory.        
		if(offset==0) return;
		if(offset>_pixels.length) offset=_pixels.length;
		if(-offset>_pixels.length) offset=-_pixels.length;
		int dir=offset>0?-1:1;				      
		int rowLength = _pixels[0].length;

		int start=offset>0?_pixels.length-1:0;
		for(int i=0; i<_pixels.length+offset*dir;i++) {
			int row=start+i*dir;
			RGBColor[] temp=_pixels[row];
			_pixels[row]=_pixels[row-offset];
			_pixels[row-offset]=temp;
		}

		for(int i=_pixels.length+offset*dir; i<_pixels.length; i++) {
			int row=start+i*dir;
			for (int col = 0; col < rowLength; ++col) {
				updatePixel(_pixels[row][col],0,0,0);
			}
		}
	}

	/**
	 * Shifts the image left or right, according to the given offset.
	 * Column 0 is moved into column offset, column 1 is moved into column 
	 * offset+1, etc. offset may be negative (or 0).
	 * Any column that is shifted in from outside the image should be all black.
	 * @param offset Offset to shift the image by. 
	 */
	public void shiftCol(int offset){
		//The code is a bit messy because we do the shift in-place to avoid
		//allocating memory.
		if(offset==0) return;
		if(offset>_pixels[0].length) offset=_pixels[0].length;
		if(-offset>_pixels[0].length) offset=-_pixels[0].length;
		int dir=offset>0?-1:1;				      
		int rowLength = _pixels[0].length;

		int start=offset>0?_pixels[0].length-1:0;
		for(int row=0; row<_pixels.length;row++) {
			for(int j=0; j<_pixels[row].length+offset*dir;j++) {
				int col=start+j*dir;
				RGBColor temp=_pixels[row][col];
				_pixels[row][col]=_pixels[row][col-offset];
				_pixels[row][col-offset]=temp;
			}

			for(int j=_pixels[row].length+offset*dir; j<_pixels[row].length; j++) {
				int col=start+j*dir;
				updatePixel(_pixels[row][col],0,0,0);
			}
		}
	}
	/**
	 * Gets the pixel at the given coordinates.
	 * Returns a black RGBColor if the given coordinates are outside the image 
	 * @param row The row of the pixel to get.
	 * @param col The column of the pixel to get.
	 * @return The pixel at the given coordinates.
	 */
	public RGBColor getPixel(int row, int col){
		if (row < 0 || row >= _pixels.length || 
				col < 0 || col >= _pixels[row].length){
			return new RGBColor();
		}
		return new RGBColor(_pixels[row][col]);
	}

	/**
	 * Sets the pixel at the given coordinates.
	 * Raises an error if the given coordinates are outside the image.
	 * @param row The row of the pixel to set.
	 * @param col The column of the pixel to set.
	 * @param pixel Contains the RGB values to set at the given coordinates.
	 */
	public void setPixel(int row, int col, RGBColor pixel){
		if (row < 0 || row >= _pixels.length || 
				col < 0 || col >= _pixels[row].length){
			ErrorPrinter.error("Pixel coordinates out of range");
		}
		updatePixel(_pixels[row][col],pixel.getRed(),pixel.getGreen(),pixel.getBlue());
	}

	/**
	 * Gets the height of the image in pixels.
	 * @return The height of the image.
	 */
	public int getHeight(){
		return _pixels.length;
	}

	/**
	 * Gets the width of the image in pixels.
	 * The width is the number of columns.
	 * @return The width of the image.
	 */
	public int getWidth(){
		return _pixels[0].length;
	}

	/**
	 * Flips the image around the vertical axis.  The first column becomes the
	 * last column, The second becomes second to last, etc.
	 */
	public void flipVertical(){
		for (int row=0; row<_pixels.length; row++){
			for (int col=0;col<_pixels[row].length/2;col++){
				RGBColor temp = _pixels[row][col];
				_pixels[row][col] = _pixels [row][_pixels[row].length-col-1];
				_pixels[row][_pixels[row].length-col-1] = temp;
			}
		}
	}

	/**
	 * Flips the image around the horizontal axis.  The first row becomes the
	 * last row, The second becomes second to last, etc.
	 */
	public void flipHorizontal(){
		for (int row=0; row<_pixels.length/2; row++){
			RGBColor[] temp = _pixels[row];
			_pixels[row] = _pixels[_pixels.length-row-1];
			_pixels[_pixels.length-row-1] = temp;
		}
	}

	/** 
	 * Rotates the image 90 degrees clockwise.  
	 * Note that this may change the dimensions of the image.
	 */
	public void rotateClockwise(){
		//Here I chose to re-allocate the data because it would be a bit
		//messier to do this in-place:
		RGBColor[][] temp = new RGBColor[_pixels[0].length][_pixels.length];
		for (int row=0; row<_pixels.length; row++){
			for (int col=0;col<_pixels[0].length;col++){
				temp[col][_pixels.length-1-row] = _pixels[row][col];
			}
		}
		_pixels = temp;
	}

	/** 
	 * Rotates the image 90 degrees counter-clockwise.  
	 * Note that this may change the dimensions of the image.
	 */
	public void rotateCounterClockwise(){
		//Here I chose to re-allocate the data because it would be a bit
		//messier to do this in-place:
		RGBColor[][] temp = new RGBColor[_pixels[0].length][_pixels.length];
		for (int row=0; row<_pixels.length; row++){
			for (int col=0;col<_pixels[0].length;col++){
				temp[_pixels[0].length-1-col][row] = _pixels[row][col];
			}
		}
		_pixels = temp;
	}

	/**
	 * Blurs the image.
	 *
	 * <br><br>
	 *
	 * The blur operation replaces each of the pixel values of the image with
	 * an average of the values in its surrounding neighborhood. The
	 * neighborhood of radius <b>R</b> includes all pixels that are no more
	 * then <b>R</b> steps away from the modified pixel. A single step can take
	 * you one pixel to the left, right, up, down or to one of the four
	 * diagonals.
	 * The blur operation is being done on each of the colors separately.
	 * Note that after doing this operation we get floating point values
	 * you should cast it back to int using (int) - that is take the integer part
	 *
	 * <br><br>
	 *
	 * In the picture below, the radius 1 neighborhood of the central pixel,
	 * includes all cells marked '1' and the central pixel, radius 2
	 * neighborhood includes all cells marked '2','1' and the central pixel,
	 * etc.
	 *
	 * <br><br>
	 *
	 * <center><img src="l_inf.png" width=25%></center>
	 *
	 * <br><br>
	 *      
	 * The blur radius can not be zero or negative. If an illegal radius is
	 * provided, An error should be raised.
	 *
	 * <br><br>
	 *
	 * When computing the values for pixels near the edge of the image, some
	 * neighbors may be outside the image bounds. The values used for these
	 * neighbors should be 0.
	 *
	 * Note that when computing the average of intensities of of pixels, the
	 * value that should be used in the calculation for all pixels is the value
	 * before this operation began (after some pixels have changed, their new
	 * value is not used when calculating the value of their neighbors, but
	 * rather their old value)
	 * @param radius Radius of averaging.
	 */
	public void blurImage(int radius){
		if(radius<=0) {
			ErrorPrinter.error("Blur radius must be positive");
		}
		int rows = _pixels.length, cols = _pixels[0].length;
		RGBColor[][] newImage = new RGBColor[rows][cols];
		int area = (2*radius+1)*(2*radius+1);

		for (int i=0; i<rows; ++i) {
			for (int j=0; j<cols; ++j) {
				int sumR = 0, sumG = 0, sumB = 0;
				for (int k=-radius; k<=radius; ++k) {
					for (int l=-radius; l<=radius; ++l) {
						if (!((i+k)<0 || (i+k)>=rows || (j+l)<0 || (j+l)>=cols)) {
							RGBColor curPixel = _pixels[i+k][j+l];
							sumR += curPixel.getRed();
							sumG += curPixel.getGreen();
							sumB += curPixel.getBlue();
						}
					}
				}
				newImage[i][j] = new RGBColor(sumR/area,sumG/area,sumB/area);
				//		newImage[i][j].setRed(sumR/area);
				//  newImage[i][j].setGreen(sumG/area);
				//   newImage[i][j].setBlue(sumB/area);
			}
		}
		_pixels = newImage;
	}


	/**
	 * Gets an array of the color component values of this image's pixels.
	 * The first index denotes
	 * the row, the second index denotes the column, and the third index
	 * denotes the color component (red=0, green=1, blue=2).
	 * @return An array containing the color component values of this image's
	 * pixels.
	 */
	public int[][][] toIntArray() {
		int[][][] array = new int[_pixels.length][_pixels[0].length][];
		for (int row = 0; row < _pixels.length; ++row) {
			for (int col = 0; col < _pixels[row].length; ++col) {
				array[row][col] = new int[3];
				array[row][col][0] = _pixels[row][col].getRed();
				array[row][col][1] = _pixels[row][col].getGreen();
				array[row][col][2] = _pixels[row][col].getBlue();
			}
		}
		return array;
	}
	/**
	 * Return true iff the images are equal, that is they have the same height and width, and for each
	 * i and j in the legal ranges, the Color in row i column j are equal.
	 * @return true iff the images are equal
	 */
	public boolean equals(RGBImage other){
		if(other==null) return false;
		if(other.getWidth()!=getWidth() || other.getHeight()!=getHeight()){
			return false;
		}

		for(int i = 0; i < getHeight(); i++){
			for(int j = 0; j < getWidth(); j++){
				if(!_pixels[i][j].equals(other._pixels[i][j])){
					return false;
				}
			}
		}
		return true;
	}
	public void sortRowsByGrayLevel(){
		for(int i=0;i<_pixels.length;i++){
			Arrays.sort(_pixels[i]);
		}
	}
	public void sortColumnsByGrayLevel(){
		this.rotateCounterClockwise();
		this.sortRowsByGrayLevel();
		this.rotateClockwise();
	}

}
