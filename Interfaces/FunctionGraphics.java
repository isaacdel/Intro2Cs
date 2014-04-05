import java.awt.Dimension;
import java.awt.Graphics;

/**
* 
The class graphically plots objects that implement the RealFunction interface.

*/

public class FunctionGraphics extends java.lang.Object{
    /**
    * Instantiates a new function graphics object.
 
    * @param dimension the number of pixels (width and height) of the frame that instantiates this graph
    * @param minX the left boundary of the plot region
    * @param maxX the right boundary of the plot region
    * @param minY the bottom boundary of the plot region
    * @param maxY the top boundary of the plot region
    */
	private int dimension,minX,maxX,minY,maxY;
	private int xArray[];
	private int realXArray[];
	private int yArray[];
	private int realYArray[];

    public FunctionGraphics(int dimension, int minX, int maxX, int minY, int maxY) {
    	this.dimension=dimension;
    	this.minX=minX;
    	this.maxX=maxX;
    	this.minY=minY;
    	this.maxY=maxY;
    }
    /**
    * Draws a graph of a given RealFunction object.
    * @param function the function to draw
    * @param g the Graphics object (of the calling Jframe)
    */
    public void drawGraph(RealFunction function, java.awt.Graphics g) {
    	xArray=new int[dimension];
    	yArray=new int [dimension];
    	for(int i=0;i<dimension;i++){
    		xArray[i]=i;
    		yArray[i]=(int)((((function.valueAt(((minX+(maxX-minX)*i)/(dimension-1)))-maxY)*(dimension-1)))/-(maxY-minY));
    	
    		
    	}
    	g.drawPolyline(xArray, yArray, dimension);
    }
    /**
    * Draws a graph of a parametric function defined by two RealFunction objects.
 The first function f1 generates the x coordinates of the plot, while the second
 function f2 generates the y coordinates. Both functions should be evaluated
 for each X value represented in the pixel grid, thus producing a set of (X, Y)
 coordinates. Note that these coordinates should be converted to integer pixel
 coordinates.

    * @param f1 the x(t) function of the parametric function
    * @param f2 the y(t) function of the parametric function
    * @param g the Graphics object (of the calling Jframe)
    */
    public void drawGraph(RealFunction f1, RealFunction f2, java.awt.Graphics g) {
    	xArray=new int[dimension];
    	yArray=new int [dimension];
    	for(int i=0;i<dimension;i++){
    		xArray[i]=i;
    		realXArray[i]=(int)((f1.valueAt(i)*(dimension-1))/(minX+(maxX-minX)));
    		
    		realYArray[i]=(int)(((f2.valueAt(i)-maxY)*(dimension-1))/(-(maxY-minY)));
    		
    		
    	}
    	g.drawPolyline(realXArray, realYArray, dimension);

    }
}