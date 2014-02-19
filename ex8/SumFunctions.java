/**
* 
This class represents a RealFunction that is the sum
 of the other real functions.

*/

public class SumFunctions implements RealFunction{
    /**
    * Constructs a new SumFunctions object that is
 the sum of the 2 given parameters.

    * @param f1 the first function used in the sum
    * @param f2 the second function used in the sum
    */
	private RealFunction f1,f2;
    public SumFunctions(RealFunction f1, RealFunction f2) {
    	this.f1=f1;
    	this.f2=f2;
    }
    /**
    * returns the f(x) value of the sum of the two functions used.

    * @param x the x value given.

    * @return the f(x) value of this function i.e. f(x)= f1(X) + f2(x)
    */
    public double valueAt(double x) {
    	return this.f1.valueAt(x)+this.f2.valueAt(x);
    }
    /**
    * returns a String representation of the sum of the 2 real functions held.

    * @return a String representation of the 2 real functions held.
    */
    public String toString() {
	return (this.f1.toString()+"+"+this.f2.toString());
    
    }
}