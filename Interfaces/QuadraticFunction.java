/**
* 
This class represents a Quadratic function of the form a*(x^2)

*/

public class QuadraticFunction implements RealFunction{
    /**
    * Constructs a new QuadraticFunction using the given parameter.

    * @param a the 2nd degree coefficient.
    */
	private double a;
    public QuadraticFunction(double a) {
    	this.a=a;
    }
    /**
    * returns the f(x) value of the RealFunction.

    * @param x the x value given.

    * @return the f(x) value of this function i.e when y= a*x^2
    */
    public double valueAt(double x) {
    	return a*(Math.pow(x, 2));
    }
    /**
    * returns a String representation of the Quadratic function.

    * @return a String representation of the Quadratic function.
    */
    public String toString() {
    	return "y="+a+"*x^2";
    }
}