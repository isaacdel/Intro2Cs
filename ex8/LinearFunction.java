
/**
* 
This class implements a linear function.

*/

public class LinearFunction implements RealFunction{
    /**
    * Constructs a new LinearFunction. Receives two integers that are the coefficients of
 the linear function.

    * @param a the coefficient of x int the linear equation.
    * @param b the linear function's free coefficient.
    */
	private double xCoefficent;
	private double yCoefficent;
    public LinearFunction(double a, double b) {
    	xCoefficent=a;
    	yCoefficent=b;
    }
    /**
    * returns the f(x) value of the RealFunction.

    * @param x the x value given.

    * @return the f(x) value of this function i.e. a*x + b
    */
    public double valueAt(double x) {
    	return xCoefficent*x+yCoefficent;
    }
    /**
    * returns a String representation of the Linear function.

    * @return a String representation of the Linear function.
    */
    public String toString() {
    	return "y="+xCoefficent+"*x+"+yCoefficent;
    }
}