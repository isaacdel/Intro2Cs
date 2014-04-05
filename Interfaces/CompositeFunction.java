/**
* 
This class represents a RealFunction that is the composition of
 the two functions, i.e. f(x) = f1(f2(x))

*/

public class CompositeFunction implements RealFunction{
    /**
    * Constructs a new CompositeFunction object
 that is the composition of the 1st function on the 2nd.

    * @param f1 the first function used
    * @param f2 the second function used
    */
	private RealFunction f1,f2;
    public CompositeFunction(RealFunction f1, RealFunction f2) {
    	this.f1=f1;
    	this.f2=f2;
    }
    /**
    * returns the f(x) value of the composite function

    * @param x the x value given.

    * @return the f(x) value of this function i.e. f(x)= f1(f2(x))
    */
    public double valueAt(double x) {
    	return (this.f1.valueAt(this.f2.valueAt(x)));
    }
    /**
    * returns a String representation of the function

    * @return a String representation of the composite function.
    */
    public String toString() {
    	String fOneString=f1.toString();
    	String fTwoSring=f2.toString();
    	return "f(x)="+fTwoSring+"("+fOneString+")";
    }
}