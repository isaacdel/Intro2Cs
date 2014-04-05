
import intro.ex5.Complex;
import intro.ex5.RGBColor;
/**
 * 
The Mandelbrot class represents a rectangular region of the complex plane 
 as a color image, where the color of each pixel (corresponding to a point 
 in the complex plane) is determined according to the escape time of the 
 complex point from the Mandelbrot radius (in ex5 this radius is set to 2).
 The complex numbers contained in each Mandelbrot object are determined 
 according to the size of the rectangular region, its resolution and the 
 complex number in its top left corner.
 The color in the corresponding image is determined according to the escape 
 time of each complex number and a palette of colors. This palette is an 
 array of RGBColors where the color in index 0 represents the color of numbers
 in the Mandelbrot radius and the colors of the other entries are the colors
 of complex numbers that "escaped" from the Mandelbrot set -
 where in entry i lies the color of complex numbers with escape time i.

 */
public class Mandelbrot extends java.lang.Object{
    /**
     * The radius used for calculating the escape time, for ex5 this radius should be 2.

     */
    public static final int RADIUS=2;
    /**
     * Creates a new 
     * @param rows The height of this Mandelbrot plane (number of complex nubmers).
     * @param cols The width of this Mandelbrot plane (number of complex nubmers).
     * @param topLeftCorner The complex number at the top left corner of the plane.
     * @param xStepSize The size of the change along the x (real) line.
     * @param yStepSize The size of the change along the y (imaginery) line.
     * @param maxIterations Max number of iterations to use when computing the
 escape from the Mandelbrot set.
     * @param palette The color assigned for each escape time: an array 
 of size maxIterations+1, where the color in entry i (palette[i]) is the 
 color for a complex number with escape time i and the color in the first
 entry (palette[0]) is the color of complex numbers that didn't "escape" from 
 the Mandelbrot radius.
     */
    private Complex [][] complexArray;
    private RGBColor[][] mandelbrotColor;
    private intro.ex5.Complex topLeftCorner;
    private double xStepSize, yStepSize;
    private int rows;
    private int cols;
    private int maxIterations;
    private intro.ex5.RGBColor[] palette;
    
    public Mandelbrot(int rows, int cols, intro.ex5.Complex topLeftCorner
    		, double xStepSize, double yStepSize, int maxIterations
    		, intro.ex5.RGBColor[] palette) {
        complexArray=new Complex[rows][cols];//builds the mandelbrot base complex array
        mandelbrotColor=new RGBColor[rows][cols];//builds the mandelbrot base colors array
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                complexArray[i][j]=new Complex(topLeftCorner.getReal()+j*xStepSize
                		, topLeftCorner.getImg()-i*yStepSize);//updates the complex in every cell by given steps.reals affected by x and img by y.
            }
        }    
        updateImage();//now we have a complete pic with wanted complex numbers.
        this.xStepSize=xStepSize;
        this.yStepSize=yStepSize;
        this.topLeftCorner=topLeftCorner;
        this.rows=rows;
        this.cols=cols;
        this.maxIterations=maxIterations;
        this.palette=palette;
    }
    /**
     * Returns a color image representing this Mandelbrot plane.

     * @return The image representing this Mandelbrot plane.
     */
    
    private void updateImage() {
    	for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(complexArray[i][j].escapeTime(RADIUS, maxIterations)!=-1){//the complex escaped
                    mandelbrotColor[i][j]=new RGBColor(palette[complexArray[i][j].escapeTime(RADIUS, maxIterations)]);
                }
                else{
                    mandelbrotColor[i][j]=palette[complexArray[i][j].escapeTime(RADIUS, maxIterations)+1];//the complex didnt escaped
                }
            }
        }
    }
    public RGBImage getImage() {
    	updateImage();//returns the most updated pic after modifications.
        return new RGBImage(mandelbrotColor);
    }
    /**
     * Enlarge the resolution of this Mandelbrot object (maginfy)
 and sets the center of the plane to be the complex number at the given
 row at column.
 The total number of complex numbers in this plane 
 (and thus the dimensions of the image) are not changed, 
 only the resolution and range of covered numbers.

     * @param newCenterRow The row of the new center.
     * @param newCenterCol The column of the new center.
     * @param magnificationFactor The factor to enlarge the resolution by.
     */
    public void magnify(int newCenterRow, int newCenterCol, int magnificationFactor) {
        xStepSize=xStepSize/magnificationFactor;//x steps size are smaller by the magnification value after zooming.
        yStepSize=yStepSize/magnificationFactor;//y steps size are smaller by the magnification value after zooming.
        this.shift(newCenterRow*magnificationFactor, newCenterCol*magnificationFactor
        		,getImage().getHeight()/RADIUS 
        		,getImage().getWidth()/RADIUS);//uses shift method to move the wanted place zoom to middle and calculates the new corner by "stepping back" than the whole new pic
    }
    /**
     * Shift this Mandelbrot palne such the source point (srcRow,srcCol) will 
 move to (destRow,destCol).

     * @param srcRow Row of the origin point.
     * @param srcCol Column of the origin point.
     * @param destRow Row of the destination point.
     * @param destCol Column of the destination point.
     */
    public void shift(int srcRow, int srcCol, int destRow, int destCol) {
        double newCornerReal = topLeftCorner.getReal()-(destCol-srcCol)*xStepSize;//steps back to calc new real value at wanted shift point
        double newCornerImg = topLeftCorner.getImg()+(destRow-srcRow)*yStepSize;//steps back to calc new img value at wanted shift point
        topLeftCorner=new Complex(newCornerReal, newCornerImg);
        for(int i=0;i<rows;i++){//cals the new copmlex  numbers array with the given new corner
            for(int j=0;j<cols;j++){
                complexArray[i][j]=new Complex(topLeftCorner.getReal()+j*xStepSize,topLeftCorner.getImg()-i*yStepSize);
            }
        }
        updateImage(); //returns the fixed pic withe new complex values
    }
}